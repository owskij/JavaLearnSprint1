public class Converter {
    public int covertToKm(int steps){
        return steps * 75 / 100000;
    }

    public int convertStepsToKilocalories(int steps){
        return steps * 50 / 1000;
    }
}
