public class UserService {

	public User createUser (String username, String password, String name, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
      user.setRole(role);
		//user.setLastName("Doe");
		return user;
	}
}
