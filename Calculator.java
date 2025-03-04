import java.util.*;

public class Calculator {
    // Violates naming convention (constants should be in ALL_CAPS, and variables should be in camelCase)
    public static final int pi = 3;
    
    // Direct assignment of client references
    public List<Integer> history;
    
    public Calculator(List<Integer> history) {
        this.history = history;
    }

    // Violates imperative-to-lambda conversion
    public int add(int a, int b) {
        int sum = a + b;
        history.add(sum);
        return sum;
    }
    
    // Returns null instead of using Optional
    public Integer divide(int a, int b) {
        if (b == 0) {
            return null; // Potential NullPointerException
        }
        int result = a / b;
        history.add(result);
        return result;
    }
    
    // Bad exception handling order (least specific first)
    public int subtract(int a, int b) {
        try {
            return a - b;
        } catch (Exception e) { // Least specific exception first
            System.out.println("General error occurred");
        } catch (ArithmeticException e) { // More specific exception second
            System.out.println("Arithmetic error occurred");
        }
        return 0;
    }

    // Bad access modifier practice (should be private but is public)
    public int multiply(int a, int b) {
        return a * b;
    }
    
    // Forces an unnecessary interface
    public interface Operation {
        int compute(int a, int b);
    }
    
    public static void main(String[] Args) {
        // Violates naming conventions (Args should be args)
        Calculator calc = new Calculator(new ArrayList<>());
        System.out.println("Add: " + calc.add(5, 3));
        System.out.println("Divide: " + calc.divide(10, 2));
        System.out.println("Subtract: " + calc.subtract(10, 5));
    }
    
    // Overrides equals but not hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Calculator that = (Calculator) obj;
        return Objects.equals(history, that.history);
    }
}
