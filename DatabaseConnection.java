package cn.ysu.lius.dbc;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection{
	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/mldn";
	public static final String DBUSER="root";
	public static final String DBPASSWORD="187127";
	private Connection conn=null;
	public DatabaseConnection() throws Exception {
		try{
			Class.forName(DBDRIVER); //返回一个类 作用是要求JVM查找并加载指定的类
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		}catch (Exception e){
			throw e;
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close() throws Exception{
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch (Exception e){
				throw e;
			}
		}
	}
}