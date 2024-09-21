import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    StepTracker(Scanner scanner){
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++){
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay(){
        System.out.println("Введите номер месяца (От 1 до 12 включительно).");
        int monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12)
        {
            System.out.println("Введен неверный номер мясяца.");
            return;
        }

        System.out.println("Введите номер дня (от 1 до 30 включительно).");
        int dayNumber = scanner.nextInt();

        if (dayNumber < 1 || dayNumber > 30)
        {
            System.out.println("Введен неверный номер дня.");
            return;
        }

        System.out.println("Введите количество шагов (неотрицательное).");
        int stepsNumber = scanner.nextInt();

        if (stepsNumber < 0)
        {
            System.out.println("Ошибка. Введено отрицательное количество шагов.");
            return;
        }

        monthToData[monthNumber - 1].days[dayNumber - 1] = stepsNumber;
    }

    public void changeStepGoal(){
        System.out.println("Введите цель шагов на каждый день (число больше 0);");
        int newStepsGoal = scanner.nextInt();

        if (newStepsGoal <= 0)
        {
            System.out.println("Ошибка. Введено некорректное значение цели шагов.");
            return;
        }

        goalByStepsPerDay = newStepsGoal;
    }

    public void printStatistics(){
        System.out.println("Введите номер месяца (От 1 до 12 включительно).");
        // ввод и проверка номера месяца
        int monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12)
        {
            System.out.println("Введен неверный номер мясяца.");
            return;
        }

        MonthData monthData = monthToData[monthNumber - 1];// получение соответствующего месяца


        // вывод общей статистики по дням
        monthData.printDaysAndStepsFromMonth();

        int sumSteps = monthData.sumStepsFromMonth();// получение суммы шагов за месяц

        // вывод суммы шагов за месяц
        System.out.println("Сумма шагов за месяц " + sumSteps + ".");
        // вывод максимального пройденного количества шагов за месяц
        System.out.println("Максимальное пройденное количество шагов за месяц " + monthData.maxSteps() + ".");
        // вывод среднего пройденного количества шагов за месяц
        System.out.println("Среднее пройденное количество шагов за месяц " + sumSteps / monthData.days.length);
        // вывод пройденной за месяц дистанции в км
        System.out.println("Пройденная за месяц дистанция " + converter.covertToKm(sumSteps) + " км.");
        // вывод количества сожжённых килокалорий за месяц
        System.out.println("Колмчество сожженных килокалорий за мясяц " + converter.convertStepsToKilocalories(sumSteps) + ".");
        // вывод лучшей серии
        System.out.println("Лучшая серия " + monthData.bestSeries(goalByStepsPerDay) + ".");
        //дополнительный перенос строки
        System.out.println();
    }
}
