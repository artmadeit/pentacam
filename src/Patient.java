
import java.time.LocalDate;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
class Patient {
    String firstName;
    String lastName;
    LocalDate birthDate;
    
    List<Exam> exams;

    public Patient(String firstName, String lastName, LocalDate birthDate, List<Exam> exams ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.exams = exams;
    }
    
    
}
