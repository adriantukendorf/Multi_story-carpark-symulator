import java.io.Serializable;

public class Vehicle implements Serializable {
    public String IdPlate;
    public String size;
    public int zone;
    public int space;
    public int receipt;
    public long startTime;

    public Vehicle(String idPlate, String size, int zone, int space, int receipt, long startTime) {
        IdPlate = idPlate;
        this.size = size;
        this.zone = zone;
        this.space = space;
        this.receipt = receipt;
        this.startTime = startTime;
    }

    public Vehicle() {
    }

    public String getIdPlate() {
        return IdPlate;
    }

    public void setIdPlate(String idPlate) {
        IdPlate = idPlate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }

    public long getStartTime() { return startTime; }

    public void setStartTime(long startTime) { this.startTime = startTime; }

    @Override
    public String toString() {
        return "*Vehicle " + "ID plate = " + IdPlate + ", size = " + size + ", zone = " + zone + ", space number = " + space + ", receipt number = " + receipt +'}';
    }
}
