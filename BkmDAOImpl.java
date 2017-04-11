package cn.ysu.lius.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.ysu.lius.dao.IBkmDAO;
import cn.ysu.lius.vo.Bkm;
public  class BkmDAOImpl implements IBkmDAO{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public BkmDAOImpl (Connection conn){
		this.conn=conn;
	}
	//create a table
	public boolean doCreate(Bkm bkm) throws Exception{
		boolean flag=false;
		String sql="INSERT INTO bkm(bkmno,bkmname,bkmurl,addate) VALUES(?,?,?,?)"; //
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,bkm.getBkmno());
		this.pstmt.setString(2,bkm.getBkmname());
		this.pstmt.setString(3,bkm.getBkmurl());
		this.pstmt.setDate(4,new java.sql.Date(bkm.getAddate().getTime()));
		if(this.pstmt.executeUpdate()>0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	} 
	//delete a row
	public boolean doDelete(int bkmno) throws Exception{
		boolean flag=false;
		String sql="DELETE FROM bkm WHERE bkmno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,bkmno);
		if(this.pstmt.executeUpdate()>0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}
	// find all in the table
	public List<Bkm> findAll(String keyword) throws Exception{
		List<Bkm> all=new ArrayList<Bkm>();   //define a array to load all the data
		String sql="SELECT bkmno,bkmname,bkmurl,addate FROM bkm WHERE bkmname LIKE ? OR bkmurl LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,"%"+keyword+"%");
		this.pstmt.setString(2,"%"+keyword+"%");
		ResultSet rs=this.pstmt.executeQuery();  // used to update the db like select&insert etc
		Bkm bkm=null;
		while(rs.next()){
			bkm=new Bkm();
			bkm.setBkmno(rs.getInt(1));
			bkm.setBkmname(rs.getString(2));
			bkm.setBkmurl(rs.getString(3));
			bkm.setAddate(rs.getDate(4));
			all.add(bkm);
		}
		this.pstmt.close();
		return all;
	}
	public Bkm findById(int bkmno) throws Exception{
		Bkm bkm=null;
		String sql="SELECT bkmno,bkmname,bkmurl,addate FROM bkm WHERE bkmno=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,bkmno);
		ResultSet rs=this.pstmt.executeQuery(); 
		if(rs.next()){
			bkm=new Bkm();
			bkm.setBkmno(rs.getInt(1));
			bkm.setBkmname(rs.getString(2));
			bkm.setBkmurl(rs.getString(3));
			bkm.setAddate(rs.getDate(4));
		}
		this.pstmt.close();
		return bkm;
	}
}

