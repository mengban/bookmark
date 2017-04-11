package cn.ysu.lius.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.ysu.lius.dao.IUserDAO;
import cn.ysu.lius.vo.User;
public  class UserDAOImpl implements IUserDAO{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public UserDAOImpl (Connection conn){
		this.conn=conn;
	}
	//create a table
	public boolean doCreate(User user) throws Exception{
		boolean flag=false;
		String sql="INSERT INTO user(userno,username,userpsd,addate) VALUES(?,?,?,?)"; //
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,user.getUserno());
		this.pstmt.setString(2,user.getUsername());
		this.pstmt.setString(3,user.getUserpsd());
		this.pstmt.setDate(4,new java.sql.Date(user.getAddate().getTime()));
		if(this.pstmt.executeUpdate()>0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	} 
	//delete a row
	public boolean doDelete(int userno) throws Exception{
		boolean flag=false;
		String sql="DELETE FROM user WHERE userno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,userno);
		if(this.pstmt.executeUpdate()>0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}
	// find all in the table
	public List<User> findAll(String keyword) throws Exception{
		List<User> all=new ArrayList<User>();   //define a array to load all the data
		String sql="SELECT userno,username,userpsd,addate FROM user WHERE username LIKE ? OR userno LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,"%"+keyword+"%");
		this.pstmt.setString(2,"%"+keyword+"%");
		ResultSet rs=this.pstmt.executeQuery();  // used to update the db like select&insert etc
		User user=null;
		while(rs.next()){
			user=new User();
			user.setUserno(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUserpsd(rs.getString(3));
			user.setAddate(rs.getDate(4));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}
	public User findById(int userno) throws Exception{
		User user=null;
		String sql="SELECT userno,username,userpsd,addate FROM user WHERE userno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,userno);
		ResultSet rs=this.pstmt.executeQuery(); 
		if(rs.next()){
			user=new User();
			user.setUserno(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUserpsd(rs.getString(3));
			user.setAddate(rs.getDate(4));
		}
		this.pstmt.close();
		return user;
	}
	//check user
	public boolean doCheck(User user) throws Exception{
		boolean flag=false;
		String sql="SELECT * FROM user WHERE username=? AND userpsd=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,user.getUsername());
		this.pstmt.setString(2,user.getUserpsd());
		ResultSet rs=this.pstmt.executeQuery(); 
		if(rs.next()){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}
	//get the max no
	public int getCurMaxno() throws Exception{
		int count=0;
		String sql="SELECT MAX(userno) FROM user";
		this.pstmt=this.conn.prepareStatement(sql);
		//this.pstmt.setString(1,"userno");
		ResultSet rs=this.pstmt.executeQuery(); 
		if(rs.next()){
			count=rs.getInt(1)+1;
		}
		this.pstmt.close();
		return count;
	}
}













