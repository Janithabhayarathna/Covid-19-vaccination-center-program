package Task02_extended;

public class Booth {

    private String patientFirstName;

    public Booth(String patientFirstName) {         //Constructor
        this.patientFirstName = patientFirstName;
    }

    public String getPatientFirstName() {   //To get the patient name

        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {   //To set the patient name

        this.patientFirstName = patientFirstName;
    }

}