public class Subtraction implements Calculator {
    public Subtraction() {
    }

    @Override
    public double action(double one, double two) {
        return resultSubtraction(one, two);

    }
    private double resultSubtraction(double one, double two){
        double result = one - two;
        return result;
    }
}
