package com.onetechone.data;

/**
 * Created by rasoul on 7/19/2017.
 */
import com.onetechone.model.User;

import java.util.List;




public interface UserDao {

    User findById(int id);

    void save(User user);

    List<User> findAllUsers();
}
