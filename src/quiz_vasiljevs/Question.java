package quiz_vasiljevs;

/**
 * Klase, kas attēlo vienu testa jautājumu ar četrām atbilžu iespējām.
 * Pareizā atbilde tiek glabāta kā burts (A, B, C vai D).
 * @author Glebs.Vasiljev
 */
public class Question {

    private int id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    /**
     * Izveido jaunu jautājumu ar visiem laukiem.
     * @param id unikāls jautājuma ID no datubāzes
     * @param questionText jautājuma teksts
     * @param optionA atbildes variants A
     * @param optionB atbildes variants B
     * @param optionC atbildes variants C
     * @param optionD atbildes variants D
     * @param correctAnswer pareizās atbildes burts (A, B, C vai D)
     */
    public Question(int id, String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Atgriež jautājuma ID.
     * @return jautājuma ID
     */
    public int getId() { return id; }

    /**
     * Atgriež jautājuma tekstu.
     * @return jautājuma teksts
     */
    public String getQuestionText() { return questionText; }

    /**
     * Atgriež atbildes variantu A.
     * @return varianta A teksts
     */
    public String getOptionA() { return optionA; }

    /**
     * Atgriež atbildes variantu B.
     * @return varianta B teksts
     */
    public String getOptionB() { return optionB; }

    /**
     * Atgriež atbildes variantu C.
     * @return varianta C teksts
     */
    public String getOptionC() { return optionC; }

    /**
     * Atgriež atbildes variantu D.
     * @return varianta D teksts
     */
    public String getOptionD() { return optionD; }

    /**
     * Atgriež pareizās atbildes burtu.
     * @return pareizā atbilde (A, B, C vai D)
     */
    public String getCorrectAnswer() { return correctAnswer; }
}