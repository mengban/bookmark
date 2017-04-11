package cn.ysu.lius.vo;
import java.util.Date;
public class Bkm{
	private int bkmno;
	private String bkmname;
	private String bkmurl;
	private Date addate;
	// get/set number
	public int getBkmno(){
		return bkmno;
		}
	public void setBkmno(int bkmno){
		this.bkmno=bkmno;
	}
	// get/set name
	public String getBkmname(){
		return bkmname;
	}
	public void setBkmname(String bkmname){
		this.bkmname=bkmname;
	}
	// get/set url
	public String getBkmurl(){
		return bkmurl;
	}
	public void setBkmurl(String bkmurl){
		this.bkmurl=bkmurl;
	}
    // get/set Addate
	public Date getAddate(){
		return addate;
	}
	public void setAddate(Date addate){
		this.addate=addate;
	}
}