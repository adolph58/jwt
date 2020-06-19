package com.example.jwt.controller;

import com.example.jwt.auth.Audience;
import com.example.jwt.auth.JwtTokenUtil;
import com.example.jwt.domain.User;
import com.example.jwt.service.UserService;
import com.example.jwt.util.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (User)表控制层
 *
 * @author arte
 * @since 2020-06-18 21:19:39
 */
@RestController
@RequestMapping("/user")
public class UserController{
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    @Autowired
    private Audience audience;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result selectOne(@PathVariable("id") Long id) {
        return Result.success(this.userService.queryById(id));
    }
    
    /**
     * 新增一条数据
     */
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return Result.success(this.userService.insert(user));
    }
    
    /**
     * 修改数据
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        return Result.success(this.userService.update(user));
    }
    
    /**
     * 通过主键删除单条数据
     * @param id 主键
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return Result.success(this.userService.deleteById(id));
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        return userService.login(username, password);
    }

    @GetMapping("/getUserInfo")
    public Result getUserInfo(String token) {
        User user = new User();
        user.setId(Long.parseLong(JwtTokenUtil.getUserId(token, audience.getBase64Secret())));
        user.setUsername(JwtTokenUtil.getUsername(token, audience.getBase64Secret()));
        return Result.success(user);
    }

}