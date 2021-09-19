package Task01_extended;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 SD2 Course Work Task 03(Extended version of task 01).
 Vaccination Center Program.
 Janith Chanaka Abhayarathna - w1830253 (20200571).
 */

public class Task01_Extended {

    private static String firstName[] = new String[6];           //Creates the array called 'firstName'
    private static String surname[] = new String[6];             //Creates the array called 'surname'
    private static int vaccines = 150;

    public static void main(String[] args) {

        initialise(firstName);         //Calling the method 'initialise' to initialise array 'firstName'
        initialise(surname);          //Calling the method 'initialise' to initialise array 'surname'

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
            String function = input.nextLine().toUpperCase();   //Reads the user input and convert to uppercase letters and assigned to variable 'function'
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
                    System.out.println("Please check your input again! Refer the above option menu.");
            }
        }
    }


    private static void initialise( String booth[] ) {
        //Method to initialise the first and last names of patients as empty

        for (int x = 0; x < 6; x++ ) {  //Assigning  all the 6 booths as "empty"
            booth[x] = "empty";
        }
    }


    public static void viewVaccinationBooths() {
        //Method to view all the booths

        for (int x = 0; x < 6; x++)
        {
            if (firstName[x].equals("empty")) {                //Check whether the booth is empty or not
                System.out.println("Booth " + x + " is empty.");
            }
            else {
                System.out.println("Booth " + x + " is occupied by " + firstName[x] + " " + surname[x]);
            }
        }
    }


    public static void viewEmptyBooths() {
        //Method to view all the empty booths

        for (int i=0; i < firstName.length; i++) {
            if (firstName[i].equals("empty")) {
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

            //Vaccine Menu
            System.out.println(" ");
            System.out.println(".................... Vaccine Menu ...............");
            System.out.println(" 1 : AstraZeneca ");
            System.out.println(" 2 : Sinopharm ");
            System.out.println(" 3 : Pfizer ");
            System.out.println("-------------------------------------------------");

            Scanner in = new Scanner(System.in);      //Creates an object to the Scanner class

            System.out.print("Enter the required vaccine number: ");
            if (in.hasNextInt()) {       //Check the data type of user input
                int neededVaccine = in.nextInt();   //Getting the needed vaccine type
                if ((neededVaccine>0) && (neededVaccine<4)) {   //Check the range of input data
                    System.out.print("Enter the patient's first name: ");
                    if (in.hasNext()) {                        //Check the data type of user input
                        String patientFName = in.next();       //Getting patient's first name
                        System.out.print("Enter the patients surname: ");
                        String patientSName = in.next();       //Getting the patient's surname
                        //Assigning the patient to the relevant booth
                        if (neededVaccine == 1) {
                            if (firstName[0].equals("empty")) {
                                firstName[0] = patientFName;
                                surname[0] = patientSName;
                                System.out.println("Patient " + firstName[0] + " " + surname[0] + " successfully added to the booth number 0." );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else if (firstName[1].equals("empty")) {
                                firstName[1] = patientFName;
                                surname[1] = patientSName;
                                System.out.println("Patient " + firstName[1] + " " + surname[1] + " successfully added to the booth number 1." );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else {
                                System.out.println("sorry! All the booths which provide 'AstraZeneca' vaccine, are already occupied.");
                                break;
                            }
                        } else if (neededVaccine == 2) {
                            if (firstName[2].equals("empty")) {
                                firstName[2] = patientFName;
                                surname[2] = patientSName;
                                System.out.println("Patient " + firstName[2] + " " + surname[2] + " successfully added to the booth number 2." );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else if (firstName[3].equals("empty")) {
                                firstName[3] = patientFName;
                                surname[3] = patientSName;
                                System.out.println("Patient " + firstName[3] + " " + surname[3] + " successfully added to the booth number 3." );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else {
                                System.out.println("sorry! All the booths which provide 'Sinopharm' vaccine, are already occupied.");
                                break;
                            }
                        } else if (neededVaccine == 3) {
                            if (firstName[4].equals("empty")) {
                                firstName[4] = patientFName;
                                surname[4] = patientSName;
                                System.out.println("Patient " + firstName[4] + " " + surname[4] + " successfully added to the booth number 4." );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else if (firstName[5].equals("empty")) {
                                firstName[5] = patientFName;
                                surname[5] = patientSName;
                                System.out.println("Patient " + firstName[5] + " " + surname[5] + " successfully added to the booth number 5." );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else {
                                System.out.println("sorry! All the booths which provide 'Pfizer' vaccine, are already occupied.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Please enter patient's name correctly.");
                    }
                }else{
                    System.out.println("Please check your input! (Input should be between 0-4. Refer the above Vaccine Menu.)");
                }
            }else {
                System.out.println("Please check the input! (Input should be an integer - Refer the above Vaccine Menu).");
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
                    if (!(firstName[boothNum].equals("empty"))) {
                        System.out.println("Patient " + firstName[boothNum] + " " + surname[boothNum] + " removed from the booth " + boothNum);
                        firstName[boothNum] = "empty";
                        surname[boothNum] = "empty";
                        break;
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
        for (int y=0; y<firstName.length; y++) {
            alphabeticalOrder[y] = firstName[y];   //Getting values from the 'vaccinationCenter' array and passing them to the 'alphabeticalOrder' array
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
        System.out.println(Arrays.toString(alphabeticalOrder));
    }


    public static void storeDataIntoFile() {
        //Method to store program data into the file
        //Referenced from: https://www.w3schools.com/java/java_files_create.asp

        try {
            FileWriter writer = new FileWriter("DetailsOfVaccination.txt.txt");
            writer.write("Vaccination booth info - First names-" + Arrays.toString(firstName));  //Write the patients first name
            writer.write("\n Patient's surnames - " + Arrays.toString(surname));        //Write the patients surname
            writer.write("\n Number of remaining vaccines = " + vaccines);           //Write the remaining of vaccines in stock
            writer.close();
            System.out.println("Successfully stored data into the file.");
        }
        catch (IOException e) {     //Runs if there was an error in file
            System.out.println("An error occurred while storing data into the file. Please try again.");
            e.printStackTrace();    //Tool used to handle exceptions and errors (gives the line number and class name where exception happened)
        }
    }


    public static void loadProgramData() {
        //Method to read the data stored in the file
        //Referenced from: https://www.w3schools.com/java/java_files_create.asp

        try {
            File f = new File("DetailsOfVaccination.txt.txt");  //Accessing the file
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {    //Print data in the file line by line
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        }
        catch (FileNotFoundException e) {    //Runs if there was an error
            System.out.println("An error occurred while reading data from the file.");
            e.printStackTrace();
        }
    }


    public static void viewRemainingVaccinations() {
        //Method to view remaining vaccines in the stock

        System.out.println("Number of remaining vaccinations - " + vaccines);
    }


    public static void addVaccinationsToStock() {
        //Method to add vaccines to the stock

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of vaccinations which adding to the stock: ");
        if (input.hasNextInt()) {               //Check the data type of user input
            int newVaccines = input.nextInt();
            vaccines = vaccines + newVaccines;
            System.out.println(newVaccines + ", new vaccines has been added to the stock.");
        }
        else {
            System.out.println("Please check your input again! Input should be an integer.");
        }
    }


    public static void exitProgram() {
        //Method to exit from the program

        System.out.println("Thank you for using 'Covid 19 Vaccination Center Program'. \n                  Stay safe!");
        System.exit(0);
    }

    public static void lowStockWarning(int vaccines) {
        //Method to display 'low stock on vaccines' warning message

        if (vaccines <= 20) {
            System.out.println("Warning! only " + vaccines + " more vaccines are available at the stock.");
        }
    }
}
