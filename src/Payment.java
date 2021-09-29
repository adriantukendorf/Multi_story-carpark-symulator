import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Payment {
    public double Zone1price;
    public double Zone2price;
    public double Zone3price;
    public double Zone4price;
    public double Zone5price;
    private String Zone1priceString;

    public Payment(double Zone1price, double Zone2price, double Zone3price, double Zone4price, double Zone5price) {
      this.Zone1price = Zone1price;
      this.Zone2price = Zone2price;
      this.Zone3price = Zone3price;
      this.Zone4price = Zone4price;
      this.Zone5price = Zone5price;
    }

    public Payment() {

    }

//Method that is loading prices from a text file.
public void readingPrices() throws FileNotFoundException, IOException{
    //creating File instance to reference text file in Java
    FileReader fr = new FileReader("prices.txt");
    BufferedReader br = new BufferedReader(fr);
    Scanner infile = new Scanner(br);
    infile.useDelimiter("\r?\n|\r");

    //Reading each line of file using Scanner class
        while(infile.hasNext()){
            setZone1price(Double.parseDouble(infile.next()));
            setZone2price(Double.parseDouble(infile.next()));
            setZone3price(Double.parseDouble(infile.next()));
            setZone4price(Double.parseDouble(infile.next()));
            setZone5price(Double.parseDouble(infile.next()));
    }

}


    public double getZone1price() {
        return Zone1price;
    }

    public void setZone1price(double zone1price) {
        Zone1price = zone1price;
    }

    public double getZone2price() {
        return Zone2price;
    }

    public void setZone2price(double zone2price) {
        Zone2price = zone2price;
    }

    public double getZone3price() {
        return Zone3price;
    }

    public void setZone3price(double zone3price) {
        Zone3price = zone3price;
    }

    public double getZone4price() {
        return Zone4price;
    }

    public void setZone4price(double zone4price) {
        Zone4price = zone4price;
    }

    public double getZone5price() {
        return Zone5price;
    }

    public void setZone5price(double zone5price) {
        Zone5price = zone5price;
    }
}
