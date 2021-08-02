public String toString() {
    	String polynomial = "";
    	if(this.poly.length == 0) {
    		return "0";
    	}
    	else if(this.poly.length == 1) {
    		return "" + poly[0];
    	}
    	else {
    		polynomial = Double.toString(poly[poly.length - 1]) + "x^" + Integer.toString(poly.length);
    		
    		for(int i = poly.length - 2; i >= 0; i--) {
    			if(poly[i] == 0) { continue; }
    			else if (poly[i]  > 0) { polynomial = polynomial + " + " + (poly[i]); }
    	        else if (poly[i]  < 0) { polynomial = polynomial + " - " + (-poly[i]);}
    			
    			if(i == 1 && !(poly[i] == 0)) { polynomial = polynomial + "x";}
    	        else if (i >  1 && !(poly[i] == 0)) { polynomial = polynomial + "x^" + i; };
    		}
    	}
    	return polynomial;
    }