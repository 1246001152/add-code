package com.myself.code.controller;

import com.myself.code.dataobject.User;
import com.myself.code.service.UserService;
import com.myself.winter.utils.ResultVOUtil;
import com.myself.winter.vo.ResultVo;
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

    @Autowired
    private ResultVOUtil resultVOUtil;

    @PostMapping("/resgist")
    public ResultVo resgist(@RequestParam("name") String name,
                            @RequestParam("pass") String pass){
        if (name.isEmpty() | pass.isEmpty()){
            return resultVOUtil.error(444,"【参数错误】");
        }
        User user = userService.findByName(name);
        if (user != null){
            return resultVOUtil.error(445,"【用户存在】");
        }
        User resgist = new User();
        resgist.setName(name);
        resgist.setPass(pass);
        userService.save(resgist);
        return resultVOUtil.success();
    }

    @PostMapping("/login")
    public ResultVo login(@RequestParam("name") String name,
                          @RequestParam("pass") String pass){
        if (name.isEmpty() | pass.isEmpty()){
            return resultVOUtil.error(444,"【参数错误】");
        }
        User user = userService.findByName(name);
        if (user == null){
            return resultVOUtil.error(446,"【用户不存在】");
        }
        if (pass.equals(user.getPass())){
            return resultVOUtil.success(name);
        }else {
            return resultVOUtil.error(447,"【密码错误】");
        }
    }
}
