package quiz_vasiljevs;

/**
 * Klase, kas attēlo administratora lietotāju sistēmā.
 * Administrators var pārvaldīt jautājumus un apskatīt rezultātus.
 * Paplašina bāzes klasi User.
 * @author Glebs.Vasiljev
 */
public class Admin extends User {

    /**
     * Izveido jaunu administratoru ar norādītajiem datiem.
     * @param id unikāls lietotāja ID no datubāzes
     * @param name administratora vārds
     * @param surname administratora uzvārds
     * @param login administratora pieteikšanās vārds
     * @param password administratora parole
     */
    public Admin(int id, String name, String surname, String login, String password) {
        super(id, name, surname, login, password);
    }
}