import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

public class User {
    Vehicle vehicle = new Vehicle();
    int receipt;
    SpacesManager spacesManager = new SpacesManager();
    Scanner userinput = new Scanner(System.in);

    public void registerCar(Parking parking) {
        System.out.println("Type license plate number: ");
        vehicle.setIdPlate(userinput.nextLine());
        printVehicleSpec();

try {
    switch (userinput.nextInt()) {
        case 1:
            vehicle.setZone(1);
            vehicle.setSize("Standard sized vehicle");
            break;
        case 2:
            vehicle.setZone(2);
            vehicle.setSize("Higher vehicle");
            break;
        case 3:
            vehicle.setZone(3);
            vehicle.setSize("Longer vehicle");
            break;
        case 4:
            vehicle.setZone(4);
            vehicle.setSize("Coach");
            break;
        case 5:
            vehicle.setZone(5);
            vehicle.setSize("Motorbike");
            break;
        default:
            System.err.println("\nERROR ZONE");
            System.out.println();
            registerCar(parking);
            break;
    }

}catch (Exception e) {
    System.out.println("\nERROR!");
}
        vehicle.setReceipt(receipt++); //receipt
        vehicle.setStartTime(System.currentTimeMillis()); //time
        parking.addCarToSpace(vehicle); //adding car to zone and space

    }
public void collectCar(Parking parking) throws FileNotFoundException, IOException {
    System.out.println("Please type your receipt number: ");
    receipt = userinput.nextInt();
    parking.findVehicleAndDelete(receipt);

}

public void printVehicleSpec(){
    System.out.println("Our parking have 5 special zones for different vehicles, you have to choose vehicle specification.");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(" 1 - Standard sized vehicle \n max height: 2 meters \n max length: 5 meters \n CAR or SMALL VAN");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(" 2 - Higher vehicles \n max height: 3 meters \n max length: 5 meters \n TALL SHORT WHEEL-BASED VANS");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(" 3 - Longer vehicles \n max height: 3 \n between 5.1 and 6 meters high \n LONG WHEEL-BASED VANS");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(" 4 - Coaches \n any height \n max length: 15 meters");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(" 5 - Motorbikes");
}

    public void registerCarAttendant(Parking parking) {

        System.out.println("Type customer's license plate number: ");
        vehicle.setIdPlate(userinput.nextLine());
        printVehicleSpec();

        try {
            switch (userinput.nextInt()) {
                case 1:
                    vehicle.setZone(1);
                    vehicle.setSize("Standard sized vehicle");
                    break;
                case 2:
                    vehicle.setZone(2);
                    vehicle.setSize("Higher vehicle");
                    break;
                case 3:
                    vehicle.setZone(3);
                    vehicle.setSize("Longer vehicle");
                    break;
                case 4:
                    vehicle.setZone(4);
                    vehicle.setSize("Coach");
                    break;
                case 5:
                    vehicle.setZone(5);
                    vehicle.setSize("Motorbike");
                    break;
                default:
                    System.err.println("\nERROR ZONE");
                    System.out.println();
                    registerCar(parking);
                    break;
            }

        } catch (Exception e) {
            System.out.println("\nERROR!");
        }

        System.out.println("1 - Find space automatically 2 - Find space manually  ");
        if (userinput.nextInt() == 1) {
            vehicle.setReceipt(receipt++); //receipt
            vehicle.setStartTime(System.currentTimeMillis()); //time
            parking.addCarToSpace(vehicle); //adding car to zone and space

        }else{
            vehicle.setReceipt(receipt++); //receipt
            vehicle.setStartTime(System.currentTimeMillis()); //time
            parking.addCarToSpaceManually(vehicle);

        }}}
