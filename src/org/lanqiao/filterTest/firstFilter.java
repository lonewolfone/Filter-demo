package org.lanqiao.filterTest;

import java.io.IOException;

//@javax.servlet.annotation.WebFilter(filterName = "firstFilter",urlPatterns = "/*")
public class firstFilter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("destroy 方法执行。。。。。。。。。。。。。。。。。。。。");
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("doFilter 方法前执行 。。。。。。。。。。。。。。");
        //放行
        chain.doFilter(req, resp);
        System.out.println("doFilter 方法后执行 。。。。。。。。。。 ");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        //获取初始化参数
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        System.out.println("init 方法执行");
        System.out.println(username);
        System.out.println(password);
    }

}
