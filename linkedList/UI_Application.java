package eg.edu.alexu.csd.datastructure.linkedList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException ;
public class UI_Application {
	
	private static Scanner input;

	public static void main (String[] args) {
		PolynomialSolver o = new PolynomialSolver();
		while(true) {
		
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1 - Set a polynomial variable");
		System.out.println("2 - Print the value of a polynomial variable");
		System.out.println("3 - Add two polynomials");
		System.out.println("4 - Subtract two polynomials");
		System.out.println("5 - Multiply two polynomials");
		System.out.println("6 - Evaluate a polynomial at some point");   
		System.out.println("7 - Clear a polynomial variable");
		System.out.println("8 - Close the Program");
		System.out.println("====================================================================");
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//(2,2),(4,1),(3,0)(2,2),(1,4),(3,-2)
		
			try {
		input = new Scanner(System.in);
		int number = input.nextInt();
		
		switch (number) {
		
		case 1 :    System.out.println("Insert the variable name: A, B or C");
		            char poly = input.next().charAt(0);
		            if(poly == 'A'|| poly == 'B'|| poly == 'C'|| poly == 'a'|| poly == 'b'|| poly == 'c') {
	 	            System.out.println("Insert the polynomial terms in the form:\r\n" + 
	 	   		    "(coeff1, exponent1), (coeff2, exponent2), ..");
	 	            try {
                    String terms = input.next();
                    String[] Sarr = terms.split(",") ;
                   
                     for (int i=0 ; i< Sarr.length; i+=2) {
                       Sarr[i] = Sarr[i].replace('(' ,' ');
                       Sarr[i] = Sarr[i].trim();
                     }
                    for (int i=1 ; i< Sarr.length; i+=2) {
                       Sarr[i] = Sarr[i].replace(')' ,' ');
                       Sarr[i] = Sarr[i].trim();
                     }
                    int [][] arr = new int [2][Sarr.length/2];
                    int k=1,l=0;
                    for(int j=0 ; j< arr[0].length ; j++) {
            	    arr[0][j]= Integer.parseInt(Sarr[l]);
            	    arr[1][j]= Integer.parseInt(Sarr[k]);
            	    k+=2; l+=2;
                    }
                    o.setPolynomial(poly , arr);
		            }
		            catch (NumberFormatException e) {
		            	System.out.println("Invalid input!");
		            }
		         	}
		            else {System.out.println("Error enter a valid character !");}
                    break ; 
 
		case 2 :  System.out.println("Insert the variable name: A, B ,C or R");
        		  char poly2 = input.next().charAt(0);
        			  if(poly2=='A'|| poly2=='a') {
            		  System.out.println(o.print('A'));}
            		  else if(poly2=='B' || poly2=='b') {
                		  System.out.println(o.print('B'));}
            		  else if(poly2=='C'|| poly2=='c'){
                		  System.out.println(o.print('C'));}
            		  else if(poly2=='R'|| poly2=='r'){
                		  System.out.println(o.print('R'));}
            		  else {
            			  System.out.println("Invalid Variable");
            		  }  
        		 
        		  break;
		
		case 3 :  System.out.println("Insert the variable name: A, B or C");
				  char poly4 = input.next().charAt(0); 
				  if(poly4 == 'A'|| poly4 == 'B'|| poly4 == 'C'|| poly4 == 'a'|| poly4 == 'b'|| poly4 == 'c' ) {
				  System.out.println("Insert the variable name: A, B or C");
				  try {
				  char poly5 = input.next().charAt(0);
				  o.add(poly4, poly5);
				  }
				  catch(Exception e) {
        			  System.out.println("Invalid Input");
				  }
				  }
				  else {
        			  System.out.println("Invalid Input");
				  }
				  break;
				  
		case 4 :  System.out.println("Insert the variable name: A, B or C");
			      char poly6 = input.next().charAt(0); 
			      if(poly6 == 'A'|| poly6 == 'B'|| poly6 == 'C'|| poly6 == 'a'|| poly6 == 'b'|| poly6 == 'c' ) {
			      System.out.println("Insert the variable name: A, B or C");
			       try {
			      char poly7 = input.next().charAt(0);
			          o.subtract(poly6, poly7);
			       }
			       catch(Exception e) {
			    	   System.out.println("Invalid Input");
			      }
			      }
			      else {
			    	  System.out.println("Invalid Input");
			      }
			      break;		  
	
		case 5 : System.out.println("Insert the variable name: A, B or C");
				 char poly8 = input.next().charAt(0); 
				 if(poly8 == 'A'|| poly8 == 'B'|| poly8 == 'C'|| poly8 == 'a'|| poly8 == 'b'|| poly8 == 'c' ) {
					 System.out.println("Insert the variable name: A, B or C");
					 try {
						 char poly9 = input.next().charAt(0);
						 o.subtract(poly8, poly9);
					 }
					 catch(Exception e) {
						 System.out.println("Invalid Input");
					 }
				 }
				 else {
					 System.out.println("Invalid Input");
				 }
				 break;
				 
		case 6 : System.out.println("Insert the variable name: A, B or C");
				 char poly3 = input.next().charAt(0); 
				 if(poly3 == 'A'|| poly3 == 'B'|| poly3 == 'C'|| poly3 == 'a'|| poly3 == 'b'|| poly3 == 'c' ) {
				 System.out.println("Enter the value of x");
				 try {
			  	 float value = input.nextFloat(); 
		  		  System.out.println(o.evaluatePolynomial(poly3, value));
				 }
				 catch(Exception e) {
				 System.out.println("Invalid Input");
				 }
				 }
				 else {
				 System.out.println("Invalid Input");
				 }
				 break;  
		
		case 7 :  System.out.println("Insert the variable name: A, B or C");
				  char poly0 = input.next().charAt(0);		
				  try {
		  	      o.clearPolynomial(poly0);
				  }
				  catch(RuntimeException e) {
				  System.out.println("Invalid Input!");}
		  	      break;	
		  	      
		case 8 : break;
		
		default :  System.out.println("Enter a number from 1 to 8"); break;
				 	  
		} 
		if(number == 8) {
			break;
		}
		}
			catch(InputMismatchException e) {
				System.out.println("Enter a number from 1 to 8");
				
			}
			
		
		}	
	}
}