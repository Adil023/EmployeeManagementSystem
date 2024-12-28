package service;

import entity.Employee;

import java.util.Scanner;

public class Menu {
    public   void menu(){
        CrudOperations crud = new CrudOperations();
        String name;
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome to our employee management system");
        do{
            System.out.println(  "1.Add employee \n" +
                    "2.Show all employees \n" +
                    "3.Show employee based on id \n" +
                    "4.Update employee \n" +
                    "5.Delete employee \n" +
                    "6.Exit program");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter employee id:");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter employee name:");
                    name = sc.nextLine();
                    System.out.println("Enter employee surname:");
                    String surname = sc.nextLine();
                    System.out.println("Enter employee age:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter employee salary");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSurname(surname);
                    emp.setAge(age);
                    emp.setSalary(salary);

                    crud.insertEmployee(emp);
                    break;

                case 2:
                    System.out.println("Our All employees: ");
                    crud.showAllEmployees();
                    break;

                case 3:
                    System.out.println("Enter employee id which you want to search");
                    id = sc.nextInt();
                    sc.nextLine();
                    crud.showAllEmployeesBasedOnId(id);
                    break;

                case 4:
                    System.out.println("Enter employee id which you want to update");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new  employee name:");
                    name = sc.nextLine();
                    crud.updateEmployee(id, name);
                    break;

                case 5:
                    System.out.println("Enter employee id which you want to delete");
                    id = sc.nextInt();
                    sc.nextLine();
                    crud.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our system...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }while(true);
    }
}
