package com.shinerio.domain;

import javax.persistence.*;

/**
 * Created by jstxzhangrui on 2016/11/26.
 */
@Entity
@Table(name="PATIENTS")
public class Patients {

    private int id;
    private String username;
    private String password;
    private Doctors doctor;

    public Patients() {
    }

    public Patients(int id,  String username,String password, Doctors doctor) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.doctor = doctor;
    }

    public Patients(String username, String password,Doctors doctor ) {
        this.username = username;
        this.doctor = doctor;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
}
    @Column(name="username",nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name="doctor_id")
    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "编号:"+id+" 用户名："+username;
    }
}
