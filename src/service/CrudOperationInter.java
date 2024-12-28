package service;

import entity.Employee;

public interface CrudOperationInter {
     void insertEmployee(Employee employee) ;
     void showAllEmployees();
     void showAllEmployeesBasedOnId(int id);

     void updateEmployee(int id,String name);

     void deleteEmployee(int id);

}
