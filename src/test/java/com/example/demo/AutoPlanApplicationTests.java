package com.example.demo;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("dev")
public class AutoPlanApplicationTests {
    @Resource
    private StringEncryptor stringEncryptor;

    @Test
    void test() {
        // 要加密的数据（如数据库的用户名或密码）
        String username = stringEncryptor.encrypt("123456");
        String password = stringEncryptor.encrypt("12345678");
        System.out.println(username);
        System.out.println(password);
    }

    /**
     * 随机指定范围内N个不重复的数(不含)
     * 最简单最基本的方法
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     */
    public static int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }

}
