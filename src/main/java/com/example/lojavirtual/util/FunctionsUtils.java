package com.example.lojavirtual.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class FunctionsUtils {

    public static String getUserRemoteIpAddress() {
        String ip = null;

        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return ip;
    }
}
