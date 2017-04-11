package cn.ysu.lius.dao.proxy;
import java.util.List;
import cn.ysu.lius.dao.IUserDAO;
import cn.ysu.lius.dao.impl.UserDAOImpl;
import cn.ysu.lius.dbc.DatabaseConnection;
import cn.ysu.lius.vo.User;
public class UserDAOProxy implements IUserDAO{
	private DatabaseConnection dbc=null;
	private IUserDAO dao=null;
	// structure
	public UserDAOProxy() throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new UserDAOImpl(this.dbc.getConnection());
	} 
	// insert
	public boolean doCreate(User user) throws Exception{
		boolean flag=false;
		try{
			if(this.dao.findById(user.getUserno())==null){
				flag=this.dao.doCreate(user);
			}
		}catch (Exception e ){
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	//delete a row
	public boolean doDelete(int userno) throws Exception{
		boolean flag=false;
		try{
			if(this.dao.doDelete(userno)){
				flag=true;
			}
			}catch (Exception e){
				throw e;
			}
			finally{
				this.dbc.close();
			}
			return  flag;
	}
	// findall
	public List<User> findAll(String keyword) throws Exception{
		List<User> all=null;
		try{
			all=this.dao.findAll(keyword);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}
	//findById
	public User findById(int userno) throws Exception{
		User user=null;
		try{
			user=this.dao.findById(userno);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return user;
	}
	//doCheck
	public boolean doCheck(User user) throws Exception{
		boolean flag=false;
		try{
			flag=this.dao.doCheck(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}
	//get Cur Maxno
	public int getCurMaxno() throws Exception{
		int count=0;
		try{
			count=this.dao.getCurMaxno();
		}catch (Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return count;
	}
}























