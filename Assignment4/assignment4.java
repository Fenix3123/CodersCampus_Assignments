import java.io.*;
import java.util.*;

//Need to add the bufferedwriter
public class assignment4{
   public static void main(String[] args) throws IOException{
   //UserService
      UserService userService = new UserService();
   //user array
      User[] arr_user = new User[20];
      
   //buffered writer thing
   BufferedWriter writer = null;

   //fileio
   		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("users.txt"));
			int i = 0;
			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] accounts = line.split(", ");
            arr_user[i] = userService.createUser(accounts[0], accounts[1], accounts[2], accounts[3]);
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
      //boolean bool = true;
      int i;
      for(i = 0; i < 5; i++){
         
         System.out.println("Enter Your email: ");
         String username = scanner.nextLine();
         username = username.toUpperCase();
         
         System.out.println("Enter Your password: ");
         String password = scanner.nextLine();
         
         System.out.println();
         
         
         User user_logged = null;
         for(int index = 0; index < arr_user.length; index++){
            if(arr_user[index].getUsername().toUpperCase().equals(username) && arr_user[index].getPassword().equals(password)){
               user_logged = arr_user[index];
               System.out.println("Welcome: "+ arr_user[index].getName());
               System.out.println("----------");
               
               //where the real assignment 4 begins
               if(arr_user[index].getRole().equals("normal_user")){
                  while(true){
        
                     System.out.println("(0) Update username");
                     System.out.println("(1) Update password");
                     System.out.println("(2) Update name");
                     System.out.println("(3) Exit");
                     String choice = scanner.nextLine();
                     
                     if(choice.equals("0")){
                        System.out.println("What do you want your new username to be?");
                        String new_username = scanner.nextLine();
                        arr_user[index].setUsername(new_username);
                     }else if(choice.equals("1")){
                              System.out.println("What do you want your new password to be?");
                              String new_password = scanner.nextLine();
                              arr_user[index].setPassword(new_password);
      
                     }else if(choice.equals("2")){
                               System.out.println("What do you want your new Name to be?");
                               String new_name = scanner.nextLine();
                               arr_user[index].setName(new_name);
                     }else if(choice.equals("3")){
                                Arrays.sort(arr_user);
                                   try {
   			                        writer = new BufferedWriter(new FileWriter("users.txt"));
                                     for(User user : arr_user){
   			                             writer.write(user.getUsername()+", "+user.getPassword()+", "+user.getName()+", "+user.getRole());
                                           writer.newLine();
                                         }
   		                             } finally {
   			                                  if (writer != null) writer.close();
   		                             }
   
                                       System.exit(0);
                      }else{
                               System.out.println("Please try again");
                      }

                  }//end of while for normal user
               
               }
               while(true){
                  System.out.println("(0) Log in as another user");
                  System.out.println("(1) Update username");
                  System.out.println("(2) Update password");
                  System.out.println("(3) Update name");
                  System.out.println("(4) Exit");
                  String choice = scanner.nextLine();
                  
                  if(choice.equals("0")){
                     if(arr_user[index].getRole().equals("super_user")){
                        while(true){

                           System.out.println("Which user would you like to login as? (Type in a valid username)");
                           String diff_user = scanner.nextLine();
                           diff_user = diff_user.toUpperCase();
                           
                           for(index = 0; index < arr_user.length; index++){
                              if(arr_user[index].getUsername().toUpperCase().equals(diff_user)){
                                 while(true){
                                    System.out.println("Welcome: "+ arr_user[index].getName());
                                    System.out.println("----------");

                                    System.out.println("(1) Update username");
                                    System.out.println("(2) Update password");
                                    System.out.println("(3) Update name");
                                    System.out.println("(4) Exit");
                                    String _choice = scanner.nextLine();
                                    
                                    if(_choice.equals("1")){
                                       System.out.println("What do you want your new username to be?");
                                       String new_username = scanner.nextLine();
                                       arr_user[index].setUsername(new_username);
      
                                    }else if(_choice.equals("2")){
                                       System.out.println("What do you want your new password to be?");
                                       String new_password = scanner.nextLine();
                                       arr_user[index].setPassword(new_password);
      
                                    }else if(_choice.equals("3")){
                                       System.out.println("What do you want your new Name to be?");
                                       String new_name = scanner.nextLine();
                                       arr_user[index].setName(new_name);
                                    }else if(_choice.equals("4")){
                                       Arrays.sort(arr_user);
                                       try {
   			                              writer = new BufferedWriter(new FileWriter("users.txt"));
                                          for(User user : arr_user){
   			                                  writer.write(user.getUsername()+", "+user.getPassword()+", "+user.getName()+", "+user.getRole());
                                                writer.newLine();
                                                }
   		                                  } finally {
   			                                       if (writer != null) writer.close();
   		                                   }
   
                                       System.exit(0);
                                    }else{
                                       System.out.println("Please try again");
                                    }
                                 }//end of while loop inside
                              }//end of if 
            
                          }//end of for
                          System.out.println("Please try again");
                        }//end of while
                        
                     }else{
                        System.out.println("This option is not available as you are not a super user");
                     }
                  }else if(choice.equals("1")){
                     System.out.println("What do you want your new username to be?");
                     String new_username = scanner.nextLine();
                     arr_user[index].setUsername(new_username);
                     

                  }else if(choice.equals("2")){
                     System.out.println("What do you want your new password to be?");
                     String new_password = scanner.nextLine();
                     arr_user[index].setPassword(new_password);

                  }else if(choice.equals("3")){
                     System.out.println("What do you want your new Name to be?");
                     String new_name = scanner.nextLine();
                     arr_user[index].setName(new_name);

                  
                  }else if(choice.equals("4")){
                     Arrays.sort(arr_user);
                     try {
			                  writer = new BufferedWriter(new FileWriter("users.txt"));
                           for(User user : arr_user){
			                        writer.write(user.getUsername()+", "+user.getPassword()+", "+user.getName()+", "+user.getRole());
                                 writer.newLine();
                              }	
		                    } finally {
			                      if (writer != null) writer.close();
		                   }

                     System.exit(0);
                  }else{
                     System.out.println("Please try again");
                  }



               }//end of while loop
               
               
               //System.exit(0);
            }else{
               
            }
         }//end of inside for loop
         
        System.out.println();

        System.out.println("Invalid login, please try again");
        
        System.out.println();
         
      }//end of for loop
      
      if(i == 5){
         System.out.println("Too many failed login attempts, you are now locked out.");
         scanner.close();
        }
      Arrays.sort(arr_user);
      //BufferedWriter writer = null;
		
//		try {
//			writer = new BufferedWriter(new FileWriter("data.txt"));
 //        for(User user : arr_user){
//			   writer.write(user.getUsername()+", "+user.getPassword()+", "+user.getName()+", "+user.getRole()+", ");
//           }
			
//		} finally {
//			if (writer != null) writer.close();
//		}
		
		      


      
   }//end of main
}//end class