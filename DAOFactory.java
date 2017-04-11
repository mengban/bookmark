package cn.ysu.lius.factory;
import cn.ysu.lius.dao.IBkmDAO;
import cn.ysu.lius.dao.proxy.BkmDAOProxy;
import cn.ysu.lius.dao.IUserDAO;
import cn.ysu.lius.dao.proxy.UserDAOProxy;
public class DAOFactory{
	public static IBkmDAO getIBkmDAOInstance() throws Exception{
		return new  BkmDAOProxy();
	}
	public static IUserDAO getIUserDAOInstance() throws Exception{
		return new  UserDAOProxy();
	}
}