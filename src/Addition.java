public class Addition implements Calculator {
    public Addition() {
    }

    @Override
    public double action(double one, double two) {
        return resultAddition(one,two);
    }

    private double resultAddition(double one, double two){
        double result = one + two;
        return result;
    }
}
