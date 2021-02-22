import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        //Проверить логин и пароль
        User user = getUserByLoginAndPassword(login, password);

        //Вызвать методы валидации пользователя
        validateUser(user);
        System.out.println("Доступ разрешен");
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "pass", "jhon@gmail.com", 24);
        User user2 = new User("dave", "word", "dave@gmail.com", 21);
        User user3 = new User("sam", "sam3322", "sam@gmail.com", 32);
        User user4 = new User("frodo", "sam445", "frodo@gmail.com", 27);
        User user5 = new User("achieves", "qwerty", "achiles@gmail.com", 11);
        return new User[]{user1, user2, user3, user4, user5};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Ошибка! Пользователю меньше 18 лет!");
        }
    }
}