package com.cn.topsroboteer.scheduling;

import org.junit.Test;

import java.util.UUID;

/**
 * @Author 李波帆
 * @Version 1.0
 * Create: 2023/9/11-19:04
 * Description:
 */
public class UUIDTest {
    @Test
    public void testUUid(){
        String s = UUID.randomUUID().toString().replace("-", "");
        System.out.println(s);
        System.out.println("s.length() = " + s.length());
    }
}
