public class StepTrackerApp {
    public static void main(String[] args){

        StepTracker stepTracker = new StepTracker();

        stepTracker.sayHello();

        int menuItem = 0;

        while (menuItem != 4){
            stepTracker.printMenu();
            menuItem = stepTracker.userInput();

            if (menuItem == 1){
                stepTracker.setSteps();
            } else if (menuItem == 2) {
                stepTracker.getStatisticPerMonth();
            } else if (menuItem == 3) {
                stepTracker.setTargetSteps();
            }

        }

        stepTracker.sayGoodbye();

    }
}
