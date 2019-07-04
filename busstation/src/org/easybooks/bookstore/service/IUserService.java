package org.easybooks.bookstore.service;
import java.util.List;

import org.easybooks.bookstore.vo.User;

public interface IUserService {
	public void saveUser(User user);
	public User validateUser(String username,String password);
	public User findUserNameById(Integer id);
	public List getAllUser();
	public boolean exitUser(String username);
}
