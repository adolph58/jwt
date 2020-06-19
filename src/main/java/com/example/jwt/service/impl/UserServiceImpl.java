package com.example.jwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jwt.auth.Audience;
import com.example.jwt.auth.JwtTokenUtil;
import com.example.jwt.domain.User;
import com.example.jwt.enumeration.ReturnCode;
import com.example.jwt.mapper.UserMapper;
import com.example.jwt.service.UserService;
import com.example.jwt.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (User)表服务实现类
 *
 * @author arte
 * @since 2020-06-18 21:19:38
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Audience audience;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userMapper.selectById(id);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userMapper.updateById(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userMapper.deleteById(id) > 0;
    }

    @Override
    public Result login(String username, String password) {
        User user = userMapper.getUserByUsername(username);
        if (null == user) {
            return Result.fail(ReturnCode.USER_INEXISTENCE);
        }
        if (!user.getPassword().equals(password)) {
            return Result.fail(ReturnCode.USER_INFO_ERROR);
        }
        String token = JwtTokenUtil.createJWT(user.getId().toString(), user.getUsername(), audience);
        return Result.success(token);
    }

    @Override
    public void logout(String userId) {

    }
}