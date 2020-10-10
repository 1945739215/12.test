package com.cidp.config;

public class VideoConfig {

    public static String  WINDOWVIDEOHOME = VideoConfig.class.getResource("/").getPath();

    public static void main(String[] args) {
        System.out.println(WINDOWVIDEOHOME);
    }
}
