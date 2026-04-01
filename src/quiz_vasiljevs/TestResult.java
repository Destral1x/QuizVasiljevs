/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_vasiljevs;

/**
 *
 * @author Glebs.Vasiljev
 */
public class TestResult {
    private int correct;
    private int total;
    private double percentage;
    private int grade;

    public TestResult(int correct, int total) {
        this.correct = correct;
        this.total = total;
        this.percentage = (double) correct / total * 100;
        this.grade = (int) Math.round(percentage / 10);
    }

    public int getCorrect() { return correct; }
    public int getTotal() { return total; }
    public double getPercentage() { return percentage; }
    public int getGrade() { return grade; }
}
