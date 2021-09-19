package sample;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
    SD2 Course Work Task 01 (Array Version).
    Vaccination Center Program.
    Janith Chanaka Abhayarathna - w1830253 (20200571).
 */

public class Task1 {

    private static String[] vaccinationCenter = new String[6];   //Creates the array called 'vaccinationCenter'
    private static int vaccines = 150;   // Basic number of vaccines per day

    public static void main(String[] args) {

        initialise(vaccinationCenter);      //Calling the method 'initialise' to initialise array 'vaccinationCenter'

        while (true) {         //To loop until, user want to exit('999/EXT')

            //Option menu
            System.out.println(" ");
            System.out.println("--------------------------------------------------------");
            System.out.println(".............. Covid 19 Vaccination Center .............");
            System.out.println("--------------------------------------------------------");
            System.out.println("********************* Menu Option **********************");
            System.out.println(" ");
            System.out.println("100 or VVB: View all Vaccination Booths.");
            System.out.println("101 or VEB: View all Empty Booths.");
            System.out.println("102 or APB: Add Patient to a Booth.");
            System.out.println("103 or RPB: Remove Patient from a Booth.");
            System.out.println("104 or VPS: View Patients Sorted in alphabetical order.");
            System.out.println("105 or SPD: Store Program Data into file.");
            System.out.println("106 or LPD: Load Program Data from file.");
            System.out.println("107 or VRV: View Remaining Vaccinations.");
            System.out.println("108 or AVS: Add Vaccinations to the Stock.");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println("--------------------------------------------------------");
            System.out.println(" ");

            //Getting the option code that user wants to run
            Scanner input = new Scanner(System.in);     //Creates an object to the Scanner class
            System.out.print("Enter the option you want: ");
            String function = input.nextLine().toUpperCase();     //Reads the user input and convert to uppercase letters
            System.out.println(" ");

            //Calling the relevant method according to the user input
            switch (function) {

                case "100":
                case "VVB":
                    System.out.println("_ View all Vaccination Booths option _");
                    viewVaccinationBooths();
                    System.out.println(" ");
                    break;
                case "101":
                case "VEB":
                    System.out.println("_ View all Empty Booths option _");
                    viewEmptyBooths();
                    System.out.println(" ");
                    break;
                case "102":
                case "APB":
                    System.out.println("_ Add Patient to a Booth option _");
                    addPatientToBooth();
                    System.out.println(" ");
                    break;
                case "103":
                case "RPB":
                    System.out.println("_ Remove Patient from a Booth option _");
                    removePatientFromBooth();
                    System.out.println(" ");
                    break;
                case "104":
                case "VPS":
                    System.out.println("_ View Patients Sorted in alphabetical order option _");
                    viewPatientsStoredInAlphabetical();
                    System.out.println(" ");
                    break;
                case "105":
                case "SPD":
                    System.out.println("_ Store Program Data into file option _");
                    storeDataIntoFile();
                    System.out.println(" ");
                    break;
                case "106":
                case "LPD":
                    System.out.println("_ Load Program Data from File option _");
                    loadProgramData();
                    System.out.println(" ");
                    break;
                case "107":
                case "VRV":
                    System.out.println("_ View Remaining Vaccinations option _");
                    viewRemainingVaccinations();
                    System.out.println(" ");
                    break;
                case "108":
                case "AVS":
                    System.out.println("_ Add Vaccinations to the Stock option _");
                    addVaccinationsToStock();
                    System.out.println(" ");
                    break;
                case "999":
                case "EXT":
                    exitProgram();
                    break;

                default:
                    System.out.println("Please check your input again! Refer the above option menu.");  //If user entered a wrong value this block will run
            }
        }
    }

    private static void initialise( String booth[] ) {
        //Method to initialise the booths as empty

        for (int x = 0; x < 6; x++ ) {      //Assigning  all the 6 booths as "empty"
            booth[x] = "empty";
        }
    }


    public static void viewVaccinationBooths() {
        //Method to view all the booths

        for (int x = 0; x < 6; x++)
        {
            if (vaccinationCenter[x].equals("empty")) {                //Check whether the booth is empty or not
                System.out.println("Booth " + x + " is empty.");
            }
            else {
                System.out.println("Booth " + x + " is occupied by " + vaccinationCenter[x]);
            }
        }
    }


    public static void viewEmptyBooths() {
        //Method to view all the empty booths

        for (int i=0; i < vaccinationCenter.length; i++) {
            if (vaccinationCenter[i].equals("empty")) {
                System.out.println("Booth number " + i + " is empty.");      //Check whether the booth is empty or not
            }
        }
        System.out.println(" ");
        System.out.println("Note: If all the booths are occupied nothing will display.");
    }


    public static void addPatientToBooth() {
        //Method to add patients to a booth

        String question = "YES";
        while (question.equals("YES")) {
            Scanner in = new Scanner(System.in);      //Creates an object to the Scanner class
            System.out.print("Enter the booth number (0-6): ");
            if (in.hasNextInt()) {       //Check the data type of user input
                int boothNum = in.nextInt();
                if ((boothNum >= 0) && (boothNum < 6)) {      //Check the range of user input
                    if (vaccinationCenter[boothNum].equals("empty")) {    //Check whether the booth is empty or not
                        System.out.print("Enter patient's name for booth number " + boothNum + ": ");
                        if (in.hasNext()) {                        //Check the data type of user input
                            String patientName = in.next();
                            vaccinationCenter[boothNum] = patientName;      //Assigning the patient to the given booth number
                            System.out.println("Patient " + patientName + " successfully added to the booth number " + boothNum);
                            vaccines -= 1;

                            //Warning for low stock
                            if (vaccines <= 20) {
                                System.out.println("Warning! Only " + vaccines + " more vaccines are available at the stock.");
                            }
                        }
                        else {
                            System.out.println("Please enter a name!");
                        }
                        System.out.println(" ");
                        //Asking whether user need to continue with the same option or not
                        System.out.print("Do you want to add more patients (YES/NO-input any value) : ");
                        if (in.hasNext()) {
                            question = in.next().toUpperCase();  //Asking whether to continue or not
                        } else {
                            System.out.println("Sorry, invalid input!");
                            question = "NO";
                        }
                    }
                    else {
                        System.out.println("Patient " + vaccinationCenter[boothNum] + " is already in the booth number, " + boothNum);
                        System.out.println("Please remove a patient by option (103/RPB) before adding another patient to the same booth.");
                        break;
                    }
                }
                else {
                    System.out.println("Please check the booth number! (Input should be between 0-6).");
                }
            }
            else {
                System.out.println("Please check the booth number! (Input should be an integer).");
                question = "YES";
                continue;
            }
        }
    }


    public static void removePatientFromBooth() {
        //Method to remove a patient

        String question = "YES";
        while (question.equals("YES")) {
            Scanner input = new Scanner(System.in);     //Creates an object to the Scanner class
            System.out.print("Enter the booth number of the removed patient: ");
            if (input.hasNextInt()) {                   //Check the data type of user input
                int boothNum = input.nextInt();
                if ((boothNum>=0) && (boothNum<6)) {    //Check the range of user input
                    if (!(vaccinationCenter[boothNum].equals("empty"))) {
                        System.out.println("Patient " + vaccinationCenter[boothNum] + " removed from the booth " + boothNum);
                        vaccinationCenter[boothNum] = "empty";  //Assigning the removed patient's booth as empty
                        //Asking whether user need to continue with the same option or not
                        System.out.print("Do you want to remove more patients? (YES/NO): ");
                        Scanner input1 = new Scanner(System.in);
                        if (input1.hasNext()) {          //Check the data type of user input
                            question = input.next().toUpperCase();
                        } else {
                            System.out.println("Sorry invalid input!");
                            question = "NO";
                        }
                    }
                    else {
                        System.out.println("Booth number, " + boothNum + " is already empty.");
                        System.out.println("Enter only an occupied booth number to remove a patient.");
                        break;
                    }
                }
                else {
                    System.out.println("Please check the input! (Input should be between 0-6)");
                }
            }
            else {
                System.out.println("Please check the input and try again! (Input should be an integer).");
                question = "YES";
                continue;
            }
        }
    }


    public static void viewPatientsStoredInAlphabetical() {
        //Method to view the patient's name in alphabetical order
        //Referenced from: https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-alphabetical-order

        String[] alphabeticalOrder = new String[6];     //Creates an array called 'alphabeticalOrder'
        for (int y=0; y<vaccinationCenter.length; y++) {
            alphabeticalOrder[y] = vaccinationCenter[y];   //Getting values from the 'vaccinationCenter' array and passing them to the 'alphabeticalOrder' array
        }
        for(int a=0; a<(alphabeticalOrder.length-1); a++)
        {
            for(int b=a+1; b<alphabeticalOrder.length; b++)
            {
                if((alphabeticalOrder[a].toLowerCase(Locale.ROOT)).compareTo(alphabeticalOrder[b].toLowerCase(Locale.ROOT))> 0)
                {
                    String temp = alphabeticalOrder[a];
                    alphabeticalOrder[a] = alphabeticalOrder[b];
                    alphabeticalOrder[b] = temp;
                    //Sorted elements of the array to alphabetical order
                }
            }
        }
        System.out.println(Arrays.toString(alphabeticalOrder));   //Displaying the sorted array
    }


    public static void storeDataIntoFile() {
        //Method to store program data into the file
        //Referenced from: https://www.w3schools.com/java/java_files_create.asp

        try {
            FileWriter writer = new FileWriter("DetailsOfVaccination");     //Creating the file "DetailsOfVaccination"
            writer.write("Vaccination booth info - " + Arrays.toString(vaccinationCenter));  //Write the patients information
            writer.write("\n Number of remaining vaccines = " + vaccines);    //Write the number of remaining vaccines in the stock
            writer.close();
            System.out.println("Successfully stored data into the file.");
        }
        catch (IOException e) {     //Runs if there was an error in file creating or writing
            System.out.println("An error occurred while storing data into the file. Please try again.");
            e.printStackTrace();    //Tool used to handle exceptions and errors (gives the line number and class name where exception happened)
        }
    }


    public static void loadProgramData() {
        //Method to read the data stored in the file
        //Referenced from: https://www.w3schools.com/java/java_files_create.asp

        try {
            File f = new File("DetailsOfVaccination");  //Accessing the file
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {    //Print data in the file line by line
                String data = read.nextLine();  //Assigning the data in the file line by line to the variable "data"
                System.out.println(data);
            }
            read.close();   //Closing the opened file
        }
        catch (FileNotFoundException e) {    //Runs if there was an error while reading the file
            System.out.println("An error occurred while reading data from the file.");
            e.printStackTrace();    //Tool used to handle exceptions and errors (gives the line number and class name where exception happened)
        }
    }


    public static void viewRemainingVaccinations() {
        //Method to view remaining vaccines in the stock

        System.out.println("Number of remaining vaccinations - " + vaccines);
    }


    public static void addVaccinationsToStock() {
        //Method to add vaccines to the stock

        if (vaccines<=150) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number of vaccinations which adding to the stock: ");
            if (input.hasNextInt()) {               //Check the data type of user input
                int newVaccines = input.nextInt();
                vaccines = vaccines + newVaccines;  //Adding the number of newly added vaccines to the stock
                System.out.println(newVaccines + ", new vaccines has been added to the stock.");
            } else {
                System.out.println("Please check your input again! Input should be an integer.");
            }
        }
        else {
            System.out.println("You can't add more vaccines as the stock if full.");
        }
    }


    public static void exitProgram() {
        //Method to exit from the program

        System.out.println("Thank you for using 'Covid 19 Vaccination Center Program'. \n                  Stay safe!");
        System.exit(0);
    }

}

