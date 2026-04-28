//step1 : importing the package
import java.sql.*;
//Step2 : Load the Driver



//{for dynamic query -> object prepared Statement (insert intro tablename values(?,?,?);
// for static query- > object of Statement}

//{Execute the statemnt obj}
// 3 ways
// executeupdate()->ddl or dml (return number of rows affected)
// executQuery()-> dql (return result)
// execute()-> for any type of query
// }
public class learningJDBC {
    private final static String url = "jdbc:mysql://localhost:3306/?user=root";
    private final static String username = "root";
    private final static String password = "";
    public static void main() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Step3 : Create Connection
        Connection connection = DriverManager.getConnection(url, username, password);
        //Step4 : create statement
        Statement statement = connection.createStatement(); //or PreparedStatement
        //step5 : Excetuting queries
        String query = "";
        ResultSet rs = statement.executeQuery(query); //result set used to show output in table format
        while(rs.next()){
            int id = rs.getInt("uid");
            String name = rs.getString("name");
            int marks = rs.getInt("Marks");
            System.out.println(id + " " + name + " "+ marks);
        }
        connection.close();
    }
}
