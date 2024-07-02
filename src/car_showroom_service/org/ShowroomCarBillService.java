package car_showroom_service.org;

import car_showroom_model.org.ShowroomCarBillModel;
import car_showroom_repository.org.ShowroomCarBillRepository;
import java.util.*
;public class ShowroomCarBillService {
	ShowroomCarBillRepository sCBRepo = new ShowroomCarBillRepository();
	CarMasterService cMService = new CarMasterService();
	public boolean addDataInBill(ShowroomCarBillModel sCBillModel) {
		return sCBRepo.addDataInBill(sCBillModel);
	}

	public Map<Integer,Integer> getPrediction() {
		// total no of orders;
		int total = sCBRepo.getTotalOrds();
		System.out.println(total);
		Map<Integer,Float> yMap= new LinkedHashMap<Integer, Float>();
		Map<Integer,Float> nMap= new LinkedHashMap<Integer, Float>();
		Map<Integer,Integer> map=cMService.getCarStock();
		Map<Integer,Integer> mapStock = new LinkedHashMap<Integer, Integer>(); 
		for(Map.Entry<Integer, Integer> m: map.entrySet())
		{
//			System.out.println("Car ID"+m.getKey());
			float yesPro=(float)m.getValue()/total;
//			System.out.println("Yes Pro"+yesPro);
			int no=total-m.getValue();
//			System.out.println("No count"+no);
			float noPro=(float)no/total;
//			System.out.println("Pro No"+noPro);
//			System.out.println("----------------------------------------");
			yMap.put(m.getKey(), yesPro);
			nMap.put(m.getKey(), noPro);
			int stock=(int) (yesPro*total);
			mapStock.put(m.getKey(), stock);
//			System.out.println("Stock "+stock);
		}
		return mapStock;
//		System.out.println(yMap);
//		System.out.println(nMap);
	}
	
	public long getSalePrediction(String startDate) {
		
		ArrayList<Long>al=sCBRepo.getMonthWiseSell(startDate);
		long len=al.size();
		long xsum=0;
		long ysum=0;
//		System.out.println(al.size());
		int count=1;
		for(int i=0;i<al.size();i++)
		{
				xsum+=count;
				count++;
//				System.out.println("x :- "+xsum);
				ysum+=al.get(i);
//				System.out.println(ysum);
		}
//		System.out.println("x :- "+xsum);
//		System.out.println("y :- "+ysum);
		long xmean=xsum/len;
		long ymean=ysum/len;
//		System.out.println("x mean :- "+xmean);
//		System.out.println("y mean :- "+ymean);
		long prodsum=0;
		long devxsquare=0;
		long devx=0,devy=0;
		for(int i=1;i<al.size();i++)
		{
			devx = i-xmean;
			devxsquare +=(devx*devx);
			devy = al.get(i)-ymean;
			prodsum+= (devx*devy);
		}
//		System.out.println("x devication :- "+devx);
//		System.out.println("y devication :- "+devy);
//		System.out.println("Sum of product:- "+prodsum);
//		System.out.println("sum of Squer of x:- "+devxsquare);
		long m = prodsum/devxsquare; // value of slope 
		long b = ymean-(m*xmean);
		
//		System.out.println("m :- "+m);
//		System.out.println("b:- "+b);
		long prediction = (m*(al.size()+1))+b;
//		System.out.println("The predicted sale for next month is "+(ysum-prediction));
		return ysum-prediction;
	}

	public void getcurdate() {
		
		sCBRepo.getcurdate();
	}

}
