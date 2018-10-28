package com.imooc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.service.UserService;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "用户相关的接口",tags = {"用户controller"})
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册",notes = "用户注册的接口")
    @PostMapping("registry")
    public ResponseEntity userRegistry(@RequestBody Users user){
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
            return ResponseEntity.badRequest().body("用户名和密码不能为空");
        }
        boolean flag = userService.queryForUserIsExit(user.getUsername());
        if (flag){
            return ResponseEntity.badRequest().body("用户名已存在");
        }
        user.setFansCounts(0);
        user.setFollowCounts(0);
        user.setNickname(user.getUsername());
        user.setReceiveLikeCounts(0);
        try {
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        userService.saveUser(user);


        return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "用户查询")
    @GetMapping("list")
    public ResponseEntity getAllUsers(
            @RequestParam(value = "page",defaultValue = "1") int page ,
            @RequestParam(value = "rows",defaultValue = "5") int rows){

        PageInfo<Users> pageInfo = userService.selectAllUsers(page, rows);
        if (pageInfo == null || pageInfo.getTotal() < 1){
            return ResponseEntity.badRequest().body("没有查询到结果");

        }
        return ResponseEntity.ok(pageInfo);

    }


}
