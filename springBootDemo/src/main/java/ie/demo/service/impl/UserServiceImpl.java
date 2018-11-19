package ie.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import ie.demo.mapper.StudentCardMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ie.demo.domain.User;
import ie.demo.mapper.UserMapper;
import ie.demo.service.UserService;
import ie.demo.service.PasswordService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private StudentCardMapper studentCardMapper;

	@Autowired
	private PasswordService passwordService;

	@Override
	public int register(User u) {
		int result;
		String username = u.getUsername();
		String newPassword = passwordService.encryptPassword(u.getPassword());
		u.setPassword(newPassword);
		if(u.getStudentCardId() != null) {
			if(studentCardMapper.cardExists(u.getStudentCardId()) == 0) {
				studentCardMapper.createCard(u.getStudentCardId());
			}
		}
		if(userMapper.userExists(username) == 0) {
			try {
				result = userMapper.register(u);
			} catch (DataIntegrityViolationException e) {
				result = 400;
			}
		} else {
			result = 409;
		}
		return result;
	}

	@Override
	public List<String> login(String username, String password) {
		User user = findUserByUserName(username);
		List<String> result = new ArrayList<>();
		if(user == null)
			result.add(0, "404");
		else {
			if(password.equals(passwordService.decryptPassword(user.getPassword()))) {
				result.add(0,"200");
				result.add(Integer.toString(user.getUserId()));
				result.add(Integer.toString(user.getUserTypeId()));
				result.add(user.getUsername());
				result.add(user.getEmail());
				result.add(Integer.toString(user.getIsBanned() ? 1 : 0 ));
			}
			else {
				result.add(0,"400");
			}
		}

		return result;
	}

	@Override
	public User findUserByUserName(String userName) {
		User user = userMapper.findUserByUserName(userName);
		return user;
	}

}
