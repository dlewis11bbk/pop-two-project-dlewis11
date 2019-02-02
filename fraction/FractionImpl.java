package fraction;
import java.lang.Math.*;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */

    private int numerator;
    private int denominator;

    public FractionImpl(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.normalise();
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // TODO
        // string white space at front and end
        String f = fraction.trim();
        // split string at "/"
        String[] mystring = new String[2];
        mystring = f.split("/");
        // numerator is part 1
        // System.out.println(mystring[0]);
        // denominator is part 2
        // System.out.println(mystring[1]);
        this.numerator = Integer.parseInt(mystring[0]);
        this.denominator = Integer.parseInt(mystring[1]);

        this.normalise();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        /*
        FractionImpl temp;
        temp = new FractionImpl(f.toString());
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        return new FractionImpl(a * d - b * c, b * d);
        */

        FractionImpl temp;
        temp = new FractionImpl(f.toString());
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        temp.numerator = a * d - b * c;
        temp.denominator = b * d;
        temp.normalise();
        return temp;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        // (a/b) * (c/d) is (a*c)/(b*d)
        FractionImpl temp;
        temp = new FractionImpl(f.toString());
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        temp.numerator = a * c;
        temp.denominator = b * d;
        temp.normalise();
        return temp;
    }


    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }


    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * @inheritDoc
     */
    private void normalise() {
        int i;

        if (this.denominator == 0){
            throw new ArithmeticException("Divide by zero!");
        }

        i = this.GCD(Math.abs(this.numerator), Math.abs(this.denominator));

        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
        this.numerator /=  i;
        this.denominator /= i;
    }


    /**
     * @inheritDoc
     */
    public int GCD(int a, int b) {
        while (a != 0 && b != 0) {
            // System.out.println(a + " " + b);
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return (a == 0) ? b : a;
    }
}
