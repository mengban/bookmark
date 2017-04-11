 package cn.ysu.lius.dao.test;
 import cn.ysu.lius.factory.DAOFactory;
 import cn.ysu.lius.vo.Bkm;
 public class TestDAOInsert{
	 public static void main(String[] args) throws Exception{
		 Bkm bkm=null;
		 for(int i=0;i<5;i++){
			 bkm=new Bkm();
			 bkm.setBkmno(1000+i);
			 bkm.setBkmname("lius-"+i);
			 bkm.setBkmurl("xxoo.com"+i);
			 bkm.setAddate(new java.util.Date());
			 DAOFactory.getIBkmDAOInstance().doCreate(bkm);
		 }
	 }
 }