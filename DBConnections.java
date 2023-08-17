package campus_reqruit;

import java.sql.*;

public class DBConnections {
    Connection conn;

    public void connectDB(){
        String connectionDBUrl = "jdbc:mysql://localhost:3306/" + Constants.DB_NAME;
        String userName = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(connectionDBUrl, userName, password);
            System.out.println("DB Connection is seccussful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchingDBData(){
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + Constants.TABLE_NAME);

            while (result.next()) {
                String name = result.getString(Constants.COLUMN_STUDENTNAME);
                String email = result.getString(Constants.COLUMN_EMAIL);
                int phone = result.getInt(Constants.COLUMN_PHONE);
                int id = result.getInt(Constants.COLUMN_ID);
                System.out.println("Student name: " + name + ", Email: " + email + ", Mobile: "+ phone );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void countByInterest(){
        try{
            Statement stmt1 = conn.createStatement();
            ResultSet result1 = stmt1.executeQuery("SELECT COUNT(" + Constants.COLUMN_ID + "),"
                    + Constants.COLUMN_INTEREST + " FROM " + Constants.TABLE_NAME + " GROUP BY " + Constants.COLUMN_INTEREST);

            while (result1.next()) {
                String interest = result1.getString(2);
                int count = result1.getInt(1);
                System.out.println(count + " are interested in " + interest);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void innerJoinEx(){
        try{
            Statement stmt1 = conn.createStatement();
            ResultSet result1 = stmt1.executeQuery("SELECT student.name, result.cgpa FROM student INNER JOIN result " +
                    "on student.name = result.name");

            while (result1.next()) {
                String name = result1.getString(1);
                float cgpa = result1.getFloat(2);
                System.out.println(name + " got " + cgpa);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
