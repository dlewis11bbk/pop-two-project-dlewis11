package fraction;
import java.lang.Math.*;

public final class FractionImpl implements Fraction {
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

    // Fractions should be immutable
    private final int numerator;
    private final int denominator;
    private final int NUM_POS = 0;
    private final int DENOM_POS = 1;


    public FractionImpl(int numerator, int denominator) {
        int fracArray[] = this.normalise(numerator, denominator);
        this.numerator = fracArray[NUM_POS];
        this.denominator = fracArray[DENOM_POS];
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
        String fracSplit[] = fraction.trim().split("/");
        int n, d;
        if (fracSplit.length == 1){
            this.numerator = Integer.parseInt(fracSplit[NUM_POS]);
            this.denominator = 1;
        }
        else {
            n = Integer.parseInt(fracSplit[NUM_POS]);
            d = Integer.parseInt(fracSplit[DENOM_POS]);
            int fracArray[] = this.normalise(n, d);
            this.numerator = fracArray[NUM_POS];
            this.denominator = fracArray[DENOM_POS];
        }

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
        FractionImpl temp = (FractionImpl) f;
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        return new FractionImpl(a * d - b * c, b * d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        // (a/b) * (c/d) is (a*c)/(b*d)
        FractionImpl temp = (FractionImpl) f;
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        return new FractionImpl(a * c, b * d);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        // (a/b) / (c/d) is (a*d)/(b*c)
        FractionImpl temp = (FractionImpl) f;
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        return new FractionImpl(a * d, b * c);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        int a, b;
        a = this.numerator;
        b = this.denominator;
        return new FractionImpl(Math.abs(a), Math.abs(b));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int n;
        n = this.numerator;
        n = -n;
        return new FractionImpl(n, this.denominator);
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
        if (obj instanceof Fraction){
            FractionImpl f = (FractionImpl)obj;
            return (f.numerator == this.numerator &&
                    f.denominator == this.denominator);
        }
        else {
            return false;
        }
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
        // The inverse of a/b is b/a.
        return new FractionImpl(this.denominator, this.numerator);
    }

    /**
     * @inheritDoc
     */
    @Override
    /*
    This method returns:
    A negative int if this is less than o.
    Zero if this is equal to o.
    A positive int if this is greater than o
     */
    public int compareTo(Fraction o) {
        FractionImpl temp = (FractionImpl) o;
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        return ((a * d) - (c * b));
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
    private int[] normalise(int n, int d) {
        int i;
        int normFract[] = new int[2];
        if (d == 0){
            throw new ArithmeticException("Divide by zero!");
        }

        i = this.GCD(Math.abs(n), Math.abs(d));

        if (d < 0) {
            n *= -1;
            d *= -1;
        }
        normFract[0] = n / i;
        normFract[1] = d / i;
        return normFract;
    }

    /**
     * @inheritDoc
     */
    private int GCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return (a == 0) ? b : a;
    }

    /**
     * @inheritDoc
     */
    private int splitN(String s) {
        s = s.trim();
        String mystring[] = s.split("/");
        return Integer.parseInt(mystring[0]);
    }
    /**
     * @inheritDoc
     */
    private int splitD(String s) {
        s = s.trim();
        String mystring[] = s.split("/");
        return Integer.parseInt(mystring[1]);
    }


}
