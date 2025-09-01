package com.turktrust.football_hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    //SessionFactory oluşturuluyor.
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("sesionFactory oluşturulurken hata oluştu " + e);
        }
    }


    //Diğer sınıflardan getSessionFactory metoduyla sessionFactory çağırılıyor.
    public static SessionFactory getSessionFactory() {
        return sessionFactory;

    }
}
