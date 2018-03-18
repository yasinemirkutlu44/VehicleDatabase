package project;

import java.util.*;
//test

public class Program {

    static LinkedList<Vehicle> vehicles = new LinkedList<>();
    
    public static void main(String[] args) {
        boolean menu = true;
        Scanner input = new Scanner(System.in);
        while(menu)
        {
            int choice;
            System.out.println("Menu:\n1.Veri Girişinde Bulun\n2.Veri Listele\n3.Veri Güncelle\n4.Cıkış\nSecim:");
            try
            {
                choice = input.nextInt();
            }
            catch (Exception e)
            {
                continue;
            }
            if (choice == 1)
            {
                //get input from user
                //create an object with the input
                Automobile a = new Automobile("brand",3,3f,1992,"red");
                vehicles.addLast(a);
            }
            else if (choice == 2)
            {

            }
            else if (choice == 3)
            {

            }
            else if (choice == 4)
            {
                menu = false;
            }
            else
                System.out.println("Gecersiz bir deger girdiniz.Lütfen dogru bir deger giriniz.");
        }
    }
    
}
