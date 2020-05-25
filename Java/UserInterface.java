import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class UserInterface {
    SQL_Handler sql_handler = new SQL_Handler();
    Scanner input = new Scanner(System.in);

    public void startMenu(){
        showMenu();
        System.out.print("Enter number: ");
        int choice = input.nextInt();
        while(true){
            switch (choice){
                case 0:
                    exitProgram();
                    break;
                case 1:
                    viewTeams();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    addPlayer();
                    break;
                case 4:
                    addCoach();
                    break;
                case 5:
                    addNewMatch();
                    break;
                case 6:
                    showPlayers();
                    break;
                case 7:
                    viewPlayersStats();
                    break;
                case 8:
                    updatePlayerStats();
                    break;
                case 9:
                    deleteMember();
                    break;
                case 10:
                    switchPlayerShirts();
                    break;
                default:
                    System.out.println("Wrong input, try again");
                    break;
            }
            System.out.println();
            showMenu();
            System.out.print("Enter number: ");
            choice = input.nextInt();
        }

    }

    private void showMenu(){
        System.out.println(" [0] Exit program                     */");
        System.out.println(" [1] View team list                   */");
        System.out.println(" [2] Add member                       */");
        System.out.println(" [3] Add player                       */");
        System.out.println(" [4] Add coach                        */");
        System.out.println(" [5] Add new match                    */");
        System.out.println(" [6] View players                     */");
        System.out.println(" [7] View player statistics           */");
        System.out.println(" [8] Update player statistics         */");
        System.out.println(" [9] Delete member                    */");
        System.out.println("[10] Switch players shirts            */");
    }
    //*********************************************************************
    /* Duomenų pridėjimas */
    private void addMember(){
        System.out.println("Enter Licence-number, Name, Surname, Birth Date, Salary, Team");
        try{
            sql_handler.updateDB("INSERT INTO NARYS(licencijos_nr, vardas, pavarde, gimimo_data, alga, komanda) values ('" +
                    input.nextInt() + "','" + input.next() + "','" + input.next() + "','" + input.next() + "','" + input.nextInt() + "','" + input.next() + "')");
            System.out.println("Member added!");
        }
        catch(SQLException ex){
            System.out.println("Insertion failed!");
        }
    }

    private void addPlayer(){
        System.out.println("Enter Licence-number, Shirt-number, Position");
        try{
            sql_handler.updateDB("INSERT INTO ZAIDEJAS(licencijos_nr, marškinėlių_nr, pozicija) values ('" + input.nextInt() + "','" + input.nextInt() + "','" + input.next() + "')");
            System.out.println("Player added!");
        }
        catch(SQLException ex){
            System.out.println("Insertion failed!");
        }
    }

    private void addCoach(){
        System.out.println("Enter Licence-number, Position");
        try{
            sql_handler.updateDB("INSERT INTO TRENERIU_STABAS(licencijos_nr, pareigos) values ('" + input.nextInt() + "','" + input.next() + "')");
            System.out.println("Coach added!");
        }
        catch(SQLException ex){
            System.out.println("Insertion failed!");
        }
    }

    private void addNewMatch(){
        System.out.println("Enter Date");
        try{
            sql_handler.updateDB("INSERT INTO RUNGTYNES(_data) values ('" + input.next() + "')");
            System.out.println("Match added!");
        }
        catch(SQLException ex){
            System.out.println("Insertion failed!");
        }
    }

    //*********************************************************************
    /* Duomenų peržiūrėjimas */

    private void viewTeams(){
        LinkedList<LinkedList<String>> result = sql_handler.queryDatabase("SELECT * FROM KOMANDA");
        System.out.printf("%-20s | %-20s | %-20s | %-20s %n", "Licence-number", "Team Name", "Played matches", "Victories");
        System.out.printf("------------------------------------------- %n");
        for(int i = 0; i < result.size(); i++){
            System.out.printf("%-20s | %-20s | %-20s | %-20s %n", result.get(i).get(0).trim(), result.get(i).get(1).trim(), result.get(i).get(2).trim(), result.get(i).get(3).trim());
        }
        System.out.println("");
    }

    private void viewPlayersStats(){
        LinkedList<LinkedList<String>> answer = showPlayers();
        while(true){
            System.out.print("Enter player`s surname: ");
            String in = input.next();
            for(int j = 0; j < answer.size(); j++)
                if(answer.get(j).contains(in)) {
                    LinkedList<LinkedList<String>> result = sql_handler.queryDatabase("SELECT pavarde, rungtynių_nr, padavimai, smūgiai, blokai FROM STATISTIKA S, ZAIDEJAS Z, NARYS N WHERE pavarde ='" +
                            in + "'AND S.zaidejoID = Z.licencijos_nr AND Z.licencijos_nr = N.licencijos_nr");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s %n", "Surname", "Match-number", "Serves", "Strikes", "Blocks");
                    System.out.printf("------------------------------------------- %n");
                    for(int i = 0; i < result.size(); i++){
                        System.out.printf("%-20s | %-20s | %-20s | %-20s | %-20s %n",
                                result.get(i).get(0).trim(), result.get(i).get(1).trim(), result.get(i).get(2).trim(), result.get(i).get(3).trim(), result.get(i).get(4).trim());
                    }
                    System.out.println("");
                    return;
                }
            System.out.println("There is no player named: " + in);
            System.out.println("Try again");
        }
    }
    /* EXTRA */
    private LinkedList<LinkedList<String>> showPlayers(){
        System.out.println("List of players:");
        LinkedList<LinkedList<String>> result  = sql_handler.queryDatabase("SELECT vardas, pavarde, marškinėlių_nr, pozicija FROM ZAIDEJAS Z, NARYS N WHERE N.licencijos_nr = Z.licencijos_nr");
        System.out.printf("");
        System.out.printf("%-20s | %-20s | %-20s | %-20s %n","Name", "Surname", "Shirt-number", "Position");
        System.out.printf("------------------------------------------- %n");
        for(int i = 0; i < result.size(); i++){
            System.out.printf("%-20s | %-20s | %-20s | %-20s %n", result.get(i).get(0).trim(), result.get(i).get(1).trim(), result.get(i).get(2).trim(), result.get(i).get(3).trim());
        }
        System.out.println("");
        return result;
    }

    private LinkedList<LinkedList<String>> showMembers(){
        System.out.println("List of players:");
        LinkedList<LinkedList<String>> result  = sql_handler.queryDatabase("SELECT vardas, pavarde FROM NARYS");
        System.out.printf("");
        System.out.printf("%-20s | %-20s %n","Name", "Surname");
        System.out.printf("------------------------------------------- %n");
        for(int i = 0; i < result.size(); i++){
            System.out.printf("%-20s | %-20s %n", result.get(i).get(0).trim(), result.get(i).get(1).trim());
        }
        System.out.println("");
        return result;
    }

    //*********************************************************************
    /* Duomenų atnaujinimas */
    private void updatePlayerStats() {
        showPlayers();
        try{
            System.out.print("Enter Surname of which player you want to update: ");
            String surname = input.next();
            System.out.println("Enter what do you want to update");
            System.out.println("[1] - Serves");
            System.out.println("[2] - Strikes");
            System.out.println("[3] - Blocks");
            System.out.print("Answer: ");
            int answer = input.nextInt();

            System.out.print("Enter number which you want to update to: ");
            int change = input.nextInt();
            switch(answer){
                case 1:
                    sql_handler.updateDB("UPDATE STATISTIKA S SET padavimai = '" + change +
                            "'FROM Zaidejas Z, Narys N WHERE zaidejoID = Z.licencijos_nr AND Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + surname + "' AND S.rungtynių_nr = 1");
                    System.out.println("Update Successful!");
                    break;
                case 2:
                    sql_handler.updateDB("UPDATE STATISTIKA S SET smūgiai = '" + change +
                            "'FROM Zaidejas Z, Narys N WHERE zaidejoID = Z.licencijos_nr AND Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + surname + "' AND S.rungtynių_nr = 1");
                    System.out.println("Update Successful!");
                    break;
                case 3:
                    sql_handler.updateDB("UPDATE STATISTIKA S SET blokai = '" + change +
                            "'FROM Zaidejas Z, Narys N WHERE zaidejoID = Z.licencijos_nr AND Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + surname + "' AND S.rungtynių_nr = 1");
                    System.out.println("Update Successful!");
                    break;
                default:
                    System.out.println("Wrong input, try again");
                    break;
            }
        }
        catch(SQLException ex){
            System.out.println("Failed to update!");
        }
    }
    //*********************************************************************
    /* Duomenų šalinimas */
    private void deleteMember(){
        System.out.println("Members List:");
        showMembers();
        System.out.print("Enter member surname which you want to delete: ");
        try{
            sql_handler.updateDB("DELETE FROM NARYS WHERE pavarde = '" + input.next() + "'");
            System.out.println("Player successfully deleted!");
        }
        catch(SQLException ex){
            System.out.println("Deletion failed!");
        }
    }

    //*********************************************************************
    /* Marškinėlių susikeitimas */
    private void switchPlayerShirts(){
        showPlayers();
        System.out.println("Enter player surname and his shirt number which you want to change:");
        String pav1 = input.next();
        String shirt_nr1 = input.next();

        LinkedList<LinkedList<String>> checkNR1 = sql_handler.queryDatabase("SELECT marškinėlių_nr FROM ZAIDEJAS Z, NARYS N WHERE Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + pav1 + "'");

        if (!checkNR1.get(0).contains(shirt_nr1)){
            System.out.println("Entered wrong number");
            return;
        }

        System.out.println("Enter second player surname and his shirt number:");
        String pav2 = input.next();
        String shirt_nr2 = input.next();

        LinkedList<LinkedList<String>> checkNR2 = sql_handler.queryDatabase("SELECT marškinėlių_nr FROM ZAIDEJAS Z, NARYS N WHERE Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + pav2 + "'");

        if (!checkNR2.get(0).contains(shirt_nr2)){
            System.out.println("Entered wrong number");
            return;
        }

        String firstUpdate = "UPDATE ZAIDEJAS Z SET marškinėlių_nr = '" + shirt_nr1 + "' FROM NARYS N WHERE Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + pav2 + "'";
        String secondUpdate = "UPDATE ZAIDEJAS Z SET marškinėlių_nr = '" + shirt_nr2 + "' FROM NARYS N WHERE Z.licencijos_nr = N.licencijos_nr AND pavarde = '" + pav1 + "'";

        LinkedList<String> queries = new LinkedList<String>();
        queries.add(firstUpdate);
        queries.add(secondUpdate);

        try {
            sql_handler.updateWithTransaction(queries);
            System.out.println("Shirts numbers successfully switched!");
        } catch (SQLException e){
            System.out.println("An error occured during switching shirts!");
        }
    }

    //*********************************************************************
    /* Išėjimas iš programos */
    private void exitProgram(){
        System.exit(1);
        sql_handler.closeConnection();
    }
}