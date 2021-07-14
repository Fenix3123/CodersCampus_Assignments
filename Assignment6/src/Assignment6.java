import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



public class Assignment6 {
	
	public static void main(String[] args) {
		List <CarSales> carSaleList = new ArrayList<>();
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("model3.csv"));
			String line = "";
			int i = 0;
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] Saleinfo = line.split(",");
				carSaleList.add(new CarSales(Saleinfo[0], Saleinfo[1]));
				
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

	}

}
