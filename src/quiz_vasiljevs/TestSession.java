package quiz_vasiljevs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Klase, kas pārvalda vienu testa sesiju studentam.
 * Nejauši izvēlas 10 jautājumus, izseko navigāciju un saglabā atbildes.
 * @author Glebs.Vasiljev
 */
public class TestSession {

    private List<Question> questions;
    private int currentIndex;
    private Map<Integer, String> selectedAnswers;

    /**
     * Izveido jaunu testa sesiju, sajaucot visus jautājumus un izvēloties 10.
     * @param allQuestions pilns jautājumu saraksts no datubāzes
     */
    public TestSession(List<Question> allQuestions) {
        List<Question> shuffled = new ArrayList<>(allQuestions);
        Collections.shuffle(shuffled);
        this.questions = shuffled.subList(0, Math.min(10, shuffled.size()));
        this.currentIndex = 0;
        this.selectedAnswers = new HashMap<>();
    }

    /**
     * Atgriež pašreizējo jautājumu.
     * @return pašreizējais jautājums
     */
    public Question getCurrentQuestion() { return questions.get(currentIndex); }

    /**
     * Atgriež pašreizējā jautājuma indeksu.
     * @return pašreizējais indekss
     */
    public int getCurrentIndex() { return currentIndex; }

    /**
     * Atgriež kopējo jautājumu skaitu sesijā.
     * @return kopējais jautājumu skaits
     */
    public int getTotalQuestions() { return questions.size(); }

    /**
     * Pārbauda vai ir nākamais jautājums.
     * @return true ja nav pēdējais jautājums
     */
    public boolean hasNext() { return currentIndex < questions.size() - 1; }

    /**
     * Pārbauda vai ir iepriekšējais jautājums.
     * @return true ja nav pirmais jautājums
     */
    public boolean hasPrevious() { return currentIndex > 0; }

    /**
     * Pārbauda vai pašreizējais jautājums ir pēdējais.
     * @return true ja ir pēdējais jautājums
     */
    public boolean isLastQuestion() { return currentIndex == questions.size() - 1; }

    /**
     * Atgriež iepriekš saglabāto atbildi pašreizējam jautājumam.
     * @return izvēlētās atbildes burts vai null ja vēl nav atbildēts
     */
    public String getSelectedAnswer() { return selectedAnswers.get(currentIndex); }

    /**
     * Saglabā izvēlēto atbildi pašreizējam jautājumam.
     * @param selected studenta izvēlētās atbildes burts (A, B, C vai D)
     */
    public void saveAnswer(String selected) {
        if (selected != null) {
            selectedAnswers.put(currentIndex, selected);
        }
    }

    /**
     * Pāriet uz nākamo jautājumu ja tāds ir.
     */
    public void goNext() { if (hasNext()) currentIndex++; }

    /**
     * Pāriet uz iepriekšējo jautājumu ja tāds ir.
     */
    public void goBack() { if (hasPrevious()) currentIndex--; }

    /**
     * Aprēķina un atgriež testa gala rezultātu.
     * Saskaita visas pareizās atbildes no saglabātajām izvēlēm.
     * @return TestResult objekts ar punktiem un atzīmi
     */
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