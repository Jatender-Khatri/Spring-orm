package com.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.entity.User;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserDao userDao = new UserDaoImpl();
		userDao = (UserDao) context.getBean("userDaoImpl");
		
		Scanner s = new Scanner(System.in);

		System.out.println("=============== WELL COME TO SPRING ORM PROJECT================");
		System.out.println("-----------------------------------------------------------------");

		while (true) {
			System.out.println("1. Add User");
			System.out.println("2. Update User");
			System.out.println("3. Delete User");
			System.out.println("4. Get Singal User");
			System.out.println("5. Users List");
			System.out.println("6. Exit");
			System.out.println("-----------------------------------------------------------------");
			System.out.print("Please Enter the Number(1 to 6) : ");

			try {
				Integer number = s.nextInt();
				System.out.println("-----------------------------------------------------------------");
				Integer userId = 0;
				String username = "";
				String password = "";
				String email = "";
				String address = "";
				User user = null;

				if (number == 1) {
					System.out.print("Enter the Username : ");
					username = s.next();
					System.out.print("Enter the Email : ");
					email = s.next();
					System.out.print("Enter the Password : ");
					password = s.next();
					System.out.print("Enter the  Address : ");
					address = s.next();

					user.setAddress(address);
					user.setEmail(email);
					user.setPassword(password);
					user.setUsername(username);

					userDao.addUser(user);
					System.out.println(username + " Added Successfully");
				} else if (number == 2) {
					System.out.print("Please Enter The User Id : ");
					userId = s.nextInt();
					user = userDao.getUserById(userId);
					if (user != null) {
						System.out.println(" ======================= USER FOUND ============================");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("ID\t\tUsername\t\tEmail Address\t\tPassword\tAddress");
						System.out.println(user.getUserId() + " \t " + user.getUsername() + " \t " + user.getEmail()
								+ " \t" + user.getPassword() + " \t " + user.getAddress());
						System.out.println("-----------------------------------------------------------------");
						System.out.println("Do You Want Update This User Record");
						System.out.println("1. Yes");
						System.out.println("2. No");

						System.out.print("Enter the Choice : ");
						String update = s.next();
						if (update.equals("Yes")) {
							System.out.println("-----------------------------------------------------------------");
							System.out.print("Enter the New Username : ");
							username = s.next();
							System.out.print("Enter the New Email : ");
							email = s.next();
							System.out.print("Enter the New Password : ");
							password = s.next();
							System.out.print("Enter the New  Address : ");
							address = s.next();

							user.setAddress(address);
							user.setEmail(email);
							user.setPassword(password);
							user.setUsername(username);
							user.setUserId(userId);
							userDao.upateUser(user);
							System.out.println("");
							System.out.println(" ============= " + username + " Updated Successfully. ===========");

						}
					} else {
						System.out.println("==================== USER NOT FOUND ======================");
					}
				} else if (number == 3) {
					System.out.print("Please Enter The User Id : ");
					userId = s.nextInt();
					user = userDao.getUserById(userId);
					if (user != null) {
						System.out.println(" ======================= USER FOUND ============================");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("ID\t\tUsername\t\tEmail Address\t\tPassword\tAddress");
						System.out.println(user.getUserId() + " \t " + user.getUsername() + " \t " + user.getEmail()
								+ " \t" + user.getPassword() + " \t " + user.getAddress());
						System.out.println("-----------------------------------------------------------------");
						System.out.println("Do You Want Delete This User Record");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.print("Enter the Choice : ");
						String delete = s.next();

						if (delete.equals("Yes")) {
							userDao.deleteUser(userId);
							System.out.println(
									" ============= " + user.getUsername() + " Deleted Successfully. ===========");
						}

					} else {
						System.out.println("==================== USER NOT FOUND ======================");
					}
				} else if (number == 4) {
					System.out.print("Please Enter The User Id : ");
					userId = s.nextInt();
					user = userDao.getUserById(userId);
					if (user != null) {
						System.out.println(" ======================= USER FOUND ============================");
						System.out.println("ID\t\tUsername\t\tEmail Address\t\tPassword\tAddress");
						System.out.println(user.getUserId() + " \t " + user.getUsername() + " \t " + user.getEmail()
								+ " \t" + user.getPassword() + " \t " + user.getAddress());
						System.out.println("-----------------------------------------------------------------");
					} else {
						System.out.println("==================== USER NOT FOUND ======================");
					}
				} else if (number == 5) {
					System.out.println("ID\t\tUsername\t\tEmail Address\t\tPassword\tAddress");
					for (User u : userDao.getUser()) {
						System.out.println(
								"---------------------------------------------------------------------------------");
						System.out.println(u.getUserId() + " \t " + u.getUsername() + " \t " + u.getEmail() + " \t"
								+ u.getPassword() + " \t " + u.getAddress());
						System.out.println(
								"---------------------------------------------------------------------------------");
					}
				} else if (number == 6) {
					System.out.println("Thank You For Use My Project");
					System.out.println("-----------------------------------------------------------------");
				} else {
					System.out.println("Please Enter the correct Number(1 to 6).");
					System.out.println("-----------------------------------------------------------------");
				}
			}

			catch (Exception e) {
				System.out.println("Invalid Number, Please try another one.");
			}

		}
	}
}
