package com.myself.code.repository;

import com.myself.code.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MySelf on 2018/11/6.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

    User findByName(String name);

}
