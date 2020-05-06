package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.RegistrationBean;
import Connection.DbConnection;

public class RegistrationDao 
{
	static PreparedStatement ps;
	static Connection con = DbConnection.getConnection();
	static int s = 0;
	
	/*******Inserting data into database********/
	
	public static int insert(RegistrationBean rb)
	{
		try {
			ps = con.prepareStatement("INSERT into Student(Name , Address ,Contact, Email) VALUES(? ,?,?,?)");
			ps.setString(1,rb.getName());
			ps.setString(2, rb.getAddress());
			ps.setString(3, rb.getContact());
			ps.setString(4, rb.getEmail());
			s = ps.executeUpdate();
		} catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		return s;
		
	}
	
	
	/***********Select data from database************/
	
	public static List<RegistrationBean> getData()
	{
		ArrayList<RegistrationBean> l = new ArrayList<RegistrationBean>();
		try {
			ps = con.prepareStatement("SELECT * FROM Student");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				RegistrationBean rb = new RegistrationBean();
				rb.setId(rs.getInt(1));
				rb.setName(rs.getString(2));
				rb.setAddress(rs.getString(3));
				rb.setContact(rs.getString(4));
				rb.setEmail(rs.getString(5));
				
				l.add(rb);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return l;
		
	}
	
	/*** selecting data for update*****/
	
	public static List<RegistrationBean> getDataById(int id)
	{
		ArrayList<RegistrationBean> l = new ArrayList<RegistrationBean>();
		try {
			ps = con.prepareStatement("SELECT Name,Address ,Contact ,Email FROM Student where Student_id="+id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				RegistrationBean rb = new RegistrationBean();
				rb.setName(rs.getString(1));
				rb.setAddress(rs.getString(2));
				rb.setContact(rs.getString(3));
				rb.setEmail(rs.getString(4));
				
				l.add(rb);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return l;
		
	}
	
	/*************** For Updating data***************/
	
	public static int update( int id ,RegistrationBean r)
	{
	
		try 
		{
			ps = con.prepareStatement("UPDATE Student SET Name=? , Address=? , Contact=? , Email =? Where Student_id="+id);
			ps.setString(1,r.getName());
			ps.setString(2, r.getAddress());
			ps.setString(3, r.getContact());
			ps.setString(4, r.getEmail());
			s = ps.executeUpdate();
		
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return s;
		
	}
	
	
	
	/************** For Deleteting data****************/
	
	public static int delete(int id)
	{
		
		try 
		{
			ps = con.prepareStatement("DELETE FROM Student WHERE Student_id="+id);
			ps.executeUpdate();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return id;
		
	}



}
