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
import java.util.HashMap;
import java.util.Map;

public class TestSession {
    private List<Question> questions;
    private int currentIndex;
    private Map<Integer, String> selectedAnswers;

    public TestSession(List<Question> allQuestions) {
        List<Question> shuffled = new ArrayList<>(allQuestions);
        Collections.shuffle(shuffled);
        this.questions = shuffled.subList(0, Math.min(10, shuffled.size()));
        this.currentIndex = 0;
        this.selectedAnswers = new HashMap<>();
    }

    public Question getCurrentQuestion() { return questions.get(currentIndex); }
    public int getCurrentIndex() { return currentIndex; }
    public int getTotalQuestions() { return questions.size(); }
    public boolean hasNext() { return currentIndex < questions.size() - 1; }
    public boolean hasPrevious() { return currentIndex > 0; }
    public boolean isLastQuestion() { return currentIndex == questions.size() - 1; }

    public String getSelectedAnswer() { return selectedAnswers.get(currentIndex); }

    public void saveAnswer(String selected) {
        if (selected != null) {
            selectedAnswers.put(currentIndex, selected);
        }
    }

    public void goNext() { if (hasNext()) currentIndex++; }
    public void goBack() { if (hasPrevious()) currentIndex--; }

    public TestResult getResult() {
        int correct = 0;
        for (int i = 0; i < questions.size(); i++) {
            String selected = selectedAnswers.get(i);
            if (selected != null && selected.equals(questions.get(i).getCorrectAnswer())) {
                correct++;
            }
        }
        return new TestResult(correct, questions.size());
    }
}