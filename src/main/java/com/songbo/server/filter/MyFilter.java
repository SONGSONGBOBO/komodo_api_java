package com.songbo.server.filter;

import com.songbo.server.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 下午1:58
 **/
@WebFilter(urlPatterns = "/admin/*")
@Slf4j
public class MyFilter extends HttpFilter {

    /**
      *@Description TODO 对请求进行拦截，验证Token
      *@param
      *@return
    **/
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
       /* String token = request.getHeader("Token");
        Map map = JwtUtil.validateToken(token);
        if ((Integer) map.get("code")==200){
            chain.doFilter(request, response);
        } else {
            response.sendError(404);
        }*/
        chain.doFilter(request, response);
    }

}
