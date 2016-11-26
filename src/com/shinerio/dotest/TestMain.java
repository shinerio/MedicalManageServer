package com.shinerio.dotest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jstxzhangrui on 2016/11/26.
 */
public class TestMain {
    public static void main(String args[]){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        UsersDAO usersDAO = beanFactory.getBean("userDao_test",UsersDAO.class);
        Users user = usersDAO.getUserByID(1);
        System.out.println(user);
    }
}
