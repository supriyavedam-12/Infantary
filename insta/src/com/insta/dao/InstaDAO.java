package com.insta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.insta.entity.InstaEmployee;

public class InstaDAO implements InstaDAOServiceInterface
{
  private InstaDAO() {}
	public static InstaDAO createObject() {
		// TODO Auto-generated method stub
		return new InstaDAO();
	}
	@Override
	public int createProfileDAO(InstaEmployee ie) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into InstaEmployee values(?,?,?,?)");
			ps.setString(1, ie.getName());
			ps.setString(2, ie.getPass());
			
			ps.setString(3, ie.getEmail());
			ps.setString(4, ie.getAddress());
			i=ps.executeUpdate();
			System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return i;
	}

}
