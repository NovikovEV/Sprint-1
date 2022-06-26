public class StepTrackerApp {
    public static void main(String[] args){
        StepTracker stepTracker = new StepTracker(); //создание объекта StepTracker

        stepTracker.printMessage("Добро пожаловать в StepTracker!");

        int menuItem = 0; // переменная для выбора пункта меню

        while (menuItem != 4){
            //вызов меню
            stepTracker.printMenu();
            //обработка ввода пользователя
            menuItem = stepTracker.userInput();
            //работа с меню программы
            if (menuItem == 1){
                stepTracker.setSteps(); // ввод количества шагов по дням за выбранный месяц
            } else if (menuItem == 2) {
                stepTracker.getStatisticPerMonth(); // статистика за месяц
            } else if (menuItem == 3) {
                stepTracker.setTargetSteps(); // установка цели количества шагов
            }

        }

        stepTracker.printMessage("Программа завершила работу");

    }
}
