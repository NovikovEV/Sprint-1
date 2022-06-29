public class Converter {
    final double STRIDE_LENGTH; // длинна шага
    final int CALORIES_PER_STEP; // количество калорий на 1 шаг
    final int CALORIES_TO_KCALORIES; // количество калорий в 1 килокалории
    final int METERS_TO_KILOMETERS; // количество метров в километре
    Converter(){
        STRIDE_LENGTH = 0.75;
        CALORIES_PER_STEP = 50;
        CALORIES_TO_KCALORIES = 1000;
        METERS_TO_KILOMETERS = 1000;
    }
    public int caloriesCount(int stepsPerMonth){
        return  (stepsPerMonth * CALORIES_PER_STEP)/CALORIES_TO_KCALORIES;
    }
    public double distancePerMonth(int stepsPerMonth){
        return (stepsPerMonth * STRIDE_LENGTH)/METERS_TO_KILOMETERS;
    }
}
