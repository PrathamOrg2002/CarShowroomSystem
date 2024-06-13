package car_showroom_repository.org;

import java.util.ArrayList;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarMasterModel;

public class CarMasterRepository extends DBHelper{

	public boolean addCarData(CarMasterModel cMModel) {
		try {
			String insertInCarmaster=p.getProperty("insertInCarmaster");
			cs=conn.prepareCall(insertInCarmaster);
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

	public int getCarIdAuto() {
		try
		{
			String getCarIDAuto=p.getProperty("getCarIDAuto");
			pstmt=conn.prepareStatement(getCarIDAuto);
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
			String getCarFeature=p.getProperty("getCarFeature");
			pstmt=conn.prepareStatement(getCarFeature);
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
			pstmt=conn.prepareStatement(p.getProperty("getCarByPrice"));
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
			pstmt=conn.prepareStatement(p.getProperty("UpdateCarPrice"));
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
			pstmt=conn.prepareStatement(p.getProperty("UpdateCarName"));
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
			pstmt=conn.prepareStatement(p.getProperty("UpdateCarCC"));
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
			pstmt=conn.prepareStatement(p.getProperty("UpdateCarMileage"));
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
			pstmt=conn.prepareStatement(p.getProperty("UpdateCarTypeOfFual"));
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
}
