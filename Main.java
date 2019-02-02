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
            FractionImpl f1 = new FractionImpl(n[i], d[i]);
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

    }
}