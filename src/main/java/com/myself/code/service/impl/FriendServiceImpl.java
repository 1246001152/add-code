package com.myself.code.service.impl;

import com.myself.code.dataobject.Friend;
import com.myself.code.dataobject.User;
import com.myself.code.dto.FriendDTO;
import com.myself.code.repository.FriendRepository;
import com.myself.code.repository.UserRepository;
import com.myself.code.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MySelf on 2018/11/7.
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FriendDTO> findByUserId(Integer userId) {
        List<Friend> friendList = friendRepository.findByUserId(userId);
        List<FriendDTO> friendDTOList = friendList.stream().map(e ->
            transToDTO(e)
        ).collect(Collectors.toList());
        return friendDTOList;
    }

    @Override
    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

    private FriendDTO transToDTO(Friend e) {
        //System.out.println(e.getUserId()+"-"+e.getFriendId());
        FriendDTO friendDTO = new FriendDTO();
        User user = userRepository.getOne(e.getFriendId());
        friendDTO.setName(user.getName());
        return friendDTO;
    }
}
