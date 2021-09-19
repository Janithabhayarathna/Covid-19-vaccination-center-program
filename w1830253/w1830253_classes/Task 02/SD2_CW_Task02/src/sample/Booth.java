package sample;

public class Booth {

    private String patientName;
    private int boothNumber;


    public Booth(String patientName, int boothNumber) {         //Constructor

        this.patientName = patientName;
        this.boothNumber = boothNumber;
    }

    public String getPatientName() {   //To get the patient name

        return patientName;
    }


    public void setPatientName(String patientName) {   //To set the patient name

        this.patientName = patientName;
    }

}
