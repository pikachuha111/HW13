import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu implements ResultOperationHistory {
    Scanner sc = new Scanner(System.in);
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Subtraction subtraction = new Subtraction();
    Addition addition = new Addition();
    private double one;
    private double two;
    private int operationCounter = 0;
    private String symbolOperation;
    private Double res;
    private ArrayList<Double> history = new ArrayList<>();
    private ArrayList<Double> multiplicationList = new ArrayList<>();
    private ArrayList<Double> divisionList = new ArrayList<>();
    private ArrayList<Double> subtractionList = new ArrayList<>();
    private ArrayList<Double> additionList = new ArrayList<>();
    private HashMap<String, ArrayList<Double>> map = new HashMap<>();

    public Menu() {

    }

    public void answer() {
        try {
            menuOperation();
        } catch (unvalidMenuException e) {
            sc.next();
            answer();
        }
    }

    private void menuOperation() throws unvalidMenuException {
        System.out.println("Калькулятор работает");
        System.out.println("Для подсчета мат операции введите - 1");
        System.out.println("Для вывода истории операций введите - 2");
        System.out.println("Для вывода истории операций по символам введите - 3");
        System.out.println("Для выхода введите - 0");
        razdelitel();
        while (!sc.hasNext("0")) {
            if (sc.hasNext("1")) {
                result();
            } else if (sc.hasNext("2")) {
                outputHistory();
                sc.next();
                menuOperation();
            } else if (sc.hasNext("3")) {
                historyOperation();
                menuOperation();
            } else {
                throw new unvalidMenuException();
            }
        }
    }

    private void result() throws unvalidMenuException {
        firstNumber();
        secondNumber();
        System.out.println("Введите мат операцию");
        res = whichMethod();
        razdelitel();
        System.out.println("Результат " + res);
        razdelitel();
        addResulHistory();
        operationCounter++;
        menuOperation();
    }

    private void historyOperation() {
        if (map.isEmpty()) {
            System.out.println("История операция пуста");
            razdelitel();
            sc.next();
        } else {
            boolean ans = false;
            char oper;
            System.out.println("Для вывода операций введите символы ( + , - , * , / )");
            sc.next();
            while (!ans) {
                switch (oper = sc.next().charAt(0)) {
                    case '+':
                        System.out.println("История операций сложения: ");
                        System.out.println(map.get("+"));
                        razdelitel();
                        ans = true;
                        break;
                    case '-':
                        System.out.println("История операций вычетания: ");
                        System.out.println(map.get("-"));
                        razdelitel();
                        ans = true;
                        break;
                    case '/':
                        System.out.println("История операций деления: ");
                        System.out.println(map.get("/"));
                        razdelitel();
                        ans = true;
                        break;
                    case '*':
                        System.out.println("История операций умножения: ");
                        System.out.println(map.get("*"));
                        razdelitel();
                        ans = true;
                        break;
                    default:
                        System.out.println("Вы ввели невалидную операцию");
                }
            }
        }
    }

    private void firstNumber() {
        System.out.println("Введите 1ый символ");
        sc.next();
        one = numbers();
    }

    private void secondNumber() {
        System.out.println("Введите 2ой символ");
        two = numbers();
    }

    private double numbers() {
        double number = 0;
        while (!sc.hasNextDouble()) {
            System.out.println("Вы ввели неверное число");
            sc.next();
        }
        return number = sc.nextDouble();
    }

    private void symbol() throws outOfMathOperation {
        boolean ans = false;
        char oper;
        while (!ans) {
            switch (oper = sc.next().charAt(0)) {
                case '+':
                    this.symbolOperation = "Addition";
                    ans = true;
                    break;
                case '-':
                    this.symbolOperation = "Subtraction";
                    ans = true;
                    break;
                case '/':
                    this.symbolOperation = "Division";
                    ans = true;
                    break;
                case '*':
                    this.symbolOperation = "Multiplication";
                    ans = true;
                    break;
                default:
                    throw new outOfMathOperation();
            }
        }
    }

    private double whichMethod() {
        try {
            symbol();
        } catch (outOfMathOperation e) {
            System.out.println("Введите валидный символ ( + , - , * , / )");
            whichMethod();
        }
        String method = this.symbolOperation;
        if (method.equals("Multiplication")) {
            multiplicationList.add(multiplication.action(one, two));
            map.put("*", multiplicationList);
            return multiplication.action(one, two);
        } else if (method.equals("Division")) {
            divisionList.add(division.action(one, two));
            map.put("/", divisionList);
            return division.action(one, two);
        } else if (method.equals("Addition")) {
            additionList.add(addition.action(one, two));
            map.put("+", additionList);
            return addition.action(one, two);
        } else {
            subtractionList.add(subtraction.action(one, two));
            map.put("-", subtractionList);
            return subtraction.action(one, two);
        }
    }

    public void outputHistory() {
        razdelitel();
        System.out.println("История операций");
        razdelitel();

        for (Double value : history) {
            System.out.println(value);
        }
        razdelitel();
    }

    public void addResulHistory() {
        history.add(res);
    }

    public void razdelitel() {
        System.out.println("---------------------------");
    }


}
