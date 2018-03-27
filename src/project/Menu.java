package project;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//160202103 Tarık BİR
//150202040 Yasin Emir KUTLU

public class Menu extends JFrame {

    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private static String fileName = "DATA_VEHICLE.txt";

    private JRadioButton automobileRadioButton;
    private JRadioButton bicycleRadioButton;
    private JRadioButton planeRadioButton;
    private JRadioButton hydroplaneRadioButton;
    private JRadioButton shipRadioButton;
    private JTextField brandTextField;
    private JTextField speedTextField;
    private JTextField capacityTextField;
    private JTextField wheelTextField;
    private JTextField priceTextField;
    private JTextField productionDateTextField;
    private JTextField colorTextField;
    private JButton addVehicleButton;
    private JRadioButton trueFlyingRadioButton;
    private JRadioButton falseFlyingRadioButton;
    private javax.swing.JPanel JPanel1;
    private JButton updateSelectedVehicleButton;
    private DefaultListModel<Vehicle> listModel = new DefaultListModel<Vehicle>();
    private JList<Vehicle> listVehicleUI;
    private JPanel propertyPanel;
    private JPanel flyingTrueFalseCheck;
    private JTextField fuelTextField;
    private JPanel fuelTypeText;
    private JButton accelerateButton;
    private JButton decelerateButton;
    private JButton stopButton;
    private JPanel speedButtons;
    private JTextField accelerateTextField;
    private JTextField decelerateTextField;
    private JButton removeSelectedVehicleButton;
    private ButtonGroup isFlying;
    private ButtonGroup VehicleClasses;

    public Menu() {
        //Default initialization settings of GUI
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(JPanel1);
        this.setSize(500, 500);
        this.setTitle("Vehicle Data");
        speedButtons.setVisible(false);
        updatePanels(false,false);
        this.setLocationRelativeTo(null);

        //::  Component   Listeners  :://

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleClasses.isSelected(null)) //Bug fix: Can't add new vehicle unless a class is selected.
                    JOptionPane.showMessageDialog(addVehicleButton,"No vehicle class selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = getVehicle(addVehicleButton); //Generates a vehicle with the information got from text boxes.
                    if (veh == null) return; //End prematurely to deny exception generation.
                    vehicleList.add(veh); //Adds newly generated vehicle to the array.
                    listModel.addElement(veh); //Updates the array list with the new vehicle.
                    pack();
                    listVehicleUI.setSelectedIndex(listVehicleUI.getLastVisibleIndex()); //Selects the newly added vehicle from the list.
                    writeFile(fileName);
                    JOptionPane.showMessageDialog(addVehicleButton,"Vehicle have been added!","Done",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        updateSelectedVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listVehicleUI.isSelectionEmpty()) //Bug fix: Can't update without a selection.
                    JOptionPane.showMessageDialog(updateSelectedVehicleButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = vehicleList.get(listVehicleUI.getSelectedIndex()); //Gets the vehicle to update
                    if (veh == null) return; //End prematurely to deny exception generation.
                    try
                    {
                        veh.setBrand(brandTextField.getText());
                        veh.setSpeed(Float.parseFloat(speedTextField.getText()));
                        veh.setCapacity(Integer.parseInt(capacityTextField.getText()));
                        veh.setWheel(Integer.parseInt(wheelTextField.getText()));
                        veh.setPrice(Float.parseFloat(priceTextField.getText()));
                        veh.setProductionDate(Integer.parseInt(productionDateTextField.getText()));
                        veh.setColour(colorTextField.getText());
                        if (veh instanceof Automobile)
                            ((Automobile) veh).setFuel(fuelTextField.getText());
                        if (veh instanceof AirVehicle) {
                            if (trueFlyingRadioButton.isSelected())
                                ((AirVehicle) veh).setFlight(true);
                            else if (falseFlyingRadioButton.isSelected())
                                ((AirVehicle) veh).setFlight(false);
                            else
                                throw new Exception("Plane flight is not selected!");
                        }
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(updateSelectedVehicleButton,"Cannot add vehicle!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    writeFile(fileName);
                    JOptionPane.showMessageDialog(updateSelectedVehicleButton,"Vehicle have been updated!","Done",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        removeSelectedVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listVehicleUI.isSelectionEmpty())
                    JOptionPane.showMessageDialog(removeSelectedVehicleButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    vehicleList.remove(listVehicleUI.getSelectedIndex());
                    listModel.removeElementAt(listVehicleUI.getSelectedIndex());
                    clearTextBoxes();
                    writeFile(fileName);
                    JOptionPane.showMessageDialog(removeSelectedVehicleButton,"Vehicle have been removed!","Done",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        automobileRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listVehicleUI.isSelectionEmpty()) {
                    clearTextBoxes();
                    listVehicleUI.clearSelection();
                }
                wheelTextField.setText("4");
                updatePanels(false,true);
            }
        });
        bicycleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listVehicleUI.isSelectionEmpty()) {
                    clearTextBoxes();
                    listVehicleUI.clearSelection();
                }
                wheelTextField.setText("2");
                updatePanels(false,false);
            }
        });
        planeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listVehicleUI.isSelectionEmpty()) {
                    clearTextBoxes();
                    listVehicleUI.clearSelection();
                }
                wheelTextField.setText("3");
                updatePanels(true,false);
            }
        });
        hydroplaneRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listVehicleUI.isSelectionEmpty()) {
                    clearTextBoxes();
                    listVehicleUI.clearSelection();
                }
                wheelTextField.setText("3");
                updatePanels(true,false);
            }
        });
        shipRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listVehicleUI.isSelectionEmpty()) {
                    clearTextBoxes();
                    listVehicleUI.clearSelection();
                }
                wheelTextField.setText("0");
                updatePanels(false,false);
            }
        });
        listVehicleUI.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listVehicleUI.isSelectionEmpty()) return; //Bug fix: An array can't index as -1.
                Vehicle veh = vehicleList.get(listVehicleUI.getSelectedIndex()); //Gets the selected vehicle as a vehicle.
                //Fills the text boxes.
                brandTextField.setText(veh.getBrand());
                speedTextField.setText(String.valueOf(veh.getSpeed()));
                capacityTextField.setText(String.valueOf(veh.getCapacity()));
                wheelTextField.setText(String.valueOf(veh.getWheel()));
                priceTextField.setText(String.valueOf(veh.getPrice()));
                productionDateTextField.setText(String.valueOf(veh.getProductionDate()));
                colorTextField.setText(veh.getColour());
                //Updates the panels according to the vehicle's class.
                speedButtons.setVisible(true);
                if(veh instanceof Automobile)
                {
                    automobileRadioButton.setSelected(true);
                    updatePanels(false,true);
                    fuelTextField.setText(((Automobile) veh).getFuel());
                }
                else if(veh instanceof Bicycle)
                {
                    bicycleRadioButton.setSelected(true);
                    updatePanels(false,false);
                }
                else if(veh instanceof Plane)
                {
                    planeRadioButton.setSelected(true);
                    updatePanels(true,false);
                    if (((Plane) veh).isFlying())
                        trueFlyingRadioButton.setSelected(true);
                    else
                        falseFlyingRadioButton.setSelected(true);
                }
                else if(veh instanceof Hydroplane)
                {
                    hydroplaneRadioButton.setSelected(true);
                    updatePanels(true,false);
                    if (((Hydroplane) veh).isFlying())
                        trueFlyingRadioButton.setSelected(true);
                    else
                        falseFlyingRadioButton.setSelected(true);
                }
                else if(veh instanceof Ship)
                {
                    shipRadioButton.setSelected(true);
                    updatePanels(false,false);
                }
            }
        });
        accelerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listVehicleUI.isSelectionEmpty())
                    JOptionPane.showMessageDialog(accelerateButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = vehicleList.get(listVehicleUI.getSelectedIndex()); //Gets the vehicle to update
                    if (veh == null) return; //End prematurely to deny exception generation.
                    try
                    {
                        if (!veh.accelerate(Float.parseFloat(accelerateTextField.getText()))) throw new Exception("Functional error!");
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(accelerateButton,"Cannot accelerate!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    speedTextField.setText(""+veh.getSpeed());
                    writeFile(fileName);
                }
            }
        });
        decelerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listVehicleUI.isSelectionEmpty())
                    JOptionPane.showMessageDialog(decelerateButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = vehicleList.get(listVehicleUI.getSelectedIndex()); //Gets the vehicle to update
                    if (veh == null) return; //End prematurely to deny exception generation.
                    try
                    {
                        if (!veh.decelerate(Float.parseFloat(decelerateTextField.getText()))) throw new Exception("Functional error!");
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(decelerateButton,"Cannot decelerate!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    speedTextField.setText(""+veh.getSpeed());
                    writeFile(fileName);
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listVehicleUI.isSelectionEmpty())
                    JOptionPane.showMessageDialog(stopButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = vehicleList.get(listVehicleUI.getSelectedIndex()); //Gets the vehicle to update
                    if (veh == null) return; //End prematurely to deny exception generation.
                    try
                    {
                        if (!veh.stop()) throw new Exception("Functional error!");
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(stopButton,"Can't stop!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    speedTextField.setText(""+veh.getSpeed());
                    writeFile(fileName);
                }
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu(); //Create a new menu window.
        menu.setVisible(true); //Set it visible.
        menu.listVehicleUI.setModel(menu.listModel); //Set the list model to call type.
        readFile(fileName);
        for (Vehicle v: vehicleList) {
            menu.listModel.addElement(v);
        }
    }

    private void updatePanels(boolean flying, boolean fuel)
    {
        /*Toggles toggleable panels with parameters given.*/
        this.flyingTrueFalseCheck.setVisible(flying);
        this.fuelTypeText.setVisible(fuel);
        this.pack();
    }

    private void clearTextBoxes()
    {
        /*Clears all the text boxes except the wheel one.*/
        this.brandTextField.setText("");
        this.speedTextField.setText("");
        this.capacityTextField.setText("");
        this.priceTextField.setText("");
        this.productionDateTextField.setText("");
        this.colorTextField.setText("");
        this.fuelTextField.setText("");
        this.speedButtons.setVisible(false);
        this.trueFlyingRadioButton.setSelected(false);
        this.falseFlyingRadioButton.setSelected(false);
    }

    private Vehicle getVehicle(JButton button)
    {
        /*Gets a new vehicle from text boxes. Handles exceptions and generates error parented to the button given
        as the parameter.*/
        Vehicle veh;
        String brand;
        float speed;
        int capacity;
        float price;
        int productionDate;
        String colour;
        String fuel="";
        boolean isFlying=true;
        try
        {
            brand = brandTextField.getText();
            speed = Float.parseFloat(speedTextField.getText());
            capacity = Integer.parseInt(capacityTextField.getText());
            price = Float.parseFloat(priceTextField.getText());
            productionDate = Integer.parseInt(productionDateTextField.getText());
            colour = colorTextField.getText();
            if (fuelTypeText.isVisible())
                fuel = fuelTextField.getText();
            if (flyingTrueFalseCheck.isVisible()) {
                if (trueFlyingRadioButton.isSelected())
                    isFlying = true;
                else if (falseFlyingRadioButton.isSelected())
                    isFlying = false;
                else
                    throw new Exception("Plane flight is not selected!");
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(button,"Cannot add vehicle!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (automobileRadioButton.isSelected())
            veh = new Automobile(brand,speed,capacity,price,productionDate,colour,fuel);
        else if (bicycleRadioButton.isSelected())
            veh = new Bicycle(brand,speed,capacity,price,productionDate,colour);
        else if (planeRadioButton.isSelected())
            veh = new Plane(brand,speed,capacity,price,productionDate,colour,isFlying);
        else if (hydroplaneRadioButton.isSelected())
            veh = new Hydroplane(brand,speed,capacity,price,productionDate,colour,isFlying);
        else if (shipRadioButton.isSelected())
            veh = new Ship(brand,speed,capacity,price,productionDate,colour);
        else
        {
            JOptionPane.showMessageDialog(button,"Cannot add vehicle!\nNo vehicle class selected!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return veh;
    }

    private static Vehicle getVehicle(String s)
    {
        /*Gets a new vehicle from a string. Handles exceptions, doesn't return any error generated.*/
        Vehicle veh;
        String brand;
        float speed;
        int capacity;
        float price;
        int productionDate;
        String colour;
        String fuel="";
        boolean isFlying=true;
        String[] properties = s.split(",");
        String type = properties[0];
        try
        {
            brand = properties[1];
            speed = Float.parseFloat(properties[2]);
            capacity = Integer.parseInt(properties[3]);
            price = Float.parseFloat(properties[5]);
            productionDate = Integer.parseInt(properties[6]);
            colour = properties[7];
            if (type.contains("Automobile"))
                fuel = properties[8];
            else if (type.contains("Plane") || type.contains("Hydroplane"))
                isFlying = Boolean.valueOf(properties[8]);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        if (type.contains("Automobile"))
            veh = new Automobile(brand,speed,capacity,price,productionDate,colour,fuel);
        else if (type.contains("Bicycle"))
            veh = new Bicycle(brand,speed,capacity,price,productionDate,colour);
        else if (type.contains("Plane"))
            veh = new Plane(brand,speed,capacity,price,productionDate,colour,isFlying);
        else if (type.contains("Hydroplane"))
            veh = new Hydroplane(brand,speed,capacity,price,productionDate,colour,isFlying);
        else if (type.contains("Ship"))
            veh = new Ship(brand,speed,capacity,price,productionDate,colour);
        else
        {
            return null;
        }
        System.out.println(veh.getFileWriter());
        return veh;
    }

    private static void readFile(String filename)
    {
        File dataFile = new File(filename);
        try (Scanner input = new Scanner(dataFile)) {
            while(input.hasNextLine()){
                vehicleList.add(getVehicle(input.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String filename)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Vehicle veh : vehicleList) {
                bw.write(veh.getFileWriter()+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
