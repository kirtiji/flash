package com.extremity.service;

import java.util.List;

import com.extremity.model.User;

public interface Servicee {
	public void saveUser(User user);
	public List<User> loginuser(String username,String password);
	public List<User> getalldata(User user);
	//public List<User> displayAll(User user);
	public void deleteUser(int id);
	public User editUser(int id);
	public void updateUser(User user);
}
