package project;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;

//160202103 Tarık BİR
//150202040 Yasin Emir KUTLU

public class Menu extends JFrame {

    private static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    private JRadioButton automobileRadioButton;
    private JRadioButton bicycleRadioButton;
    private JRadioButton planeRadioButton;
    private JRadioButton hydroplaneRadioButton;
    private JRadioButton shipRadioButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton addVehicleButton;
    private JRadioButton trueRadioButton;
    private JRadioButton falseRadioButton;
    private javax.swing.JPanel JPanel1;
    private JButton updateSelectedVehicleButton;
    private DefaultListModel<Vehicle> listModel = new DefaultListModel<Vehicle>();
    private JList<Vehicle> list1;
    private JPanel propertyPanel;
    private JPanel flyingTrueFalseCheck;
    private JTextField textField8;
    private JPanel fuelTypeText;
    private ButtonGroup isFlying;
    private ButtonGroup VehicleClasses;

    public Menu() {
        //Default initialization settings of GUI
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(JPanel1);
        this.setSize(500, 500);
        clearPanels(false,false);
        this.setLocationRelativeTo(null);

        //::  Component   Listeners  :://

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleClasses.isSelected(null)) //Bug fix: Can't add new vehicle unless a class is selected.
                    JOptionPane.showMessageDialog(addVehicleButton,"No vehicle class selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = getVehicle(addVehicleButton,"add"); //Generates a vehicle with the information got from text boxes.
                    vehicleList.add(veh); //Adds newly generated vehicle to the array.
                    updateList(veh); //Updates the array list with the new vehicle.
                    list1.setSelectedIndex(list1.getLastVisibleIndex()); //Selects the newly added vehicle from the list.
                    JOptionPane.showMessageDialog(addVehicleButton,"Vehicle have been added!","Done",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        updateSelectedVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty()) //Bug fix: Can't update without a selection.
                    JOptionPane.showMessageDialog(updateSelectedVehicleButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                    Vehicle veh = getVehicle(updateSelectedVehicleButton,"update"); //Generates a vehicle with the information got from text boxes.
                    vehicleList.remove(list1.getSelectedIndex()); //Removes the old vehicle from the list.
                    vehicleList.add(list1.getSelectedIndex(),veh); //Adds the new vehicle into the removed one's index on the list.
                    JOptionPane.showMessageDialog(updateSelectedVehicleButton,"Vehicle have been updated!","Done",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        automobileRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty()) {
                    textField4.setText("4");
                    clearPanels(false,true);
                }
                else
                {
                    clearTextBoxes();
                    textField4.setText("4");
                    clearPanels(false,true);
                    list1.clearSelection();
                }
            }
        });
        bicycleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty()) {
                    textField4.setText("2");
                    clearPanels(false,false);
                }
                else
                {
                    clearTextBoxes();
                    textField4.setText("2");
                    clearPanels(false,false);
                    list1.clearSelection();
                }
            }
        });
        planeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty()) {
                    textField4.setText("3");
                    clearPanels(true,false);
                }
                else
                {
                    clearTextBoxes();
                    textField4.setText("3");
                    clearPanels(true,false);
                    list1.clearSelection();
                }
            }
        });
        hydroplaneRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty()) {
                    textField4.setText("3");
                    clearPanels(true,false);
                }
                else
                {
                    clearTextBoxes();
                    textField4.setText("3");
                    clearPanels(true,false);
                    list1.clearSelection();
                }
            }
        });
        shipRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty()) {
                    textField4.setText("0");
                    clearPanels(false,false);
                }
                else
                {
                    clearTextBoxes();
                    textField4.setText("0");
                    clearPanels(false,false);
                    list1.clearSelection();
                }
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list1.isSelectionEmpty()) return; //Bug fix: An array can't index as -1.
                Vehicle veh = vehicleList.get(list1.getSelectedIndex()); //Gets the selected vehicle as a vehicle.
                //Fills the text boxes.
                textField1.setText(veh.getBrand());
                textField2.setText(String.valueOf(veh.getSpeed()));
                textField3.setText(String.valueOf(veh.getCapacity()));
                textField4.setText(String.valueOf(veh.getWheel()));
                textField5.setText(String.valueOf(veh.getPrice()));
                textField6.setText(String.valueOf(veh.getProductionDate()));
                textField7.setText(veh.getColour());
                //Updates the panels according to the vehicle's class.
                if(veh.toString().contains("Automobile"))
                {
                    clearPanels(false,true);
                    textField8.setText(((Automobile) veh).getFuel());
                    automobileRadioButton.setSelected(true);
                }
                else if(veh.toString().contains("Bicycle"))
                {
                    clearPanels(false,false);
                    bicycleRadioButton.setSelected(true);
                }
                else if(veh.toString().contains("Plane"))
                {
                    clearPanels(true,false);
                    if (((Plane) veh).isFlying())
                        trueRadioButton.setSelected(true);
                    else
                        falseRadioButton.setSelected(true);
                    planeRadioButton.setSelected(true);
                }
                else if(veh.toString().contains("Hydroplane"))
                {
                    clearPanels(true,false);
                    hydroplaneRadioButton.setSelected(true);
                }
                else if(veh.toString().contains("Ship"))
                {
                    clearPanels(false,false);
                    shipRadioButton.setSelected(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        Menu menu = new Menu(); //Create a new menu window.
        menu.setVisible(true); //Set it visible.
        menu.list1.setModel(menu.listModel); //Set the list model to call type.

        vehicleList.add(new Automobile("BMW", 0,4, 300, 2010, "RED","Gasoline"));
        vehicleList.add(new Automobile("MERCEDES", 0,4, 200, 2010, "BLACK","Diesel"));
        vehicleList.add(new Automobile("TOYOTA", 0,4, 100, 2010, "WHITE","LPG"));
        vehicleList.add(new Bicycle("BIANCHI",0,1,30,2003,"YELLOW"));
        vehicleList.add(new Plane("BOEING",10, 200, 3500, 2017, "WHITE",true));

        for (int i = 0; i < vehicleList.toArray().length; i++) {
            menu.updateList((Vehicle) vehicleList.toArray()[i]);
        }
    }

    private void updateList(Vehicle veh)
    {
        /*Adds an element to the list.*/
        listModel.addElement(veh);
    }

    private void clearPanels(boolean flying, boolean fuel)
    {
        /*Toggles toggleable panels with parameters given.*/
        this.flyingTrueFalseCheck.setVisible(flying);
        this.fuelTypeText.setVisible(fuel);
        this.pack();
    }

    private void clearTextBoxes()
    {
        /*Clears all the text boxes except the wheel one.*/
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField3.setText("");
        this.textField5.setText("");
        this.textField6.setText("");
        this.textField7.setText("");
    }

    private Vehicle getVehicle(JButton button, String message)
    {
        /*Gets a new vehicle from text boxes. Handles exceptions and generates error parented to the button given
        as the parameter.*/
        Vehicle veh;
        String brand;
        float speed;
        int capacity;
        int wheel;
        float price;
        int productionDate;
        String colour;
        String fuel="";
        boolean isFlying=true;
        try
        {
            brand = textField1.getText();
            speed = Float.parseFloat(textField2.getText());
            capacity = Integer.parseInt(textField3.getText());
            wheel = Integer.parseInt(textField4.getText());
            price = Float.parseFloat(textField5.getText());
            productionDate = Integer.parseInt(textField6.getText());
            colour = textField7.getText();
            if (fuelTypeText.isVisible())
                fuel = textField8.getText();
            if (flyingTrueFalseCheck.isVisible()) {
                if (trueRadioButton.isSelected())
                    isFlying = true;
                else if (falseRadioButton.isSelected())
                    isFlying = false;
                else
                    throw new Exception("Plane flight is not selected!");
            }
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(button,"Cannot " + message + " vehicle!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(button,"Cannot" + message + "vehicle!\nNo vehicle class selected!","Error",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return veh;
    }
}
