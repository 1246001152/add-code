package com.myself.code.service;

import com.myself.code.dataobject.User;

/**
 * Created by MySelf on 2018/11/6.
 */
public interface UserService {

    User save(User user);

    User findByName(String name);

}
