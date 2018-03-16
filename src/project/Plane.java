package project;

public class Plane implements AirVehicle {
    private String brand = "";
    private float speed = 0f;
    private int capacity = 30;
    private int wheel = 6;
    private float price = 0f;
    private int productionDate = 0;
    private String colour = "";
    private boolean onFlight = false;
    private static int ID=0;

    public Plane() { ID++; }

    public Plane(String brand, int capacity, float price, int productionDate, String colour) {
        this.brand = brand;
        this.capacity = capacity;
        this.price = price;
        this.productionDate = productionDate;
        this.colour = colour;
        ID++;
    }

    public static int getID() {
        return ID;
    }

    @Override
    public boolean isFlying()
    {
        return onFlight;
    }

    @Override
    public void accelerate(float amount)
    {
        if (onFlight)
            speed+=amount;
        else {
            onFlight = true;
            speed += amount;
        }
    }

    @Override
    public void decelerate(float amount)
    {
        if (onFlight) {
            speed -= amount;
            if (speed <= 0) onFlight = false;
        }
    }

    @Override
    public void stop ()
    {
        if(!onFlight) speed=0;
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
