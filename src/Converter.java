public class Converter {
    final double strideLength;
    Converter(){
        strideLength = 0.75;
    }
    public int caloriesCount(int stepsPerMonth){
        return  (stepsPerMonth * 50)/1000;
    }
    public double distancePerMonth(int stepsPerMonth){
        return (stepsPerMonth * strideLength)/1000;
    }
}
