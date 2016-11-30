import com.shinerio.dao.DoctorDao;
import com.shinerio.dao.PatientsDao;
import com.shinerio.domain.Doctors;
import com.shinerio.domain.Patients;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by jstxzhangrui on 2016/11/26.
 */
public class TestMain {

    @Test
    public void insertDoctor(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        DoctorDao doctorDao = beanFactory.getBean("doctorDao_test",DoctorDao.class);
        Doctors doctor = new Doctors("tom","admin");
        doctorDao.saveDoctor(doctor);
    }

    @Test
    public void selectDoctor(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        DoctorDao doctorDao = beanFactory.getBean("doctorDao_test",DoctorDao.class);
        Doctors doctor = doctorDao.getDoctorByID(1);
        System.out.println(doctor);
    }
    public Doctors getDoctor(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        DoctorDao doctorDao = beanFactory.getBean("doctorDao_test",DoctorDao.class);
        Doctors doctor = doctorDao.getDoctorByID(1);
       return doctor;
    }
    @org.junit.Test
    public void insertPatient() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        PatientsDao patientsDao = beanFactory.getBean("patientsDao_test",PatientsDao.class);
        Doctors doctor = getDoctor();
        Patients patient = new Patients("JACK","ADMIN",doctor);
        patientsDao.savePatient(patient);
    }

    @Test
    public void selectPatientByDoctor() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        DoctorDao doctorDao = beanFactory.getBean("doctorDao_test",DoctorDao.class);
        Doctors doctor = new Doctors();
        doctor.setId(1);
        Set<Patients> patients = doctorDao.getPatients(doctor);
       Iterator<Patients> iterator = patients.iterator();
        while (iterator.hasNext()){
            Patients patient = iterator.next();
            System.out.println(patient);
        }
    }
}
