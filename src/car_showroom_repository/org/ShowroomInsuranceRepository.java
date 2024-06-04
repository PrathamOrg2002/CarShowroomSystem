package car_showroom_repository.org;

import java.util.ArrayList;

import car_showroom_config.org.DBHelper;
import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.ShowroomInsuranceModel;
import java.util.*;
public class ShowroomInsuranceRepository extends DBHelper{

	public boolean setInsuranceInfo(ShowroomInsuranceModel shInsModel) {
		try
		{
			String insertInInsMaster=p.getProperty("insertInInsMaster");
			pstmt=conn.prepareStatement(insertInInsMaster);
			pstmt.setString(1, shInsModel.getName());
			pstmt.setLong(2,shInsModel.getPrice());
			return pstmt.executeUpdate()>0 ? true: false ;
		}
		catch(Exception ex)
		{
			System.out.println("error in setInsuranceInfo method "+ex);
			return false;
		}
		
	}

	public ArrayList<ShowroomInsuranceModel> getInsuranceList() {
		ArrayList<ShowroomInsuranceModel> al= new ArrayList<ShowroomInsuranceModel>();
		try
		{
			String selectAllInsurance=p.getProperty("selectAllInsurance");
			pstmt=conn.prepareStatement(selectAllInsurance);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShowroomInsuranceModel shInsModel=new ShowroomInsuranceModel();
				shInsModel.setInsId(rs.getInt(1));
				shInsModel.setName(rs.getString(2));
				shInsModel.setPrice(rs.getLong(3));
				al.add(shInsModel);
			}
			return al.size()>0 ? al:null;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error in Get Insurance List metod "+ex);
			return null;
		}
		
	}

	public ShowroomInsuranceModel getInsurancePrice(int insId) {
		try
		{
			String selectInsById=p.getProperty("selectInsById");
			pstmt=conn.prepareStatement(selectInsById);
			pstmt.setInt(1, insId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				
				return new ShowroomInsuranceModel(rs.getString(2),rs.getLong(3));
			}
			return null;
		}
		catch(Exception ex)
		{
			System.out.println("Error in Get price metode "+ex);
			return null;
		}
	}

}
