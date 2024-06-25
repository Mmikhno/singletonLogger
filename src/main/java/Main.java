import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        String input = null;
        int n = 0; //размер списка
        int m = 0; // верхняя граница
        int f = 0; // порог для фильтра
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        n = getUserInput();
        System.out.print("Введите верхнюю границу для значений: ");
        m = getUserInput();
        logger.log("Создаём и наполняем список");
        List<Integer> list = getRandomList(m, n);
        System.out.print("Вот случайный список: " + list.stream().map(x -> x + " ").collect(Collectors.joining()) + "\n");
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        f = getUserInput();
        Filter filter = new Filter(f);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        result.stream().sorted().forEach(x -> System.out.print(x + " "));
    }

    public static List<Integer> getRandomList(int max, int count) {
        return new Random()
                .ints(0, max + 1)
                .limit(count)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int getUserInput() {
        Logger logger = Logger.getInstance();
        String userInput;
        int n;
        while (true) {
            userInput = scanner.nextLine().trim();
            if (userInput.isEmpty()) {
                logger.log("Введено пустое значение/пробел");
                System.out.print("Введите целое положительное число: ");
                continue;
            }
            if (!isInt(userInput)) {
                logger.log("Введенное значение " + userInput + " не соответствует формату");
                System.out.print("Введите целое положительное число: ");
                continue;
            }
            n = Integer.parseInt(userInput);
            if (n <= 0) {
                logger.log("Введенное значение меньше 1");
                System.out.print("Введите целое положительное число: ");
                continue;
            }

            return n;
        }
    }


    public static boolean isInt(String item) {
        return item.matches("-?\\d+");
    }
}
