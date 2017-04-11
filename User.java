package cn.ysu.lius.vo;
import java.util.Date;
public class User{
	private int userno;
	private String username;
	private String userpsd;
	private Date addate;
	// get/set number
	public int getUserno(){
		return userno;
		}
	public void setUserno(int userno){
		this.userno=userno;
	}
	// get/set name
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	// get/set url
	public String getUserpsd(){
		return userpsd;
	}
	public void setUserpsd(String userpsd){
		this.userpsd=userpsd;
	}
    // get/set Addate
	public Date getAddate(){
		return addate;
	}
	public void setAddate(Date addate){
		this.addate=addate;
	}
}