package Task02_extended;

public class Patient extends Booth {

    private String patientSurname;
    private String age;
    private String city;
    private String nic;

    public Patient(String patientFirstName,String patientSurname, String age, String city, String nic) {
        super(patientFirstName);
        this.patientSurname = patientSurname;
        this.age = age;
        this.city = city;
        this.nic = nic;

    }

    public String getPatientSurname() {

        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {

        this.patientSurname = patientSurname;
    }

    public String getAge() {

        return age;
    }

    public void setAge(String age) {

        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNic() {

        return nic;
    }

    public void setNic(String nic) {

        this.nic = nic;
    }

}
