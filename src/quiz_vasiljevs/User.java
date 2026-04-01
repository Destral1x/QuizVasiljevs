/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz_vasiljevs;

/**
 *
 * @author Glebs.Vasiljev
 */
public class User {

    protected int id;
    protected String name;
    protected String surname;
    protected String login;
    protected String password;

    public User(int id, String name, String surname, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}
//commit try 2
