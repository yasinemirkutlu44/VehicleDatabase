package project;

public interface Vehicle {
    boolean accelerate(float amount);
    boolean decelerate(float amount);
    boolean stop();

    int getID();
    int getGeneralID();
    
    String getBrand();
    void setBrand(String brand);
    float getSpeed();
    void setSpeed(float speed);
    int getCapacity();
    void setCapacity(int capacity);
    int getWheel();
    void setWheel(int wheel);
    float getPrice();
    void setPrice(float price);
    int getProductionDate();
    void setProductionDate(int productionDate);
    String getColour();
    void setColour(String colour);
    String getFileWriter();
}