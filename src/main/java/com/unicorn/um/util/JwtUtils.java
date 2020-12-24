package com.unicorn.um.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {
    // 过期时间
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    private static final String SECRET = "sdjk9bfJOV43kJ5dj6hPRs0kj";

    /**
     * 获取JWT生成的Token字符串
     *
     * @param id   存储的用户id
     * @param name 存储的用户名
     * @return token字符串
     */
    public static String getJwtToken(String id, String name) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("ume")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("name", name)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }


    /**
     * 判断token是否有效
     *
     * @param jwtToken token字符串
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否有效
     *
     * @param request Http请求
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        return checkToken(jwtToken);
    }

    /**
     * 通过jwt token获取用户id
     *
     * @param jwtToken
     * @return
     */
    public static String getUserIdByJwtToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return "";
        return (String) Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken).getBody().get("id");
    }

    /**
     * 通过jwt token获取用户id
     *
     * @param request
     * @return
     */
    public static String getUserIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        return getUserIdByJwtToken(jwtToken);
    }


}
