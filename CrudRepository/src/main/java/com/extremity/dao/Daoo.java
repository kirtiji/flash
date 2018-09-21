package com.extremity.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.extremity.model.User;



public interface Daoo extends CrudRepository<User, Integer>{
	@Override
	public <S extends User> S save(S user);
	public List<User> findAllByUsernameAndPassword(String username,String password);
  
  public User findAllById(int id);
  @Override
public void delete(Integer id);
 
  
    
	
 
	
	
	
	
	
}
