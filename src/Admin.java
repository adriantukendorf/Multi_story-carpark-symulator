import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    Attendant attendant = new Attendant();
    int receipt;
    String attendantName;
    Scanner userinput = new Scanner(System.in);
    //ArrayList holds assistants and their name and state.
    ArrayList<Attendant> Attendants = new ArrayList<Attendant>();

    //Adding a new attendant.
    public void addNewAttendant(){
        System.out.println("ADDING NEW ATTENDANT\nEnter attendant's name: ");
        attendant = new Attendant();
        attendant.setName(userinput.nextLine());
        attendant.setFree(true);
       Attendants.add(attendant);
}
    //Removing an attendant.
    public void removeAttendant(){
        System.out.println("Enter attendant name: ");
        String nameToDelete = userinput.nextLine();

        for(Attendant attendant : Attendants)
        {
            if(Objects.equals(attendant.getName(), nameToDelete))
            {
                System.out.println("Attendant: " +attendant.getName()+ " deleted.");
                Attendants.remove(attendant);
                break;
            }
        }
    }
//Method that is printing all attendants and their state.
    public void printAttendants(){
        System.out.println("Attendants: "+ Arrays.toString(Attendants.toArray()));
    }
    //This method finds a free attendant.
    public boolean findFreeAttendant(){
        boolean x = false;
        boolean free = true;
        for(Attendant attendant : Attendants)
        {
            if(Objects.equals(attendant.isFree(), free))
            {
                System.out.println("Attendant - " +attendant.getName()+ " is going to help you.");
                attendant.setFree(false);
                x = true;
                break;
            }
        }
        return x;
    }
//Method used by attendants to check if someone needs their help, attendant is entering name, if someone requested attendant to collect
// vehicle from a car park, he will be informed and asked for a customers token, then program is waiting for attendant to collect car.
    public void checkIfSomeoneNeedAttendant(Parking parking){
        System.out.println("Type your name: ");
        attendantName=userinput.nextLine();
        for(Attendant attendant : Attendants)
        {
            if(Objects.equals(attendant.getName(), attendantName))
            {
                if(Objects.equals(attendant.isFree(), false)) {
                    System.out.println("You are marked as occupied, someone is waiting for your help!\nAsk customer for token and enter it.\nEnter token:");
                    int token = userinput.nextInt();
                    //check token, if valid print zone and space from token and wait for assistant to collect car
                    if(parking.checkTokenParking(token)==true){
                        System.out.println("Type '1' when you will deliver vehicle to customer.");
                        if(userinput.nextInt()==1){
                            attendant.setFree(true);
                            System.out.println("Good job! You are marked as free again.");
                        }else{
                            System.err.println("You have to deliver vehicle to the customer as fast as possible!\nOtherwise you will still marked as occupied in the system.");
                        }

                    }else{
                        System.out.println("Token expired!");
                    }
                    break;
                }else{
                    System.out.println("You are marked as free, no one requested your help right now.");
                }
                break;
            }
        }



    }
//This method is used by user to request attendant to collect car from a car park.
    public void requestAttendantToCollectCar(Parking parking) throws FileNotFoundException, IOException {
        if(findFreeAttendant()){ //check if there is any free attendant if yes mark as occupied
            System.out.println("Please type your receipt number: ");
            receipt = userinput.nextInt();
            parking.findVehicleAndDelete(receipt);
            System.out.println("Don't forget to give your token to an attendant driver!");
        }else{
            System.out.println("Sorry all attendants are busy right now, please collect your vehicle yourself.");
        }
    }

}
