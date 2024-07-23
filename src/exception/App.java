package exception;

import exception.WrongLoginException;
import exception.WrongPasswordException;

public class App {
    private static final String VALID_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    public static void main(String[] args) {
        try {
            authenticateUser("123wd", "23123", "23123");
            System.out.println("Всё хорошо");
        } catch (WrongLoginException wle) {
            System.out.println(wle.getMessage());
        } catch (WrongPasswordException wpe) {
            System.out.println(wpe.getMessage());
        }
    }

    private static void authenticateUser(String login, String password, String confirmPassword) {
        for (int i = 0; i < login.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(login.charAt(i))) || login.length() > 20) {
                throw new WrongLoginException();
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(password.charAt(i))) || password.length() > 20) {
                throw new WrongPasswordException();

            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}
