public class Division implements Calculator {
    public Division() {
    }

    @Override
    public double action(double one, double two) {
        return resultDivision(one, two);
    }

    private double resultDivision(double one, double two) {
        double result = one / two;
        return result;
    }
}
