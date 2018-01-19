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

            String localname = ia.getHostName();
            localip = ia.getHostAddress();
            System.out.println("本机名称是：" + localname);
            System.out.println("本机的ip是 ：" + localip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localip;
    }
}
