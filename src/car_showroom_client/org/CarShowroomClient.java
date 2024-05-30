package car_showroom_client.org;

import java.util.Scanner;

import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.LoginModel;
import car_showroom_model.org.ShowRoomCustomreModel;
import car_showroom_service.org.CarMasterService;
import car_showroom_service.org.LoginService;
import car_showroom_service.org.ShowroomCustomerService;

import java.util.*;
public class CarShowroomClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CarMasterService cMService= new CarMasterService();
		LoginService lServices = new LoginService();
		ShowroomCustomerService sCService= new ShowroomCustomerService();
		int choice = 0;
		int choice2 = 0;
		int choice4=0;
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
				System.out.println("🎉🎉 Welcome to Car Showroom 🎉🎉");
				System.out.println("🙏 Please Fill The Enquiry Form 🙏");
				System.out.println("Enter the Full Name ");
				String name=sc.nextLine();
				System.out.println("Enter the Contact Number");
				String contact=sc.nextLine();
				System.out.println("Enter the City ");
				String city=sc.nextLine();
				ShowRoomCustomreModel scModel= new ShowRoomCustomreModel(name,contact,city);
				if(sCService.AddShowRCustInfo(scModel))
				{
					do
					{
						System.out.println("1. Display All Cars");
						System.out.println("2. See's The Discount Here");
						System.out.println("3. Gate Estimate of Car");
						System.out.println("4. Gate Bill Of Car");
						System.out.println("5. Exit from Customer Menu 😊😊");
						System.out.println("Enter the choice ");
						choice4=sc.nextInt();
						sc.nextLine();
						switch(choice4)
						{
						case 1:
							System.out.println("All Cars Information");
							ArrayList<CarMasterModel> al=cMService.getAllCars();
							System.out.println("Car ID \t Name \t Price ");
							for(CarMasterModel cMModel1 : al)
							{
								System.out.println(cMModel1.getCarId()+"\t"+cMModel1.getCarName()+"\t"+cMModel1.getCarPrice());
							}
							System.out.println();
							break;
						case 2:
							if(sCService.checkDiscount())
							{
								System.out.println("you have 5000/- Discount on Car");
								System.out.println("🎉🎉🎉 Congratulations 🎉🎉🎉");
							}
							else
							{
								System.out.println("You don't have a Discount on Car ");
								System.out.println("🤗🤗 Better luck next time 🤗🤗");
							}
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							System.out.println("🙏 Exit from Customer Menu 🙏");
							break;
						default:
							System.out.println("Invalid Choice 😒😒");
							break;
						}
					}while(choice4!=5);
					
				}
				else
				{
					System.out.println("🙏🙏 Fill Complite Enquiry Form 🙏🙏");
				}
				
				
				
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
							// showroom
							System.out.println("login succesfull");
							int choice3=0;
							do {
								System.out.println("1. Add Car Data");
								System.out.println("2. Display All Cars");
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
									System.out.println("All Cars Information");
									ArrayList<CarMasterModel> al=cMService.getAllCars();
									System.out.println("Car ID \t Name \t Price \t Car Count");
									for(CarMasterModel cMModel1 : al)
									{
										System.out.println(cMModel1.getCarId()+"\t"+cMModel1.getCarName()+"\t"+cMModel1.getCarPrice()+"\t"+cMModel1.getNoOfCar());
									}
//									System.out.println();
									break;
								case 3:
									break;
								case 4:
									System.out.println("Exit From ShowRoom ");
									break;
								}
							}while(choice3!=4);
							// end Showroom 

						} else {
							System.out.println("Not permitted to enter");
						}
						 
						
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
