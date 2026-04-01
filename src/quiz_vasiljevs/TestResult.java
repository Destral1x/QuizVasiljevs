package quiz_vasiljevs;

/**
 * Klase, kas attēlo pabeigtas testa sesijas rezultātu.
 * Aprēķina procentuālo rezultātu un pārvērš to atzīmē skalā no 1 līdz 10.
 * @author Glebs.Vasiljev
 */
public class TestResult {

    private int correct;
    private int total;
    private double percentage;
    private int grade;

    /**
     * Izveido testa rezultātu un aprēķina procentus un atzīmi.
     * @param correct pareizo atbilžu skaits
     * @param total kopējais jautājumu skaits
     */
    public TestResult(int correct, int total) {
        this.correct = correct;
        this.total = total;
        this.percentage = (double) correct / total * 100;
        this.grade = (int) Math.round(percentage / 10);
    }

    /**
     * Atgriež pareizo atbilžu skaitu.
     * @return pareizo atbilžu skaits
     */
    public int getCorrect() { return correct; }

    /**
     * Atgriež kopējo jautājumu skaitu.
     * @return kopējais jautājumu skaits
     */
    public int getTotal() { return total; }

    /**
     * Atgriež procentuālo rezultātu.
     * @return procenti kā decimālskaitlis
     */
    public double getPercentage() { return percentage; }

    /**
     * Atgriež atzīmi skalā no 1 līdz 10.
     * @return atzīme
     */
    public int getGrade() { return grade; }
}