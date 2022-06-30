import java.sql.*;

public class MavenH2 {

    public static void main(String[] args) throws SQLException {

        //let s define aur connection, URL jdbc
        //how to create a string connection to H2
        //GET path on Windows: jdbc:h2:C:\Users\AdministradorCIFO\dataBaseH2\campusPayPal
        //GET localhost jdb tcp: jdbc:h2:tcp://localhost/
        //concatenate from USER WINDOWS: jdbc:h2:tcp://localhost/~/dataBaseH2/campusPayPal
        String stringURLConnection = "jdbc:h2:tcp://localhost/c:/dataBaseH2/demoMavenH2";
        String username = "alex";
        String password = "1234";
        //connect ot url with connection object
        Connection connection = DriverManager.getConnection(stringURLConnection, username, password);
        System.out.println("Connected to H2 local database.");
        System.out.println(" ");

        String tableName = "USERSDB";
        Statement statement = connection.createStatement();

        if (Check.check(tableName,connection)){
            Check.dropTable(tableName,connection);
            Check.createTable(tableName,connection);
            Check.persistSqlData(tableName, statement);
            Check.listQuerytable(tableName,statement);

        }else{
            Check.createTable(tableName,connection);
            Check.persistSqlData(tableName, statement);
            Check.listQuerytable(tableName,statement);

        }

        connection.close();


    }
}