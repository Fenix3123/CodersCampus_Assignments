public class User{
   String username;
   String password;
   String name;
   
  // public User(String username, String password){
   //   this.username = username;
   //   this.password = password;
   //   this.name = name;
 //  }//constructor
   
   public String getUserName(){
      return this.username;
   }
   
   public void setUsername(String str){
      this.username = str;
   }
   
   public String getPassword(){
      return this.password;
   }
   
   public void setPassword(String pass){
      this.password = pass;
   }
   
   public String getName(){
      return this.name;
   }
   
   public void setName(String str){
      this.name = str;
   }


}//end of class