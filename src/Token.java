import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Token implements Serializable {

    public int numberOfToken;
    public long timeOfGenerating;
    public int zone;
    public int space;

    int usersToken;
    long time;
    Random rand = new Random();
    ArrayList<Token> Tokens = new ArrayList<Token>();

    public Token(int numberOfToken, int timeOfGenerating, int zone, int space) {
        this.numberOfToken = numberOfToken;
        this.timeOfGenerating = timeOfGenerating;
        this.zone = zone;
        this.space = space;
    }

    public Token() {

    }

    int randomNumber = rand.nextInt(1000);
//Method that checks if token is valid (less than 15minutes) and printing zone and space of vehicle.
public boolean checkingToken(int tokenToCheck){
    boolean x = false;
    usersToken = tokenToCheck;
    for(Token token : Tokens)
    {
        if(Objects.equals(token.getNumberOfToken(), usersToken))
        {
            time = System.currentTimeMillis() - token.timeOfGenerating;
            if(time<900000){
                System.out.println("Token: OK");
                System.out.println("Zone:"+token.getZone()+" Space:"+token.getSpace());
                x = true;
                break;
            }else{
                System.out.println("Sorry, it's been more than 15 minutes.");
                x = false;
                break;
            }
        }
    }
return x;
}








    public int getNumberOfToken() {
        return numberOfToken;
    }

    public void setNumberOfToken(int numberOfToken) {
        this.numberOfToken = numberOfToken;
    }

    public long getTimeOfGenerating() {
        return timeOfGenerating;
    }

    public void setTimeOfGenerating(long timeOfGenerating) {
        this.timeOfGenerating = timeOfGenerating;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
