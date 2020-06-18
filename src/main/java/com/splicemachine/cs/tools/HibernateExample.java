package com.splicemachine.cs.tools;

import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class HibernateExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // add user
        session.beginTransaction();
        User user = new User();
        user.setId(1);
        user.setName("Foo");
        session.save(user);
        session.getTransaction().commit();

        // view users
        Criteria c = session.createCriteria(User.class);
        List<User> users = c.list();
        for(User u : users) {
            System.out.println("name: " + u.getName() + " id: " + u.getId());
        }
    }
}