package project;

public class Bicycle extends LandVehicle{
    private String brand = "";
    private float speed = 0f;
    private int capacity = 1;
    private int wheel = 2;
    private float price = 0f;
    private int productionDate = 0;
    private String colour = "";
    private static int ID=0;
    private int selfID;

    public Bicycle() { ID++; this.selfID = ID; }

    public Bicycle(String brand, float speed, int capacity, float price, int productionDate, String colour) {
        this.brand = brand;
        this.speed = speed;
        this.capacity = capacity;
        this.price = price;
        this.productionDate = productionDate;
        this.colour = colour;
        ID++;
        this.selfID = ID;
    }

    @Override
    public String toString(){
        return "Bicycle" + selfID;
    }

    @Override
    public int getID() {
        return this.selfID;
    }

    @Override
    public int getGeneralID() {return this.ID; }

    @Override
    public void accelerate(float amount)
    {
        speed+=amount;
    }

    @Override
    public void decelerate(float amount)
    {
        speed-=amount;
    }

    @Override
    public void stop ()
    {
        if(speed!=0) speed=0;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getWheel() {
        return wheel;
    }

    @Override
    public void setWheel(short wheel) {
        this.wheel = wheel;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(short productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void finalize()
    {
        ID--;
    }
}
