package com.songbo.server.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @ClassName BcryptUtil
 * @Description TODO
 * @Author songbo
 * @Date 19-8-2 下午1:37
 **/
public class BcryptUtil {
    /*加密*/
    public static String encryption(String word){
        String hashed = BCrypt.hashpw(word,BCrypt.gensalt());
        return hashed;
    }
    /*解密*/
    public static boolean decryption(String word,String hashed){
        return BCrypt.checkpw(word,hashed);
    }

    public static void main(String[] args) {
        String pwt = BcryptUtil.encryption("ss6522011");
        //String pwt1 = BcryptUtil.encryption("qwdasd");
        //System.out.println(pwt+' '+pwt1);
        boolean b = BcryptUtil.decryption("ss6522011", pwt);
        System.out.println(pwt);
        System.out.println(b);
    }
}
