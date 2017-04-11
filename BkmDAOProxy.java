package cn.ysu.lius.dao.proxy;
import java.util.List;
import cn.ysu.lius.dao.IBkmDAO;
import cn.ysu.lius.dao.impl.BkmDAOImpl;
import cn.ysu.lius.dbc.DatabaseConnection;
import cn.ysu.lius.vo.Bkm;
public class BkmDAOProxy implements IBkmDAO{
	private DatabaseConnection dbc=null;
	private IBkmDAO dao=null;
	// structure
	public BkmDAOProxy() throws Exception{
		this.dbc=new DatabaseConnection();
		this.dao=new BkmDAOImpl(this.dbc.getConnection());
	} 
	// insert
	public boolean doCreate(Bkm bkm) throws Exception{
		boolean flag=false;
		try{
			if(this.dao.findById(bkm.getBkmno())==null){
				flag=this.dao.doCreate(bkm);
			}
		}catch (Exception e ){
			throw e;
		}finally {
			this.dbc.close();
		}
		return flag;
	}
	//delete a row
	public boolean doDelete(int bkmno) throws Exception{
		boolean flag=false;
		try{
			if(this.dao.doDelete(bkmno)){
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
	// fiadall
	public List<Bkm> findAll(String keyword) throws Exception{
		List<Bkm> all=null;
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
	public Bkm findById(int bkmno) throws Exception{
		Bkm bkm=null;
		try{
			bkm=this.dao.findById(bkmno);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return bkm;
	}
}























