package cn.ysu.lius.dao;
import java.util.List;
import cn.ysu.lius.vo.User;
public  interface IUserDAO{
	public boolean doCreate(User user) throws Exception;
	public boolean doDelete(int userno) throws Exception;
	public List<User> findAll(String KeyWord) throws Exception;
	public User findById(int userno) throws Exception;
	public boolean doCheck(User user) throws Exception;
	public int getCurMaxno() throws Exception;
}
