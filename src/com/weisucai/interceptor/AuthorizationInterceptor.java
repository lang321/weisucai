package com.weisucai.interceptor;

import com.weisucai.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URL = {"/","/index.html", "/designer/index",
            "/qq/login","/qq/afterLogin","/user/logout","/article/detail",
            "/login","/loginPro","/register","/registerPro","/header","/footer",
            "/area/getAreas","/article/getAllPage","/article/getArticleRange"};

    /**
     * 拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String servletPath = httpServletRequest.getServletPath();
//        System.out.println(servletPath);
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        //修改
        if(user!=null){
            return true;
        }
        if(servletPath.startsWith("/article/detail")){
            return true;
        }
        for (String url :
                IGNORE_URL) {
            if(url.equals(servletPath)){
                return true;
            }
        }

        if(user==null){
            httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
