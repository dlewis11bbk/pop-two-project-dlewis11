import fraction.*;
public class Main {

    public static void lineprint(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

    public static void main(String[] args) {
        lineprint();
        System.out.println("Constructor tests for ints:");
        lineprint();
        int[] n = new int[]{1, 2, 3,    5,   2,  10,    2,   4,  -5,  -6};
        int[] d = new int[]{1, 4, 12,  15,  22,  27,  300, -12,  20,  -36};

        Fraction f1;
        for (int i = 0;  i < n.length; i++){
            f1 = new FractionImpl(n[i], d[i]);
            System.out.println("Test " + i + ": " + f1);
        }

        lineprint();
        System.out.println("Further constructor tests:");


        lineprint();
        f1 = new FractionImpl(0, 33);
        System.out.println("Expecting: 0/1 from int input 0/33");
        System.out.println(f1);

        lineprint();
        String x = "2/20";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: 1/10");
        System.out.println(f1);

        lineprint();
        x = "0/1";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: 0/1");
        System.out.println(f1);

        lineprint();
        x = "0/12";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: 0/1 from 0/12 input");
        System.out.println(f1);

        lineprint();
        x = "-4";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: -4/1 from -4 input");
        System.out.println(f1);

        lineprint();
        x = "              4/20";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: 1/5");
        System.out.println(f1);


        lineprint();
        x = "5";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: 5/1");
        System.out.println(f1);

        lineprint();
        x = "-3";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: -3/1");
        System.out.println(f1);

        lineprint();
        x = "              5/-20";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: -1/4");
        System.out.println(f1);

        lineprint();
        x = "              -5/20";
        f1 = new FractionImpl(x);
        System.out.println("Expecting: -1/4");
        System.out.println(f1);

        lineprint();
        System.out.println("Expecting: divide by zero error");
        try {
            new FractionImpl(3, 0);
        }
        catch (ArithmeticException exc){
            System.out.println(exc);
        }

        lineprint();
        System.out.println("Expecting: divide by zero error");
        try {
            new FractionImpl("23/0     ");
        }
        catch (ArithmeticException exc){
            System.out.println(exc);
        }

        lineprint();
        System.out.println("Both n & d are negative");
        System.out.println("Not specifically specified for");
        System.out.println("Creates positive fraction");
        System.out.println("Expecting: 1/3");
        f1 = new FractionImpl("-1/-3");
        System.out.println(f1);


        lineprint();
        System.out.println("Expecting: java.lang.NumberFormatException error");
        try {
            x = "              -5/2t/23";
            new FractionImpl(x);
        }
        catch (NumberFormatException exc){
            System.out.println(exc);
        }

        lineprint();
        x = "              -5/20/23";
        f1 = new FractionImpl(x);
        System.out.println("Would an error make more sense?");
        System.out.println("Not specified so leave as is...");
        System.out.println("For input string: " + x);
        System.out.println(f1);

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
        x = "5/50     ";
        f1 = new FractionImpl(x);
        f2 = f1.inverse();
        System.out.println("Expecting: inverse of 5/50 which is 10/1");
        System.out.println(f2);


        lineprint();
        f1 = new FractionImpl("0/12   ");
        System.out.println(f1);
        System.out.println("Expecting: divide by zero error 1");
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

        lineprint();
        x = "10/20";
        Fraction f4;
        FractionImpl f5;
        Fraction f6;
        f4 = new FractionImpl(x);
        f5 = new FractionImpl(2, 3);
        f6 = f4.subtract(f5);
        /*
        The variable that subtract return a value to
        must be of type Fraction.
        However the type passed to subtract can be either
        Fraction or FractionImpl
         */
        System.out.println(f4 + " subtracted by " + f4 + " = " + f6);


    }
}
