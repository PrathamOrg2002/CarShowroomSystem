package car_showroom_client.org;

import java.util.Scanner;

import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.LoginModel;
import car_showroom_service.org.CarMasterService;
import car_showroom_service.org.LoginService;

public class CarShowroomClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CarMasterService cMService= new CarMasterService();
		LoginService lServices = new LoginService();
		int choice = 0;
		int choice2 = 0;
		do {
			System.out.println("\n1. Cars for Customer :) :)");
			System.out.println("2. Employee Login :) :)");
			System.out.println("3. Exit :) :)");
			System.out.println("Enter the choice");
			choice = sc.nextInt();
			sc.nextLine();
			boolean flag = false; // use for break main loop

			switch (choice) {
			case 1:

				break;
			case 2: // Employee Login

				do {

					System.out.println("\n1. Showroom Login :) :)");
					System.out.println("2. Serviceing Center Login :) :)");
					System.out.println("3. sign-up :) :)");
					System.out.println("4. Exit from Employee Login:) :)");
					System.out.println("Enter the choice");
					choice2 = sc.nextInt();
					sc.nextLine();

					switch (choice2) {
					case 1:
						System.out.println("Enter the Employee User Name ");
						String uName = sc.nextLine();
						System.out.println("Enter the Employee PassWord ");
						String passWord = sc.nextLine();
						LoginModel eLModel = new LoginModel(uName, passWord);
						boolean b = lServices.isValidShowEmp(eLModel);
						if (b) {
							System.out.println("login succesfull");

						} else {
							System.out.println("Not permitted to enter");
						}
						// showroom 
						int choice3=0;
						do {
							System.out.println("1. Add Car Data");
							System.out.println("4. Exit!!!");
							System.out.println("Enter the Choice ");
							choice3=sc.nextInt();
							sc.nextLine();
							switch(choice3)
							{
							case 1:
								System.out.println("Enter the Car Name ");
								String carName=sc.nextLine();
								System.out.println("Enter the Car Price");
								long carPrice=sc.nextInt();
								System.out.println("Enter the number of Cars ");
								int noOfCar=sc.nextInt();
								sc.nextLine();
								CarMasterModel cMModel= new CarMasterModel(carName,carPrice,noOfCar);
								if(cMService.addCarData(cMModel))
								{
									System.out.println("Car is add succesfull:)");
								}
								else {
									System.out.println("Car not added!!");
								}
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								System.out.println("Exit From ShowRoom ");
								break;
							}
						}while(choice3!=4);
						// end Showroom 
						break;
					case 2:
						System.out.println("Enter the Employee User Name ");
						uName = sc.nextLine();
						System.out.println("Enter the Employee PassWord ");
						passWord = sc.nextLine();
						eLModel = new LoginModel(uName, passWord);
						b = lServices.isValidServiceEmp(eLModel);
						if (b) {
							System.out.println("login succesfull");

						} else {
							System.out.println("Not permitted to enter");
							
						}
						break;
					case 3: 	//sign-up
						System.out.println("\n1. Showroom sign-up ");
						System.out.println("2. Service sign-up");
						System.out.println("Enter the choice ");
						int choice1=sc.nextInt();
						sc.nextLine();
						if(choice1==1)
						{
							System.out.println("Enter the Employee User Name for showroom sign-up ");
							uName = sc.nextLine();
							System.out.println("Enter the Employee PassWord for showroom sign-up ");
							passWord = sc.nextLine();
							
							
							eLModel = new LoginModel(uName, passWord);
//							eLModel.setAccessStatus(b);
							b = lServices.empSignUpInShowR(eLModel);
							if (b) {
								System.out.println("Registration Successfully :|");
								System.out.println("Wait for Admin Verification");
							} else {
								System.out.println("Registration fill!!!");
							}
						}
						if(choice==2)
						{
							System.out.println("Enter the Employee User Name for service sign-up ");
							uName = sc.nextLine();
							System.out.println("Enter the Employee PassWord for service sign-up ");
							passWord = sc.nextLine();
							
							
							eLModel = new LoginModel(uName, passWord);
//							eLModel.setAccessStatus(b);
							b = lServices.empSignUpInService(eLModel);
							if (b) {
								System.out.println("Registration Successfully :|");
								System.out.println("Wait for Admin Verification");
							} else {
								System.out.println("Registration fill!!!");
							}
						}
						
						break;
					case 4:
						System.out.println("Exited from Employee Login:) :)");
						break;
					}
				} while (choice2 != 4);
				break;// Employee Login
			case 3:
				System.out.println("Thank You Visit Again");
				break;
			default:
				System.out.println("Enter the Correct choice");
				break;
			}

		} while (choice != 3);

	}

}
