package com.dxr.hospitalmedicinemanagementsystem.service.impl;

import com.dxr.hospitalmedicinemanagementsystem.entity.User;
import com.dxr.hospitalmedicinemanagementsystem.mapper.UserMapper;
import com.dxr.hospitalmedicinemanagementsystem.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author dxr
 * @since 2025-10-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
