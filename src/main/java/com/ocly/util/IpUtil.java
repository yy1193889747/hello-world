package com.ocly.util;

import java.net.InetAddress;

/**
 * @author ocly
 * @date 2018/1/19 16:14
 */
public class IpUtil {
    public static String getIp() {
        InetAddress ia = null;
        String localip = null;
        try {
            ia = InetAddress.getLocalHost();
            localip = ia.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localip;
    }
}
