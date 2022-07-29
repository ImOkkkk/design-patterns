package com.controller;

import com.pojo.UserVo;

/**
 * @author ImOkkkk
 * @date 2022/7/29 9:21
 * @since 1.0
 */
public interface IUserController {

  UserVo login(String telephone, String password);

  UserVo register(String telephone, String password);
}
