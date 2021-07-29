package com.myhibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static final Configuration cfg;
    public static final SessionFactory sessionFactory;
    static {
        cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }
}
