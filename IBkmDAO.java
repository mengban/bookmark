package cn.ysu.lius.dao;
import java.util.List;
import cn.ysu.lius.vo.Bkm;
public  interface IBkmDAO{
	public boolean doCreate(Bkm bkm) throws Exception;
	public boolean doDelete(int bkmno) throws Exception;
	public List<Bkm> findAll(String KeyWord) throws Exception;
	public Bkm findById(int bkmno) throws Exception;
}