package com.cmpt213.tokimon;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args){
        System.out.println("*****************************************\n" +
                "* Welcome to Tokimon Track application! *\n" +
                "*****************************************\n");

        int optNum = displayMainMenu();
        Tokimon[] listOfTokimons = new Tokimon[300];
        int numOfTokimons = 0;

        while(optNum != 6){
            if(optNum == 1){
                displayAllTokis(listOfTokimons, numOfTokimons);
            }
            else if(optNum == 2){
                numOfTokimons++;
                addNewToki(listOfTokimons, numOfTokimons);
            }
            else if(optNum == 3 && numOfTokimons != 0){
                numOfTokimons = deleteToki(listOfTokimons, numOfTokimons);
            }
            else if(optNum == 4){
                alterToki(listOfTokimons, numOfTokimons);
            }
            else if(optNum == 5){
                System.out.println("All Tokimon Objects:");
                for(int i = 1; i <= numOfTokimons; i++){
                    System.out.println(listOfTokimons[i].toString());
                }
            }
            else{
                System.out.println("Given number is out of range. Please try again!");
            }
            optNum = displayMainMenu();
        }

        System.out.println("BYE!");
    }

    public static int displayMainMenu(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("*************\n" +
                "* Main Menu *\n" +
                "*************");
        System.out.println("1. List Tokimons\n" +
                "2. Add a new Tokimon\n" +
                "3. Remove a Tokimon\n" +
                "4. Change Tokimon strength\n" +
                "5. DEBUG: Dump objects (toString)\n" +
                "6. Exit");
        System.out.println("Choose one of the options above by typing a number");

        return myObj.nextInt();
    }

    public static void displayAllTokis(Tokimon[] listOfTokimons, int numOfTokimons){
        System.out.println("*********************\n" +
                "* List of Tokimons: *\n" +
                "*********************\n");

        for(int i = 1; i <= numOfTokimons; i++) {
            String name = listOfTokimons[i].getName();
            String type = listOfTokimons[i].getType();
            float height = listOfTokimons[i].getHeight();
            float weight = listOfTokimons[i].getWeight();
            int strength = listOfTokimons[i].getStrength();

            System.out.println(i + ". " + name + ", " + type + " ability, " + height + "cm, " + weight + "kg, "
                    + strength + " strength");
        }
    }

    public static void addNewToki(Tokimon[] listOfTokimons, int numOfTokimons){
        if(numOfTokimons >= 300){
            System.out.println("You can only save less than 300 Tokimons. Please delete one of your tokimons to add new tokimon!");
            return;
        }
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter Tokimon's name: ");
        String name = myObj.nextLine();
        System.out.println("Enter Tokimon's type:");
        String type = myObj.nextLine();
        System.out.println("Enter Tokimon's height(cm):");
        float height = myObj.nextFloat();
        System.out.println("Enter Tokimon's weight(kg):");
        float weight = myObj.nextFloat();

        Tokimon newToki = new Tokimon(name, type, height, weight);
        listOfTokimons[numOfTokimons] = newToki;
    }

    public static void alterToki(Tokimon[] listOfTokimons, int numOfTokimons){
        Scanner myObj = new Scanner(System.in);
        displayAllTokis(listOfTokimons, numOfTokimons);

        System.out.println("Choose tokimon that you want to increase/decrease strength");
        System.out.println("(Enter 0 to cancel)");
        int number = myObj.nextInt();

        if(number == 0){
            return;
        }

        System.out.println("How much: ");

        int numberOfStrength = myObj.nextInt();
        int currentStrength = listOfTokimons[number].getStrength();
        int newStrength = currentStrength + numberOfStrength;

        if(newStrength <= 0){
            listOfTokimons[number].setStrength(0);
        }
        else if(newStrength >= 100){
            listOfTokimons[number].setStrength(100);
        }
        else{
            listOfTokimons[number].setStrength(newStrength);
        }

        String name = listOfTokimons[number].getName();
        System.out.println(name + " now has strength " + listOfTokimons[number].getStrength() + "!");
    }

    public static int deleteToki(Tokimon[] listOfTokimons, int numOfTokimons){
        Scanner myObj = new Scanner(System.in);
        displayAllTokis(listOfTokimons, numOfTokimons);

        System.out.println("Choose tokimon that you want to delete");
        System.out.println("(Enter 0 to cancel)");
        int removeIndex = myObj.nextInt();

        if(removeIndex == 0){
            return numOfTokimons;
        }
        else if(removeIndex > numOfTokimons || removeIndex < 0){
            System.out.println("Given number is out of range. Please try again!");
            return deleteToki(listOfTokimons, numOfTokimons);
        }

        String name = listOfTokimons[removeIndex].getName();
        for(int i = removeIndex; i <= numOfTokimons ; i++){
            listOfTokimons[i] = listOfTokimons[i+1];
        }
        System.out.println(name + " is deleted");

        numOfTokimons--;
        return numOfTokimons;
    }

}
