import java.sql.*;

public class ConnectionSQLXampp {
    public static void main(String[] args) {
        var url ="jdbc:mysql://localhost:3306/student";
        var user = "root";
        var password = "";
        var sql= "select * from student";
        try(Connection conn= DriverManager.getConnection(url,user,password)){
            System.out.println(conn.getCatalog());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            showInfo(resultSet);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    private static void showInfo(ResultSet resultSet) {
        try {
            while (resultSet.next()){
                System.out.println(resultSet.getString() + " - " + resultSet.getString()
                + " - " + resultSet.getString() + " - " + resultSet.getDate()+ " - " + resultSet.getInt());

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
