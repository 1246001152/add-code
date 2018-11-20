package com.myself.code.controller;

import com.myself.code.dataobject.Friend;
import com.myself.code.dataobject.User;
import com.myself.code.dto.FriendDTO;
import com.myself.code.service.FriendService;
import com.myself.code.service.UserService;
import com.myself.code.utils.CreateQRCodeUtil;
import com.myself.winter.utils.ResultVOUtil;
import com.myself.winter.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MySelf on 2018/11/7.
 */
@Slf4j
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private CreateQRCodeUtil createQRCodeUtil;

    @Autowired
    private ResultVOUtil resultVOUtil;

    @Autowired
    private FriendService friendService;

    @Autowired
    private UserService userService;

    /**
     * 获取当前好友
     * @param name
     * @return
     */
    @GetMapping("/my_friend")
    public ResultVo GetMyFriend(@RequestParam("name") String name){
        User user = userService.findByName(name);
        List<FriendDTO> friendDTOList = friendService.findByUserId(user.getId());
        return resultVOUtil.success(friendDTOList);
    }

    /**
     * 获取个人二维码
     * @param name
     * @return
     */
    @PostMapping("/code")
    public ResultVo code(@RequestParam("name") String name){
        String path = createQRCodeUtil.create(name,name);
        log.info(path);
        return resultVOUtil.success(path);
    }

    @PostMapping("/add")
    public ResultVo add(@RequestParam("me") String me,@RequestParam("name") String name){
        User user = userService.findByName(me);
        User friend = userService.findByName(name);
        Friend friendMsg = new Friend();
        friendMsg.setUserId(user.getId());
        friendMsg.setFriendId(friend.getId());
        friendService.save(friendMsg);
        return resultVOUtil.success("ok");
    }
}
