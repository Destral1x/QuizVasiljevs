/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_vasiljevs;

/**
 *
 * @author Glebs.Vasiljev
 */
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class TestSession {
    private List<Question> questions;
    private int currentIndex;
    private int score;

    public TestSession(List<Question> allQuestions) {
        // shuffle and pick 10 random questions
        List<Question> shuffled = new ArrayList<>(allQuestions);
        Collections.shuffle(shuffled);
        this.questions = shuffled.subList(0, Math.min(10, shuffled.size()));
        this.currentIndex = 0;
        this.score = 0;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    public int getCurrentIndex() { return currentIndex; }
    public int getTotalQuestions() { return questions.size(); }
    public boolean hasNext() { return currentIndex < questions.size() - 1; }

    public void submitAnswer(String selected) {
        if (selected != null && selected.equals(getCurrentQuestion().getCorrectAnswer())) {
            score++;
        }
        currentIndex++;
    }

    public TestResult getResult() {
        return new TestResult(score, questions.size());
    }
}