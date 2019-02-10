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

        lineprint();
        f1 = new FractionImpl("1/3");
        System.out.println(f1.splitN(f1.toString()));
        System.out.println(f1.splitD(f1.toString()));

        lineprint();
        x = "              5/-20";
        f1 = new FractionImpl(x);
        System.out.println(f1);
        System.out.println(f1.splitN(f1.toString()));
        System.out.println(f1.splitD(f1.toString()));


        lineprint();
        x = "5/50     ";
        f1 = new FractionImpl(x);
        System.out.println(f1);
        System.out.println(f1.splitN(f1.toString()));
        System.out.println(f1.splitD(f1.toString()));
        f2 = f1.inverse();
        System.out.println(f2);

        lineprint();
        f1 = new FractionImpl("0/12   ");
        System.out.println(f1);
        try {
            f1.inverse();
        }
        catch (ArithmeticException exc){
            System.out.println(exc);
        }
        // division
        lineprint();
        f1 = new FractionImpl("4/5   ");
        f2 = new FractionImpl("2/3");
        f3 = f1.divide(f2);
        System.out.println(f1 + " divided by " + f2 + " = " + f3);

        lineprint();
        f1 = new FractionImpl("4/7   ");
        f2 = new FractionImpl("2/3");
        f3 = f1.divide(f2);
        System.out.println(f1 + " divided by " + f2 + " = " + f3);

        lineprint();
        x = "              5/-20";
        f1 = new FractionImpl(x);
        f2 = f1.abs();
        System.out.println("The absolute value of " + f1 + " is " + f2);

        lineprint();
        x = "              -5/10";
        f1 = new FractionImpl(x);
        f2 = f1.abs();
        System.out.println("The absolute value of " + f1 + " is " + f2);

        lineprint();
        x = "              -5/10";
        f1 = new FractionImpl(x);
        f2 = f1.negate();
        System.out.println("The negated value of " + f1 + " is " + f2);

        lineprint();
        x = "              5/-15";
        f1 = new FractionImpl(x);
        f2 = f1.negate();
        System.out.println("The negated value of " + f1 + " is " + f2);

        lineprint();
        x = "              1/20";
        f1 = new FractionImpl(x);
        f2 = f1.negate();
        System.out.println("The negated value of " + f1 + " is " + f2);

        lineprint();
        x = " 5/20     ";
        f1 = new FractionImpl(x);
        f2 = f1.inverse();
        System.out.println("The inverse value of " + f1 + " is " + f2);

        lineprint();
        x = " 0/1     ";
        f1 = new FractionImpl(x);
        System.out.println("Attempting to invert " + f1 + " ...");
        try {
            f2 = f1.inverse();
        }
        catch (ArithmeticException exc){
            System.out.println(exc);
        }

        lineprint();
        System.out.println("Testing equals");

        lineprint();
        f1 = new FractionImpl("4/7   ");
        f2 = new FractionImpl("2/3");
        System.out.println(f1.equals(f2));

        lineprint();
        x = "I am a string ";
        f1 = new FractionImpl("4/7   ");
        System.out.println(f1.equals(x));

        lineprint();
        f1 = new FractionImpl("4/7   ");
        f2 = new FractionImpl("12/21");
        System.out.println(f1.equals(f2));

        lineprint();
        f1 = new FractionImpl("4/7   ");
        f2 = new FractionImpl("12/21");
        System.out.println(f1.equals(f2));

        lineprint();
        System.out.println("Testing compareTo:");
        lineprint();
        lineprint();
        f1 = new FractionImpl("4/7   ");
        f2 = new FractionImpl("12/21");
        System.out.println("Comparing " + f2 + " to " + f1 + ": " + f1.compareTo(f2));

        lineprint();
        f1 = new FractionImpl("1/2   ");
        f2 = new FractionImpl("3/4");
        System.out.println("Comparing " + f2 + " to " + f1 + ": " + f1.compareTo(f2));

        lineprint();
        f1 = new FractionImpl("3/6   ");
        f2 = new FractionImpl("9/12");
        System.out.println("Comparing " + f2 + " to " + f1 + ": " + f1.compareTo(f2));


        lineprint();
        f1 = new FractionImpl("9/12   ");
        f2 = new FractionImpl("3/6");
        //  return ((a * d) - (c * b)) / b * dx;
        System.out.println("Comparing " + f2 + " to " + f1 + ": " + f1.compareTo(f2));
    }
}