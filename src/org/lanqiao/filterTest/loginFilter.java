package org.lanqiao.filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();
        String username = (String) session.getAttribute("username");
        String requestURI = ((HttpServletRequest)req).getRequestURI();
        System.out.println(requestURI);
        if ( requestURI.equals("/loginServlet")){
            chain.doFilter(req, resp);
        }else if (username != null && ! username.equals("") ){
            chain.doFilter(req, resp);
        }else {
            req.setAttribute("msg","您尚未登陆，请登陆账号");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
