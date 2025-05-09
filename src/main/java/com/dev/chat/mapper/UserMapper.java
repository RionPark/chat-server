package com.dev.chat.mapper;

import java.util.List;

import com.dev.chat.vo.UserVO;

public interface UserMapper {
    List<UserVO> selectUsers();
    UserVO selectUser(int uiNum);
    UserVO selectUserById(String uiId);
    int insertUser(UserVO user);
    int updateUser(UserVO user);
    int deleteUser(int uiNum);
}
