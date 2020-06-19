package com.example.jwt.service;

import com.example.jwt.domain.User;
import com.example.jwt.util.Result;

/**
 * (User)表服务接口
 *
 * @author arte
 * @since 2020-06-18 21:19:37
 */
public interface UserService{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 登录
     */
    Result login(String username, String password);

    /**
     * 登出
     */
    void logout(String userId);

}