import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;





public class Assignment6 {
	
	public static void main(String[] args) {
	List <CarSales> model3List = readfile("./model3.csv");
	List <CarSales> modelSList = readfile("./modelS.csv");
	List <CarSales> modelXList = readfile("./modelX.csv");
	
	
//	model3List.stream()
//	  .forEach(p -> System.out.println(p.getSale()));
	
	Map<String, List<CarSales>> groupedByDate = model3List.stream()
								.collect(Collectors.groupingBy(info -> info.getYear()));
	
	Set<Entry<String, List<CarSales>>> model3entry = groupedByDate.entrySet();
	
	List <String> model3Str = model3entry.stream()
											.map(car -> car.getKey())
	 			 							.filter(year -> year.startsWith("17"))
	 			 							.collect(Collectors.toList());
	
	System.out.println(model3entry.);
	
	
//	entryCarSales.stream()
//				 .forEach((entry)-> { 
//					 System.out.println(entry.getKey() + " - > "+ entry.getValue().get(0).getYear());
//				 });
//	
//	System.out.println("Model 3 Yearly Sales Report");
//	System.out.println("---------------------------");
//	System.out.println("2017 -> ####");
//	System.out.println("2018 -> ####");
//	System.out.println("2019 -> ####");
	
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
