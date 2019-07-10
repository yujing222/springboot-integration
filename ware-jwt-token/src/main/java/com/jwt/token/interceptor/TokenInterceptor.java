package com.jwt.token.interceptor;

import com.jwt.token.config.JwtConfig;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token 拦截器
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private JwtConfig jwtConfig ;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 地址过滤
        String uri = request.getRequestURI() ;
        if (uri.contains("/login")){
            return true ;
        }
        // Token 验证
        String token = request.getHeader(jwtConfig.getHeader());
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(jwtConfig.getHeader());
        }
        if(StringUtils.isEmpty(token)){
            throw new Exception(jwtConfig.getHeader()+ "不能为空");
        }
        Claims claims = jwtConfig.getTokenClaim(token);
        if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
            throw new Exception(jwtConfig.getHeader() + "失效，请重新登录");
        }
        //设置 identityId 用户身份ID
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }
}
