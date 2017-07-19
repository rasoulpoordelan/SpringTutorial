package com.onetechone.data;

import com.onetechone.model.User;

import java.util.List;

/**
 * Created by rasoul on 7/19/2017.
 */
public interface UserService {

    User findById(int id);



    void saveUser(User user);

    void updateUser(User user);


    List<User> findAllUsers();


}