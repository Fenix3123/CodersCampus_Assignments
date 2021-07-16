import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Assignment6 {
	
	public static void main(String[] args) {
	List <CarSales> model3List = readfile("./model3.csv");
	List <CarSales> modelSList = readfile("./modelS.csv");
	List <CarSales> modelXList = readfile("./modelX.csv");
	

	
	

	

	
	Map<String, List<CarSales>> groupedByDate = model3List.stream()
								.collect(Collectors.groupingBy(info -> info.getYear()));
	
	Set<Entry<String, List<CarSales>>> model3entry = groupedByDate.entrySet();
	
	
	
	
				CarSales model3info = model3entry.stream()
												 .map(p -> p.getValue())
												 .flatMap(sales -> sales.stream())
					 			 				 .filter(sales -> sales.getYear().startsWith("17"))
												 .max((CarSales o1, CarSales o2)-> o1.getSale().compareTo(o2.getSale()));
				                             

			System.out.println(model3info);
	
	//getting total sales for model 3
	int model3Sale17 = model3entry.stream()
	 			 				  .map(p -> p.getValue())
	 			 				  .flatMap(sales -> sales.stream())
	 			 				  .filter(sales -> sales.getYear().startsWith("17"))
	 			 				  .mapToInt(sales -> sales.getSale())
	 			 				  .sum();
	
	int model3Sale18 = model3entry.stream()
								  .map(p -> p.getValue())
								  .flatMap(sales -> sales.stream())
									.filter(sales -> sales.getYear().startsWith("18"))
									.mapToInt(sales -> sales.getSale())
									.sum();
	
	int model3Sale19 = model3entry.stream()
								  .map(p -> p.getValue())
								  .flatMap(sales -> sales.stream())
								  .filter(sales -> sales.getYear().startsWith("19"))
								  .mapToInt(sales -> sales.getSale())
								  .sum();
	

				

	 			 						 
	 			 							
	
	
	
	

	System.out.println("Model 3 Yearly Sales Report");
	System.out.println("---------------------------");
	System.out.println("2017 -> " + model3Sale17);
	System.out.println("2018 -> " + model3Sale18);
	System.out.println("2019 -> " + model3Sale19);
	
//	int num = model3List.stream()
//			  .map(p -> p.getSale())
//			  .collect(Collectors.summingInt(Integer::intValue));
//	
//	System.out.println(num);
			  

	}//main
	public static ArrayList<CarSales> readfile(String fileName) {
		ArrayList <CarSales> carSaleList = new ArrayList<>();
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			String line = "";
			int i = 0;
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] Saleinfo = line.split(",");
				String[] Saleinfo2 = Saleinfo[0].split("-");
				String Saleinfo3 = Saleinfo2[0]+","+ Saleinfo2[1]+","+ Saleinfo[1];
				String[] Saleinfo4 = Saleinfo3.split(",");
				carSaleList.add(new CarSales(Saleinfo4[1], Saleinfo4[0],Integer.parseInt(Saleinfo4[2])));
				
			}
	
         
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
		} finally {
			try {
				//System.out.println("Closing file reader");
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return carSaleList;
	}//end of readfile method

}//end of class
