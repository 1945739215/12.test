package com.cidp.config;

import com.cidp.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class InterceptConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("user");
        if (user==null)
        {
            String code="899";
            //request.setAttribute("msg","请先登录");
            //request.getRequestDispatcher("/login").forward(request,response);
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter=response.getWriter();
            printWriter.write("{\n" +
                    "    \"code\": 899,\n" +
                    "    \"msg\": \"请重新登录\",\n" +
                    "    \"object\": []\n" +
                    "}");

            printWriter.flush();
            printWriter.close();
            return false;
        }
        else
            return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
