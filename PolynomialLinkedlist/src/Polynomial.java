import java.util.Objects;
/**
 * @author Abdulrahman Isegen and somtoo chukwurah
 */ 

/** 
 * The Polynomial class is a linked list of Terms, which have a double coefficient
 * and an integer degree. One can evaluate a Polynomial, add it to others,
 * multiply it by others, as well as add and remove terms.
 * @invariant The Polynomial always contains at least one node representing a constant.
 */
public class Polynomial {
    
    //Instance variable
    private TermNode first;
    
    /** @postcondition A new polynomial has been made. It represents zero. */
    public Polynomial() {
        first = new TermNode();
    }
    
    /** @postcondition A new polynomial has been made that represents a single term of degree zero.
        @param a0 the double this new polynomial will represent */
    public Polynomial(double a0) {
        first = new TermNode(0, a0, null);
    }
    
    /** @postcondition A new polynomial has been made that is a deep copy of the one passed to this constructor.
        @param p the polynomial to be copied */
    public Polynomial(Polynomial p) {
        this.first = new TermNode(p.first.getDeg(), p.first.getCoef(), null);
        TermNode pCursor = p.first.getLink();
        TermNode thisCursor = this.first;
        while(pCursor != null) {
            thisCursor.setLink(new TermNode(pCursor.getDeg(), pCursor.getCoef(), null));
            thisCursor = thisCursor.getLink();
            pCursor = pCursor.getLink();
            
        }
    }
    
    /** @postcondition Two polynomials have been added and a third one is returned.
        @param p the polynomial that is added to this one.
        @return Polynomial */
    public Polynomial add(Polynomial p) {
        Polynomial ans = new Polynomial();
        for(TermNode cursor = this.first; cursor != null; cursor = cursor.getLink())
            ans.add_to_coef(cursor.getCoef(), cursor.getDeg());
        for(TermNode cursor = p.first; cursor != null; cursor = cursor.getLink())
            ans.add_to_coef(cursor.getCoef(), cursor.getDeg());
        return ans;
    }
    
    /** @postcondition Two polynomials have been multiplied and a third one is returned.
     *  
     *  @param p the polynomial that is multiplied with this one. 
     *  @return Polynomial 
     */
    public Polynomial multiply(Polynomial p) {
        Polynomial ans = new Polynomial();
        for(TermNode thisCursor = this.first; thisCursor != null; thisCursor = thisCursor.getLink()) {
            for (TermNode pCursor = p.first; pCursor != null; pCursor = pCursor.getLink()) {
                //Adds the product of the terms to a cumulative sum.
                ans.add_to_coef(thisCursor.getCoef() * pCursor.getCoef(), thisCursor.getDeg() + pCursor.getDeg());
            }
        }
        return ans;
    }
    

    @Override
    public boolean equals(Object p) {
        if(p == this) {
            return true;
        }
        if (!(p instanceof Polynomial)) {
            return false;
        }
        Polynomial q = (Polynomial)p;
        TermNode thisCursor = this.first;
        TermNode qCursor = q.first;
        while(thisCursor != null && qCursor != null) {
            if(thisCursor.equals(qCursor)) {
                thisCursor = thisCursor.getLink();
                qCursor = qCursor.getLink();
            }
            else return false;
        }
        return true;
    }
        
    
    /** @precondition amount is nonzero
     *  @postcondition A double amount has been added to the term of the specified degree. 
     *  @param degree the degree of the term that is added to
     *  @param amount the amount added to the term */
    public void add_to_coef(double amount, int degree) {
        
        TermNode t = first.findTermWithDegree(degree);
        t.setCoef(t.getCoef() + amount);
        
    }
    
    /** @precondition amount is nonzero
     *  @postcondition The term of the specified degree has had its coefficient changed.
     *  @param degree the degree of the term to change
     *  @param amount the amount that the coefficient is changed to */
    public void set_coef(double amount, int degree) {
        
        TermNode t = first.findTermWithDegree(degree);
        t.setCoef(amount);
        
    }
    
    /** @postcondition Returns the coefficient of the specified exponent value. 
        @param exp the degree to search 
        @return double */
    public double coefficient(int exp) {
        for(TermNode t = first; t != null; t = t.getLink()){
            if (t.getDeg() == exp) {
                return t.getCoef();
            }
        }
        return 0;
    }
    
    /** @postcondition Returns the value of the polynomial with input value x.
        @param x the double value to evaluate for
        @return double */
    public double eval(double x) {
        double sum = 0.0;
        for(TermNode cursor = first; cursor != null; cursor = cursor.getLink()) {
            sum += cursor.getCoef() * Math.pow(x, cursor.getDeg());
        }
        return sum;
    }
    
    /** Returns a String representing the Polynomial.
        @return String s */
    @Override
    public String toString() {
        String s = "";
        for(TermNode cursor = first; cursor != null; cursor = cursor.getLink()) {
            s += cursor.toString();
        }
        return s;
    }
    
    /** @postcondition Terms of this Polynomial that are zero have been removed. */
    public void removeZeroTerms() {
        TermNode cursor = first;
        while(cursor != null) {
            if ((cursor.getLink().getCoef() == 0) && (cursor.getLink().getLink() != null))
                cursor.setLink(cursor.getLink().getLink());
            cursor = cursor.getLink();
        }
    }

}

class TermNode {

    //Instance variables
    private double coef;
    private int deg;
    private TermNode link;
    
    //Constructors
    public TermNode(int degree, double amount, TermNode initLink) {
        deg = degree;
        coef = amount;
        link = initLink;
    }
    public TermNode() {
        deg = 0;
        coef = 0;
        link = null;
    }
    
    /** Returns the coefficient of this term. */
    public double getCoef() {
        return coef;
    }
    
    /** Returns the degree of this term. */
    public int getDeg() {
        return deg;
    }
    
    /** Returns the link to the next term in this list. */
    public TermNode getLink() {
        return link;
    }
    
    /** Sets the link of this Term.
        @param t the TermNode that is linked to */
    public void setLink(TermNode t) {
        link = t;
    }
    
    /** Sets the coefficient of this Term. 
        @param c the double that the coefficient is set to*/
    public void setCoef(double c) {
        coef = c;
    }
    
    
    /** Returns a string representing the term. */
    @Override
    public String toString() {
        String s = "";
        if(deg > 1) {
            s += coef + "x^" + deg + " + ";
        } else if (deg == 1) {
            s += coef + "x" + " + ";
        } else if (deg == 0) {
            s += coef;
        }
        return s;
    }
    /** Finds the TermNode with the specified degree, or makes it if it does not already exist.
     *  @param exp the degree to find */
    public TermNode findTermWithDegree(int exp) {
        if(exp > deg) {
            setLink(new TermNode(deg, coef, link));
            deg = exp;
            coef = 0;
            return this;
        } else if (exp == deg) {
            return this;
        } else {
            return link.findTermWithDegree(exp);
        }
    }
    
    public void removeIfZero(){
        if(coef == 0 && deg != 0) {
            deg = link.deg;
            coef = link.coef;
            link = link.link;
        }
    }
    


}