/**
 * This QuadraticExpression class creates quadratic expressions with coefficients
 * a, b, c and can check if the expression if there are roots and can return
 * the largest and smallest roots.
 * @author Abdulrahman Isegen
 * @since 2019-09-13
 *
 */
public class QuadraticExpression implements Cloneable {

    private double a;
    private double b;
    private double c;

    /**
     * Default Contructor that initializes all
     * variables to 0
     */
    QuadraticExpression(){
        a = 0;
        b = 0;
        c = 0;
    }

    /**
     * Constructor that initializes the coefficients
     * with those given in the parameters
     * @param a
     * @param b
     * @param c
     */
    QuadraticExpression(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

    }

    /**
     *
     * @return quadratic expression
     * as string depending on coefficients
     */
    public String toString() {
        String eqn = "";
        if(this.a == 0.0 && this.b == 0.0 && this.c == 0.0) {
            eqn = "0";
        }else if(this.a == 0 && this.b == 0) {
            eqn = this.c + "";
        }
        else if(this.a == 0) {
            eqn = this.b + "x + " + this.c;
        }
        else if(this.b == 0.0) {
            eqn = this.a + "x^2 + " + this.c;
        }
        else if(this.c == 0.0) {
            eqn = this.a + "x^2 + " + this.b + "x";
        }
        else if(this.a == 0  && this.c == 0.0) {
            eqn = this.b + "x ";
        }else if(this.b == 0 && this.c == 0){
            eqn = this.a + "x^2 ";
        }else {
            eqn = this.a + "x^2 + " + this.b + "x + " + this.c;
        }
        return eqn;
    }

    /**
     * evaluate method that x
     * @param x
     * @return the value of the expression at x
     */

    public double evaluate(double x) {
        return (this.a * x * x) + (this.b * x) + this.c;
    }
    /**
     * @param newA A double
     * sets new value of A
     */
    public void setA(double newA) {
        this.a = newA;
    }
    /**
     * @param newB A double
     * sets new value of B
     */
    public void setB(double newB) {
        this.b = newB;
    }
    /**
     * @param newC A double
     * sets new value of C
     */
    public void setC(double newC) {
        this.c = newC;
    }
    /**
     *  @param q1 A quadratic expression
     *  @param q2 A quadratic expression
     *  @returns a new expression that is the sum of the q1 and q2
     */
    public static QuadraticExpression sum( QuadraticExpression q1, QuadraticExpression q2) {

        QuadraticExpression q = new QuadraticExpression();
        q.a = q1.a + q2.a;
        q.b = q1.b + q2.b;
        q.c = q1.c + q2.b;
        return q;

    }
    /**
     * @param q A quadratic expression
     * @param r A constant
     * @returns a new expression that is r times q
     */
    public static QuadraticExpression scale(double r, QuadraticExpression q) {
        QuadraticExpression q1 = new QuadraticExpression();
        q1.a = r * q.a;
        q1.a = r * q.b;
        q1.a = r * q.c;
        return q1;

    }
    /**
     * @returns the number of roots
     * the expression has depending on
     * the coefficients of the expression
     */
    public int numberOfRoots() {
        int roots;

        if(this.a == 0 && this.b == 0 && this.c ==0) {
            roots = 3;
        }
        else if( ((this.b * this.b) - (4 * this.a * this.c)) > 0 ) {
            roots = 2;
        }else if( ((this.b * this.b) - (4 * this.a * this.c)) < 0 ) {
            roots = 0;
        }
        else if ((this.a == 0 && this.b == 0)) {
            roots = 0;
        }
        else {
            roots = 1;
        }

        return roots;
    }


    /**
     * add q to the calling expression object
     * @param q A quadratic expression
     */
    public void add( QuadraticExpression q) {
        this.a = this.a + q.a;
        this.b = this.b + q.b;
        this.c = this.c + q.c;
    }

    /**
     * Depending on the equation ax^2 + bx + c = 0:
     * finds the smaller of the roots
     * @return Returns the smaller root of the equation
     * @throws Exception Raises exception if number of roots is zero
     */
    public double smallerRoot() throws Exception{
        int roots = numberOfRoots();
        double smallest = 0;
        if(roots == 0) {
            throw new Exception("No solution, thus no small root");
        }else if( roots == 1) {
            smallest = ((-this.b) / (2 * this.a));
        }else if( roots == 2) {
            smallest = (-this.b - Math.sqrt(((this.b *this.b)) - (4*this.a*this.c)))/(2*this.a);
        }else {
            smallest = -Double.MAX_VALUE;
        }

        return smallest;

    }
    /**
     * Depending on the equation ax^2 + bx + c = 0:
     * finds the larger of the roots
     * @return Returns the larger root of the equation
     * @throws Exception Raises exception if number of roots is zero
     */
    public double largerRoot() throws Exception{
        int roots = numberOfRoots();
        double largest = 0;
        if(roots == 0) {
            throw new Exception("No solution, thus no small root");
        }else if( roots == 1) {
            largest = ((-this.b) / (2 * this.a));
        }else if( roots == 2) {
            largest = (-this.b + Math.sqrt(((this.b *this.b)) - (4*this.a*this.c)))/(2*this.a);
        }else {
            largest = Double.MAX_VALUE;
        }

        return largest;

    }
    /**
     * Compares the the object that called the method and the param
     * @param obj A quadratic expression obj
     * @return true if two expressions have same a, same b and same c
     */
    public boolean equals(Object obj) {

        if( obj instanceof QuadraticExpression) {
            QuadraticExpression check = (QuadraticExpression) obj;
            return (check.a == this.a) && (check.b == this.b) && (check.c == this.c);

        }
        else {
            return false;
        }
    }

    /**
     * @return a copy of the calling object
     */
    protected QuadraticExpression clone() throws CloneNotSupportedException{
        QuadraticExpression copy;
        try {
            copy  = (QuadraticExpression) super.clone();
        }
        catch(CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }
        return copy;
    }



}
