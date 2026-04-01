package quiz_vasiljevs;

/**
 * Klase, kas attēlo studentu lietotāju sistēmā.
 * Students var pildīt testus un apskatīt savus rezultātus.
 * Paplašina bāzes klasi User.
 * @author Glebs.Vasiljev
 */
public class Student extends User {

    private int correctAnswers;
    private int wrongAnswers;
    private int unanswered;

    /**
     * Izveido jaunu studentu ar norādītajiem datiem.
     * @param id unikāls lietotāja ID no datubāzes
     * @param name studenta vārds
     * @param surname studenta uzvārds
     * @param login studenta pieteikšanās vārds
     * @param password studenta parole
     */
    public Student(int id, String name, String surname, String login, String password) {
        super(id, name, surname, login, password);
    }
}