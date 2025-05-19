package com.dev.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.chat.common.exception.ServiceException;
import com.dev.chat.mapper.UserMapper;
import com.dev.chat.util.FileUploadUtil;
import com.dev.chat.util.JWTUtil;
import com.dev.chat.util.SHA256Util;
import com.dev.chat.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JWTUtil jwtUtil;
	
	public UserVO insertUser(UserVO user) {
		if(userMapper.selectUserById(user.getUiId())!=null) {
			throw new ServiceException(user.getUiId() + "는 이미 존재하는 아이디입니다.");
		}
		if(user.getUiImg()!=null) {
			String originFileName = user.getUiImg().getOriginalFilename(); // cat.jpg
			user.setUiImgName(originFileName);
			String realPath = FileUploadUtil.saveFile(user.getUiImg()); // asdfasdf-sadf-asf-as-fsad.jgp
			user.setUiImgPath(realPath);
		}
		user.setUiPwd(SHA256Util.encodePwd(user.getUiPwd()));
		userMapper.insertUser(user);
		return userMapper.selectUserById(user.getUiId());
	}
	
	public UserVO login(UserVO user) {
		String encodePwd = SHA256Util.encodePwd(user.getUiPwd());
		UserVO dbUser = userMapper.selectUserById(user.getUiId());
		
		if(dbUser==null || !encodePwd.equals(dbUser.getUiPwd())) {
			throw new ServiceException("아이디나 비밀번호를 확인해주세요");
		}
		String token = jwtUtil.getToken(dbUser);
		dbUser.setToken(token);
		return dbUser;
	}
	public List<UserVO> getUserList(UserVO user){
		return userMapper.selectUsers();
	}

	public UserVO getUser(int uiNum) {
		return userMapper.selectUser(uiNum);
	}
}
