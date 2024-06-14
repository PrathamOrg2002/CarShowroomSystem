package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;

public class ServicingCarBillRepository extends DBHelper {

	public boolean setBill(int amt,int carid,int cusid)
	{
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("insertIntoServBill"));
			pstmt.setInt(1, amt);
			pstmt.setInt(2, carid);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Bill set succesfull");
				
				int bid=this.getIdbillByCarId(carid);
				pstmt=conn.prepareStatement(properties.getProperty("insertIntocusbilljoin"));
				pstmt.setInt(1, bid);
				pstmt.setInt(2, cusid);
				value=pstmt.executeUpdate();
				if(value>0)
				{
					System.out.println("Bill customer joined succesfull");
				return true;
				}
				return false;
			}
			else
			{
				System.out.println("Bill set not succesfull");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public int getIdbillByCarId(int carid)
	{
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getBillIdByCarId"));
			pstmt.setInt(1, carid);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				System.out.println("bill id not found");
				return -1;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return -1;
		}
		
	}
	public boolean getBill(int cusid)
	{
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getBillByCusId"));
			pstmt.setInt(1, cusid);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("bid\tamount\tdate\tcarid");
				System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getDate(3)+"\t"+rs.getInt(4));
				return true;
			}
			else
			{
				System.out.println("Bill not found");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public boolean getSaleByParticularDate(String fromdate, String todate) {
		
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getSaleByParticularDate"));
			pstmt.setString(1, fromdate);
			pstmt.setString(2, todate);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("The sale from "+fromdate+" to "+todate+" is "+rs.getInt(1));
				return true;
			}
			return false;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	
	
}
