package car_showroom_client.org;

import java.io.Console;
import java.util.*;
import car_showroom_custom_exception.org.CheckCustomerException;
import car_showroom_custom_exception.org.CheckEmployeeException;
import car_showroom_custom_exception.org.RunTimeCustomException;
import car_showroom_model.org.CarIssue;
import car_showroom_model.org.CarMasterModel;
import car_showroom_model.org.LoginModel;

import car_showroom_model.org.ServicingCarModel;
import car_showroom_model.org.ServicingCustomerModel;
import car_showroom_service.org.CarIssueService;
import car_showroom_service.org.CarMasterService;
import car_showroom_service.org.LoginService;
import car_showroom_service.org.ServicingCarBillService;
import car_showroom_service.org.ServicingCarService;
import car_showroom_service.org.ServicingCustomerService;
import car_showroom_service.org.ShowroomCarBillService;
import car_showroom_model.org.ShowRoomCustomreModel;
import car_showroom_model.org.ShowroomCarBillModel;
import car_showroom_model.org.ShowroomInsuranceModel;
import car_showroom_service.org.ShowroomCustomerService;
import car_showroom_service.org.ShowroomInsuranceService;

import java.util.*;

public class CarShowroomClient {
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		CarMasterService cMService = new CarMasterService();
		LoginService lServices = new LoginService();
		ShowroomCustomerService sCService = new ShowroomCustomerService();
		ServicingCustomerService scs = new ServicingCustomerService();
		ServicingCarService scservice = new ServicingCarService();
		CarIssueService cis = new CarIssueService();
		ShowroomInsuranceService shInsService = new ShowroomInsuranceService();
		ShowroomCarBillService sCBillService = new ShowroomCarBillService();
		ServicingCarBillService sbillService = new ServicingCarBillService();
		int choice = 0;
		int choice2 = 0;
		int choice4 = 0;
		int choice3=0;
    	int carId;
		do {
			System.out.println("\n----------------------------------");
			System.out.println("1.🚘 Enter in Car Showroom 🚘");
			System.out.println("2.🧑🏻‍💻 Employee Login 🧑🏻‍💻");
			System.out.println("3.🙏🏻 Exit 🙏🏻");
			System.out.println("----------------------------------");
			System.out.print("Enter Your Choice:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:// Car showroom
				System.out.println("\n===========🚘================🚘===========");
				System.out.println("🎉🎉 Welcome to Car Showroom 🎉🎉");
				System.out.println("\n===========🚘================🚘===========");
				System.out.print("Do You Want to Fill Enquiry Form ? (yes/no):");
				String option = sc.nextLine();
				if (option.equals("yes")) {
					try
					{
						System.out.println("Enter the Full Name ");
						String name = sc.nextLine();
						CheckCustomerException.checkCustName(name);
						System.out.println("Enter the Contact Number");
						String contact = sc.nextLine();
						CheckCustomerException.checkCustContact(contact);
						System.out.println("Enter the City ");
						String city = sc.nextLine();
						CheckCustomerException.checkCustCity(city);
						ShowRoomCustomreModel scModel = new ShowRoomCustomreModel(name, contact, city);
						sCService.AddShowRCustInfo(scModel);
					}
					catch(RunTimeCustomException rx)
					{
						System.out.println(rx.getMsg());
						rx.printStackTrace();
					}	
				}
				do {
					System.out.println("\n==============🚘================🚘==============");
					System.out.println("1. Display All Cars");
					System.out.println("2. Check Feature of Car");
					System.out.println("3. Enter the Car Price See the Car Under price");
					System.out.println("4. Checkout Discount Here...");
					System.out.println("5. Get Approximate Estimate Of your favourite Car");
					System.out.println("6. Get Bill Of Car");
					System.out.println("7. Exit from Car Showroom 🙏🏻");
					System.out.println("==============🚘================🚘==============");
					System.out.print("Enter your choice: ");
					choice4 = sc.nextInt();
					sc.nextLine();
					switch (choice4) {
					case 1:
						ArrayList<CarMasterModel> al = cMService.getAllCars();
						if (al != null) {
		
							System.out.println("All Cars Information");
							String header = String.format("%-10s %-20s %-10s", "Car ID", "Car Name", "Price");
				            String separator = String.format("%-10s %-20s %-10s", "----------", "--------------------", "----------");
				            System.out.println(header);
				            System.out.println(separator);
				            
							for (CarMasterModel cMModel1 : al) {
								String data = String.format("%-10s %-20s %-10s", cMModel1.getCarId(), cMModel1.getCarName(), cMModel1.getCarPrice());
								System.out.println(data);
							}
						} else {
							System.out.println("No Cars in Database");
						}
						break;
						
					case 2:  //Check Feature of Car
							System.out.println("Enter the Car ID for Check Features of car");
							carId= sc.nextInt();
							sc.nextLine();
							CarMasterModel cmModel=cMService.getCarFeature(carId);
							if(cmModel!=null)
							{
								String header = String.format("%-20s %-10s %-10s %-15s", "Car Name", "Car CC", "Mileage", "Type Of Fuel");
					            String separator = String.format("%-20s %-10s %-10s %-15s", "--------------------", "----------", "----------", "---------------");
					            String data = String.format("%-20s %-10s %-10s %-15s", cmModel.getCarName(), cmModel.getCarCC(), cmModel.getMileage(), cmModel.getFuel());
					            System.out.println(header);
					            System.out.println(separator);
					            System.out.println(data);
							}
							else
							{
								System.out.println("😌😌 Car Is Not Available 😌😌");
							}
						break;
						
					case 3:    // Enter the Car Price See the Car Under price
						System.out.println("Enter the Car Price ");
						long carPrice=sc.nextLong();
						ArrayList<CarMasterModel>alPrice=cMService.getCarByPrice(carPrice);
						if(alPrice!=null)
						{
							Iterator<CarMasterModel> it= alPrice.iterator();
							System.out.println(String.format("%-20s %-10s", "Car Name", "Car Price"));
							System.out.println(String.format("%-20s %-10s", "--------------------", "----------") );
							while(it.hasNext())
							{
								CarMasterModel cmm=it.next();
								
								System.out.println(String.format("%-20s %-10s", cmm.getCarName(), cmm.getCarPrice()) );
							}
						}
						else {
							System.out.println("😌😌 Car Is Not Available 😌😌");
						}
						break;
						
					case 4:  		//Checkout Discount Here...
						try
						{
							System.out.println("Enter the Customer Name For Discount ");
							String cname=sc.nextLine();
							CheckCustomerException.checkCustName(cname);
							System.out.println("Enter the Customer Contact ");
							String dcontact=sc.nextLine();
							CheckCustomerException.checkCustContact(dcontact);
							ShowRoomCustomreModel srCModel=new ShowRoomCustomreModel();
							srCModel.setCustName(cname);
							srCModel.setContact(dcontact);
							int custId = sCService.getCustIdByName(srCModel);
							if (custId != -1) {
								if (sCService.checkDiscount(custId)) {
									System.out.println("🎉🎉🎉 Congratulations 🎉🎉🎉");
									System.out.println("you have 5000/- Discount on Car");
								} else {
									System.out.println("You don't have a Discount on Car ");
									System.out.println("🤔🤔 Better luck next time 🤔🤔");
								}
							}
							else
							{
								System.out.println("🙏 Customer not found Please Fill Enquiry Form 🙏");
							}
						}
						catch(RunTimeCustomException rx)
						{
							System.out.println(rx.getMsg());
							rx.printStackTrace();
						}
						
						
						break;
					case 5: // Gate Estimate of Car
						System.out.println("  Car Estimate  ");
						System.out.println("Enter the Car Id ");
						int CarId = sc.nextInt();
						sc.nextLine();
						long carPrice = cMService.getShowCarPriceById(CarId);
						if (carPrice != -1) {
							String carName = cMService.getShowCarNameById(CarId);
							if (carName != null) {
								System.out.println("Insurance List ");
								ArrayList<ShowroomInsuranceModel> al1 = shInsService.getInsuranceList();
								if (al1 != null) {
									System.out.println("Id \t Name \t Price");
									for (ShowroomInsuranceModel shIM : al1) {
										System.out.println(
												shIM.getInsId() + "\t" + shIM.getName() + "\t" + shIM.getPrice());
									}
									System.out.println("Enter the Insurance Id");
									int insId = sc.nextInt();
									ShowroomInsuranceModel shRInsModel = shInsService.getInsurancePrice(insId);

									System.out.println("Car Name " + carName + "\tEx Showroom  Price" + carPrice);
									System.out.println("Insurance Name " + shRInsModel.getName() + "\tPrice "
											+ shRInsModel.getPrice());
									System.out.println("Total Price is " + (carPrice + shRInsModel.getPrice()));
								} else {
									System.out.println("Insurance List is not present ????");
								}

							} else {
								System.out.println("Car name not found");
							}

						} else {
							System.out.println("Car price not found by car id");
						}

						break;
					case 6:// Gate Bill Of Car
						try
						{
							System.out.println("Enter the Customer Name");
							String custName = sc.nextLine();
							CheckCustomerException.checkCustName(custName);
							System.out.println("Enter the Customer Contact");
							String contact = sc.nextLine();
							CheckCustomerException.checkCustContact(contact);
							System.out.println("Enter the City ");
							String city = sc.nextLine();
							CheckCustomerException.checkCustCity(city);
							int custId = sCService.getCustIdByName(new ShowRoomCustomreModel(custName, contact, city));
							if (custId != -1) {
								System.out.println("Enter Car Name");
								String carName = sc.nextLine();
								carPrice = cMService.getShowCarPriceByName(carName);
								if (carPrice != -1) {
									carId = cMService.getCarIdbyName(carName);
									ArrayList<ShowroomInsuranceModel> al1 = shInsService.getInsuranceList();

									if (al1 != null) {
										System.out.println("Insurance List ");
										System.out.println("Id \t Name \t Price");
										for (ShowroomInsuranceModel shIM : al1) {
											System.out.println(
													shIM.getInsId() + "\t" + shIM.getName() + "\t" + shIM.getPrice());
										}
									} else {
										System.out.println("Insurance List is not present ????");
									}
									System.out.println("Enter the Insurance Id");
									int insId = sc.nextInt();
									ShowroomInsuranceModel shRInsModel = shInsService.getInsurancePrice(insId);
									if (shRInsModel != null) {
										System.out.println("\n🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆");
										System.out.println("Customer Name :- " + custName);
										System.out.println("Car Name :- " + carName + "\t" + "Car Price :- " + carPrice);
										System.out.println("Insurance Name :- " + shRInsModel.getName() + "\t"
												+ "Insurance Price :-" + shRInsModel.getPrice());
										System.out.println("Total Bill :- " + (shRInsModel.getPrice() + carPrice));
										ShowroomCarBillModel sCBillModel = new ShowroomCarBillModel(custId, carId);
										sCBillModel.setIncurance(insId);
										sCBillModel.setTotal((shRInsModel.getPrice() + carPrice));
										if (sCBillService.addDataInBill(sCBillModel)) {
											System.out.println("😊😊 Bill Add succesfully 😊😊");
										} else {
											System.out.println("😌😌 Bill not Added 😌😌");
										}
										System.out.println("🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆🔆\n");
									} else {
										System.out.println("ShowroomInsuranceModel not found");
									}

								} else {
									System.out.println("Car price not found by name");
								}

							} else {
								System.out.println("Customer not found Please Fill Enquiry Form");
							}
						}
						catch(RunTimeCustomException rx)
						{
							System.out.println(rx.getMsg());
							rx.printStackTrace() ;
						}
						
						break;
					case 7:
						System.out.println("😌😌 Exit from Car Showroom 😌😌");
						break;
					default:
						System.out.println("Invalid Choice 😌😌");
						break;
					}
				} while (choice4 != 7);
				break;
			case 2: // Employee Login
				do {
					System.out.println("\n----------------------------------");
					System.out.println("1. 🚘 Showroom Login 🚘");
					System.out.println("2. ⚙️ Servicing Center Login ⚙️");
					System.out.println("3. 😀 Sign-up 😀");
					System.out.println("4. 🙏🏻 Exit from Employee Login 🙏🏻");
					System.out.println("----------------------------------");
					System.out.print("Enter your choice: ");
					choice2 = sc.nextInt();
					sc.nextLine();

					switch (choice2) {
					case 1:
						try
						{
							System.out.println("Enter the Employee User Name ");
							String uName = sc.nextLine();
							CheckEmployeeException.checkEmpUname(uName);
							System.out.println("Enter the Employee Password ");
							String passWord = sc.nextLine();
							CheckEmployeeException.checkEmpPass(passWord);
							LoginModel eLModel = new LoginModel(uName, passWord);
							boolean b = lServices.isValidShowEmp(eLModel);
							if (b) {
								System.out.println("login succesfull");
								
								do {
									System.out.println("\n==============🚘================🚘==============");
									System.out.println("1. Add Car Data");
									System.out.println("2. Display All Cars");
									System.out.println("3. Add Insurance Info");
									System.out.println("4. Update Car Data");
									System.out.println("5. Exit!!!");
									System.out.println("==============🚘================🚘==============");
									System.out.print("Enter the Choice: ");
									choice3 = sc.nextInt();
									sc.nextLine();
									switch (choice3) {
									case 1:
										System.out.println("Enter the Car Name ");
										String carName = sc.nextLine();
										System.out.println("Enter the Type of Fuel");
										String fuel=sc.next();
										System.out.println("Enter the Car CC ");
										long carCC=sc.nextLong();
										System.out.println("Enter the car Mileage");
										int mileage=sc.nextInt();
										System.out.println("Enter the Car Price");
										long carPrice = sc.nextInt();
										System.out.println("Enter the number of Cars ");
										int noOfCar = sc.nextInt();
										sc.nextLine();
										CarMasterModel cMModel = new CarMasterModel(carName, carPrice, noOfCar);
										cMModel.setFuel(fuel);
										cMModel.setCarCC(carCC);
										cMModel.setMileage(mileage);
										cMModel.setCarId(cMService.getCarIdAuto());
										if (cMService.addCarData(cMModel)) {
											System.out.println("Car added succesfull:)");
										} else {
											System.out.println("Car not added!!");
										}
										break;
									case 2:
										System.out.println("All Cars Information");
										ArrayList<CarMasterModel> al = cMService.getAllCars();
										System.out.println("Car ID \t Name \t Price \t Car Count");
										for (CarMasterModel cMModel1 : al) {
											System.out.println(cMModel1.getCarId() + "\t" + cMModel1.getCarName() + "\t"
													+ cMModel1.getCarPrice() + "\t" + cMModel1.getNoOfCar());
										}
										break;
									case 3:
										System.out.println("Enter the Insurance Name");
										String InsuranceName = sc.nextLine();
										System.out.println("Enter the Insurance Price");
										long insPrice = sc.nextLong();
										ShowroomInsuranceModel shInsModel = new ShowroomInsuranceModel(InsuranceName,
												insPrice);
										if (shInsService.setInsuranceInfo(shInsModel)) {
											System.out.println("Insurance Information is added");
										} else {
											System.out.println("Insurance Information is not added");
										}
										break;
									case 4:
										do {
											carId=0;
											System.out.println("\n♻️➖➖➖➖➖➖➖➖➖➖➖➖➖♻️➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖♻️");
											System.out.println("\t1. Update Car Price");
											System.out.println("\t2. Update Car Name ");
											System.out.println("\t3. Update Car CC");
											System.out.println("\t4. Update Car mileage");
											System.out.println("\t5. Update Type of Fual");
											System.out.println("\t6. Exit from Update menu");
											System.out.println("♻️➖➖➖➖➖➖➖➖➖➖➖➖➖➖♻️➖➖➖➖➖➖➖➖➖➖➖➖➖➖♻️");
											System.out.println("Enter the choice ");
											choice=sc.nextInt();
											if(choice!=6)
											{
												System.out.println("\t Enter the Car ID from Update ");
												carId=sc.nextInt();
											}
											sc.nextLine();
											switch(choice)
											{
											case 1:
												System.out.println("Enter the Car Price for Update");
												carPrice=sc.nextLong();
												sc.nextLine();
												CarMasterModel cmm= new CarMasterModel();
												cmm.setCarId(carId);
												cmm.setCarPrice(carPrice);
												if(cMService.updateCarPrice(cmm))
												{
													System.out.println("Car Price is Update");
												}
												else
												{
													System.out.println("Car Price is Not Update");
												}
												break;
											case 2:
												System.out.println("Enter the Car Name for Update");
												carName=sc.nextLine();
												cmm= new CarMasterModel();
												cmm.setCarId(carId);
												cmm.setCarName(carName);
												if(cMService.updateCarName(cmm))
												{
													System.out.println("Car Name is Update");
												}
												else
												{
													System.out.println("Car Name is Not Update");
												}
												break;
											case 3:
												System.out.println("Enter the Car CC for Update");
												carCC=sc.nextLong();
												sc.nextLine();
												cmm= new CarMasterModel();
												cmm.setCarId(carId);
												cmm.setCarCC(carCC);
												if(cMService.updateCarCC(cmm))
												{
													System.out.println("Car CC is Update");
												}
												else
												{
													System.out.println("Car CC is Not Update");
												}
												break;
											case 4:  // Update Car mileage
												System.out.println("Enter the Car mileage for Update");
												mileage=sc.nextInt();
												sc.nextLine();
												cmm= new CarMasterModel();
												cmm.setCarId(carId);
												cmm.setMileage(mileage);
												if(cMService.updateCarMileage(cmm))
												{
													System.out.println("Car mileage is Update");
												}
												else
												{
													System.out.println("Car mileage is Not Update");
												}
												break;
											case 5:  //	Type of Fual
												System.out.println("Enter the Car Type of Fual for Update");
												fuel=sc.nextLine();
												cmm= new CarMasterModel();
												cmm.setCarId(carId);
												cmm.setFuel(fuel);
												if(cMService.updateCarTOfFual(cmm))
												{
													System.out.println("Car Type of Fual is Update");
												}
												else
												{
													System.out.println("Car Type of Fual is Not Update");
												}
												break;
											case 6:
												System.out.println("♻️ Exit From Update Menu ♻️");
												break;
											}
										}while(choice!=6);
										break;
									case 5:
										System.out.println("Exit From Showroom ");
										break;
									}
								} while (choice3 != 5);
								// end Showroom
							} else {
								System.out.println("Not permitted to enter");
							}
						}
						catch(RunTimeCustomException rx)
						{
							System.out.println(rx.getMsg());
							rx.printStackTrace();
						}
						
						break;
					case 2:
						try {
							System.out.println("Enter the Employee User Name ");
							String uName = sc.nextLine();
							CheckEmployeeException.checkEmpUname(uName);
							System.out.println("Enter the Employee PassWord ");
							String passWord = sc.nextLine();
							CheckEmployeeException.checkEmpPass(passWord);
							LoginModel eLModel = new LoginModel(uName, passWord);
							boolean b = lServices.isValidServiceEmp(eLModel);
							if (b) // Servicing center
							{
								System.out.println("login succesfull");
								choice3 = 0;
								do {
									System.out.println("\n==============⚙️================⚙️==============");
									System.out.println("1. Add new Customer");
									System.out.println("2. Add new problems/issue/modification element of car");
									System.out.println("3. Show all problems/issue/modification element of car present in database");
									System.out.println("4. Show all Customer");
									System.out.println("5. Search Customer/Car");
									System.out.println("6. Change car status");
									System.out.println("7. Modify details");
									System.out.println("8. set bill of car");
									System.out.println("9. Get bill of car");
									System.out.println("10. Get total sale between particular date");
									System.out.println("11. Exit");
									System.out.println("==============⚙️================⚙️==============");
									System.out.print("Enter your choice: ");
									choice3 = sc.nextInt();
									sc.nextLine();

									switch (choice3) {
									case 1:
										System.out.println("Enter Customer Name");
										String name = sc.nextLine();
										System.out.println("Enter Customer Contact number");
										String contact = sc.nextLine();
										System.out.println("Enter Car Number");
										String carnumber = sc.nextLine();
										System.out.println("Enter Car model name");
										String carmodelname = sc.nextLine();
										String replay = "";
										ArrayList<CarIssue> al = new ArrayList<CarIssue>();
										int flag1 = 1;
										do {
											System.out.println("Enter car problems/issue/modification element one by one");
											String s = sc.nextLine();
											int id = cis.getIssueId(s);
											if (id > 0) {
												CarIssue imodel = new CarIssue();
												imodel.setIssueid(id);
												imodel.setIssuename(name);
												al.add(imodel);
											} else {
												System.out.println("car issue not found add it first");
												flag1 = 0;
												break;
											}
											System.out.println("Do you want to add more issue");
											replay = sc.nextLine();

										} while (replay.equals("yes"));
										if (flag1 == 1) {
											ServicingCarModel carmodel = new ServicingCarModel(carnumber, carmodelname, al);
											ServicingCustomerModel customermodel = new ServicingCustomerModel(name, contact,
													carmodel);

											b = scs.isAddServicigCutomer(customermodel);
											if (b) {
												System.out.println("Customer Added Succesfully");
											} else {
												System.out.println("Error while adding Customer...");
											}
										}
										break;
									case 2:
										System.out.println("Enter issue name");
										String issuename = sc.nextLine();
										System.out.println("Enter price");
										int price = sc.nextInt();
										System.out.println("Enter quantity");
										int quantity = sc.nextInt();
										CarIssue imodel = new CarIssue(issuename,price,quantity);
										b = cis.isAddIssue(imodel);
										if (b) {
											System.out.println("Issue Added Succesfully");
										} else {
											System.out.println("Error while adding Issue...");
										}
										break;
									case 3:
										b = cis.isShowAllIssue();
										break;
									case 4:
										b = scs.isShowAllServicigCutomer();
										break;
									case 5:
										System.out.print("What do you want to search--> 1)Car 2)Customer\nEnter option number: ");
										int no=sc.nextInt();
										sc.nextLine();
										if(no==1)
										{
											System.out.print("How do you want to search car by 1)CarId 2)CustomerId\nEnter option number: ");
											int no1=sc.nextInt();
											sc.nextLine();
											if(no1==1)
											{
												System.out.println("Enter car id");
												int carid = sc.nextInt();
												sc.nextLine();
												b = scservice.getCarById(carid);
											}
											else if(no1==2)
											{
												System.out.println("Enter id of customer");
												int id=sc.nextInt();
												sc.nextLine();
												b=scservice.getCarByCustId(id);
											}
											
										}
										else if(no==2)
										{
											System.out.print("How do you want to search customer by 1)name 2)id\nEnter option number: ");
											int no1=sc.nextInt();
											sc.nextLine();
											if(no1==1)
											{
												System.out.println("Enter name of customer");
												name=sc.nextLine();
												b=scs.getCustomerByName(name);
											}
											else if(no1==2)
											{
												System.out.println("Enter id of customer");
												int id=sc.nextInt();
												sc.nextLine();
												b=scs.getCustomerById(id);
											}
										}
										
										break;
									case 6:
										System.out.println("Enter car id");
										int carid = sc.nextInt();
										sc.nextLine();
										b = scservice.getCarById(carid);
										if (b) {
											System.out.println("Is car ready for delivery (yes/no)");
											replay = sc.nextLine();
											if (replay.equals("yes")) {
												b = scservice.changeCarStatusYesById(carid);
											} else if (replay.equals("no")) {
												b = scservice.changeCarStatusNoById(carid);
											}
										}
										break;
									case 7:
										 option="";
										do {
											System.out.println("************************************");
											System.out.println("1.Update Customer Details");
											System.out.println("2.Update Car Details");
											System.out.println("3.Update Issue Details");
											System.out.println("4.Delete Customer Details");
											System.out.println("5.Delete Car Details");
											System.out.println("6.Delete Issue Details");
											System.out.println("************************************");
											System.out.println("Enter your choice: ");
											int ch=sc.nextInt();
											sc.nextLine();
											switch(ch)
											{
											case 1:
												System.out.print("How do you want to update customer by 1)name 2)id\nEnter option number: ");
												int no1=sc.nextInt();
												sc.nextLine();
												if(no1==1)
												{
													System.out.println("Enter name of customer");
													name=sc.nextLine();
													b=scs.isupdateCustomerByName(name);
												}
												else if(no1==2)
												{
													System.out.println("Enter id of customer");
													int id=sc.nextInt();
													sc.nextLine();
													b=scs.isUpdateCustomerById(id);
												}
												break;
											case 2:
												System.out.print("How do you want to update car by 1)CarId 2)CustomerId\nEnter option number: ");
												no1=sc.nextInt();
												sc.nextLine();
												if(no1==1)
												{
													System.out.println("Enter car id");
													carid = sc.nextInt();
													sc.nextLine();
													b = scservice.isUpdateCarById(carid);
												}
												else if(no1==2)
												{
													System.out.println("Enter id of customer");
													int id=sc.nextInt();
													sc.nextLine();
													b=scservice.isUpdateCarByCusId(id);
												}
												break;
											case 3:
												System.out.print("How do you want to update issue by 1)name 2)id\nEnter option number: ");
												no1=sc.nextInt();
												sc.nextLine();
												if(no1==1)
												{
													System.out.println("Enter name of issue");
													name=sc.nextLine();
													b=cis.isupdateIssueByName(name);
												}
												else if(no1==2)
												{
													System.out.println("Enter id of issue");
													int id=sc.nextInt();
													sc.nextLine();
													b=cis.isupdateIssueById(id);
												}
												break;
											case 4:
												System.out.println("Enter id of customer to delete");
												int id=sc.nextInt();
												sc.nextLine();
												b=scs.getCustomerById(id);
												if(b)
												{
													System.out.println("Do you want to delete this customer (yes/no)");
													option=sc.nextLine();
													if(option.equals("yes"))
													{
														b=scs.deletecustomerById(id);
													}
												}
												break;
											case 5:
												System.out.println("Enter id of car to delete");
												id=sc.nextInt();
												sc.nextLine();
												b=scservice.getCarById(id);
												if(b)
												{
													System.out.println("Do you want to delete this car (yes/no)");
													option=sc.nextLine();
													if(option.equals("yes"))
													{
														b=scservice.deleteCarById(id);
													}
												}
												break;
											case 6:
												System.out.println("Enter id of issue to delete");
												id=sc.nextInt();
												sc.nextLine();
												b=cis.getIssueById(id);
												if(b)
												{
													System.out.println("Do you want to delete this issue (yes/no)");
													option=sc.nextLine();
													if(option.equals("yes"))
													{
														b=cis.deleteIssueById(id);
													}
												}
												break;
											default:System.out.println("Enter correct choice...");
											}
											
										System.out.println("Do you want to modify more details (yes/no)");
										option=sc.nextLine();
										}while(option.equals("yes"));
										break;
									case 8:
										System.out.println("Enter customer id");
										int id=sc.nextInt();
										sc.nextLine();
										b=scs.getCustomerById(id);
										if(b)
										{
											System.out.println("Do you want to generate bill for above customer(yes/no)");
											String s=sc.nextLine();
											if(s.equals("yes"))
											{
												b=scservice.getCarByCustId(id);
												if(b)
												{
													System.out.println("Do you want to generate bill for above car(yes/no)");
													s=sc.nextLine();
													if(s.equals("yes"))
													{
														ArrayList<CarIssue>cl=cis.getAllIssueOfCar(id);
														if(cl!=null)
														{
															int amt=0;
															for(CarIssue ci:cl)
															{
																System.out.println("Enter quantity of "+ci.getIssuename() +" used for car");
																int n=sc.nextInt();
																sc.nextLine();
																amt=amt+(n*ci.getPrice());
															}
															System.out.println("total bill of car is "+amt);
															int carId=scservice.getCarIdByCustId(id);
															b=sbillService.setBill(amt,carId,id);															
														}
													}
												}
											}
										}
										break;
									case 9:
										System.out.println("Enter customer id to get bill");
										int cid=sc.nextInt();
										sc.nextLine();
										b=sbillService.getBill(cid);
										break;
									case 10:
										System.out.println("Enter from date and to date to get total sale [Date in this  (yyyy-mm-dd) format]");
										String fromdate=sc.nextLine();
										String todate=sc.nextLine();
										b=sbillService.getSaleByParticularDate(fromdate,todate);
										break;									
									case 11:
										System.out.println("Exited from Servicing Center 🙏🏻");
										break;
									default:
										System.out.println("Enter correct choice");
									}

								} while (choice3 != 11);
							} 
							else {
								System.out.println("Not permitted to enter");
							}// Servicing center end
						}
						catch(RunTimeCustomException rx)
						{
							System.out.println(rx.getMsg());
							rx.printStackTrace();
						}
						break;
					case 3: // sign-up
						
						do
						{
							System.out.println("\n----------------------------------");
							System.out.println("1. Showroom sign-up ");
							System.out.println("2. Servicing center sign-up");
							System.out.println("3. Exit from Sign-up");
							System.out.println("----------------------------------");
							System.out.print("Enter the choice: ");
							choice = sc.nextInt();
							sc.nextLine();
							switch(choice)
							{
							case 1: 
								try {
									System.out.println("Enter the Employee User Name for showroom sign-up ");
									String uName = sc.nextLine();
									CheckEmployeeException.checkEmpUname(uName);
									System.out.println("Enter the Employee PassWord for showroom sign-up ");
									String passWord = sc.nextLine();
									CheckEmployeeException.checkEmpPass(passWord);
									LoginModel eLModel = new LoginModel(uName, passWord);
//									eLModel.setAccessStatus(b);
									boolean b = lServices.empSignUpInShowR(eLModel);
									if (b) {
										System.out.println("Registration Successfully :|");
										System.out.println("Wait for Admin Verification");
									} else {
										System.out.println("Registration failed !!!");
									}
								}
								catch(RunTimeCustomException rx)
								{
									System.out.println(rx.getMsg());
									rx.printStackTrace();
								}
							break;	
							case 2: 
								try {
									System.out.println("Enter the Employee User Name for service sign-up ");
									String uName = sc.nextLine();
									CheckEmployeeException.checkEmpUname(uName);
									System.out.println("Enter the Employee PassWord for service sign-up ");
									String passWord = sc.nextLine();
									LoginModel eLModel = new LoginModel(uName, passWord);
									CheckEmployeeException.checkEmpPass(passWord);
									boolean b = lServices.empSignUpInService(eLModel);
									if (b) {
										System.out.println("Registration Successfully :|");
										System.out.println("Wait for Admin Verification");
									} else {
										System.out.println("Registration fill!!!");
									}
								}
								catch(RunTimeCustomException rx)
								{
									System.out.println(rx.getMsg());
									rx.printStackTrace();
								}
								
							break;
							case 3:
								System.out.println("😌😌 You have Exit from Sign-up 😌😌");
								break;
							default:
									System.out.println("🙏🙏 Please Enter the Valid Choice 🙏🙏");
								break;	
							}
						}while(choice!=3);
						break;
					case 4:
						System.out.println("Exited from Employee Login 🙏🏻");
						break;
					}
				} while (choice2 != 4);
				break;// Employee Login
			case 3:
				System.out.println(" 🙏🏻🙏🏻 Thank You Visit Again 🙏🏻🙏🏻 ");
				break;
			default:
				System.out.println("Enter the Correct choice");
				break;
			}
		} while (choice != 3);

	}

}
