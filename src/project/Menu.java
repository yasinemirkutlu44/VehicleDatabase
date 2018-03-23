package project;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;

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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(JPanel1);
        this.setSize(500, 500);
        flyingTrueFalseCheck.setVisible(false);
        fuelTypeText.setVisible(false);
        this.pack();
        this.setLocationRelativeTo(null);
        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (VehicleClasses.isSelected(null))
                    JOptionPane.showMessageDialog(addVehicleButton,"No class selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
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
                        JOptionPane.showMessageDialog(addVehicleButton,"Cannot create class!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
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
                        JOptionPane.showMessageDialog(addVehicleButton,"Cannot create class!\nNo radio button selected!","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    vehicleList.add(veh);
                    updateList(veh);
                    list1.setSelectedIndex(veh.getGeneralID()+1);
                    JOptionPane.showMessageDialog(addVehicleButton,"Vehicle have been added!","Done",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        updateSelectedVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.isSelectionEmpty())
                    JOptionPane.showMessageDialog(updateSelectedVehicleButton,"No vehicle selected!","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
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
                        JOptionPane.showMessageDialog(addVehicleButton,"Cannot create class!\n" + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        return;
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
                        JOptionPane.showMessageDialog(addVehicleButton,"Cannot create class!\nNo radio button selected!","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    vehicleList.remove(list1.getSelectedIndex());
                    vehicleList.add(list1.getSelectedIndex(),veh);
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
                else if (!automobileRadioButton.isSelected())
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
                else if (!bicycleRadioButton.isSelected())
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
                else if (!planeRadioButton.isSelected())
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
                else if (!hydroplaneRadioButton.isSelected())
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
                    System.out.println("Selection is empty.");
                    textField4.setText("0");
                    clearPanels(false,false);
                }
                else
                {
                    clearTextBoxes();
                    textField4.setText("0");
                    clearPanels(false,false);
                    list1.setSelectedIndex(-1);
                }
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Vehicle veh = vehicleList.get(list1.getSelectedIndex());
                textField1.setText(veh.getBrand());
                textField2.setText(String.valueOf(veh.getSpeed()));
                textField3.setText(String.valueOf(veh.getCapacity()));
                textField4.setText(String.valueOf(veh.getWheel()));
                textField5.setText(String.valueOf(veh.getPrice()));
                textField6.setText(String.valueOf(veh.getProductionDate()));
                textField7.setText(veh.getColour());


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
        Menu menu = new Menu();
        menu.setVisible(true);
        vehicleList.add(new Automobile("BMW", 0,4, 300, 2010, "RED","Gasoline"));
        vehicleList.add(new Automobile("MERCEDES", 0,4, 200, 2010, "BLACK","Diesel"));
        vehicleList.add(new Automobile("TOYOTA", 0,4, 100, 2010, "WHITE","LPG"));
        vehicleList.add(new Bicycle("BIANCHI",0,1,30,2003,"YELLOW"));
        vehicleList.add(new Plane("BOEING",10, 200, 3500, 2017, "WHITE",true));
        menu.list1.setModel(menu.listModel);
        for (int i = 0; i < vehicleList.toArray().length; i++) {
            menu.updateList((Vehicle) vehicleList.toArray()[i]);
        }
    }

    private void updateList(Vehicle veh)
    {
        listModel.addElement(veh);
    }

    private void clearPanels(boolean flying, boolean fuel){
        this.flyingTrueFalseCheck.setVisible(flying);
        this.fuelTypeText.setVisible(fuel);

        this.pack();
    }

    private void clearTextBoxes()
    {
        this.textField1.setText("");
        this.textField2.setText("");
        this.textField3.setText("");
        this.textField5.setText("");
        this.textField6.setText("");
        this.textField7.setText("");
    }
}
