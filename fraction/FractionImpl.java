package fraction;
/**
 * Implementation of Fraction interface for POP2 coursework
 * Representing fractions of the form numerator and denominator
 * The instance objects are immutable.
 */
public final class FractionImpl implements Fraction {
    // Instance variables can only be set once.
    private final int numerator;
    private final int denominator;

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em> of a fraction.
     * Fraction are created in a normalised form.
     * If the parameters are <pre>(8, -12)</pre>, a <pre>fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre> is created. i.e. negative fractions can be created
     * by using a negative numerator or denominator.
     * Using both a negative numerator and denominator results in a positive fraction.
     * The constructor throws an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator the numerator of the fraction
     * @param denominator the denominator of the fraction
     */
    public FractionImpl(int numerator, int denominator) {
        // Note: ArithmeticException is subclass of RunTimeException
        // So we don't have to explicitly state "throws" in signature
        this.checkZeroD(denominator);
        Tuple f = new Tuple(numerator, denominator);
        this.manage_negs(f);
        this.normalise(f);
        this.numerator = f.n;
        this.denominator = f.d;
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Space characters are allowed around (but not within) integers.
     * The constructor throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * negative fractions can be created
     * by using a negative numerator or denominator.
     * Using both a negative numerator and denominator results in a positive fraction.
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // Note: ArithmeticException is subclass of RunTimeException
        // So we don't have to explicitly state "throws" in signature
        final int NUM_POS = 0;
        final int DENOM_POS = 1;
        String[] fracSplit = fraction.trim().split("/");
        // Only numerator is given in string
        // In this case can be a zero
        if (fracSplit.length == 1){
            this.numerator = Integer.parseInt(fracSplit[NUM_POS]);
            this.denominator = 1;
        }
        // Numerator and denominator given in string
        else {
            int n, d;
            d = Integer.parseInt(fracSplit[DENOM_POS]);
            this.checkZeroD(d);
            n = Integer.parseInt(fracSplit[NUM_POS]);
            Tuple f = new Tuple(n, d);
            this.manage_negs(f);
            this.normalise(f);
            this.numerator = f.n;
            this.denominator = f.d;
        }
    }

    /**
     * A helper class to make passing
     * two int vars convenient
     */
    private static class Tuple {
        private int n;
        private int d;

        private Tuple(int a, int b){
            this.n = a;
            this.d = b;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl temp = (FractionImpl) f;
        int a, b, c, d;
        a = this.numerator;
        b = this.denominator;
        c = temp.numerator;
        d = temp.denominator;
        return new FractionImpl(a * d + b * c, b * d);
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
        return new FractionImpl(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(-this.numerator, this.denominator);
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

    /**
     * This method returns:
     * A negative int if this is less than o.
     * Zero if this is equal to o.
     * A positive int if this is greater than o
     */
    @Override
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
     * Manages constructor with denominator given as zero
     *
     * @param d an integer representing a denominator
     * @exception ArithmeticException
     */
    private void checkZeroD(int d){
        if (d == 0){
            throw new ArithmeticException("Divide by zero!");
        }
    }

    /**
     * Normalises a fraction. A helper method.
     *
     * @param f a Tuple representing a numerator and denominator
     */
    private void normalise(Tuple f) {
        int i;
        i = this.GCD(Math.abs(f.n), Math.abs(f.d));
        f.n = f.n / i;
        f.d = f.d / i;
    }

    /**
     * Manages how a negative is stored in a fraction. A helper method.
     *
     * @param f a Tuple representing a numerator and denominator
     */
    private void manage_negs(Tuple f) {
        // If the denominator is negative
        // and i) the numerator is negative then both become positive
        // and ii) the numerator is not negative then both signs are flipped
        if (f.d < 0) {
            f.n *= -1;
            f.d *= -1;
        }
    }

    /**
     * Finds the greatest common divisor using Euclid's algorithm
     *
     * @param a an integer
     * @param b an integer
     * @return greatest common divisor of a an b
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

}
