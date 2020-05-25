import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        UserInterface UI = new UserInterface();
        UI.startMenu();

        /*SQL_Handler sqlHandler = new SQL_Handler();
        LinkedList<LinkedList<String>>  result  = sqlHandler.queryDatabase("SELECT vardas FROM NARYS");
        for(int i = 0; i < result.size(); i++){

            System.out.println("\n****** " + result.get(i).get(2).trim() + " " + result.get(i).get(3).trim() + " ******");
            System.out.println("Name: " + result.get(i).get(0).trim());
        }
        sqlHandler.closeConnection();*/
    }
}