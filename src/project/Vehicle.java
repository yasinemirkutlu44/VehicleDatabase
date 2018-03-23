package project;

public interface Vehicle {
    public void accelerate(float amount);
    public void decelerate(float amount);
    public void stop ();

    public int getID();
    public int getGeneralID();
    
    public String getBrand();
    public void setBrand(String brand);
    public float getSpeed();
    public int getCapacity();
    public void setCapacity(int capacity);
    public int getWheel();
    public void setWheel(short wheel);
    public float getPrice();
    public void setPrice(float price);
    public int getProductionDate();
    public void setProductionDate(short productionDate);
    public String getColour();
    public void setColour(String colour);
}
