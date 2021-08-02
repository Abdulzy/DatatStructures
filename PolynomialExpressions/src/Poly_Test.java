/*
 * Abdulrahman Isegen
 * 10/19/19
 * Homework 2
 * Polynomial class
 */
public class Poly_Test {

	public static void main(String[] args) {
		Polynomial first = new Polynomial();
		System.out.println("First poly: " + first.toString());
		
		Polynomial second = new Polynomial(5.1);
		System.out.println("Second poly: " + second.toString());
		
		System.out.println();
		Polynomial third = new Polynomial(9.6);
		third.add_to_coef(85.65, 3);
		third.add_to_coef(452, 2);
		third.add_to_coef(79, 1);
		System.out.println("Third poly: " + third.toString());
		third.add_to_coef(12.5, 5);
		third.add_to_coef(15.0, 4);
		System.out.println("\nThird poly with changed coeff: " + third.toString() + "\n");
		third.add_to_coef(25, 1);


		System.out.println("Thirds coefficient for the power of 4: " + third.coefficient(4));
		System.out.println("Thirds coefficient for the power of 8: " + third.coefficient(8));
		System.out.println("\nThird poly with changed coeff: " + third.toString());
		
		second.add_to_coef(2.0, 2);

		System.out.println();
		
		
		third.assign_coef(98, 3);
		third.assign_coef(12, 4);
		third.assign_coef(12, 5);
		
		System.out.println();
		System.out.println("Second poly: " + second.toString());
		System.out.println("Third poly: " + third.toString());
		
		second.add_to_coef(38, 4);
		
		
		Polynomial fourth = second.add(third);
		System.out.println("Second poly plus third poly: " + fourth.toString());
		
		
		
		Polynomial fifth = new Polynomial(36);
		fifth.add_to_coef(12, 2);
		fifth.add_to_coef(1, 3);
		System.out.println("\nThe fifth poly is: " + fifth.toString());
		double eval = fifth.eval(2);
		System.out.println("The fifth poly evaluated with x=2: " + eval);
		
		
		
		Polynomial sixth = new Polynomial(4);
		sixth.add_to_coef(2, 2);;
		sixth.add_to_coef(3, 1);
		
		Polynomial seven = new Polynomial(7);
		seven.add_to_coef(5, 2);
		seven.add_to_coef(-1, 1);
		
		System.out.println("\nThe sixth poly is: " + sixth.toString());
		System.out.println("\nThe seventh poly is: " + seven.toString());
		
		Polynomial mult = sixth.multiply(seven);
		System.out.println("\nThe sixth and seventh poly multiplied is: " + mult.toString());
		
		
	}
	
	
	

}
