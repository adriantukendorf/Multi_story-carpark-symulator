public class Attendant {
    public String name;
    public boolean isFree;

    public Attendant(String name, boolean isFree) {
        name = name;
        this.isFree = isFree;
}

    public Attendant() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isFree() {
        return isFree;
    }
    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Attendant{" + "name = '" + name + '\'' + ", is free=" + isFree + '}';
    }
}
