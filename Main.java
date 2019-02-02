import fraction.*;
public class Main {

    public static void lineprint(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - ");
    }

    public static void main(String[] args) {
        lineprint();
        int n[] = new int[]{1, 2, 3,    5,   2,  10,    2,   4,  -4,  -4};
        int d[] = new int[]{1, 4, 12,  15,  22,  27,  300, -12,  12,  -12};
        lineprint();
        for (int i = 0;  i < n.length; i++){
            Fraction f1 = new FractionImpl(n[i], d[i]);
            System.out.println("Test " + i + ": " + f1);
        }

        lineprint();
        lineprint();
        String x = "2/20";
        FractionImpl f1 = new FractionImpl(x);
        System.out.println(f1);

        lineprint();
        x = "              4/20";
        f1 = new FractionImpl(x);
        System.out.println(f1);

        lineprint();
        x = "              5/-20";
        f1 = new FractionImpl(x);
        System.out.println(f1);

        lineprint();
        x = "              -5/20";
        f1 = new FractionImpl(x);
        System.out.println(f1);

        lineprint();
        try {
            f1 = new FractionImpl(3, 0);
        }
        catch (ArithmeticException exc){
            System.out.println(exc);
        }

        lineprint();
        try {
            f1 = new FractionImpl("23/0     ");
        }
        catch (ArithmeticException exc){
            System.out.println(exc);
        }

        lineprint();
        x = "10/20";
        f1 = new FractionImpl(x);
        Fraction f2 = new FractionImpl(1, 8);
        Fraction f3;
        f3 = f1.subtract(f2);
        System.out.println(f1 + " subtracted by " + f2 + " = " + f3);


        lineprint();
        x = "10/20";
        f1 = new FractionImpl(x);
        f2 = new FractionImpl(5, 8);
        f3 = f1.subtract(f2);
        System.out.println(f1 + " subtracted by " + f2 + " = " + f3);

        lineprint();
        f1 = new FractionImpl("1/3");
        f2 = new FractionImpl("1/4");
        f3 = f1.multiply(f2);
        System.out.println(f1 + " multiplied by " + f2 + " = " + f3);



    }
}