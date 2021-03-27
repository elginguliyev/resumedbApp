package com.company.service.inter;


import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {

     List<User> getAllUser(String name, String surname);
    public boolean upDateUser(User u);
    public  boolean removeUser(int id);
    public  boolean addUser(User u);
    public User getById(int userid);


}
