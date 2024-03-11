/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package hospital_management_system;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class Patient {
    private final  String id;
    private final  String name;
    private final  int age;
    private final  String gender;

    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and setters
}
class Doctor {
    private final String id;
    private final String name;
    private final String specialization;

    public Doctor(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Getters and setters
}
class Appointment {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private String appointmentTime;

    public Appointment(String id, Doctor doctor, Patient patient, String appointmentTime) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
    }

    // Getters and setters
}
class Hospital {
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Appointment> appointments;

    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    // Methods to add patient, doctor, and appointment
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

   
}
public class Hospital_Management_System {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","natts3804");
            System.out.println(con);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Hospital_Management_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        Hospital hospital = new Hospital();

        // Adding patients
        Patient patient1 = new Patient("P001", "John Doe", 30, "Male");
        Patient patient2 = new Patient("P002", "Jane Smith", 25, "Female");
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Adding doctors
        Doctor doctor1 = new Doctor("D001", "Dr. Smith", "Cardiologist");
        Doctor doctor2 = new Doctor("D002", "Dr. Johnson", "Pediatrician");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Scheduling appointments
        Appointment appointment1 = new Appointment("A001", doctor1, patient1, "2024-02-25 10:00 AM");
        Appointment appointment2 = new Appointment("A002", doctor2, patient2, "2024-02-26 11:00 AM");
        hospital.scheduleAppointment(appointment1);
        hospital.scheduleAppointment(appointment2);

        
    }
}




    