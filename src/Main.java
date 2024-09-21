import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true)
        {
            printMenu();

            int command = scanner.nextInt();

            if (command == 1){
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2){
                stepTracker.changeStepGoal();
            } else if (command == 3){
                stepTracker.printStatistics();
            } else if (command == 4){
                System.out.println("Выход.");
                scanner.close();
                return;
            } else {
                System.out.println("Команды с таким номером не существует.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Введите номер команды.");
        System.out.println("1 - Добавить число шагов за определенный день определенного месяца.");
        System.out.println("2 - Изменить цель шагов на каждый день.");
        System.out.println("3 - Вывод статистики за определенный мясяц.");
        System.out.println("4 - Выйти из приложения.");
    }
}
