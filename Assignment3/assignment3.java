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
      //int index = 0;
      boolean bool = true;
      for(int i = 0; i < 5; i++){
         
         System.out.println("Enter Your email: ");
         String username = scanner.nextLine();
         username = username.toUpperCase();
         
         System.out.println("Enter Your password: ");
         String password = scanner.nextLine();
          
         
         for(int index = 0; index < arr_user.length; index++){
            if(arr_user[index].getUsername().toUpperCase().equals(username) && arr_user[index].getPassword().equals(password)){
               System.out.println("Welcome: "+ arr_user[index].getName());
               System.exit(0);
            }else{
               
            }
         }//end of inside for loop
         
        System.out.println();

        System.out.println("Invalid login, please try again");
        
        System.out.println();
         
      }//end of for loop
      System.out.println("Too many failed login attempts, you are now locked out.");
      scanner.close();
      
      


      
   }
}//end class