package car_showroom_service.org;

import car_showroom_model.org.LoginModel;
import car_showroom_repository.org.LoginRepository;

public class LoginService {
	LoginRepository eRR= new LoginRepository();
	public boolean isValidShowEmp(LoginModel eRM) {
		// TODO Auto-generated method stub
		return eRR.isValidShowEmp(eRM);
	}
	public boolean empSignUpInShowR(LoginModel eLModel) {
		// TODO Auto-generated method stub
		return eRR.empSignUpInShowR(eLModel);
	}
	public boolean empSignUpInService(LoginModel eLModel) {
		// TODO Auto-generated method stub
		return eRR.empSignUpInService(eLModel);
	}
	public boolean isValidServiceEmp(LoginModel eLModel) {
		// TODO Auto-generated method stub
		return eRR.isValidServiceEmp(eLModel);
	}

}
