package quiz_vasiljevs;

/**
 * Bāzes klase, kas attēlo sistēmas lietotāju.
 * Satur kopīgus laukus un metodes visiem lietotāju tipiem.
 * @author Glebs.Vasiljev
 */
public class User {

    protected int id;
    protected String name;
    protected String surname;
    protected String login;
    protected String password;

    /**
     * Izveido jaunu lietotāju ar norādītajiem datiem.
     * @param id unikāls lietotāja ID no datubāzes
     * @param name lietotāja vārds
     * @param surname lietotāja uzvārds
     * @param login lietotāja pieteikšanās vārds
     * @param password lietotāja parole
     */
    public User(int id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    /**
     * Atgriež lietotāja pieteikšanās vārdu.
     * @return pieteikšanās vārds
     */
    public String getLogin() {
        return login;
    }

    /**
     * Pārbauda vai ievadītā parole atbilst lietotāja parolei.
     * @param inputPassword ievadītā parole
     * @return true ja parole atbilst, false ja nē
     */
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    /**
     * Atgriež lietotāja ID.
     * @return lietotāja ID
     */
    public int getId() {
        return id;
    }
}