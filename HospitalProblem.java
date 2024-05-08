package ControlFlowStatements;

/*Hospital Problem
Design a hospital application that will be used to manage and locate patients in the hospital.
    > Create the following classes and assign attributes:
        - Hospital
            Attributes:
            * List Of Rooms
            * Hospital Name
            * Hospital Address
        - Room
            Attributes:
            * Room Number
            * Floor
            * Room Specialty
            * Room Visitation Hours
        - Bed
            Attributes:
            * Bed Number
            * Bed Type
            * Bed Special Equipment
        - Patient
            Attributes:
            * Name (First & Last)
            * DOB
            * Date Admitted
            * Diagnosis (if available)
    The relationships between classes are as follows:
    A Hospital has many Rooms A room has many beds.
    Each Patient is assigned to a bed.
Requirements:
Set up the hospital layout (this means make up a Hospital with floors rooms and beds)
Provide methods to enter Patient info and assign patient to room
*/
//*******************************************************************************
class Hospital{
    //Attributes
    String hospitalName;
    String hospitalAddress;
    Room[] listOfRooms; //Creates array of Rooms
    //No-arg constructor
    public Hospital(){
        hospitalName = " ";
        hospitalAddress = " ";
    }
    //Parameterized constructor
    public void hospital(String hospitalName,String hospitalAddress, Room[] listOfRooms ){
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.listOfRooms = listOfRooms;
    }
    //Setter methods
    void setHospitalName(String hospitalName){
        this.hospitalName = hospitalName;
    }
    void setHospitalAddress(String hospitalAddress){
        this.hospitalAddress = hospitalAddress;
    }
    void setListOfRooms(Room[] listOfRooms){
        this.listOfRooms = listOfRooms;
    }
    //Getter methods
    String getHospitalName(){
        return hospitalName;
    }
    String getHospitalAddress(){
        return hospitalAddress;
    }
    Room[] getListOfRooms(){
        return listOfRooms;
    } //change the return type to be an array of Rooms
}
class Room {
    //Attributes
    int roomNumber;
    int floor;
    String visitationHours; //to me personally, something like visiting would be better described as a String instead of an int, but I'l leave it up to you
    String roomSpeciality;
    Bed[] beds;//Creates array of beds
    //since the instructions say a room has many beds, you should probably add an array of Bed objects here
    void setBeds(Bed[] beds){
        this.beds = beds;
    }
    //Setter methods
    void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    void setFloor(int floor){
        this.floor = floor;
    }
    void setVisitationHours(String visitationHours){
        this.visitationHours = visitationHours;
    }
    void setRoomSpeciality(String roomSpeciality){
        this.roomSpeciality = roomSpeciality;
    }
    Bed[] getBeds(){
        return beds;
    }
    //Getter methods
    int getRoomNumber(){
        return roomNumber;
    }
    int getFloor(){
        return floor;
    }
    String getVisitationHours(){
        return visitationHours;
    } //see prior note about visitationHours as a  String (up to you though)
    String getRoomSpeciality(){
        return roomSpeciality;
    }
}
class Bed {
    //Attributes
    int bedNumber;
    String bedType;
    String bedSpecialEquipment;
    Patient patient;
    void setPatient(Patient patient){this.patient = patient;}
    void setBedNumber(int bedNumber){
        this.bedNumber = bedNumber;
    }
    void setBedType(String bedType){
        this.bedType = bedType;
    }
    void setBedSpecialEquipment(String bedSpecialEquipment){
        this.bedSpecialEquipment = bedSpecialEquipment;
    }
    Patient getPatient(){ return patient; }
    int getBedNumber(){
        return bedNumber;
    }
    String getBedType(){
        return bedType;
    }
    String getBedSpecialEquipment(){
        return bedSpecialEquipment;
    }
}
class Patient {
    //Attributes
    String fName;
    String lName;
    String dob;
    String dateAdmitted;
    String diagnosis;
    //Setter methods
    void setFname(String fName){
        this.fName = fName;
    }
    void setLname(String lName){
        this.lName = lName;
    }
    void setDOB(String dob){
        this.dob = dob;
    }
    void setDateAdmitted(String dateAdmitted){
        this.dateAdmitted = dateAdmitted;
    }
    void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }
    //Getter methods
    String getDOB(){
        return dob;
    }
    String getDateAdmitted(){
        return dateAdmitted;
    }
    String getFname(){
        return fName;
    } //same as above
    String getLname(){
        return lName;
    }
    String getDiagnosis(){
        return diagnosis;
    }
}
public class HospitalProblem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.setHospitalName("Weenie Hut General");
        hospital.setHospitalAddress("1234 street rd, Atlanta GA, 30304");

        Room[] rooms = new Room[3];
        rooms[0].setRoomNumber(1);
        rooms[0].setFloor(1);
        rooms[0].setVisitationHours("10am - 6pm");
        rooms[0].setRoomSpeciality("Trauma");
        rooms[1].setRoomNumber(2);
        rooms[1].setFloor(2);
        rooms[1].setVisitationHours("10am - 6pm");
        rooms[1].setRoomSpeciality("Allergy");
        rooms[2].setRoomNumber(3);
        rooms[2].setFloor(3);
        rooms[2].setVisitationHours("10am - 6pm");
        rooms[2].setRoomSpeciality("Neurology");
        rooms[3].setRoomNumber(4);
        rooms[3].setFloor(4);
        rooms[3].setVisitationHours("10am - 6pm");
        rooms[3].setRoomSpeciality("Cardiology");

        //calls hospital.setListOfRooms(rooms) after creating rooms;
        hospital.setListOfRooms(rooms);

        Bed bed1 = new Bed();
        bed1.setBedNumber(1);
        bed1.setBedType("Memory Foam");
        bed1.setBedSpecialEquipment("Half Rails");
        Bed bed2 = new Bed();
        bed2.setBedNumber(2);
        bed2.setBedType("Hypo Allergic foam");
        bed2.setBedSpecialEquipment("Bedside Commode");
        Bed bed3 = new Bed();
        bed3.setBedNumber(3);
        bed3.setBedType("Memory Foam");
        bed3.setBedSpecialEquipment("Protective Padding");
        Bed bed4 = new Bed();
        bed4.setBedNumber(4);
        bed4.setBedType("Hypo Allergenic foam");
        bed4.setBedSpecialEquipment("Over bed Table");

        //Creates beds array that assigns beds
        Bed[] beds = new Bed[]{bed1, bed2, bed3, bed4};

        hospital.getListOfRooms()[0].setBeds(beds);
        hospital.getListOfRooms()[1].setBeds(beds);
        hospital.getListOfRooms()[2].setBeds(beds);
        hospital.getListOfRooms()[3].setBeds(beds);

        Patient patient1 = new Patient();
        patient1.setFname("Sandy");
        patient1.setLname("Cheeks");
        patient1.setDOB("May-01-1999");
        patient1.setDateAdmitted("September-12-2022");
        patient1.setDiagnosis("Seizures");
        Patient patient2 = new Patient();
        patient2.setFname("Squidward");
        patient2.setLname("Tentacles");
        patient2.setDOB("May-01-1999");
        patient2.setDateAdmitted("July-23-2022");
        patient2.setDiagnosis("Food poisoning");
        Patient patient3 = new Patient();
        patient3.setFname("Eugene");
        patient3.setLname("Krabs");
        patient3.setDOB("May-01-1999");
        patient3.setDateAdmitted("February-15-2022");
        patient3.setDiagnosis("Heart Attack");
        Patient patient4 = new Patient();
        patient4.setFname("Patrick");
        patient4.setLname("Star");
        patient4.setDOB("May-01-1999");
        patient4.setDateAdmitted("June-16-2022");
        patient4.setDiagnosis("Asphyxiation");

        //Assigns patient to bed
        bed1.setPatient(patient1);
        bed2.setPatient(patient2);
        bed3.setPatient(patient3);
        bed4.setPatient(patient4);
    }
}