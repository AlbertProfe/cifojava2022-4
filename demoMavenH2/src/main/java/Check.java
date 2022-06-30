import java.sql.*;

public class Check {

    public static boolean check (String tableName, Connection connection) throws SQLException {
        boolean tableExists = false;

        ResultSet rset = connection.getMetaData().getTables(null, null, tableName, null);
        boolean isTable = rset.next();
        System.out.println("isTable " + isTable );
        if (isTable) {
            tableExists = true;
            System.out.println("TABLE " + tableName + " EXISTS.");
            return  tableExists;
        }else{
            System.out.println("TABLE " + tableName + " IS MISSING.");
            return tableExists;
        }
    }

    public static void createTable(String tableName, Connection connection) throws SQLException {
        String sql = "CREATE TABLE " + tableName + "(ID int PRIMARY KEY, name VARCHAR(50), surname VARCHAR(50), age INTEGER)";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        System.out.println("TABLE " + tableName + " HAS BEEN CREATED.");

    }
    public static void dropTable(String tableName, Connection connection) throws SQLException {
        String sql = "DROP TABLE " + tableName;
        Statement statement = connection.createStatement();
        statement.execute(sql);
        System.out.println("TABLE " + tableName + " HAS BEEN DELETED.");
    }

    public static void persistSqlData(String tableName, Statement statement) throws SQLException {

        String sql = "INSERT INTO " + tableName + " (ID, name, surname, age) VALUES (1, 'Amanda', 'Jones', 25 )";
        int result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO " + tableName + " (ID, name, surname, age) VALUES (2, 'Linda', 'Jones', 28 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO " + tableName + " (ID, name, surname, age) VALUES (3, 'Susy', 'Jones', 56 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO " + tableName + " (ID, name, surname, age) VALUES (4, 'Lola', 'Figuerols', 36 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

        sql = "INSERT INTO " + tableName + " (ID, name, surname, age) VALUES (5, 'Alex', 'Picanyol', 51 )";
        result = statement.executeUpdate(sql);
        System.out.println("Operation write to DB: " +  result);

    }

    public static void listQuerytable(String tableName, Statement statement) throws SQLException {
        String sql = "SELECT * FROM " + tableName;
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
    }
}

