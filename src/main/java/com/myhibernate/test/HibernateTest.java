package com.myhibernate.test;

import com.myhibernate.bean.User;
import com.myhibernate.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

//Session 可以有很多個,thread not safe
public class HibernateTest { 

    @Test
    //get 採用立即加載,執行時候就會發送SQL子句
    public void showDataGet(){
//        dsfds
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 9);
        System.out.println(user);
        transaction.commit();
        session.close();
    }
    @Test
    //load 採用立即加載,執行時候就會發送SQL子句
    public void showDataLoad(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.load(User.class, 5);
        System.out.println(user);
        transaction.commit();
        session.close();
    }
    
    @Test
    public void addData(){
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = HibernateUtils.openSession();
        //
        Transaction transaction = session.beginTransaction();
        //operation
        User user = new User();
        user.setName("Dog");
        session.save(user);
        //提交
        transaction.commit();
        //關閉資源
        session.close();

    }
}
