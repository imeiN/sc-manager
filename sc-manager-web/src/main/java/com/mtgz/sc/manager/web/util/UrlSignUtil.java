package com.mtgz.sc.manager.web.util;

/**
 * Created by linyisheng on 2019/1/16.
 */
public class UrlSignUtil {

    public static String sign(String param) throws Exception{

        String token="asfkdjdsljdslj";

        return param+"&token="+token+param;
    }
    public static String getToken(String param) throws Exception{

        String token="asfkdjdsljdslj";

        return token+param;
    }

}
