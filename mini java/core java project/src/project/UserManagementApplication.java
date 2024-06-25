package project;

import java.util.List;
import java.util.Scanner;

public class UserManagementApplication {
	private static UserDAO userDAO = new UserDAOImpl();
	private static Scanner scanner = new Scanner(System.in);

	private static void createUser() {
		System.out.print("Enter id: ");
		System.out.println(" ");
		int id = scanner.nextInt();
		System.out.print("Enter username: ");
		System.out.println(" ");
		String username = scanner.next();
		System.out.print("Enter password: ");
		System.out.println(" ");
		String password = scanner.next();
		System.out.print("Enter email: ");
		System.out.println(" ");
		String email = scanner.next();

		User user = new User(id,username, password, email);
		userDAO.createUser(user);
		System.out.println("User created successfully.");
		System.out.println(" ");
	}

	private static void updateUser() {
		System.out.print("Enter user ID to update: ");
		System.out.println(" ");
		int userId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		User user = userDAO.getUserById(userId);
		if (user == null) {
			System.out.println("User not found.");
			System.out.println(" ");
			return;
		}

		System.out.print("Enter new username: ");
		System.out.println(" ");
		String username = scanner.nextLine();
		System.out.print("Enter new password: ");
		System.out.println(" ");
		String password = scanner.nextLine();
		System.out.print("Enter new email: ");
		System.out.println(" ");
		String email = scanner.nextLine();

		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		userDAO.updateUser(user);
		System.out.println("User updated successfully.");
		System.out.println(" ");
	}

	private static void deleteUser() {
		System.out.print("Enter user ID to delete: ");
		System.out.println(" ");
		int userId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		userDAO.deleteUser(userId);
		System.out.println("User deleted successfully.");
		System.out.println(" ");
	}

	private static void viewAllUsers() {
		List<User> users = userDAO.getAllUsers();
		if (users.isEmpty()) {
			System.out.println("No users found.");
			System.out.println(" ");
		} else {
			users.forEach(System.out::println);
			System.out.println(" ");
		}
	}

	private static void viewUserById() {
		System.out.print("Enter user ID to view: ");
		System.out.println(" ");
		int userId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		User user = userDAO.getUserById(userId);
		if (user == null) {
			System.out.println("User not found.");
			System.out.println(" ");
		} else {
			System.out.println(user);
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		boolean running = true;

		while (running) {
			System.out.println("\nUser Management Application");
			System.out.println("1. Create User");
			System.out.println("2. Update User");
			System.out.println("3. Delete User");
			System.out.println("4. View All Users");
			System.out.println("5. View User by ID");
			System.out.println("6. Exit");
			System.out.print("Select an option: ");
			System.out.println(" ");
			int option = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (option) {
			case 1:
				createUser();
				break;
			case 2:
				updateUser();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				viewAllUsers();
				break;
			case 5:
				viewUserById();				
				break;
			case 6:
				running = false;
				System.out.println("Exit.....");
				break;
			default:
				System.err.println("Invalid option. Please try again.");
				System.err.println("*******");
				System.out.println(" ");
			}
		}

		scanner.close();
	}

}
