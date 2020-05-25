import java.sql.*;
import java.util.LinkedList;

public class SQL_Handler {

    private Connection connection;

    public SQL_Handler(){
        loadDriver();
        openConnection();
    }

    private void loadDriver(){
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Can't locate postgreSQL driver class!");
            System.exit(1);
        }
    }

    private void openConnection(){
        try{
            connection = DriverManager.getConnection("Your URL", "USER", "PASSWORD");
        }
        catch (SQLException ex){
            System.out.println("Couldn't login to database !");
            System.exit(1);
        }
    }

    public void closeConnection(){
        try{
            connection.close();
        }
        catch (SQLException ex){
            System.out.println("Couldn't end the connection !?");
        }
    }

    public int updateDB(String query) throws SQLException {
        Statement statement = null;
        int count = 0;
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(query);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if(statement != null)
                    statement.close();
            } catch (SQLException e) {
                System.out.println("An unexpected error occurred!");
            }
        }

        return count;
    }

    public void updateWithTransaction(LinkedList<String> queries) throws SQLException {
        Statement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            for(String query : queries){
                statement.executeUpdate(query);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                throw ex;
            } catch (SQLException e) {
                System.out.println("An unexpected error occurred rollbacking!");
            }
        } finally {
            try {
                if(statement != null)
                    statement.close();
            } catch (SQLException ex) {
                System.out.println("An unexpected error occurred!");
            }
        }

    }

    public LinkedList<LinkedList<String>>queryDatabase(String query){
        LinkedList<LinkedList<String>> list = new LinkedList<LinkedList<String>>();

        Statement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                LinkedList<String> row = new LinkedList<String>();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    String temp = resultSet.getString(i);
                    if (temp == null) temp = "";
                    row.add(temp);
                }
                list.add(row);
            }
        }
        catch (SQLException ex){
            System.out.println("An error occurred while processing the request!");
        }
        finally {
            try{
                if(statement != null)
                    statement.close();
                if(resultSet != null)
                    resultSet.close();
            }
            catch (SQLException ex){
                System.out.println("An unexpected error occurred!");
            }
        }
        return list;
    }
}