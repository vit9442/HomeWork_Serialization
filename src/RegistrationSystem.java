import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    String filename;
    List<User> users;

    public RegistrationSystem() {
    }

    public RegistrationSystem(String filename) {//конструктор, принимающий имя файла, из которого нужно считать данные
        this.filename = filename += ".dat";

        try (ObjectInputStream fileInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            users = (ArrayList<User>) fileInputStream.readObject();
            for (User u : users) {

            }

        } catch (Exception ex) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                users = new ArrayList<User>();
                System.out.println("Файл " + filename + " создан");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public User login(String nickname, String password) { //метод авторизации
        if (users.size() > 0) {
            for (User us : users) {

                if (us.equals(new User(nickname, password))) {
                    return us;
                }
            }
            return null;
        }
        return null;
    }
    public boolean register(String nickname, String password) {//метод регистрации
        if (users.size() > 0) {
            for (User us : users) {

                if ((us.getNickname().equals(nickname))) {
                    return false;
                }
            }
        } else {
            users.add(new User(nickname, password));
            return true;
        }
        users.add(new User(nickname, password));
        return true;
    }
    public void saveData() {//метод сохранения
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(users);
            System.out.println("Файл " + filename + " записан");

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
