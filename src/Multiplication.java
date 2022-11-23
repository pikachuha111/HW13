public class Multiplication implements Calculator {
    public Multiplication() {
    }

    @Override
    public double action(double one, double two) {
        return resultMultiplication(one, two);
    }

    private double resultMultiplication(double one, double two){
        double result = one * two;
        return result;
    }
}
