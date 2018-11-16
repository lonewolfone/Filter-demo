package org.lanqiao.filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "Filter2",urlPatterns ="/*")
public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2 前拦截");
        chain.doFilter(req, resp);
        System.out.println("Filter2 后拦截");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
