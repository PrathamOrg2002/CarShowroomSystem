package car_showroom_service.org;

import java.util.ArrayList;

import car_showroom_model.org.CarMasterModel;
import car_showroom_repository.org.CarMasterRepository;

public class CarMasterService {
	CarMasterRepository cMRepo = new CarMasterRepository();

	public boolean addCarData(CarMasterModel cMModel) {
		return cMRepo.addCarData(cMModel);
	}

	public ArrayList<CarMasterModel> getAllCars() {
		return cMRepo.getAllCars();
	}

	public long getShowCarPriceById(int carId) {
		return cMRepo.getShowCarPriceById(carId);
	}

	public String getShowCarNameById(int carId) {
		return cMRepo.getShowCarNameById(carId);
	}

	public long getShowCarPriceByName(String carName) {
		return cMRepo.getShowCarPriceByName(carName);
	}

	public int getCarIdbyName(String carName) {
		return cMRepo.getCarIdbyName(carName);
	}

	public int getCarIdAuto() {
		return cMRepo.getCarIdAuto();
	}

	public CarMasterModel getCarFeature(int carId) {
		return cMRepo.getCarFeature(carId);
	}

	public ArrayList<CarMasterModel> getCarByPrice(long carPrice) {
		return cMRepo.getCarByPrice(carPrice);
	}

	public boolean updateCarPrice(CarMasterModel cmm) {
		return cMRepo.updateCarPrice(cmm);
	}

	public boolean updateCarName(CarMasterModel cmm) {
		return cMRepo.updateCarName(cmm);
	}

	public boolean updateCarCC(CarMasterModel cmm) {
		return cMRepo.updateCarCC(cmm);
	}

	public boolean updateCarMileage(CarMasterModel cmm) {
		return cMRepo.updateCarMileage(cmm);
	}

	public boolean updateCarTOfFual(CarMasterModel cmm) {
		return cMRepo.updateCarTOfFual(cmm);
	}

}
