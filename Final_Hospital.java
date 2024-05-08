package hello;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
//*************************************************************************************************
/* Java 2: Final Hospital
    Provide method to show all patients on a floor
    Provide method to show all available beds
    Provide method to print a report showing each room occupancy
    Provide method to print a report showing all patients per room sorted by admission date
    Add a medical provider (Doctor) class. The Doctor and the Patient must be children of Person.
    A doctor may be assigned to multiple patients across many rooms.
    A Patient may be treated by many doctors.
    Provide a method to display all patients for a doctor.
    Provide a method to print a patients per doctor report
    Provide a report showing a list of rooms where are patients for a specific doctor,
    order the rooms by room number or number of patients treated by the doctor
*/
//************************************************************************************************
//Class to represent a Person
class Persons {
    //VARIABLES
    String name;
    String address;
    String dateOfBirth;

    //No-arg constructor
    Persons(){}
    //Default constructor
    Persons(String name, String address, String dateOfBirth) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
    //GETTER & SETTERS
    //Getters and Setters for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Getter and Setters for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //Getter and Setters for dateOfBirth
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
//**********************************************************************************************************************
//Class to represent a Patient
class Patient extends Persons {
    List<Doctor> doctors = new ArrayList<>();
    String roomNumber;
    String admissionDate;
    String diagnosis;
    //No-arg constructor
    Patient(){}
    //Default constructor for Patient
    Patient(String name, String address, String dateOfBirth, List<Doctor> doctors, String roomNumber, String admissionDate) {
        super(name, address, dateOfBirth);
        this.doctors = doctors;
        this.roomNumber = roomNumber;
        this.admissionDate = admissionDate;
    }
    //GETTER & SETTERS
    //Getters and Setters for doctors
    public List getDoctors() {
        return doctors;
    }
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    //Getter and Setters for roomNumber
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    //Getter and Setters for admissionDate
    public String getAdmissionDate() {
        return admissionDate;
    }
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    //Getter and setters for diagnosis
    public String getDiagnosis() {return diagnosis;}
    public void setDiagnosis(String diagnosis){this.diagnosis = diagnosis;}
//================================================================================================

    //Method to add Doctor to patient
    public void addDoctor(Doctor doctor) {doctors.add(doctor);}
}
//**********************************************************************************************************************
//Class to represent a Doctor
class Doctor extends Persons {
    //VARIABLES
    String specialty;
    List<Patient> patients = new ArrayList<>();//Array list from Patient class for patients
    //=============================================
    //No-arg constructor
    Doctor(){}
    //Default constructor for Doctor
    Doctor(String name, String address, String dateOfBirth, String specialty) {
        super(name, address, dateOfBirth);
        this.specialty = specialty;
    }
    //GETTER & SETTERS
    //Getters and Setters for specialty
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    //Getter and Setters for patients
    public List<Patient> getPatients() {
        return patients;
    }
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
//======================================================================================

    //Method to add Patient to Doctor
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}
//**********************************************************************************************************************
//Class to represent a Hospital
class Hospital {
    //VARIABLES
    int[] floorNumber;//Array for floor number
    int totalRooms;
    String hospitalName;
    String hospitalAddress;
    List<Room> rooms = new ArrayList<>();// Array list from Room class for rooms
    List<Doctor> doctors = new ArrayList<>();// Array list from Doctor class for doctors
//============================================

    Hospital(){
    }

    //Default constructor for Hospital class
    Hospital(int[] floorNumber, int totalRooms) {
        this.floorNumber = floorNumber;
        this.totalRooms = totalRooms;
    }
    //GETTER & SETTERS
    //Getter and setters for hospitalName
    public String getHospitalName(){ return hospitalName;}
    public void setHospitalName(String hospitalName) {this.hospitalName = hospitalName;}

    //Getter and setters for hospitalAddress
    public String getHospitalAddress(){return hospitalAddress;}
    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    //Getters & Setters for floorNumber
    public int[] getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(int[] floorNumber) {
        this.floorNumber = floorNumber;
    }

    //Getter and Setters for totalRooms
    public int getTotalRooms() {
        return totalRooms;
    }
    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    //Getter and Setters for rooms
    public List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    //Getter and Setters for doctors
    public List<Doctor> getDoctors() {
        return doctors;
    }
    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
    //=================================================================================
    //Method to add Room to Hospital
    public void addRoom(Room room) {
        rooms.add(room);
    }

    //Method to add Doctor to Hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    //Method to show all Patients on a Floor
    public void showPatientsOnFloor(int floorNumber) { //passes in a particular floor number as a parameter
        System.out.println("Patients on Floor " + floorNumber + ":");
        for (Room room : rooms) { //this foreach loop would be for each floor in the floorNumber array
            if (room.getFloor() == floorNumber) {
                System.out.println("Room " + room.roomNumber + ":");
                for (Patient patient : room.patients) {
                    //
                    System.out.println("Name: " + patient.getName());
                }
            }
        }
    }

    //Method to show all available beds
    public void showAvailableBeds() {
        int availableBeds = 0; // Variable initialization
        for (Room room : rooms) {// for each room
            for (Bed bed : room.beds) { // were getting each bed in each room
                if (bed.getPatient() == null) { // if bed does not have a patient
                    availableBeds++; // add available bed to counter
                }
            }
            System.out.println("Room " + room.roomNumber + " has " + availableBeds + " beds available");
            availableBeds = 0;
        }
    }
    //Method to print a report showing each Room occupancy
    public void printRoomOccupancyReport() {
        System.out.println("Room Number\tNumber of Patients");
        for (Room room : rooms) {
            System.out.println("\t" + room.roomNumber + "\t\t\t\t" + room.patients.size());
        }
    }

    //Method to print a report showing all patients per Room sorted by admission date
    public void printPatientsPerRoomReport() {
        System.out.println("Patients per room report");
        for (Room room : rooms) {
            System.out.println("Room " + room.roomNumber);
            Collections.sort(room.patients, Comparator.comparing(Patient::getAdmissionDate));
            for (Patient patient : room.patients) {
                System.out.println("Name: " + patient.getName() + "  Admission Date: " + patient.getAdmissionDate());
            }
        }
    }

    //Method to display all Patients for a Doctor
    public void displayPatientsForDoctor(String doctorName) {
        System.out.println("Patients for Doctor " + doctorName + ":");
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(doctorName)) {
                for (Patient patient : doctor.patients) {
                    System.out.println("Name: " + patient.getName() + "  Room Number: " + patient.getRoomNumber());
                }
            }
        }
    }

    //Method to print a patients per Doctor report
    public void printPatientsPerDoctorReport() {
        System.out.println("Patients per Doctor report");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor: " + doctor.getName());
            for (Patient patient : doctor.patients) {
                System.out.println("Name: " + patient.getName() + "  Room Number: " + patient.getRoomNumber());
            }
        }
    }

    //Method to print a report showing a list of Rooms where are Patients for a specific Doctor,
    // order the Rooms by Room number or number of Patients treated by the Doctor
    public void printRoomsForDoctorReport(Doctor doctor) {
        System.out.println("Rooms for Doctor " + doctor.getName() + " report");
        Collections.sort(doctor.patients, Comparator.comparing(Patient::getRoomNumber));
        for (Patient patient : doctor.patients) {//for each patient with x doctor get room Number
            System.out.println("Room: " + patient.getRoomNumber());
        }
    }
}
//**********************************************************************************************************************
//Class to represent a Room
class Room {
    String roomNumber;
    Bed[] beds;
    String visitationHours;
    String roomSpeciality;
    int floor;
    List<Patient> patients = new ArrayList<>();//Array list from Patient class for patients
    //Default constructor for Room
    Room(String roomNumber, Bed[] beds) {
        this.roomNumber = roomNumber;
        this.beds = beds;
    }
    //GETTER & SETTERS
    //Getters and Setters for getRoomNumber & setRoomNumber
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    //Getter and Setters for getBeds & setBeds
    public Bed[] getBeds() {
        return beds;
    }
    public void setBeds(Bed[] beds) {
        this.beds = beds;
    }

    //Getter and Setters for getPatients & setPatients
    public List<Patient> getPatients() {
        return patients;
    }
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    //Getter and setters for getFloor & setFloor
    public int getFloor(){ return floor;}
    public void setFloor(int floor) { this.floor = floor;}

    //Getter and setters for visitationHours
    void setVisitationHours(String visitationHours){
        this.visitationHours = visitationHours;
    }
    public String getVisitationHours(){return visitationHours;}

    //Getter and setters for roomSpecialty
    void setRoomSpeciality(String roomSpeciality){
        this.roomSpeciality = roomSpeciality;
    }
    public String getRoomSpeciality(){
        return roomSpeciality;
    }
    //================================================================================

    //Method to add Patient to Room
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
}
//**********************************************************************************************************************
//Bed class
class Bed {
    //Attributes
    int bedNumber;
    String bedType;
    String bedSpecialEquipment;
    Patient patient;
    //GETTER and SETTERS
    //Getter and setters for patient
    Patient getPatient(){ return patient; }
    void setPatient(Patient patient){this.patient = patient;}

    //Getter and setters for bedNumber
    int getBedNumber(){
        return bedNumber;
    }
    void setBedNumber(int bedNumber){
        this.bedNumber = bedNumber;
    }

    //Getter and setters for bedTyper
    String getBedType(){
        return bedType;
    }
    void setBedType(String bedType){
        this.bedType = bedType;
    }

    //Getter and setters for bedSpecialEquipment
    void setBedSpecialEquipment(String bedSpecialEquipment){
        this.bedSpecialEquipment = bedSpecialEquipment;
    }
    String getBedSpecialEquipment(){
        return bedSpecialEquipment;
    }
}
//**********************************************************************************************************************
//Main Method
public class Final_Hospital {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.setHospitalName("Weenie Hut General");
        hospital.setHospitalAddress("1234 street rd, Atlanta GA, 30304");

        Bed bed1 = new Bed();
        bed1.setBedNumber(1);
        bed1.setBedType("Memory Foam");
        bed1.setBedSpecialEquipment("Half Rails");
        Bed bed2 = new Bed();
        bed2.setBedNumber(2);
        bed2.setBedType("Hypo Allergenic foam");
        bed2.setBedSpecialEquipment("Bedside Commode");
        Bed bed3 = new Bed();
        bed3.setBedNumber(3);
        bed3.setBedType("Memory Foam");
        bed3.setBedSpecialEquipment("Protective Padding");
        Bed bed4 = new Bed();
        bed4.setBedNumber(4);
        bed4.setBedType("Hypo Allergenic foam");
        bed4.setBedSpecialEquipment("Over bed Table");
        Bed bed5 = new Bed();
        bed5.setBedNumber(5);
        bed5.setBedType("Temperature Controlled");
        bed5.setBedSpecialEquipment("Half Rails");
        Bed bed6 = new Bed();
        bed6.setBedNumber(6);
        bed6.setBedType("Hypo Allergenic foam");
        bed6.setBedSpecialEquipment("Bedside Commode");
        Bed bed7 = new Bed();
        bed5.setBedNumber(7);
        bed5.setBedType("Memory Foam");
        bed5.setBedSpecialEquipment("Half Rails");
        Bed bed8 = new Bed();
        bed6.setBedNumber(8);
        bed6.setBedType("Temperature Controlled");
        bed6.setBedSpecialEquipment("Over bed table");

        //Creates beds array that assigns beds
        Bed[] beds1 = new Bed[]{bed1};
        Bed[] beds2 = new Bed[]{bed2};
        Bed[] beds3 = new Bed[]{bed3, bed4};
        Bed[] beds4 = new Bed[]{bed5, bed6, bed7, bed8};

        Room room1 = new Room("1", beds1);
        room1.setFloor(1);
        room1.setVisitationHours("10am - 6pm");
        room1.setRoomSpeciality("Trauma");

        Room room2 = new Room("2", beds2);
        room2.setFloor(2);
        room2.setVisitationHours("10am - 6pm");
        room2.setRoomSpeciality("Allergy");

        Room room3 = new Room("3", beds3);
        room3.setFloor(3);
        room3.setVisitationHours("10am - 6pm");
        room3.setRoomSpeciality("Neurology");

        Room room4 = new Room("4", beds4);
        room4.setFloor(3);
        room4.setVisitationHours("10am - 6pm");
        room4.setRoomSpeciality("Cardiology");

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        hospital.setRooms(rooms);

        Patient patient1 = new Patient();
        patient1.setName("Sandy Cheeks");
        patient1.setDateOfBirth("May-01-1999");
        patient1.setAdmissionDate("September-12-2022");
        patient1.setDiagnosis("Seizures");
        patient1.setRoomNumber("3");
        Patient patient2 = new Patient();
        patient2.setName("Squidward Tentacles");
        patient2.setDateOfBirth("May-01-1999");
        patient2.setAdmissionDate("July-23-2022");
        patient2.setDiagnosis("Food poisoning");
        patient2.setRoomNumber("3");
        Patient patient3 = new Patient();
        patient3.setName("Eugene Krabs");
        patient3.setDateOfBirth("May-01-1999");
        patient3.setAdmissionDate("February-15-2022");
        patient3.setDiagnosis("Heart Attack");
        patient3.setRoomNumber("4");
        Patient patient4 = new Patient();
        patient4.setName("Patrick Star");
        patient4.setDateOfBirth("May-01-1999");
        patient4.setAdmissionDate("June-16-2022");
        patient4.setDiagnosis("Asphyxiation");
        patient4.setRoomNumber("4");

        bed3.setPatient(patient1);
        bed4.setPatient(patient2);
        bed5.setPatient(patient3);
        bed6.setPatient(patient4);

        //
        List<Patient> patients1 = new ArrayList<>();
        patients1.add(patient1);
        patients1.add(patient2);

        List<Patient> patients2 = new ArrayList<>();
        patients2.add(patient3);
        patients2.add(patient4);

        room3.setPatients(patients1);
        room4.setPatients(patients2);

        //
        Doctor doctor1 = new Doctor();
        doctor1.setName("Plankton");
        doctor1.setSpecialty("Cardiology & Trauma");
        doctor1.setPatients(patients1);
        Doctor doctor2 = new Doctor();
        doctor2.setName("King Neptune");
        doctor2.setSpecialty("Neurology & Allergy");
        doctor2.setPatients(patients2);

        List<Doctor> doctors1 = new ArrayList<>();
        List<Doctor> doctors2 = new ArrayList<>();
        List<Doctor> allDoctors = new ArrayList<>();
        doctors1.add(doctor1);
        doctors2.add(doctor2);
        allDoctors.add(doctor1);
        allDoctors.add(doctor2);
        hospital.setDoctors(allDoctors);

        patient1.setDoctors(doctors1);
        patient2.setDoctors(doctors1);
        patient3.setDoctors(doctors2);
        patient4.setDoctors(doctors2);

        //Assigns patient to bed
        bed1.setPatient(patient1);
        bed2.setPatient(patient2);
        bed3.setPatient(patient3);
        bed4.setPatient(patient4);

        hospital.showPatientsOnFloor(3);
        hospital.showAvailableBeds();
        hospital.printRoomOccupancyReport();
        hospital.printPatientsPerRoomReport();
        hospital.displayPatientsForDoctor(doctor2.getName());
        hospital.printPatientsPerDoctorReport();
        hospital.printRoomsForDoctorReport(doctor1);

    }
}