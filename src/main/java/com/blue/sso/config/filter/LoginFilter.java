package com.blue.sso.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String token = request.getHeader("token");
        String path = request.getServletPath();
        if (path.endsWith("index.html") || path.endsWith(".ico") || path.endsWith(".css") || path.endsWith(".js")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            if (checkToken(token)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                response.sendRedirect("/html/index.html");
            }
        }

    }

    @Override
    public void destroy() {
    }

    /**
     * @description 检查token有效性
     * @param token
     * @return
     */
    private boolean checkToken(String token){
        if (null == token || "".equals(token)) {

        }
        return false;
    }

}
