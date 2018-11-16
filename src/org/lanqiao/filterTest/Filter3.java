package org.lanqiao.filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "Filter3",urlPatterns ="/*")
public class Filter3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter3 前拦截");
        chain.doFilter(req, resp);
        System.out.println("Filter3 后拦截");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
