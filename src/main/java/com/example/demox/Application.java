package com.example.demox;

import uril.DateFormatUtil;
import uril.HttpUtil;

public class Application {

    public static void main(String[] args) throws Exception {
        String ss1= DateFormatUtil.getCurrentDateString().substring(8);;
        System.out.println(ss1);
        for (int i=0;i<=500;i++){
            final int ii=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Object ss= null;
                    try {
                        ss = HttpUtil.doGet("http://localhost:8081/a/test/t1","");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(ss);
                    String bb1=DateFormatUtil.getCurrentDateString().substring(8);;
                    System.out.println("序号:"+ii+"--"+bb1+"#差额:"+(Integer.parseInt(bb1)-Integer.parseInt(ss1)));

                }
            }).start();
        }
        String ss2=DateFormatUtil.getCurrentDateString();;

    }
}
