import com.shinerio.dao.PatientsDao;
import com.shinerio.domain.Patients;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jstxzhangrui on 2016/11/26.
 */
public class TestMain {


    @org.junit.Test
    public void testInsert() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        PatientsDao patientsDao = beanFactory.getBean("userDao_test",PatientsDao.class);
        Patients patient = new Patients(1,"JACK","ADMIN");
        patientsDao.savePatient(patient);
    }

    @Test
    public void testSelect() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        PatientsDao patientsDao = beanFactory.getBean("userDao_test",PatientsDao.class);
        Patients patient = patientsDao.getPatientByID(1);
        System.out.println(patient);
    }
}
