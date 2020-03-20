package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomialSolverTest {

	@Test
	void testPolynomialSolver1() {
		PolynomialSolver test = new PolynomialSolver();
		int[][] a1 = {{5,4},{1,2}};
		int[][] b1 = {{1,2,4},{3,1,0}};
		int[][] c1 = {{1,4,7,4},{3,2,1,0}};
		int[][] d1 = {{-1,4,3,-4},{3,2,1,0}};
		int[][] e1 = {{4,5,8,26,20},{5,4,3,2,1}};


       test.setPolynomial('a',a1);
       test.setPolynomial('b', b1);
       int[][] add = test.add('a','b');
       assertArrayEquals(add,c1);
       int[][] sub = test.subtract('a','b');
       assertArrayEquals(sub,d1);
       int[][] mult = test.multiply('a','b');
       assertArrayEquals(mult,e1);
       assertEquals(test.evaluatePolynomial('a',2),26.0);
	   assertThrows(RuntimeException.class,()->test.setPolynomial('f',a1));
	   assertThrows(RuntimeException.class,()->test.setPolynomial('5',a1));
	   assertThrows(RuntimeException.class,()->test.multiply('f','a'));
	   
	   assertThrows(RuntimeException.class,()->test.evaluatePolynomial('c',2));

       
       
	}
	
	
       void testPolynomialSolver2() {
    	   
    	   
   		PolynomialSolver test2 = new PolynomialSolver();
    	   
    	   
        int[][] a2 = {{3,-1,5},{-2,7,0}};
		int[][] b2 = {{1,-1,-3},{3,-4,0}};
		int[][] c2 = {{1,4,7,4},{3,2,1,0}};
		int[][] d2 = {{-1,-1,8,3,1},{7,3,0,-2,-4}};
		int[][] e2 = {{-1,3,6,3,-15,-9,-5,-3},{10,7,3,1,0,-2,-4,-6}};
	
		  test2.setPolynomial('a',a2);
	       test2.setPolynomial('b', b2);
	       int[][] add = test2.add('a','b');
	       assertArrayEquals(add,c2);
	       int[][] sub = test2.subtract('a','b');
	       assertArrayEquals(sub,d2);
	       int[][] mult = test2.multiply('a','b');
	       assertArrayEquals(mult,e2);
	       assertEquals(test2.evaluatePolynomial('a',1),7);
	       
		   assertThrows(RuntimeException.class,()->test2.add('a','c'));
		   assertThrows(RuntimeException.class,()->test2.subtract('a','c'));


		   assertThrows(RuntimeException.class,()->test2.setPolynomial('5',a2));
		   assertThrows(RuntimeException.class,()->test2.multiply('0','a'));
		   
		   assertThrows(RuntimeException.class,()->test2.evaluatePolynomial(' ',2));
	}
	
	
	
	
	
	
	
	
	
	
	

}