package com.zzz.hathor.captcha.config.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @See Spring Boot实战：拦截器与过滤器 https://www.cnblogs.com/paddix/p/8365558.html
 */
public class LogCostFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}