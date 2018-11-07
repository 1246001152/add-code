package com.myself.code.controller;

import com.myself.code.dataobject.User;
import com.myself.code.service.UserService;
import com.myself.code.utils.ResultVoUtil;
import com.myself.code.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 19:47 2018\11\6 0006
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/resgist")
    public ResultVO resgist(@RequestParam("name") String name,
                            @RequestParam("pass") String pass){
        if (name.isEmpty() | pass.isEmpty()){
            return ResultVoUtil.error(444,"【参数错误】");
        }
        User user = userService.findByName(name);
        if (user != null){
            return ResultVoUtil.error(445,"【用户存在】");
        }
        User resgist = new User();
        resgist.setName(name);
        resgist.setPass(pass);
        userService.save(resgist);
        return ResultVoUtil.success();
    }

    @PostMapping("/login")
    public ResultVO login(@RequestParam("name") String name,
                          @RequestParam("pass") String pass){
        if (name.isEmpty() | pass.isEmpty()){
            return ResultVoUtil.error(444,"【参数错误】");
        }
        User user = userService.findByName(name);
        if (user == null){
            return ResultVoUtil.error(446,"【用户不存在】");
        }
        if (pass.equals(user.getPass())){
            return ResultVoUtil.success(name);
        }else {
            return ResultVoUtil.error(447,"【密码错误】");
        }
    }
}
