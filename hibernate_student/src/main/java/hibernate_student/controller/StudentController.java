package hibernate_student.controller;
import hibernate_student.dto.Student;
import hibernate_student.dao.StudentDao;

import java.util.Scanner;
public class StudentController {
	public static void main(String[] args) {
		Student student=new Student();
		StudentDao dao=new StudentDao();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the choice \n1.save Student \n2.Fetch Student By ID \n3.Find All \n4.Find Student by phone \n5.Update Student \n6.Delete Student");
		int choice =scanner.nextInt();
		
		switch (choice) {
		case 1:{
			System.out.println("Enter ID");
			int id=scanner.nextInt();
			System.out.println("Enter Name");
			String name=scanner.next();
			System.out.println("Enter age");
			int age=scanner.nextInt();
			System.out.println("Enter marks");
			int marks=scanner.nextInt();
			System.out.println("Enter percentage");
			double percentage=scanner.nextDouble();
			System.out.println("Enter Phone");
			long phone=scanner.nextLong();
			
			student.setAge(age);
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setPercentage(percentage);
			student.setPhone(phone);
			
			dao.saveStudent(student);
		}
			break;
		case 2:{
			System.out.println("Enter ID");
			int id=scanner.nextInt();
			
			student.setId(id);
			dao.fetchStudentById(id);
		}
			break;
		case 3:{
			dao.findAll();
		}
			break;
		case 4:{
			System.out.println("Enter Phone");
			long phone=scanner.nextLong();
			dao.findByPhone(phone);
		}
			break;
		case 5:
		{
			System.out.println("Enter ID");
			int id=scanner.nextInt();
			System.out.println("Enter Name");
			String name=scanner.next();
			System.out.println("Enter age");
			int age=scanner.nextInt();
			System.out.println("Enter marks");
			int marks=scanner.nextInt();
			System.out.println("Enter percentage");
			double percentage=scanner.nextDouble();
			System.out.println("Enter Phone");
			long phone=scanner.nextLong();
			
			student.setAge(age);
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setPercentage(percentage);
			student.setPhone(phone);
			
			dao.updateStudent(id, student);
		}
			break;
		case 6:{
			System.out.println("Enter ID");
			int id=scanner.nextInt();
			dao.deleteStudent(id, student);
		}
			break;
		
		

		default:
			break;
		}
	}

}
