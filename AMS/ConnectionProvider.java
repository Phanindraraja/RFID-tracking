

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;



public class ConnectionProvider
{
	public static String driverstring="com.mysql.jdbc.Driver";
	public static String connectionstring="jdbc:mysql://localhost/rfid_tool";
	public static String Username="root";
	public static String Password="root";
	
	public static Connection availabilityconn=null;
		
	
		public static Connection openConnection()
		{
			Connection connection=null;
			try
			{
				Class.forName(driverstring).newInstance();
				connection = DriverManager.getConnection(connectionstring,Username,Password);
			}
			catch(SQLException se)
			{
				System.out.println("exception "+se);
			}
			catch(Exception e)
			{
				System.out.println("Exception e");
			}
			return connection;
		}
		public static void closeConnection(Connection conn)
		{
			try
			{
				conn.close();
				System.gc();
			}catch(Exception e)
			{
				System.out.println("Exception e");
			}
		}
		public static void main(String[] args)  
		{
			try
			{
//				System.out.println(retdata("UserA"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		public  static String getCurrentDate()
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date curdate = new java.util.Date();
			return formatter.format(curdate);
		}
		public  static String getCurrentTime()
		{
			SimpleDateFormat sdftime = new SimpleDateFormat("HH-mm-ss");
			java.util.Date curdate = new java.util.Date();
			return sdftime.format(curdate);
		}
		public static Vector loadfiledata(String query)throws SQLException
		{
			Statement stmt=null;
			ResultSet rs=null;
			Vector vct=new Vector();
			
			try
			{
				availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 while(rs.next())
				 {
					 vct=new Vector();
					 vct.add(rs.getString(1));
					 vct.add(rs.getString(2));
					 vct.add(rs.getString(3));
				 }
			}catch (Exception e) {
				// TODO: handle exception
			}
			return vct;
		}
		public static boolean getavailability1(String query) throws SQLException
		{
			boolean toreturn=false;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				if(rs.next())
				{
					toreturn=true;
				}	
				else
				{
					toreturn=false;
				}
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			ConnectionProvider.closeConnection(availabilityconn);
			return toreturn;
		}
		public static String retpwd(String un) throws SQLException
		{
			String toreturn="",query="";
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
				 query="select category from firewallhandler where rightsto='"+un+"'";
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				while(rs.next())
				{
					toreturn=rs.getString(1);
				}	
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			return toreturn;
		}
		public static String getdata(String query) throws SQLException
		{
			String toreturn="";
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				while(rs.next())
				{
					toreturn=rs.getString(1);
				}	
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
//			System.err.println("to retur ==> "+toreturn);
			if(toreturn==null||toreturn.isEmpty()||toreturn.equals(""))
			{
				toreturn="";
			}
			return toreturn;
		}
		public static boolean getAvailability(String un,String pass)
		{
			boolean result=false;
			Statement stmt=null;
			ResultSet rs=null;
			String query="";
			try
			{
				availabilityconn=ConnectionProvider.openConnection();
				stmt=availabilityconn.createStatement();
				query="select * from login where uname='"+un.trim()+"' and pass='"+pass.trim()+"'";
				rs=stmt.executeQuery(query);
//				System.out.println(query);
				if(rs.next())
				{
					 result=true;
				}	
				else
				{
					result=false;
				}
				stmt.close();
				rs.close();
				
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return result;
		}
		public static void insertValuestoDb(String Query) throws SQLException
		{
			String toreturn="";
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(Query);
				 stmt.execute(Query);
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		public static Vector retSingleValue(String un) throws SQLException
		{
			String toreturn="",query="";
			Vector vct_value=new Vector();
			Statement stmt=null;
			ResultSet rs=null;
			int ln_pos=-1;
			try
			{
				
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
				 query="select category from firewallhandler where rightsto='"+un+"'";
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 
				 vct_value.add("0");
				 vct_value.add("0");
				 vct_value.add("0");
				 vct_value.add("0");
				 vct_value.add("0");
				while(rs.next())
				{
					ln_pos=Integer.parseInt(rs.getString(1).trim());
					vct_value.removeElementAt(ln_pos-1);
					vct_value.insertElementAt(rs.getString(1).trim(),ln_pos-1);
					//vct_value.add(rs.getString(1));
				}	
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			return vct_value;
		}
		
		public static Vector retrievedata(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_data=new Vector();
					vct_data.add(rs.getString(1));
					vct_data.add(rs.getString(2));
					vct_toreturn.add(vct_data);
				}	
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return vct_toreturn;
		}
		public static Vector getdataSet(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_toreturn.add(rs.getString(1));
				}	
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("");
			}
			return vct_toreturn;
		}
		public static Vector getdataforcombo(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_toreturn.add(rs.getString(1));
				}	
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return vct_toreturn;
		}
		public static Vector getdataSetall(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_data=new Vector();
					vct_data.add(rs.getInt(1));
					vct_data.add(rs.getString(2));
					vct_data.add(rs.getString(3));
					vct_data.add(rs.getString(4));
					vct_data.add(rs.getString(5));
					vct_toreturn.add(vct_data);
				}
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("");
			}
			return vct_toreturn;
		}
		public static Vector getdataSetanalysis(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_data=new Vector();
					vct_data.add(rs.getString(1));
					vct_data.add(rs.getString(2));
					vct_data.add(rs.getString(3));
					vct_data.add(rs.getString(4));
					vct_toreturn.add(vct_data);
				}
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("");
			}
			return vct_toreturn;
		}
		public static Vector getdataSetthree(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_data=new Vector();
					vct_data.add(rs.getString(1));
					vct_data.add(rs.getString(2));
					vct_data.add(rs.getString(3));
					vct_toreturn.add(vct_data);
				}
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("");
			}
			return vct_toreturn;
		}
		public static Vector getdataSetfive(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
//				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_data=new Vector();
					vct_data.add(rs.getInt(1));
					vct_data.add(rs.getString(2));
					vct_data.add(rs.getString(3));
					vct_data.add(rs.getString(4));
					vct_data.add(rs.getString(5));
					vct_toreturn.add(vct_data);
				}
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("");
			}
			return vct_toreturn;
		}
		public static Vector gettwodataset(String query) throws SQLException
		{
			Vector vct_toreturn=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
				 System.out.println(query);
				 rs=stmt.executeQuery(query);
				 vct_toreturn=new Vector();
				while(rs.next())
				{
					vct_data=new Vector();
					vct_data.add(rs.getString(1));
					vct_data.add(rs.getString(2));
					vct_toreturn.add(vct_data);
				}
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("0");
			}
			return vct_toreturn;
		}
		public static Vector gettwodatasetlist(Vector list) throws SQLException
		{
			Vector vct_toreturn=null;
			String query=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
				 vct_toreturn=new Vector();
				 for(int ln_row=0;ln_row<list.size();ln_row++)
				 {
					 query="select filename,sno from tbl_uploaddetails where sno='"+list.get(ln_row)+"'";
					 rs=stmt.executeQuery(query);
					 
						while(rs.next())
						{
							vct_data=new Vector();
							vct_data.add(rs.getString(1));
							vct_data.add(rs.getString(2));
							vct_toreturn.add(vct_data);
						}
				 }
				 
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("0");
			}
			return vct_toreturn;
		}
		public static Vector gettwodatasetlister(Vector list) throws SQLException
		{
			Vector vct_toreturn=null;
			String query=null;
			Vector vct_data=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				 availabilityconn=ConnectionProvider.openConnection();
				 stmt=availabilityconn.createStatement();
				 vct_toreturn=new Vector();
				 for(int ln_row=0;ln_row<list.size();ln_row++)
				 {
					 query="select filename,sno from tbl_uploaddetails where sno='"+list.get(ln_row)+"'";
					 rs=stmt.executeQuery(query);
					 
						while(rs.next())
						{
							vct_data=new Vector();
							vct_data.add(rs.getString(1));
							vct_data.add(rs.getString(2));
							vct_toreturn.add(vct_data);
						}
				 }
				 
				
				stmt.close();
				rs.close();
			}
			catch(SQLException Sqx)
			{
				Sqx.printStackTrace();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(vct_toreturn.isEmpty())
			{
				vct_toreturn.add("0");
			}
			return vct_toreturn;
		}
}
