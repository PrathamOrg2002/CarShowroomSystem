package car_showroom_repository.org;

import java.util.ArrayList;
import java.sql.*;
import java.util.*;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarMasterModel;

public class CarMasterRepository extends DBHelper{

	public boolean addCarData(CarMasterModel cMModel) {
		try {
			cs=conn.prepareCall(properties.getProperty("insertInCarmaster"));
			cs.setInt(1, cMModel.getCarId());
			cs.setString(2, cMModel.getCarName());
			cs.setLong(3, cMModel.getCarPrice());
			cs.setInt(4, cMModel.getNoOfCar());
			cs.setLong(5, cMModel.getCarCC());
			cs.setInt(6, cMModel.getMileage());
			cs.setString(7, cMModel.getFuel());
			boolean b=cs.execute();
			return !b;
			
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
			pstmt=conn.prepareStatement(properties.getProperty("selectAllcarmaster"));
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
			pstmt=conn.prepareStatement(properties.getProperty("selctCarPriceFromCarId"));
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
			pstmt=conn.prepareStatement(properties.getProperty("selectCarNameByCarId"));
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
			pstmt=conn.prepareStatement(properties.getProperty("selectCarPriceByCarName"));
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
			pstmt=conn.prepareStatement(properties.getProperty("selectCarIdFromCarName"));

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

	public int getCarIdAuto() {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getCarIDAuto"));
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1)+1;
			}
			else
			{
				return -1;
			}	

		}
		catch(Exception ex)
		{
			System.out.println("Error in get Car Id Auto "+ex);
			return -1;
		}
	}

	public CarMasterModel getCarFeature(int carId) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getCarFeature"));
			pstmt.setInt(1, carId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				CarMasterModel cmm= new CarMasterModel();
				cmm.setCarName(rs.getString(1));
				cmm.setCarCC(rs.getLong(2));
				cmm.setMileage(rs.getInt(3));
				cmm.setFuel(rs.getString(4));
				return cmm;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in Get Car Features !!?? "+ex);
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<CarMasterModel> getCarByPrice(long carPrice) {
		ArrayList<CarMasterModel> al= new ArrayList<CarMasterModel>();
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("getCarByPrice"));
			pstmt.setLong(1, carPrice);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				CarMasterModel cMM= new CarMasterModel();
				cMM.setCarName(rs.getString("carName"));
				cMM.setCarPrice(rs.getLong("carPrice"));
				al.add(cMM);
			}
			return al.size()>0 ? al:null;
		}
		catch(Exception ex)
		{
			System.out.println("Error in getCarByPrice method "+ex);
			ex.printStackTrace();
			return null;
		}
		
	}

	public boolean updateCarPrice(CarMasterModel cmm) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("UpdateCarPrice"));
			pstmt.setLong(1, cmm.getCarPrice());
			pstmt.setInt(2, cmm.getCarId());
			return pstmt.executeUpdate() >0 ? true : false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateCarName(CarMasterModel cmm) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("UpdateCarName"));
			pstmt.setString(1, cmm.getCarName());
			pstmt.setInt(2, cmm.getCarId());
			return pstmt.executeUpdate() >0 ? true : false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateCarCC(CarMasterModel cmm) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("UpdateCarCC"));
			pstmt.setLong(1, cmm.getCarCC());
			pstmt.setInt(2, cmm.getCarId());
			return pstmt.executeUpdate() >0 ? true : false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateCarMileage(CarMasterModel cmm) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("UpdateCarMileage"));
			pstmt.setLong(1, cmm.getMileage());
			pstmt.setInt(2, cmm.getCarId());
			return pstmt.executeUpdate() >0 ? true : false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateCarTOfFual(CarMasterModel cmm) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("UpdateCarTypeOfFual"));
			pstmt.setString(1, cmm.getFuel());
			pstmt.setInt(2, cmm.getCarId());
			return pstmt.executeUpdate() >0 ? true : false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public Map<Integer,Integer> getCarStock() {
		try
		{
			Map<Integer,Integer> map= new LinkedHashMap<Integer,Integer>();
			pstmt=conn.prepareStatement(properties.getProperty("getCarStock"));
			rs=pstmt.executeQuery();
			while(rs.next())
			{
//				int carId=rs.getInt(1);
//				System.out.println(rs.getInt(1));
				PreparedStatement pstmt2=conn.prepareStatement("select count(carId) from showcustcarjoin where carId=? group by carId having count(carId) > 0");
				pstmt2.setInt(1,rs.getInt(1));
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
//					System.out.println(rs2.getInt(1));
					map.put(rs.getInt(1), rs2.getInt(1));
				}
			}
//			
//			System.out.println(map);
			return map;
		}
		catch(Exception ex)
		{
			System.out.println("Error in "+ex);
			ex.printStackTrace();
		}
		return null;
	}
}
