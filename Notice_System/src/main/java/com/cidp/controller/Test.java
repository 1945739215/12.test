package com.cidp.controller;


import java.util.UUID;

public class Test {

    public static void main(String[] args)  {
        for (int i=0;i<7;i++)
        {
            String token = UUID.randomUUID() + "";
            System.out.println(token);
        }
    }
}




