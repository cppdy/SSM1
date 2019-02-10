package com.jeff.test;

import org.junit.Test;

/**
 * @description:Junit4 单元测试插件
 * @author: Jeff
 * @date: 2019年02月10日 21:19:39
 */
public class JunitTest {

    /**
     * @description: 直接测试方法，不需要编写主方法；在需要运行的方法上面添加@Test；方法有强制要求：必须是public、必须是没有返回值、必须是没有参数；当前类中不要有Test类
     * @author: Jeff
     * @date: 2019年02月10日 21:17:44
     */

    @Test
    public void test() {
        System.out.println("hello");
    }

}
