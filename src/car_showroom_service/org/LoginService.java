package car_showroom_service.org;

import car_showroom_model.org.LoginModel;
import car_showroom_repository.org.LoginRepository;

public class LoginService {
	LoginRepository eRR = new LoginRepository();

	public boolean isValidShowEmp(LoginModel eRM) {
		return eRR.isValidShowEmp(eRM);
	}

	public boolean empSignUpInShowR(LoginModel eLModel) {
		return eRR.empSignUpInShowR(eLModel);
	}

	public boolean empSignUpInService(LoginModel eLModel) {
		return eRR.empSignUpInService(eLModel);
	}

	public boolean isValidServiceEmp(LoginModel eLModel) {
		return eRR.isValidServiceEmp(eLModel);
	}

}
