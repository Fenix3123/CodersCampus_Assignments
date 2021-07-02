public class User implements Comparable<User>{
   String username;
   String password;
   String name;
   String role;

   
  // public User(String username, String password){
   //   this.username = username;
   //   this.password = password;
   //   this.name = name;
 //  }//constructor
   
   public String getUsername(){
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
   
    public String getRole(){
      return this.role;
   }
   
   public void setRole(String str){
      this.role = str;
   }
   
   public int compareTo(User that) {
		if (this.role.compareTo(that.role) == 0) {
			return this.name.compareTo(that.name); // this will sort names in asc order
		} else {
			return that.role.compareTo(this.role); // this will sort height in desc order
		}
   }



}//end of class