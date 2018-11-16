package org.lanqiao.filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "characterEncodingFilter")
public class characterEncodingFilter implements Filter {
    private String encoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截前执行");
        //在拦截请求时
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
        System.out.println("拦截后执行");
    }

    public void init(FilterConfig config) throws ServletException {
        //初始化方法： 获取参数值
        encoding = config.getServletContext().getInitParameter("encoding");
    }

}
