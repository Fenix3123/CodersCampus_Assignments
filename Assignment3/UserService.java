public class UserService {

	public User createUser (String username, String password, String name) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		//user.setLastName("Doe");
		return user;
	}
}