import java.time.LocalDate;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
class Exam {

    Integer number;
    LocalDate date;
    LocalTime time;
    String eye;
    String device;

    public Exam(Integer number, LocalDate date, LocalTime time, String eye) {
        this(number, date, time, eye, "Pentacam");
    }

    public Exam(Integer number, LocalDate date, LocalTime time, String eye, String device) {
        this.number = number;
        this.date = date;
        this.time = time;
        this.eye = eye;
        this.device = device;
    }

}
