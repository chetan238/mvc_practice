package DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

import javax.xml.ws.Response;

import VO.RegVO;

public class RegDAO {

	public void  insert(RegVO p)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc","root","root");
			Statement st=cn.createStatement();
			st.executeUpdate("insert into mvc01(first,last,user,pswd) values('"+p.getFname()+"','"+p.getLname()+"','"+p.getUname()+"','"+p.getPname()+"')");
			st.close();
			cn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List search()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc","root","root");
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("Select * from mvc01");
			List<RegVO> ls = new ArrayList<RegVO>();
			
			while(rs.next())
			{   RegVO p=new RegVO();
				int id=rs.getInt("id");
				String s1=rs.getString("first");
				String s2=rs.getString("last");
				String s3=rs.getString("user");
				String s4=rs.getString("pswd");
				p.setId(id);
				p.setFname(s1);
				p.setLname(s2);
				p.setUname(s3);
				p.setPname(s4);
				ls.add(p);
			}
		   return ls;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void delete(int id)
	{
		
		try {
			int k=id;
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc","root","root");
			Statement st=cn.createStatement();
			st.executeUpdate("delete from mvc01 where id='"+k+"'");
			st.close();
			cn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List edit(int id)
	{
		
		try {
			int k=id;
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc","root","root");
			Statement st=cn.createStatement();
			List ls = new ArrayList();
			ResultSet rs=st.executeQuery("select * from mvc01 where id='"+k+"'");
			while(rs.next())
			{	  RegVO p=new RegVO();
				String s1=rs.getString("first");
				String s2=rs.getString("last");
				String s3=rs.getString("user");
				String s4=rs.getString("pswd");
				System.out.print(s1);
				System.out.print(s2);
				System.out.print(s3);
				System.out.print(s4);
				p.setId(id);
				p.setFname(s1);
				p.setLname(s2);
				p.setUname(s3);
				p.setPname(s4);
				ls.add(p);
			}
			return ls;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
		
	}

	public void update(RegVO x) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc","root","root");
			Statement st=cn.createStatement();
			st.executeUpdate("UPDATE mvc01 SET first = '"+x.getFname()+"' , last = '"+x.getLname()+"' , user = '"+x.getUname()+"' , pswd = '"+x.getPname()+"' WHERE id = '"+x.getId()+"';");
			st.close();
			cn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
