package service;

import connector.DBConnection;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudOperations implements CrudOperationInter{
    static Connection con   = DBConnection.getConnection();;
    static PreparedStatement prs;


    @Override
    public void insertEmployee(Employee employee) {

        String query = "INSERT INTO employee VALUES(?,?,?,?,?)";
        try {
            prs =   con.prepareStatement(query);
            prs.setInt(1, employee.getId());
            prs.setString(2, employee.getName());
            prs.setString(3, employee.getSurname());
            prs.setInt(4, employee.getAge());
            prs.setDouble(5, employee.getSalary());
            prs.executeUpdate();
            System.out.println("Employee has been inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public void showAllEmployees() {
         String query = "SELECT * FROM employee";
        try {
          prs =   con.prepareStatement(query);
         ResultSet resultSet =  prs.executeQuery();

            while (resultSet.next()) {
                System.out.println("-----------------------------------------------");
                System.out.println(resultSet.getInt("id")+"|"+resultSet.getString("name")
                        +" | "+resultSet.getString("surname")+" | "+resultSet.getInt("age")+" | "+resultSet.getDouble("salary"));
                System.out.println("-----------------------------------------------");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public void showAllEmployeesBasedOnId(int id){
        String query = "SELECT * FROM employee WHERE id = ?";
        try {
          prs =   con.prepareStatement(query);
          prs.setInt(1, id);
          ResultSet resultSet =  prs.executeQuery();
          while (resultSet.next()) {
              System.out.println("-------------------------------------------");
              System.out.println(resultSet.getInt("id")+"|"+resultSet.getString("name")
                      +" | "+resultSet.getString("surname")+" | "+resultSet.getInt("age")+" | "+resultSet.getDouble("salary"));
              System.out.println("-------------------------------------------");
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public void updateEmployee(int id,String name){
        String query  ="UPDATE employee SET name = ? WHERE id = ?";
        try {
           prs =  con.prepareStatement(query);
            prs.setString(1, name);
            prs.setInt(2, id);
            prs.executeUpdate();
            System.out.println("Employee has been updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBConnection.closeConnection();
        }
    }

    @Override
    public void deleteEmployee(int id){
        String query  ="DELETE FROM employee WHERE id = ?";
        try {
            prs = con.prepareStatement(query);
            prs.setInt(1, id);
            prs.executeUpdate();
            System.out.println("Employee has been deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBConnection.closeConnection();
        }
    }


}
