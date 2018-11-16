package org.lanqiao.filterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "Filter1",urlPatterns ="/*" )
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    /*
        在开发中，如果配置了拦截器，有可能登陆页面 或者 index页面 都会访问不到，一般情况下不对页面进行拦截(页面可以被用户直接通过地址栏请求到  不允许)，只拦截Servlet
        将页面放在WEB-INF下，则用户无法通过地址栏访问到页面

        1、页面不被用户直接通过地址栏请求到
        只将index或者login页面直接放在web目录下，其他一律放在WEB-INF下
        2、只拦截Servlet
        *.do 或者 *.action
    */
        System.out.println("Filter1 前拦截");
        if(1 == 1){
            return;
        }
        chain.doFilter(req, resp);//执行改方法，则意味着请求Servlet 或 传递给下一个filter
        System.out.println("Filter1 后拦截");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
