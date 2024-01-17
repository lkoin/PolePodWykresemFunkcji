import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Main {
    public static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Program liczy pole pod wykresem funkcji");
        double[] cofficients = getCofficients();
        displayFunction(cofficients);
        System.out.println();
        System.out.println("Podaj początek przedziału: ");
        double startInterval = scanner.nextDouble();
        System.out.println("Podaj koniec przedziału: ");
        double endInterval = scanner.nextDouble();
        System.out.println("Podaj liczbę przedziałow(im wiecej tym wieksza dokładnosc): ");
        int numberIntervals = scanner.nextInt();
        double area = calculateReactangleArea(startInterval,endInterval,numberIntervals,cofficients);
        System.out.printf("Pole pod wykresem funkcji %.3f\n",area);
    }

    public static double calculateReactangleArea(double startInterval,double endInterval,int numberIntervals,double[] cofficients) {
        double interval = (endInterval - startInterval)/numberIntervals;
        // f(x) = x^2-3x +2
        double area = 0;
        for (int i=0;i<numberIntervals;i++) {
            double temp = startInterval + i*interval;
            area += getValueFunction(cofficients,temp);
//            area += abs(pow(temp,2) - 3 * temp + 2);
//            area += abs(temp);
        }
    return (interval/2) * (getValueFunction(cofficients,startInterval) + getValueFunction(cofficients,endInterval)+ 2*area);
//    return (interval/2) * (abs(pow(startInterval,2) - 3 * startInterval + 2) + abs(pow(endInterval,2) - 3 * endInterval + 2)+ 2*area);
//    return (interval/2) * (abs(startInterval) + abs(endInterval) + 2* area);
    }

    public static double[] getCofficients() {
        System.out.println("Podaj stopien wielomianu: ");
        int degree = scanner.nextInt();
        double[] cofficients = new double[degree+1];
        System.out.println("Podaj wspolczynniki wielomianu w ilosci " + degree++);
        for (int i=0;i<degree;i++) cofficients[i] = scanner.nextDouble();
        return  cofficients;
    }

    public static void displayFunction(double[] cofficients) {
        for (int i=0;i<cofficients.length;i++) {
            int lenght = cofficients.length;
            System.out.print(cofficients[i] + " * x^" + (lenght-1-i)+ " + " );
        }
    }
    public static double getValueFunction(double[] cofficients,double valueX) {
        double valueY = 0;
        int size = cofficients.length;
        for (int i=0;i<size;i++) {
            valueY += cofficients[i] * pow(valueX,size - 1 - i);
        }
        return abs(valueY);
    }
}
