import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.time.*;
import java.util.Random;

public class Parking implements Serializable {
    public int vehicleIndex;
    public long timeParked;
    public double price;
    public int zone;
    public int zoneToken;
    public int spaceToken;
    public int unusedReceipt;

    ArrayList<Vehicle> Zone1 = new ArrayList<Vehicle>();
    ArrayList<Vehicle> Zone2 = new ArrayList<Vehicle>();
    ArrayList<Vehicle> Zone3 = new ArrayList<Vehicle>();
    ArrayList<Vehicle> Zone4 = new ArrayList<Vehicle>();
    ArrayList<Vehicle> Zone5 = new ArrayList<Vehicle>();

SpacesManager spaceManager = new SpacesManager();
Payment payment = new Payment();
Token token = new Token();

    boolean[] Receipts = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,};//Every place in this array represent one receipt, parking size is 100 spaces, what means there can be 100 different receipts.

    //finding free space, assigning this to vehicle, marking as occupied
    public void addCarToSpace(Vehicle vehicle){

        switch (vehicle.getZone()) {
    case 1:
        Zone1.add(vehicle);
        spaceManager.findFreeSpaceinZone1(vehicle);
        break;

    case 2:
        Zone2.add(vehicle);
        spaceManager.findFreeSpaceinZone2(vehicle);
        break;

    case 3:
        Zone3.add(vehicle);
        spaceManager.findFreeSpaceinZone3(vehicle);
        break;

    case 4:
        Zone4.add(vehicle);
        spaceManager.findFreeSpaceinZone4(vehicle);
        break;

    case 5:
        Zone5.add(vehicle);
        spaceManager.findFreeSpaceinZone5(vehicle);
        break;

        default:
            System.out.println("error - Zone is: "+vehicle.getZone());
            break;
}
        receiptManager(vehicle);
        vehicle.setReceipt(unusedReceipt);
        System.out.println("Vehicle is successfully registered\nYour receipt number: "+vehicle.getReceipt()+"\nYour vehicle is parked in zone "+vehicle.getZone()+" space "+vehicle.getSpace()+".");
    }

    public void addCarToSpaceManually(Vehicle vehicle){
        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter space ID: ");
        int spaceToCheck = userinput.nextInt();

        switch (vehicle.getZone()) {
            case 1:
                if(spaceManager.checkSpaceInZone1(spaceToCheck)){
                    vehicle.setSpace(spaceToCheck);
                    Zone1.add(vehicle);
                }
                break;

            case 2:
                if(spaceManager.checkSpaceInZone2(spaceToCheck)){
                    vehicle.setSpace(spaceToCheck);
                    Zone2.add(vehicle);
                }
                break;

            case 3:
                if(spaceManager.checkSpaceInZone3(spaceToCheck)){
                    vehicle.setSpace(spaceToCheck);
                    Zone3.add(vehicle);
                }
                break;

            case 4:
                if(spaceManager.checkSpaceInZone4(spaceToCheck)){
                    vehicle.setSpace(spaceToCheck);
                    Zone4.add(vehicle);
                }
                break;

            case 5:
                if(spaceManager.checkSpaceInZone5(spaceToCheck)){
                    vehicle.setSpace(spaceToCheck);
                    Zone5.add(vehicle);
                }
                break;

            default:
                System.out.println("error - Zone is: "+vehicle.getZone());
                break;
        }
        receiptManager(vehicle);
        vehicle.setReceipt(unusedReceipt);
    }

    public void printParking(){
        System.out.println("Zone 1: "+ Arrays.toString(Zone1.toArray()));
        System.out.println("Zone 2: "+ Arrays.toString(Zone2.toArray()));
        System.out.println("Zone 3: "+ Arrays.toString(Zone3.toArray()));
        System.out.println("Zone 4: "+ Arrays.toString(Zone4.toArray()));
        System.out.println("Zone 5: "+ Arrays.toString(Zone5.toArray()));
    }
    //This method is setting a receipt for vehicle, thanks to this method there are no two the same receipts numbers for different vehicles.
    public void receiptManager(Vehicle vehicle){
            for(int i=0; i<Receipts.length;i++){
                if(Receipts[i]==true){
                    unusedReceipt = i;
                    Receipts[i]=false;
                    break;
                }
            }
            vehicle.setReceipt(unusedReceipt);
    }

    public void setReceiptAsUnused(int usedReceipt){
        Receipts[usedReceipt] = true;
    }


//Method depends on zone of the vehicle to assign price and also after successful payment is deleting the vehicle from parking.
    public Vehicle findVehicleAndDelete(int receipt) throws FileNotFoundException, IOException {
        payment.readingPrices(); //reading prices from a file, it can be easly edited by admin that's why I decided to save data to normal text file instead using Serialization class
        for(Vehicle vehicle : Zone1)
        {
            if(Objects.equals(vehicle.getReceipt(), receipt))
            {
                zone = 1;
                vehicleIndex = Zone1.indexOf(vehicle);
                timeParked = System.currentTimeMillis() - vehicle.getStartTime();
                price = payment.Zone1price;
                System.out.println("Vehicle is located in Zone "+vehicle.getZone()+" and space number "+vehicle.getSpace()+". ");
                spaceToken = vehicle.getSpace();
                zoneToken = vehicle.getZone();

                if(paying()){
                    spaceManager.setSpaceFreeZone1(vehicle.getSpace());
                    setReceiptAsUnused(vehicle.getReceipt());
                    Zone1.remove(Zone1.indexOf(vehicle));
                    System.out.println("Vehicle is deleted successfully.");
                }
                return vehicle;
            }
        }
        for(Vehicle vehicle : Zone2)
        {
            if(Objects.equals(vehicle.getReceipt(), receipt))
            {
                zone = 2;
                vehicleIndex = Zone2.indexOf(vehicle);
                timeParked = System.currentTimeMillis() - vehicle.getStartTime();
                System.out.println("Vehicle is located in Zone "+vehicle.getZone()+" and space number "+vehicle.getSpace()+". ");
                spaceToken = vehicle.getSpace();
                zoneToken = vehicle.getZone();
                if(paying()){
                    spaceManager.setSpaceFreeZone2(vehicle.getSpace());
                    setReceiptAsUnused(vehicle.getReceipt());
                    Zone2.remove(Zone2.indexOf(vehicle));
                    System.out.println("Vehicle is deleted successfully.");
                }
                return vehicle;
            }
        }
        for(Vehicle vehicle : Zone3)
        {
            if(Objects.equals(vehicle.getReceipt(), receipt))
            {
                zone =3;
                vehicleIndex = Zone3.indexOf(vehicle);
                timeParked = System.currentTimeMillis() - vehicle.getStartTime();
                System.out.println("Vehicle is located in Zone "+vehicle.getZone()+" and space number "+vehicle.getSpace()+". ");
                spaceToken = vehicle.getSpace();
                zoneToken = vehicle.getZone();
                if(paying()){
                    spaceManager.setSpaceFreeZone3(vehicle.getSpace());
                    setReceiptAsUnused(vehicle.getReceipt());
                    Zone3.remove(Zone3.indexOf(vehicle));
                    System.out.println("Vehicle is deleted successfully.");
                }
                return vehicle;
            }
        }
        for(Vehicle vehicle : Zone4)
        {
            if(Objects.equals(vehicle.getReceipt(), receipt))
            {
                zone =4;
                vehicleIndex = Zone4.indexOf(vehicle);
                timeParked = System.currentTimeMillis() - vehicle.getStartTime();
                System.out.println("Vehicle is located in Zone "+vehicle.getZone()+" and space number "+vehicle.getSpace()+". ");
                spaceToken = vehicle.getSpace();
                zoneToken = vehicle.getZone();
                if(paying()){
                    spaceManager.setSpaceFreeZone4(vehicle.getSpace());
                    setReceiptAsUnused(vehicle.getReceipt());
                    Zone4.remove(Zone4.indexOf(vehicle));
                    System.out.println("Vehicle is deleted successfully.");
                }
                return vehicle;
            }
        }
        for(Vehicle vehicle : Zone5)
        {
            if(Objects.equals(vehicle.getReceipt(), receipt))
            {
                zone = 5;
                vehicleIndex = Zone5.indexOf(vehicle);
                timeParked = System.currentTimeMillis() - vehicle.getStartTime();
                System.out.println("Vehicle is located in Zone "+vehicle.getZone()+" and space number "+vehicle.getSpace()+". ");
                spaceToken = vehicle.getSpace();
                zoneToken = vehicle.getZone();
                if(paying()){
                    spaceManager.setSpaceFreeZone5(vehicle.getSpace());
                    setReceiptAsUnused(vehicle.getReceipt());
                    Zone5.remove(Zone5.indexOf(vehicle));
                    System.out.println("Vehicle is removed successfully.");
                }
                return vehicle;
            }}
        return null;
    }
//This method is responsible for taking payments, depending from a zone, day of the week(Sunday) and if customer is disabled. Returning boolean if payment is successful.
    public boolean paying(){
        Scanner userinput = new Scanner(System.in);
        boolean x = false;
        int seconds = (int) (timeParked / 1000) % 60 ;
        int minutes = (int) ((timeParked / (1000*60)) % 60);
        int hours   = (int) ((timeParked / (1000*60*60)) % 24);
        System.out.println("Time parked is :" + hours +":"+ minutes +":"+ seconds);
        System.out.println("Hourly rate is : £"+price+" per every started hour.");
        double cost = (hours*price);
        if((minutes > 0) | (seconds > 0)){
        cost = cost+1;
        }
        System.out.println("Are you a disabled person? \n 1 - YES | 2 - NO");
        if(userinput.nextInt()==1){
            cost=cost/2;

            if(LocalDate.now().getDayOfWeek()==DayOfWeek.SUNDAY){ //if sunday disabled persons have free parking
                cost=0;
            }
        }else{
            if(LocalDate.now().getDayOfWeek()==DayOfWeek.SUNDAY & zone!=3){ //if sunday everyone is charged half of the price, except coaches
                cost=cost/2;
            }
        }
        System.out.println("Please pay: £"+cost);
        System.out.println("Type how much did you paid (use format 0.0): ");
        double paid = userinput.nextDouble();
        if(paid>=cost){
            double change=paid-cost;
            System.out.println("Thank you,\nChange: £"+change);
            x = true;
        }else{
            System.out.println("It's too less. Try to pay again.");
            paying();
        }
        System.out.println("Your token: "+generatingToken()+"\n" );
        return x;
    }
//This method is generating token for user using random number, is also adding token to an array what makes possible to check token in the future.
   public int generatingToken(){
       Random rand = new Random();
       int x = rand.nextInt(1000);
       token.setNumberOfToken(x);
       token.setTimeOfGenerating(System.currentTimeMillis());
       token.setSpace(spaceToken);
       token.setZone(zoneToken);
       token.Tokens.add(token);
        return x;
    }

public boolean checkTokenParking(int tokenToCheck){
    boolean x = false;
    if(token.checkingToken(tokenToCheck)){
        x = true;
    }
    return x;
}
//Method loading parking spaces and receipts to avoid parking two vehicles in one place or having same receipt. I used class Serializable because I think that's the best way to save program data.
public void loadSpacesManager() throws Exception{
        try
        {
            FileInputStream fis = new FileInputStream("SpacesData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            spaceManager.Zone1Spaces = (boolean[]) ois.readObject();
            spaceManager.Zone2Spaces = (boolean[]) ois.readObject();
            spaceManager.Zone3Spaces = (boolean[]) ois.readObject();
            spaceManager.Zone4Spaces = (boolean[]) ois.readObject();
            spaceManager.Zone5Spaces = (boolean[]) ois.readObject();
            Receipts = (boolean[]) ois.readObject();
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
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
//Method that saves parking spaces and receipts.
    public void saveSpacesManager() throws Exception{
        try
        {
            FileOutputStream fos = new FileOutputStream("SpacesData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(spaceManager.Zone1Spaces);
            oos.writeObject(spaceManager.Zone2Spaces);
            oos.writeObject(spaceManager.Zone3Spaces);
            oos.writeObject(spaceManager.Zone4Spaces);
            oos.writeObject(spaceManager.Zone5Spaces);
            oos.writeObject(Receipts);


            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }
}
