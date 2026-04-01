package quiz_vasiljevs;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Servisa klase, kas atbild par visām datubāzes operācijām.
 * Ielādē savienojuma parametrus no config.properties faila.
 * @author Glebs.Vasiljev
 */
public class DatabaseService {

    private static String URL;
    private static String USER;
    private static String PASS;
    private Connection conn;

    /**
     * Konstruktors, kas ielādē datubāzes parametrus no config.properties
     * un izveido savienojumu ar Derby datubāzi.
     */
    public DatabaseService() {
        try {
            Properties props = new Properties();
            InputStream input = getClass().getResourceAsStream("/config.properties");
            props.load(input);

            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASS = props.getProperty("db.password");

            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to Derby!");
        } catch (Exception e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }

    /**
     * Mēģina ielogot lietotāju ar norādītajiem datiem.
     * @param login lietotāja pieteikšanās vārds
     * @param password lietotāja parole
     * @return Admin vai Student objekts ja dati ir pareizi, null ja nē
     */
    public User login(String login, String password) {
        String sql = "SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String first = rs.getString("FIRST_NAME");
                String last = rs.getString("LAST_NAME");
                String role = rs.getString("ROLE");
                if (role.equals("admin")) {
                    return new Admin(id, first, last, login, password);
                } else {
                    return new Student(id, first, last, login, password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Pievieno jaunu lietotāju USERS tabulā.
     * @param firstName lietotāja vārds
     * @param lastName lietotāja uzvārds
     * @param login lietotāja pieteikšanās vārds
     * @param password lietotāja parole
     * @param role lietotāja loma (admin vai student)
     * @return true ja lietotājs veiksmīgi pievienots, false ja pieteikšanās vārds jau eksistē
     */
    public boolean addUser(String firstName, String lastName, String login, String password, String role) {
        String sql = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, ROLE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, login);
            ps.setString(4, password);
            ps.setString(5, role);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("addUser error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Ielādē visus jautājumus no QUESTIONS tabulas.
     * @return saraksts ar visiem Question objektiem
     */
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM QUESTIONS";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                questions.add(new Question(
                    rs.getInt("ID"),
                    rs.getString("QUESTION_TEXT"),
                    rs.getString("OPTION_A"),
                    rs.getString("OPTION_B"),
                    rs.getString("OPTION_C"),
                    rs.getString("OPTION_D"),
                    rs.getString("CORRECT_ANSWER")
                ));
            }
        } catch (SQLException e) {
            System.out.println("getQuestions error: " + e.getMessage());
        }
        return questions;
    }

    /**
     * Saglabā studenta testa rezultātu RESULTS tabulā.
     * @param userId studenta ID
     * @param score pareizo atbilžu skaits
     * @param total kopējais jautājumu skaits
     * @param grade gala atzīme skalā no 1 līdz 10
     */
    public void saveResult(int userId, int score, int total, int grade) {
        String sql = "INSERT INTO RESULTS (USER_ID, SCORE, TOTAL, GRADE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, score);
            ps.setInt(3, total);
            ps.setInt(4, grade);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("saveResult error: " + e.getMessage());
        }
    }
}