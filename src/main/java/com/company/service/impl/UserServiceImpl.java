package com.company.service.impl;

import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {
    @PersistenceContext
    EntityManager em;
    @Autowired
    UserDaoImpl userDao;

    @Override
    public List<User> getAllUser(String name, String surname) {
        return userDao.getAllUser(name, surname);
    }

    @Override
    public boolean upDateUser(User u) {
        return userDao.upDateUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userDao.removeUser(id);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public User getById(int userid) {
        return userDao.getById(userid);
    }
}
