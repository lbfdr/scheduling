package com.cn.topsroboteer.scheduling;

import com.cn.topsroboteer.scheduling.utils.DateUtil;
import com.cn.topsroboteer.scheduling.utils.EncryptionUtils;
import com.cn.topsroboteer.scheduling.utils.result.ResultCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SchedulingApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(EncryptionUtils.md5AndSalt("12345678"));
    }
    @Test
    public void test() throws ParseException {
        System.out.println(new Date());
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd E");
        System.out.println("format.format(new Date()) = " + format.format(new Date()));
        System.out.println(format.parse("2023-08-31 星期四"));
    }
    @Test
    public void testParse() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = format.parse(format.format(new Date()));
        System.out.println("parse = " + parse);
    }
    @Test
    public void testEnum(){
        ResultCode[] values = ResultCode.values();
        List<ResultCode> list = Arrays.asList(values);
        list.forEach(System.out::println);
    }
    @Test
    public void testBinaryTwoToHex(){
        String s = Integer.toHexString(255);
        System.out.println("s = " + s);
        System.out.println(Integer.toBinaryString(0xf2));

    }
    @Test
    public void testIsAssignableFrom(){
        /*确定此 Class 对象表示的类或接口是否与指定 Class 参数表示的类或接口相同，或者是其超类或超接口。如果是则返回 true；否则返回 false。
        如果此 Class 对象表示基本类型，且指定的 Class 参数正是此 Class 对象，则此方法返回 true；否则返回 false*/
        System.out.println(Object.class.isAssignableFrom(String.class));//true
        System.out.println(String.class.isAssignableFrom(String.class));//true
        System.out.println(String.class.isAssignableFrom(Object.class));//false
    }
    @Test
    public void testDateFormat(){
        String str  ="2023-09-21 00:00:00";
        int i = str.indexOf(" ");
        System.out.println("str.substring(0,i) = " + str.substring(0, i));
    }
    @Test
    public void testPageInfo(){
        Page<String> page = PageHelper.startPage(2, 4);
        page.addAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        PageInfo<String> pageInfo = new PageInfo<>(page);
        page.forEach(System.out::println);
        System.out.println("pageInfo==");
        System.out.println(pageInfo);
    }
}
