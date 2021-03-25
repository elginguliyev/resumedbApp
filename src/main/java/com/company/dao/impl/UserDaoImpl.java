package com.company.dao.impl;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAllUser(String name, String surname) {

        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        Query q = em.createQuery(jpql, User.class);

        if (name != null) {
            q.setParameter("name", name);
        }

        if (surname != null) {
            q.setParameter("surname", surname);
        }

        return q.getResultList();

    }

    @Override
    public boolean upDateUser(User u) {

        em.merge(u);
        return true;

    }

    @Override
    public boolean removeUser(int id) {

        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public boolean addUser(User u) {

        em.persist(u);
        return true;
    }

    @Override
    public User getById(int userid) {

        User u = em.find(User.class, userid);
        return u;
    }

}
