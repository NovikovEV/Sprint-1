import java.util.Scanner;

public class StepTracker {
    private int stepsTarget; // цель по шагам
    private final int[][] statistic; // массив для статистики
    private final Converter converter; // объявление переменной для класса Converter
    public StepTracker(){
        converter = new Converter(); // создание объекта Converter
        statistic = new int[12][30]; // создание 2d массива
        stepsTarget = 10000; // инициализация цели количества шагов
    }
    public void setTargetSteps(){ // метод для изменения цели по количеству шагов
        System.out.print("Введите цель по количеству шагов в день: ");
        int steps = userInput();
        if (steps > 0){
            stepsTarget = steps;
            System.out.println("Новая цель по количеству шагов в день: " + stepsTarget);
        }
    }
    public void printMenu(){ // метод для вывода меню
        System.out.println("1.\tВвести количество шагов за определённый день");
        System.out.println("2.\tНапечатать статистику за определённый месяц");
        System.out.println("3.\tИзменить цель по количеству шагов в день");
        System.out.println("4.\tВыйти из приложения");
        System.out.print("Выберете пункт меню: ");
    }
    public void setSteps(){ // метод для ввода количества шагов за выбранный месяц
        int month;
        int day;
        int steps;
        System.out.print("Введите месяц: ");
        month = userInput();
        System.out.print("Введите день: ");
        day = userInput();
        System.out.print("Введите количество шагов за день: ");
        steps = userInput();
        if (month > 0 && day > 0){
            if (day <= 30 && month <= 12){
                month--;
                day--;
                statistic[month][day] = steps;
            } else System.out.println("Некорректный ввод: количество месяцев 12, дней в месяце - 30");

        } else System.out.println("Некорректный ввод: неверно введены месяц или день");
    }
    public void getStatisticPerMonth(){ // метод для вывода статистики за месяц

        StringBuilder stat = new StringBuilder();
        int series = 0; // подсчет для лучшей серии шагов
        int longestSeries = 0; // самая длинная серия шагов
        int dayUp; // для вывода дней из массива
        int stepsPerMonth = 0; // количество шагов в месяц
        int maxSteps = 0; // максимальное количество шагов
        int activityDays = 0; // дни активности для подсчета среднего числа шагов
        int averageNumbersOfSteps = 0; // среднее количество шагов за месяц

        System.out.print("Введите месяц: ");
        int month = userInput();
        if (month > 0 && month < 30) {
            month--;
            int[] currentMonth = statistic[month];

            for(int days = 0; days < currentMonth.length; days++){
                dayUp = days + 1;
                stat.append(dayUp).append(" день: ").append(currentMonth[days]);
                if (days < currentMonth.length - 1){
                    stat.append(", ");
                } else stat.append(".");

                stepsPerMonth += currentMonth[days]; // накопление шагов за месяц
                if (maxSteps < currentMonth[days]) maxSteps = currentMonth[days];// максимальное количество дней
                if (currentMonth[days] > 0) {
                    activityDays++; //дни активности для вычисления среднего количества шагов
                }
                if (currentMonth[days] >= stepsTarget) {
                    series++;
                    if (series > longestSeries) {
                        longestSeries = series;
                    }
                } else if (currentMonth[days] < stepsTarget) {
                    series = 0;
                }
            }

        } else System.out.println("Некорректный ввод: введенный месяц отридцательный или больше 30");

        if (activityDays > 0){
            averageNumbersOfSteps = stepsPerMonth/activityDays; // исключение случая деления
        }

        System.out.println(stat);
        System.out.println("Количество шагов за месяц: " + stepsPerMonth);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов в месяце: " + averageNumbersOfSteps);
        System.out.println("Пройденная дистанция (в км): " + converter.distancePerMonth(stepsPerMonth));
        System.out.println("Количество сожжённых килокалорий: " + converter.caloriesCount(stepsPerMonth));
        System.out.println("Лучшая серия (дни): " + " " + longestSeries);
    }
    public void printMessage(String message){
        System.out.println(message);
    }
    public int userInput(){ // метод для обработки ввода пользователя
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        try{
            userInput = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Некорректный ввод");
        }
        return userInput;
    }

}
