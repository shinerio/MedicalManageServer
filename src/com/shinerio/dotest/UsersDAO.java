package com.shinerio.dotest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.sql.PreparedStatement;

/**
 * Created by jstxzhangrui on 2016/11/26.
 */
public class UsersDAO {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    public Users getUserByID(int id){
        Session session = getCurrentSession();
        try {
            Users instance = (Users) session.get(
                    "com.shinerio.dotest.Users", id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }


}
