package hibernate_user.controller;

import hibernate_user.dto.*;
import hibernate_user.dao.*;
import java.util.*;

public class UserController {
	public static void main(String[] args) {
		User user=new User();
		UserDao dao=new UserDao();
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter the choice \n1.signup \n2.login");
		int choice =scanner.nextInt();
		switch (choice) {
		case 1:{	
			System.out.println("Enter ID");
			int id=scanner.nextInt();
			System.out.println("Enter name");
			String name=scanner.next();
			System.out.println("Enter phone");
			long phone=scanner.nextLong();
			System.out.println("Enter email");
			String email=scanner.next();
			System.out.println("Enter password");
			String password=scanner.next();
			
			user.setId(id);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			
			dao.signupUser(user);
		}
		case 2:{
			System.out.println("Enter email");
			String email=scanner.next();
			System.out.println("Enter password");
			String password=scanner.next();
			
			boolean result=dao.loginUser(email, password);
			if (result) {
				System.out.println("Login Sucess!!");
				dao.displayPasswords(email);
				
				System.out.println("Enter the choice \n1.Update Password \n2.Logout");
				int key=scanner.nextInt();
				switch (key) {
				case 1:{
					System.out.println("enter facebook");
					String facebook=scanner.next();
					System.out.println("enter instagram");
					String instagarm=scanner.next();
					System.out.println("enter snapchat");
					String snapchat=scanner.next();
					System.out.println("enter twitter");
					String twitter=scanner.next();
					System.out.println("enter whatsapp");
					String whatsapp=scanner.next();
					
					user.setFacebook(facebook);
					user.setInstagram(instagarm);
					user.setSnapchat(snapchat);
					user.setTwitter(twitter);
					user.setWhatsapp(whatsapp);
					user.setEmail(email);
					user.setPassword(password);
					
					dao.updatePasswords(user);
					
				}
					
					break;

				default:
					break;
				}
				
			} else {
				System.out.println("Invalid Credentials");

			}
			
			
		}
			
			break;

		default:
			break;
		}
	}

}
