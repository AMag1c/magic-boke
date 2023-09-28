package com.magic.filter;

import com.mysql.cj.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.LogRecord;
@WebFilter("/personal_center.html")
public class sysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

//        String[] urls={"/error.html","/index.html","/css/","/fonts/","/image/","/js/","/less/","/scss/","/image/","/User","/Register"};
//        String url=req.getRequestURL().toString();
//
//        for (String u : urls){
//            if (url.contains(u)){
//                chain.doFilter(request,response);
//                return;
//            }
//        }
        //判session中是否有User
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        // 如果Session为空 则跳转到错误页面
        if(user==null){
            resp.sendRedirect("/boke");
        }else {
            // 不为空 则继续
            chain.doFilter(request,response);
        }

    }
}
