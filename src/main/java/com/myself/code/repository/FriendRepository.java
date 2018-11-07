package com.myself.code.repository;

import com.myself.code.dataobject.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by MySelf on 2018/11/7.
 */
public interface FriendRepository extends JpaRepository<Friend,Integer> {

    List<Friend> findByUserId(Integer userId);


}
