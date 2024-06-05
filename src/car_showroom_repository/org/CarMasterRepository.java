package car_showroom_repository.org;

import java.util.ArrayList;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarMasterModel;

public class CarMasterRepository extends DBHelper{

	public boolean addCarData(CarMasterModel cMModel) {
		try {
			String insertInCarmaster=p.getProperty("insertInCarmaster");
			pstmt=conn.prepareStatement(insertInCarmaster);
			pstmt.setString(1, cMModel.getCarName());
			pstmt.setLong(2, cMModel.getCarPrice());
			pstmt.setInt(3, cMModel.getNoOfCar());
			return pstmt.executeUpdate()>0 ? true:false;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error in Car Adding Method!!! "+ex);
		}
		return false;
	}

	public ArrayList<CarMasterModel> getAllCars() {
		ArrayList<CarMasterModel> al= new ArrayList<CarMasterModel>();
		try
		{
			String selectAllcarmaster=p.getProperty("selectAllcarmaster");
			pstmt=conn.prepareStatement(selectAllcarmaster);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				CarMasterModel cmm= new CarMasterModel();
				cmm.setCarId(rs.getInt(1));
				cmm.setCarName(rs.getString(2));
				cmm.setCarPrice(rs.getLong(3));
				cmm.setNoOfCar(rs.getInt(4));
				al.add(cmm);
			}
			return al.size()>0 ? al:null;	
		}
		catch(Exception ex)
		{
			System.out.println("Error in Get Cars method !!?? "+ex);
			return null;
		}
		
	}

	public long getShowCarPriceById(int carId) {
		try
		{
			String selctCarPriceFromCarId=p.getProperty("selctCarPriceFromCarId");
			pstmt=conn.prepareStatement(selctCarPriceFromCarId);
			pstmt.setInt(1, carId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getLong(1);
			}
			else
			{
				return -1;
			}
				
		}
		catch(Exception ex)
		{
			System.out.println("Error in get Showroom Car Price By Id "+ex);

			return -1;
		}
		
	}
  
	public String getShowCarNameById(int carId) {
		try
		{
			String selectCarNameByCarId=p.getProperty("selectCarNameByCarId");
			pstmt=conn.prepareStatement(selectCarNameByCarId);
			pstmt.setInt(1, carId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
			else
			{
				return null;
			}
				
		}
		catch(Exception ex)
		{
			System.out.println("Error in get Showroom Car Price By Id "+ex);
			return null;
		}
		
	}

	public long getShowCarPriceByName(String carName) {
		try
		{
			String selectCarPriceByCarName=p.getProperty("selectCarPriceByCarName");
			pstmt=conn.prepareStatement(selectCarPriceByCarName);
			pstmt.setString(1, carName);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getLong(1);
			}
			else
			{
				return -1;
			}
				
		}
		catch(Exception ex)
		{
			System.out.println("Error in get Showroom Car Price By Name "+ex);
			return -1;
		}
		
	}

	public int getCarIdbyName(String carName) {
		try
		{
			String selectCarIdFromCarName=p.getProperty("selectCarIdFromCarName");
			pstmt=conn.prepareStatement(selectCarIdFromCarName);

			pstmt.setString(1, carName);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return -1;
			}	

		}
		catch(Exception ex)
		{
			System.out.println("Error in get Car Id By Name "+ex);
			return -1;
		}		
	}
}
