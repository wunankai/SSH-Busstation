package org.easybooks.bookstore.dao;
import java.util.List;

import org.easybooks.bookstore.vo.User;



public interface IUserDAO {
	public void saveUser(User user);
	public User validateUser(String username,String password);
	public User findUserNameById(Integer id);
	public List getAllUser();
	public boolean exitUser(String username);
}
