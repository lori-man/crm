package com.lori.utils;

import java.util.UUID;

public class UpLoadUtils {
    /**
     * 解决目录下的文件名重复
     * @param filename
     * @return
     */
    public static String getUuidFileName(String filename){
        int ide = filename.lastIndexOf(".");
        String extions = filename.substring(ide);
        return UUID.randomUUID().toString().replace("-", "") + extions;
    }

    /**
     * 目录分离的方法
     * @param uuidFileName
     * @return
     */
    public static String getPath(String uuidFileName) {
        int code1 = uuidFileName.hashCode();
        int d1 = code1 & 0xf;  //作为一级目录
        int code2 = code1 >>> 4;
        int d2 = code2 & 0xf; //作为二级目录
        return "/" + d1 + "/" + d2 + "/";
    }

}
