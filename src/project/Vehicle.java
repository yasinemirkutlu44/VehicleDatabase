package project;

public interface Vehicle {
    public boolean accelerate(float amount);
    public boolean decelerate(float amount);
    public boolean stop ();

    public int getID();
    public int getGeneralID();
    
    public String getBrand();
    public void setBrand(String brand);
    public float getSpeed();
    public void setSpeed(float speed);
    public int getCapacity();
    public void setCapacity(int capacity);
    public int getWheel();
    public void setWheel(int wheel);
    public float getPrice();
    public void setPrice(float price);
    public int getProductionDate();
    public void setProductionDate(int productionDate);
    public String getColour();
    public void setColour(String colour);
}