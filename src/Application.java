/**
* The Multi-story Car-Parking Program (MCP)
*
*CS12320 Main module assignment.
* @author  Adrian Tukendorf
* @version 1.0
* @since   2019-05-04
*/

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Application implements Serializable {

    Scanner userinput = new Scanner(System.in);
    Parking parking = new Parking();
    Token token = new Token();
    Admin admin = new Admin();

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println();
        System.out.println("\n-----------------------------------------------------");
        System.out.println("\t***  MCP - MULTI STORY CAR PARK SYSTEM  ***");
        System.out.println("" +
                "" +
                "-----------------------------------------------------");
        System.out.println();
       Application APP = new Application();
        APP.chooseUser();

    }
    public void chooseUser(){
        while(true){
        try {
        System.out.println("\n Who you are? \n\n 1 - Driver \n 2 - Attendant \n 3 - Admin \n\n OTHER OPTIONS:\n\n 4 - Barrier(TOKEN CHECK) \n 5 - Display parking\n 6 - Save Parking\n 7 - Load Parking");
        System.out.println("\n");
        System.out.print("Please enter your option:");
        userinput = new Scanner(System.in);
        int SelectedOption;
        SelectedOption = userinput.nextInt();

        switch (SelectedOption) {
            case 1:
displayMenuForDriver();
                break;
            case 2:
displayMenuForAttendant();
                break;
            case 3:
displayMenuForAdmin();
                break;
            case 4:
                System.out.println("Enter token: ");
                int tokenToCheck = userinput.nextInt();
                parking.checkTokenParking(tokenToCheck);
                break;
            case 5:
                parking.printParking();
                break;
            case 6:
                saveParkingState();
                parking.saveSpacesManager();
                break;
            case 7:
                loadParkingState();
                parking.loadSpacesManager();
                break;
            default:
                System.err.println("\nYou have entered an invalid option!");
                System.out.println();
                break;

        }
    } catch (Exception e) {
        //Exception message
        System.err.println("WRONG INPUT!");
        chooseUser();
    }}}

private void displayMenuForDriver(){
    System.out.println("\n \n 1 - CAR REGISTRATION \n 2 - CAR COLLECTION \n 3 - REQUEST ATTENDANT TO COLLECT YOUR CAR \n");
    System.out.println("Please enter your option: ");
    try {

        User user = new User();
        int SelectedOption;
        SelectedOption = userinput.nextInt();

        switch (SelectedOption) {
            case 1:
                user.registerCar(parking);
                break;
            case 2:
                user.collectCar(parking);
                break;
            case 3:
                admin.requestAttendantToCollectCar(parking);
                break;
            default:
                System.err.println("\nYou have entered an invalid option!\n");
                break;

        }
    } catch (Exception e) {
        //Exception message
        System.err.println("\nInvalid option!");
        chooseUser();
    }}

    private void displayMenuForAttendant(){
        System.out.println("\n \n 1 - CAR REGISTRATION \n 2 - CAR DEREGISTRATION \n 3 - CAR COLLECTION USING CUSTOMER'S TOKEN  \n ");
        System.out.println("Please enter your option: ");
        try {

           User user = new User();
            int SelectedOption;
            SelectedOption = userinput.nextInt();

            switch (SelectedOption) {
                case 1:
                    user.registerCarAttendant(parking);
                    break;
                case 2:
                    user.collectCar(parking);
                    break;
                case 3:
                    admin.checkIfSomeoneNeedAttendant(parking); //checking if someone needs attendant right now, if yes - checking token, printing space and zone of vehicle
                    break;
                default:
                    System.err.println("\nYou have entered an invalid option!");
                    System.out.println();
                    break;

            }
        } catch (Exception e) {
            //Exception message
            System.out.println("\nInvalid option!");
            chooseUser();
        }}

    private void displayMenuForAdmin(){
        System.out.println("\n \n 1 - ADD ATTENDANT \n 2 - REMOVE ATTENDANT \n 3 - PRINT ATTENDANTS \n");
        System.out.println("Please enter your option: ");
        try {
            int SelectedOption;
            SelectedOption = userinput.nextInt();

            switch (SelectedOption) {
                case 1:
                  admin.addNewAttendant();
                    break;
                case 2:
                  admin.removeAttendant();
                    break;
                case 3:
                  admin.printAttendants();
                    break;
                default:
                    System.err.println("\nYou have entered an invalid option!");
                    System.out.println();
                    break;

            }
        } catch (Exception e) {
            //Exception message
            System.out.println("\nInvalid option!");
            chooseUser();
        }}
//Load method, using Class Serializable and ObjectInputStream
public void loadParkingState() throws Exception{
    try
    {
        FileInputStream fis = new FileInputStream("VehiclesData");
        ObjectInputStream ois = new ObjectInputStream(fis);

        parking.Zone1 = (ArrayList) ois.readObject();
        parking.Zone2 = (ArrayList) ois.readObject();
        parking.Zone3 = (ArrayList) ois.readObject();
        parking.Zone4 = (ArrayList) ois.readObject();
        parking.Zone5 = (ArrayList) ois.readObject();
        token.Tokens = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
    }
    catch (IOException ioe)
    {
        ioe.printStackTrace();
        return;
    }
    catch (ClassNotFoundException c)
    {
        System.out.println("Class not found.");
        c.printStackTrace();
        return;
    }
}
//Save method, using Class Serializable and ObjectOutputStream

public void saveParkingState() throws Exception{
    try
    {
        FileOutputStream fos = new FileOutputStream("VehiclesData");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(parking.Zone1);
        oos.writeObject(parking.Zone2);
        oos.writeObject(parking.Zone3);
        oos.writeObject(parking.Zone4);
        oos.writeObject(parking.Zone5);
        oos.writeObject(token.Tokens);

        oos.close();
        fos.close();
    }
    catch (IOException ioe)
    {
        ioe.printStackTrace();
    }

}}