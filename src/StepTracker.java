import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {
    private int stepsTarget; //цель по шагам
    private final int[][] statistic; // массив для статистики
    private final Converter converter;
    public StepTracker(){
        converter = new Converter();
        statistic = new int[12][30];
        stepsTarget = 10000;
        //инициализация статистики
        for (int[] ints : statistic) {
            Arrays.fill(ints, 0);
        }
    }
    public void setTargetSteps(){
        System.out.print("Введите цель по количеству шагов в день: ");
        int steps = userInput();
        if (steps > 0){
            stepsTarget = steps;
            System.out.println("Новая цель по количеству шагов в день: " + stepsTarget);
        }
    }
    public void printMenu(){
        System.out.println("1.\tВвести количество шагов за определённый день");
        System.out.println("2.\tНапечатать статистику за определённый месяц");
        System.out.println("3.\tИзменить цель по количеству шагов в день");
        System.out.println("4.\tВыйти из приложения");
        System.out.print("Выберете пункт меню: ");
    }
    public void setSteps(){

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
    public void getStatisticPerMonth(){
        StringBuilder stat = new StringBuilder();
        int series = 0;
        int longestSeries = 0;
        int dayUp;
        int stepsPerMonth = 0;
        int maxSteps = 0;
        int activityDays = 0;

        System.out.print("Введите месяц: ");
        int month = userInput();
        if (month > 0 && month < 30) {
            month--;
            for(int days = 0; days < statistic[month].length; days++){
                dayUp = days + 1;
                stat.append(dayUp).append(" день: ").append(statistic[month][days]);
                if (days < statistic[month].length){
                    stat.append(", ");
                } else stat.append(".");

                stepsPerMonth += statistic[month][days]; // накопление шагов за месяц
                if (maxSteps < statistic[month][days]) maxSteps = statistic[month][days];// максимальное количество дней

                if (statistic[month][days] > 0) {
                    activityDays++; //дни активности для вычисления среднего количества шагов
                }

                if (statistic[month][days] >= stepsTarget) {
                    series++;
                    if (series > longestSeries) {
                        longestSeries = series;
                    }
                } else if (statistic[month][days] < stepsTarget) {
                    series = 0;
                }

            }
        } else System.out.println("Некорректный ввод: введенный месяц отридцательный или больше 30");


        System.out.println(stat);
        System.out.println("Количество шагов за месяц: " + stepsPerMonth);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов в месяце: " + stepsPerMonth/activityDays);
        System.out.println("Пройденная дистанция (в км): " + converter.distancePerMonth(stepsPerMonth));
        System.out.println("Количество сожжённых килокалорий: " + converter.caloriesCount(stepsPerMonth));
        System.out.println("Лучшая серия (дни): " + " " + longestSeries);
    }
    public void sayHello(){
        System.out.println("Добро пожаловать в StepTracker!");
    }
    public void sayGoodbye(){
        System.out.println("Программа завершила работу");
    }
    public int userInput(){
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
