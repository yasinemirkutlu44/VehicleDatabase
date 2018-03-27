package project;

public class Ship implements SeaVehicle{
    private String brand = "";
    private float speed = 0f;
    private int capacity = 10;
    private int wheel = 0;
    private float price = 0f;
    private int productionDate = 0;
    private String colour = "";
    private static int ID = 0;
    private int selfID;

    public Ship() { ID++; this.selfID = ID; }

    public Ship(String brand, float speed, int capacity, float price, int productionDate, String colour) {
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
        return "Ship" + selfID;
    }

    @Override
    public String getFileWriter()
    {
        return "Ship" + selfID +
                "," + brand +
                "," + speed +
                "," + capacity +
                "," + wheel +
                "," + price +
                "," + productionDate +
                "," + colour;
    }

    @Override
    public int getID() {
        return this.selfID;
    }

    @Override
    public int getGeneralID() { return ID; }

    @Override
    public boolean accelerate(float amount)
    {
        speed+=amount;
        return true;
    }

    @Override
    public boolean decelerate(float amount)
    {
        speed-=amount;
        return true;
    }

    @Override
    public boolean stop ()
    {
        speed=0;
        return true;
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
    public void setSpeed(float speed)
    {
        this.speed = speed;
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
    public void setWheel(int wheel) {
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
    public void setProductionDate(int productionDate) {
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
