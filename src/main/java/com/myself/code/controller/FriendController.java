package com.myself.code.controller;

import com.myself.code.dataobject.Friend;
import com.myself.code.dataobject.User;
import com.myself.code.dto.FriendDTO;
import com.myself.code.service.FriendService;
import com.myself.code.service.UserService;
import com.myself.code.utils.CreateQRCodeUtil;
import com.myself.code.utils.ResultVoUtil;
import com.myself.code.vo.ResultVO;
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
    private FriendService friendService;

    @Autowired
    private UserService userService;

    /**
     * 获取当前好友
     * @param name
     * @return
     */
    @GetMapping("/my_friend")
    public ResultVO GetMyFriend(@RequestParam("name") String name){
        User user = userService.findByName(name);
        List<FriendDTO> friendDTOList = friendService.findByUserId(user.getId());
        return ResultVoUtil.success(friendDTOList);
    }

    /**
     * 获取个人二维码
     * @param name
     * @return
     */
    @PostMapping("/code")
    public ResultVO code(@RequestParam("name") String name){
        String path = createQRCodeUtil.create(name,name);
        log.info(path);
        return ResultVoUtil.success(path);
    }

    @PostMapping("/add")
    public ResultVO add(@RequestParam("me") String me,@RequestParam("name") String name){
        User user = userService.findByName(me);
        User friend = userService.findByName(name);
        Friend friendMsg = new Friend();
        friendMsg.setUserId(user.getId());
        friendMsg.setFriendId(friend.getId());
        friendService.save(friendMsg);
        return ResultVoUtil.success("ok");
    }
}
