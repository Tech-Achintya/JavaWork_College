import java.sql.*;

public class learningJDB2 {
    private final static String url = "jdbc:mysql://localhost:3306/studentdetails";
    private final static String username = "root";
    private final static String password = "achintya@2602";

    public static void main(String[] args) throws ClassNotFoundException,SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student")) {
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        }
    }
}