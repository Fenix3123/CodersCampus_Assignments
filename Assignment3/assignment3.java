import java.io.*;
import java.util.*;

public class assignment3{
   public static void main(String[] args){
   //UserService
      UserService userService = new UserService();
   //user array
      User[] arr_user = new User[4];

   //fileio
   		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			int i = 0;
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] accounts = line.split(",");
            arr_user[i] = userService.createUser(accounts[0], accounts[1], accounts[2]);
            i++;
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
      //scanner
      Scanner scanner = new Scanner(System.in);
      
      boolean bool = true;
      while(bool){
         System.out.println(arr_user[3].getUsername());
         System.out.print("Enter Your email: ");
         String userName = scanner.nextLine();
         
         System.out.print("Enter Your password: ");
         String password = scanner.nextLine();
         
        
         
      }
      
      scanner.close();
      
      


      
   }
}