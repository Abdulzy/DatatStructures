/*
 * Abdulrahman Isegen
 * 10/19/19
 * Homework 2
 * Polynomial class
 */
public class Polynomial {
	
	double[] coef ;
	
    public Polynomial(){
        coef = new double[1];
        coef[0] = 0;
    }
    public Polynomial(double x){
        coef = new double[1];
        coef[0] = x;
        
    }
    
    public Polynomial(Polynomial p){
        
    	Polynomial x = new Polynomial();

        for(int i = 0; i < p.coef.length-1; i++){
            x.coef[i] = p.coef[i];
        }
        this.coef = x.coef;
    }
    
    public String toString() {
    	String p = "";
    	for(int i = this.coef.length-1; i >= 0; i--) {
    		if(coef[i] != 0) {
    			if(i > 0 && i != 1) {
    				p = p + coef[i] + "x^" + i;
    				p = p + " + ";
    			}
    			else if(i == 1){
    				p = p + coef[i] + "x";
    				p = p + " + ";}
    			else {
    				p = p + coef[0];
    			}
    		}
    		
    	}
    	if(p.equals("")) {
    		p = "0.0";
    		}
    	return p;
    }
    
    public void add_to_coef(double amount, int exponent){
        
    	Polynomial x = new Polynomial();
        boolean expanding = true;
        
        if(exponent > coef.length) {
        	
        	x.coef = new double[exponent+1];
        	x.coef[exponent ] = amount;
        }else {
        	x.coef = new double[this.coef.length + 1];
        	expanding = false;
        }

        for(int i = coef.length - 1; i >= 0; i--){
            x.coef[i] =
            		this.coef[i] ;
        }
        
        if(expanding == false) {
        	x.coef[exponent] = amount;
        }
        
        this.coef = x.coef;
    }
    
    
    
    public double coefficient(int exponent) {
    	
    	if (this.coef.length >= exponent){
            return this.coef[exponent];
        }
        return 0;
    }
    
    public void assign_coef(double coefficient, int exponent){
        this.coef[exponent] = coefficient;
    }

    
    public Polynomial add(Polynomial p) {
    	Polynomial newPolynomial = new Polynomial();
    	
    	newPolynomial.coef = new double[Math.max(this.coef.length, p.coef.length)];
    	
    	for (int i = 0; i < this.coef.length; i++) {
    		newPolynomial.coef[i] += this.coef[i];
    	}
        for (int i = 0; i < p.coef.length ; i++) {
        	newPolynomial.coef[i] += p.coef[i];
        }
        
        return newPolynomial;
    	
    }
    
    
    
    
    public double eval(double x){
        double ans = 0;
        for(int i = 0; i <= this.coef.length - 1; i++){
        	double product = 1;
        	for(int j = 0; j < i; j++) {
        		product = product * x;
        	}
        	ans = ans + coef[i]*product;
        }
        return ans;
    }
    
   public Polynomial multiply(Polynomial p) {
	   Polynomial p1 = new Polynomial();
	   p1.coef = new double[p.coef.length + this.coef.length];
	   for (int i = 0; i <= this.coef.length - 1; i++)
           for (int j = 0; j <= p.coef.length-1 ; j++)
               p1.coef[i+j] += (this.coef[i] * p.coef[j]);
       return p1;
   }
    
    
    
}
