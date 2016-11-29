package com.shinerio.dao;

import com.shinerio.domain.Doctors;
import com.shinerio.domain.Patients;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by jstxzhangrui on 2016/11/29.
 */
public class DoctorDao {
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

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveDoctor(Doctors doctor){
        Session session = getCurrentSession();
        try {
            session.save(doctor);
        } catch (RuntimeException re) {
            throw re;
        }
    }
    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    public Doctors getDoctorByID(int id){
        Session session = getCurrentSession();
        try {
            Doctors instance = (Doctors) session.get(
                    "com.shinerio.domain.Doctors", id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Set<Patients> getPatients(Doctors doctor){
        Session session = getCurrentSession();
        try {
            Doctors instance = (Doctors) session.get(
                    "com.shinerio.domain.Doctors", doctor.getId());
            Hibernate.initialize(instance.getPatientSet());  //这句很重要，否则会出现延迟加载异常
            return instance.getPatientSet();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
