import java.sql.*;

public class MavenH2 {

    public static void main(String[] args) throws SQLException {

        //let s define aur connection, URL jdbc
        //how to create a string connection to H2
        //GET path on Windows: jdbc:h2:C:\Users\AdministradorCIFO\dataBaseH2\campusPayPal
        //GET localhost jdb tcp: jdbc:h2:tcp://localhost/
        //concatenate from USER WINDOWS: jdbc:h2:tcp://localhost/~/dataBaseH2/campusPayPal
        String stringURLConnection = "jdbc:h2:tcp://localhost/~/dataBaseH2/campusPayPal";
        String username = "albert";
        String password = "1234";
        //connect ot url with connection object
        Connection connection = DriverManager.getConnection(stringURLConnection, username, password);
        System.out.println("Connected to H2 local database.");

        String sql = "CREATE TABLE users (ID int PRIMARY KEY, name VARCHAR(50), surname VARCHAR(50), age INTEGER)";

        Statement statement = connection.createStatement();
        statement.execute(sql);

        System.out.println("Created table cards");

        sql = "INSERT INTO users (ID, name, surname, age) VALUES (1, 'Amanda', 'Jones', 25 )";
        int result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO users (ID, name, surname, age) VALUES (2, 'Linda', 'Jones', 28 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO users (ID, name, surname, age) VALUES (3, 'Susy', 'Jones', 56 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO users (ID, name, surname, age) VALUES (4, 'Lola', 'Figuerols', 36 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "SELECT * FROM users";

        //Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;
        while (resultSet.next()) {
            count++;
            int ID = resultSet.getInt("ID");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt("age");

            System.out.println("users #" + count + ": " + ID + ", " + name + " "  + surname + ", " + age);
        }


        connection.close();

    }
}