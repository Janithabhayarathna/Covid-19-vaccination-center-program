package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.LinkedList;

/**
 SD2 Course Work Task 04 (Linkedlist Version).
 Vaccination Center Program.
 Janith Chanaka Abhayarathna - w1830253 (20200571).
 */

public class VaccinationCenter {

    private static int vaccines = 150;
    //Linked list for waiting list
    static LinkedList<String> linkListAstra = new LinkedList<>();   //Linked list for 'AstraZenica' vaccine
    static LinkedList<String> linkListSino = new LinkedList<>();    //Linked list for 'Sinopharm' vaccine
    static LinkedList<String> linkListPfizer = new LinkedList<>();  //Linked list for 'Pfizer' vaccine

    public static void main(String[] args) {

        Patient[] patients = new Patient[6];    //Creates the object array "patients"

        initialise(patients);  //Calling the method 'initialise' to initialise array patients

        while (true) {      //To loop until, user want to exit('999/EXT')

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
            String function = input.nextLine().toUpperCase();  //Reads the user input and convert to uppercase letters
            System.out.println(" ");

            //Calling the relevant method according to the user input
            switch (function) {

                case "100":
                case "VVB":
                    System.out.println("_ View all Vaccination Booths option _");
                    viewVaccinationBooths(patients);
                    System.out.println(" ");
                    break;
                case "101":
                case "VEB":
                    System.out.println("_ View all Empty Booths option _");
                    viewEmptyBooths(patients);
                    System.out.println(" ");
                    break;
                case "102":
                case "APB":
                    System.out.println("_ Add Patient to a Booth option _");
                    addPatientToBooth(patients);
                    System.out.println(" ");
                    break;
                case "103":
                case "RPB":
                    System.out.println("_ Remove Patient from a Booth option _");
                    removePatientFromBooth(patients);
                    System.out.println(" ");
                    break;
                case "104":
                case "VPS":
                    System.out.println("_ View Patients Sorted in alphabetical order option _");
                    viewPatientsStoredInAlphabetical(patients);
                    System.out.println(" ");
                    break;
                case "105":
                case "SPD":
                    System.out.println("_ Store Program Data into file option _");
                    storeDataIntoFile(patients);
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


    private static void initialise(Patient[] patients) {
        //Method to initialise the booths as empty

        for (int x = 0; x < 6; x++ ) {
            patients[x] = new Patient("empty", "empty",".", ".", ".");
        }
    }


    public static void viewVaccinationBooths(Patient[] patients) {
        //Method to view all the booths

        for (int x = 0; x < 6; x++)
        {
            if (patients[x].getPatientFirstName().equals("empty")) {     //Check whether the booth is empty or not
                System.out.println("Booth " + x + " is empty.");
            }
            else {
                System.out.println("Booth " + x + " is occupied by patient " + patients[x].getPatientFirstName() + " " + patients[x].getPatientSurname());
            }
        }
    }

    public static void viewEmptyBooths(Patient[] patients) {
        //Method to view all empty booths

        for (int i=0; i < patients.length; i++) {
            if (patients[i].getPatientFirstName().equals("empty")) {     //Check whether the booth is empty or not
                System.out.println("Booth number " + i + " is empty.");
            }
        }
        System.out.println(" ");
        System.out.println("Note: If all the booths are occupied nothing will display.");
    }


    public static void addPatientToBooth(Patient[] patients) {
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

            System.out.print("Enter the required vaccine type: ");
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
                            //Selected 'AstraZeneca' as the vaccine

                            //Booth no.0
                            if (patients[0].getPatientFirstName().equals("empty")) {    //Check whether the booth is empty or not
                                patients[0].setPatientFirstName(patientFName);          //Setting the patient's first name
                                patients[0].setPatientSurname(patientSName);            //Setting the patient's surname
                                System.out.print("Enter the patient's age: ");
                                String patientAge = in.next();
                                patients[0].setAge(patientAge);         //Setting the patient's age
                                System.out.print("Enter the patient's living city: ");
                                String patientCity = in.next();
                                patients[0].setCity(patientCity);       //Setting the patient's city
                                System.out.print("Enter the patient's NIC/Passport no.: ");
                                String patientNic = in.next();
                                patients[0].setNic(patientNic);         //Setting the patient's age
                                System.out.println("Patient " + patients[0].getPatientFirstName() + " " + patients[0].getPatientSurname() + " successfully added to the booth number 0" );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;

                                //Booth no.1
                            } else if (patients[1].getPatientFirstName().equals("empty")) {     //Check whether the booth is empty or not
                                patients[1].setPatientFirstName(patientFName);                  //Setting the patient's first name
                                patients[1].setPatientSurname(patientSName);                    //Setting the patient's surname
                                System.out.print("Enter the patient's age: ");
                                String patientAge = in.next();
                                patients[1].setAge(patientAge);     //Setting the patient's age
                                System.out.print("Enter the patient's living city: ");
                                String patientCity = in.next();
                                patients[1].setCity(patientCity);  //Setting the patient's city
                                System.out.print("Enter the patient's NIC/Passport no.: ");
                                String patientNic = in.next();
                                patients[1].setNic(patientNic);     //Setting the patient's NIC/Passport no.
                                System.out.println("Patient " + patients[1].getPatientFirstName() + " " + patients[1].getPatientSurname() + " successfully added to the booth number 1" );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;
                            } else {
                                System.out.println("All the booths which provide 'AstraZeneca' vaccine, are already occupied.");
                                System.out.println("Patient " + patientFName + " " + patientSName + " will directed to the waiting list...");
                                linkListAstra.add(patientFName + " " + patientSName);   //Patient added to the linked list 'linkListAstra'
                                break;
                            }

                        } else if (neededVaccine == 2) {
                            //Selected 'Sinopharm' as the vaccine

                            //Booth no.2
                            if (patients[2].getPatientFirstName().equals("empty")) {        //Check whether the booth is empty or not
                                patients[2].setPatientFirstName(patientFName);              //Setting the patient's first name
                                patients[2].setPatientSurname(patientSName);                //Setting the patient's surname
                                System.out.print("Enter the patient's age: ");
                                String patientAge = in.next();
                                patients[2].setAge(patientAge);     //Setting the patient's age
                                System.out.print("Enter the patient's living city: ");
                                String patientCity = in.next();
                                patients[2].setCity(patientCity);   //Setting the patient's city
                                System.out.print("Enter the patient's NIC/Passport no.: ");
                                String patientNic = in.next();
                                patients[2].setNic(patientNic);     //Setting the patient's NIC/Passport no.
                                System.out.println("Patient " + patients[2].getPatientFirstName() + " " + patients[2].getPatientSurname() + " successfully added to the booth number 2" );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;

                                //Booth no.3
                            } else if (patients[3].getPatientFirstName().equals("empty")) {     //Check whether the booth is empty or not
                                patients[3].setPatientFirstName(patientFName);                  //Setting the patient's first name
                                patients[3].setPatientSurname(patientSName);                    //Setting the patient's surname
                                System.out.print("Enter the patient's age: ");
                                String patientAge = in.next();
                                patients[3].setAge(patientAge);      //Setting the patient's age
                                System.out.print("Enter the patient's living city: ");
                                String patientCity = in.next();
                                patients[3].setCity(patientCity);    //Setting the patient's city
                                System.out.print("Enter the patient's NIC/Passport no.: ");
                                String patientNic = in.next();
                                patients[3].setNic(patientNic);      //Setting the patient's NIC/Passport no.
                                System.out.println("Patient " + patients[3].getPatientFirstName() + " " + patients[3].getPatientSurname() + " successfully added to the booth number 3" );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;

                            } else {
                                System.out.println("All the booths which provide 'Sinopharm' vaccine, are already occupied.");
                                System.out.println("Patient " + patientFName + " " + patientSName + " will directed to the waiting list...");
                                linkListSino.add(patientFName + " " + patientSName);    //Patient added to the linked list 'linkListSino'
                                break;
                            }

                        } else if (neededVaccine == 3) {
                            //Selected 'Pfizer' as the vaccine

                            //Booth no.4
                            if (patients[4].getPatientFirstName().equals("empty")) {        //Check whether the booth is empty or not
                                patients[4].setPatientFirstName(patientFName);              //Setting the patient's first name
                                patients[4].setPatientSurname(patientSName);                //Setting the patient's surname
                                System.out.print("Enter the patient's age: ");
                                String patientAge = in.next();
                                patients[4].setAge(patientAge);     //Setting the patient's age
                                System.out.print("Enter the patient's living city: ");
                                String patientCity = in.next();
                                patients[4].setCity(patientCity);   //Setting the patient's city
                                System.out.print("Enter the patient's NIC/Passport no.: ");
                                String patientNic = in.next();
                                patients[4].setNic(patientNic);      //Setting the patient's NIC/Passport no.
                                System.out.println("Patient " + patients[4].getPatientFirstName() + " " + patients[4].getPatientSurname() + " successfully added to the booth number 4" );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;

                                //Booth no.5
                            } else if (patients[5].getPatientFirstName().equals("empty")) {     //Check whether the booth is empty or not
                                patients[5].setPatientFirstName(patientFName);                  //Setting the patient's first name
                                patients[5].setPatientSurname(patientSName);                    //Setting the patient's surname
                                System.out.print("Enter the patient's age: ");
                                String patientAge = in.next();
                                patients[5].setAge(patientAge);      //Setting the patient's age
                                System.out.print("Enter the patient's living city: ");
                                String patientCity = in.next();
                                patients[5].setCity(patientCity);    //Setting the patient's city
                                System.out.print("Enter the patient's NIC/Passport no.: ");
                                String patientNic = in.next();
                                patients[5].setNic(patientNic);     //Setting the patient's NIC/Passport no.
                                System.out.println("Patient " + patients[5].getPatientFirstName() + " " + patients[5].getPatientSurname() + " successfully added to the booth number 5" );
                                vaccines--;
                                lowStockWarning(vaccines);
                                break;

                            } else {
                                System.out.println("All the booths which provide 'Pfizer' vaccine, are already occupied.");
                                System.out.println("Patient " + patientFName + " " + patientSName + " will directed to the waiting list...");
                                linkListPfizer.add(patientFName + " " + patientSName);  //Patient added to the linked list 'linkListPfizer'
                                break;
                            }
                        }
                    } else {
                        System.out.println("Please enter patient's name correctly.");
                    }
                }else{
                    System.out.println("Please check your input! (Input should be between 0-4. Refer the above Vaccine Menu.)");
                    break;
                }
            }else {
                System.out.println("Please check the input! (Input should be an integer - Refer the above Vaccine Menu).");
                question = "YES";
                continue;
            }
        }
    }

    public static void removePatientFromBooth(Patient[] patients) {
        //Method to remove a patient

        String question = "YES";
        while (question.equals("YES")) {
            Scanner input = new Scanner(System.in);      //Creates an object to the Scanner class
            System.out.print("Enter the booth number of the removed patient: ");
            if (input.hasNextInt()) {      //Check the data type of user input
                int boothNum = input.nextInt();
                if ((boothNum>=0) && (boothNum<6)) {    //Check the range of user input
                    if ((boothNum==0) || (boothNum==1)) {
                        if (!(patients[boothNum].getPatientFirstName().equals("empty"))) {
                            System.out.println("Patient " + patients[boothNum].getPatientFirstName() + " removed from the booth " + boothNum);
                            patients[boothNum].setPatientFirstName(linkListAstra.getFirst());
                            System.out.println("Patient " + linkListAstra.getFirst() + " successfully added to the booth number " + boothNum);
                            linkListAstra.remove(0);
                            if (linkListAstra.isEmpty()) {
                                linkListAstra.add("empty");
                                break;
                            }
                        break;
                        }
                        else {
                            System.out.println("Booth number, " + boothNum + " is already empty.");
                            System.out.println("Enter only an occupied booth number to remove a patient.");
                            break;
                        }
                    }
                    else if ((boothNum==2) || (boothNum==3)) {
                        if (!(patients[boothNum].getPatientFirstName().equals("empty"))) {
                            System.out.println("Patient " + patients[boothNum].getPatientFirstName() + " removed from the booth " + boothNum);
                            patients[boothNum].setPatientFirstName(linkListSino.getFirst());
                            System.out.println("Patient " + linkListSino.getFirst() + " successfully added to the booth number " + boothNum);
                            linkListSino.remove(0);
                            if (linkListSino.isEmpty()) {
                                linkListAstra.add("empty");
                                break;
                            }
                        break;
                        }
                        else {
                            System.out.println("Booth number, " + boothNum + " is already empty.");
                            System.out.println("Enter only an occupied booth number to remove a patient.");
                            break;
                        }
                    }
                    else if ((boothNum==4) || (boothNum==5)) {
                        if (!(patients[boothNum].getPatientFirstName().equals("empty"))) {
                            System.out.println("Patient " + patients[boothNum].getPatientFirstName() + " removed from the booth " + boothNum);
                            patients[boothNum].setPatientFirstName(linkListPfizer.getFirst());
                            System.out.println("Patient " + linkListPfizer.getFirst() + " successfully added to the booth number " + boothNum);
                            linkListPfizer.remove(0);
                            if (linkListPfizer.isEmpty()) {
                                linkListAstra.add("empty");
                                break;
                            }
                            break;
                        }
                        else {
                            System.out.println("Booth number, " + boothNum + " is already empty.");
                            System.out.println("Enter only an occupied booth number to remove a patient.");
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Please check the input! (Input should not be between 0-6)");
                }
            }
            else {
                System.out.println("Please check the input and try again! (Input should be an integer).");
                question = "YES";
                continue;
            }
        }
    }


    public static void viewPatientsStoredInAlphabetical(Patient[] patients) {
        //Method to view the patient's name in alphabetical order
        //Referenced from: https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-alphabetical-order

        String[] alphabeticalOrder = new String[6];     //Creates an array called 'alphabeticalOrder'
        for (int y=0; y<patients.length; y++) {
            alphabeticalOrder[y] = patients[y].getPatientFirstName();   //Getting values from the 'vaccinationCenter' array and passing them to the 'alphabeticalOrder' array
        }
        for(int a=0; a<(alphabeticalOrder.length-1); a++)
        {
            for(int b=a+1; b<alphabeticalOrder.length; b++)
            {
                if((alphabeticalOrder[a].toLowerCase(Locale.ROOT)).compareTo(alphabeticalOrder[b].toLowerCase(Locale.ROOT))> 0)  //Comparing elements
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


    public static void storeDataIntoFile(Patient[] patients) {
        //Method to store program data into the file
        //Referenced from: https://www.w3schools.com/java/java_files_create.asp

        try {
            FileWriter writer = new FileWriter("DetailsOfVaccination");  //Construct a FileWriter to object 'writer'
            writer.write("Vaccination booth info - " + (patients));    //Write the patients array
            writer.write("\n Number of remaining vaccines = " + vaccines);   //Write the the count of remaining vaccines in the stock
            writer.close();   //Closing the file
            System.out.println("Successfully stored data into the file.");
        }
        catch (IOException e) {      //Runs if there was an error in file
            System.out.println("An error occurred while storing data into the file. Please try again.");
            e.printStackTrace();    //Tool used to handle exceptions and errors (gives the line number and class name where exception happened)
        }
    }


    public static void loadProgramData() {
        //Method to read the data stored in the file
        //Referenced from: https://www.w3schools.com/java/java_files_create.asp

        try {
            File f = new File("detailsOfVaccination");    //Accessing the file
            Scanner read = new Scanner(f);
            while (read.hasNextLine()) {     //Print data in the file line by line
                String data = read.nextLine();
                System.out.println(data);
            }
            read.close();
        }
        catch (FileNotFoundException e) {   //Runs if there was an error
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
        if (input.hasNextInt()) {      //Check the data type of user input
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
