package cn.edu.wzut.jwt;

import cn.edu.wzut.mbp.entity.SysUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTHelper {

    //生成token
    public static String getToken(SysUser sysUser) {
        String token = "";
        token = JWT.create().withAudience(sysUser.getId().toString())
                .sign(Algorithm.HMAC256(sysUser.getPassword()));
        return token;
    }
}
