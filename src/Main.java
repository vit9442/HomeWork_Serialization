import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RegistrationSystem registration = new RegistrationSystem("users");
        User user;
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру:\n1 - Авторизация\n2 - Регистрация\n3 - Выход");
        while ((n = scanner.nextInt()) != 3) {
            String nick;
            String pass;
            switch (n) {
                case (1): //Авторизация
                    System.out.println("Введите логин:");
                    nick = new Scanner(System.in).nextLine();
                    System.out.println("Введите пароль:");
                    pass = new Scanner(System.in).nextLine();
                    user = registration.login(nick, pass);
                    if (user != null) {
                        System.out.println("Вы успешно зарегестрированы");
                    } else System.out.println("неверный логин или пароль");
                    break;
                case (2)://Регистрация
                    System.out.println("Введите логин:");
                    nick = new Scanner(System.in).nextLine();
                    System.out.println("Введите пароль:");
                    pass = new Scanner(System.in).nextLine();
                    if (registration.register(nick, pass)) {
                        System.out.println("Вы успешно зарегистрировались!");
                    } else System.out.println("Такой пользователь уже существует");
                    break;
                default:
                    break;

            }
            System.out.println("Введите цифру:\n1 - Авторизация\n2 - Регистрация\n3 - Выход");
        }
        registration.saveData();//сохранение


    }
}