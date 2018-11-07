package com.myself.code.service;

import com.myself.code.dataobject.Friend;
import com.myself.code.dto.FriendDTO;

import java.util.List;

/**
 * Created by MySelf on 2018/11/7.
 */
public interface FriendService {

    List<FriendDTO> findByUserId(Integer userId);

    Friend save(Friend friend);
}
