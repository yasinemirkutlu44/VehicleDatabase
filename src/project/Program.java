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
            System.out.println("Menu:\n1.Add shit\n2.Remove shit\n3.See shit\n4.Close this fuck");
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
                System.out.println("You shouldn't see this bitch.");
        }
    }
    
}
