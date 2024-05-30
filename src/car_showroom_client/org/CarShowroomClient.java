package car_showroom_client.org;

import java.util.*;
import java.util.Scanner;

import car_showroom_model.org.CarIssue;
import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.LoginModel;
import car_showroom_model.org.ServicingCarModel;
import car_showroom_model.org.ServicingCustomerModel;
import car_showroom_service.org.CarIssueService;
import car_showroom_service.org.CarMasterService;
import car_showroom_service.org.LoginService;
import car_showroom_service.org.ServicingCustomerService;

public class CarShowroomClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CarMasterService cMService= new CarMasterService();
		LoginService lServices = new LoginService();
		ServicingCustomerService scs=new ServicingCustomerService();
		CarIssueService cis=new CarIssueService();
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
					System.out.println("2. Servicing Center Login :) :)");
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
							//Servicing center
							int choice3=0;
							do
							{
								System.out.println("\n===x=== Welcome To Servicing center Block ===x===\n");
								System.out.println("1. Add new Customer");
								System.out.println("2. Add new problems/issue/modification element of car");
								System.out.println("5. Exit");
								System.out.println("\n===x=========================================x===\n");
								System.out.println("Enter your choice");
								choice3=sc.nextInt();
								sc.nextLine();
								
								switch(choice3)
								{
								case 1:
									System.out.println("Enter Customer Name");
									String name=sc.nextLine();
									System.out.println("Enter Customer Contact number");
									String contact =sc.nextLine();
									
									System.out.println("Enter Car Number");
									String carnumber=sc.nextLine();
									System.out.println("Enter Car model name");
									String carmodelname =sc.nextLine();
									String replay="";
									ArrayList<CarIssue>al=new ArrayList<CarIssue>();
									int flag1=1;
									do
									{
										System.out.println("Enter car problems/issue/modification element one by one");
										String s=sc.nextLine();
										int id=cis.getIssueId(s);
										if(id>0)
										{
											CarIssue imodel=new CarIssue();
											imodel.setIssueid(id);
											imodel.setIssuename(name);
											al.add(imodel);			
										}
										else
										{
											System.out.println("car issue not found add it first");
											flag1=0;
											break;
										}
										System.out.println("Do you want to add more issue");
										replay=sc.nextLine();
																	
									}while(replay.equals("yes"));
									if(flag1==1)
									{
										ServicingCarModel carmodel=new ServicingCarModel(carnumber,carmodelname,al);
										ServicingCustomerModel customermodel=new ServicingCustomerModel(name,contact,carmodel);
										
										b=scs.isAddServicigCutomer(customermodel);
										if(b)
										{
											System.out.println("Customer Added Succesfully");
										}
										else
										{
											System.out.println("Error while adding Customer...");
										}
									}
									
									
									break;
									
								case 2:
									System.out.println("Enter issue name");
									String issuename=sc.nextLine();
									CarIssue imodel=new CarIssue(issuename);
									b=cis.isAddIssue(imodel);
									if(b)
									{
										System.out.println("Issue Added Succesfully");
									}
									else
									{
										System.out.println("Error while adding Issue...");
									}
									break;
								
								default:
									System.out.println("Enter correct choice");
								}
								
							}while(choice3!=5);
							
							//Servicing center end
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
