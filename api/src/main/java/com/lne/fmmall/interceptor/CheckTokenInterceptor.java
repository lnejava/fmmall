package com.lne.fmmall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lne.fmmall.vo.ResultVo;
import io.jsonwebtoken.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * FileName: CheckTokenInterceptor
 * Author:   fengsulin
 * Date:     2022/4/30 10:34
 * Description: token拦截器
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 浏览器预检机制
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        if(token == null){
            ResultVo resultVo = new ResultVo().setCode(401).setMsg("请先登录！").setData(null);
            doResponse(response,resultVo);
            return false;
        }else {
//            try{
//                JwtParser parser = Jwts.parser();
//                parser.setSigningKey("fengsulin");
//                parser.parseClaimsJws(token);
//                return true;
//            }catch (ExpiredJwtException e){
//                ResultVo resultVo = new ResultVo().setCode(401).setMsg("token已过期，请重新登陆！").setData(null);
//                doResponse(response,resultVo);
//                return false;
//            }catch (UnsupportedJwtException e){
//                ResultVo resultVo = new ResultVo().setCode(401).setMsg("token不合法！").setData(null);
//                doResponse(response,resultVo);
//                return false;
//            }catch (Exception e){
//                ResultVo resultVo = new ResultVo().setCode(401).setMsg("请先登录！").setData(null);
//                doResponse(response,resultVo);
//                return false;
//
//            }
            String s = stringRedisTemplate.boundValueOps(token).get();
            if(s == null){
                ResultVo resultVo = new ResultVo().setCode(401).setMsg("登录过期，请重新登录！").setData(null);
                doResponse(response,resultVo);
                return false;
            }
            stringRedisTemplate.boundValueOps(token).expire(2, TimeUnit.MINUTES);
            return true;

        }
    }

    private void doResponse(HttpServletResponse response, ResultVo resultVo){
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter writer = response.getWriter();
            String s = new ObjectMapper().writeValueAsString(resultVo);
            writer.print(s);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
