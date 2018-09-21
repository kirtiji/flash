package com.extremity.serviceimpl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extremity.dao.Daoo;
import com.extremity.model.User;
import com.extremity.service.Servicee;



@Service
public class ServiceImpl implements Servicee
{
	@Autowired
	Daoo di;
	@Override
	public void saveUser(User user) {
		di.save(user);
		
	}
	@Override
	public List<User> loginuser(String username,String password) {
		// TODO Auto-generated method stub
		List<User>list=di.findAllByUsernameAndPassword(username, password);
		return list;
	}
	@Override
	public List<User> getalldata(User user) {
		List<User>list=(List<User>) di.findAll();
		return list;
	}
	@Override
	public void deleteUser(int id) {
		di.delete(id);
		// TODO Auto-generated method stub
	
	}
	@Override
	public User editUser(int id) {
		// TODO Auto-generated method stub
		return di.findAllById(id);
	}
	


	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		 di.save(user);
	}

	

	
	

}
