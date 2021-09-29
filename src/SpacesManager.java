import java.io.Serializable;

public class SpacesManager implements Serializable {
//Arrays that holds state of specific space in a car park.
    boolean[] Zone1Spaces = {true,true,true,true,true,true,true,true,true,true};//0,1,2,3,4,5,6,7,8,9
    boolean[] Zone2Spaces = {true,true,true,true,true,true,true,true,true,true};//0,1,2,3,4,5,6,7,8,9
    boolean[] Zone3Spaces = {true,true,true,true,true,true,true,true,true,true};//0,1,2,3,4,5,6,7,8,9
    boolean[] Zone4Spaces = {true,true,true,true,true,true,true,true,true,true};//0,1,2,3,4,5,6,7,8,9
    boolean[] Zone5Spaces = {true,true,true,true,true,true,true,true,true,true};//0,1,2,3,4,5,6,7,8,9
    int freespace;

//Method that is looking automatically for a free space in a car park in a specific zone.
public void findFreeSpaceinZone1(Vehicle vehicle){

    for(int i=0; i<Zone1Spaces.length;i++){
        if(Zone1Spaces[i]==true){
            freespace = i;
           Zone1Spaces[i]=false;
            break;
        }
    }
    vehicle.setSpace(freespace);
}

    public void findFreeSpaceinZone2(Vehicle vehicle){

        for(int i=0; i<Zone2Spaces.length;i++){
            if(Zone2Spaces[i]==true){
                freespace = i;
                Zone2Spaces[i]=false;
                break;
            }
        }
        vehicle.setSpace(freespace);
    }

    public void findFreeSpaceinZone3(Vehicle vehicle){

        for(int i=0; i<Zone3Spaces.length;i++){
            if(Zone3Spaces[i]==true){
                freespace = i;
                Zone3Spaces[i]=false;
                break;
            }
        }
        vehicle.setSpace(freespace);
    }
    public void findFreeSpaceinZone4(Vehicle vehicle){

        for(int i=0; i<Zone4Spaces.length;i++){
            if(Zone4Spaces[i]==true){
                freespace = i;
                Zone4Spaces[i]=false;
                break;
            }
        }
        vehicle.setSpace(freespace);
    }
    public void findFreeSpaceinZone5(Vehicle vehicle){

        for(int i=0; i<Zone5Spaces.length;i++){
            if(Zone5Spaces[i]==true){
                freespace = i;
                Zone5Spaces[i]=false;
                break;
            }
        }
        vehicle.setSpace(freespace);
    }
//This method checks place in Zone 1 if is free or occupied, I am using this because attendants are able to choose space ID to park a vehicle.
    public boolean checkSpaceInZone1(int spaceToCheck){
        boolean x = false;

        if(Zone1Spaces[spaceToCheck]==true){
            Zone1Spaces[spaceToCheck]=false;
        x = true;
            System.out.println("Place is free.");

    }else{
            System.out.println("Sorry, place is occupied. \n");
        }

    return x;
    }

    public boolean checkSpaceInZone2(int spaceToCheck){
        boolean x = false;

        if(Zone2Spaces[spaceToCheck]==true){
            Zone2Spaces[spaceToCheck]=false;
            x = true;
            System.out.println("Place is free.");

        }else{
            System.out.println("Sorry, place is occupied. \n");
        }

        return x;
    }
    public boolean checkSpaceInZone3(int spaceToCheck){
        boolean x = false;

        if(Zone3Spaces[spaceToCheck]==true){
            Zone3Spaces[spaceToCheck]=false;
            x = true;
            System.out.println("Place is free.");

        }else{
            System.out.println("Sorry, place is occupied. \n");
        }

        return x;
    }
    public boolean checkSpaceInZone4(int spaceToCheck){
        boolean x = false;

        if(Zone4Spaces[spaceToCheck]==true){
            Zone4Spaces[spaceToCheck]=false;
            x = true;
            System.out.println("Place is free.");

        }else{
            System.out.println("Sorry, place is occupied. \n");
        }

        return x;
    }
    public boolean checkSpaceInZone5(int spaceToCheck){
        boolean x = false;

        if(Zone5Spaces[spaceToCheck]==true){
            Zone5Spaces[spaceToCheck]=false;
            x = true;
            System.out.println("Place is free.");

        }else{
            System.out.println("Sorry, place is occupied. \n");
        }

        return x;
    }
    //Setters
    public void setSpaceFreeZone1(int space){
    Zone1Spaces[space] = true;
}
    public void setSpaceFreeZone2(int space){
        Zone2Spaces[space] = true;
    }
    public void setSpaceFreeZone3(int space){
        Zone3Spaces[space] = true;
    }
    public void setSpaceFreeZone4(int space){
        Zone4Spaces[space] = true;
    }
    public void setSpaceFreeZone5(int space){
        Zone5Spaces[space] = true;
    }

}





