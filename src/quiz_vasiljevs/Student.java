/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_vasiljevs;

/**
 *
 * @author Glebs.Vasiljev
 */
public class Student extends User {

    private int correctAnswers;
    private int wrongAnswers;
    private int unanswered;

    public Student(int id, String name, String surname, String login, String password) {
        super(id, name, surname, login, password);
    }

}
