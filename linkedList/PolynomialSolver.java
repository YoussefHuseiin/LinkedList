package eg.edu.alexu.csd.datastructure.linkedList;

import java.awt.Point;
import java.lang.Math;

import eg.edu.alexu.csd.datastructure.linkedList.DLinkedList.Dnode;

public class PolynomialSolver implements IPolynomialSolver {
	public DLinkedList A = new DLinkedList();
	public DLinkedList B = new DLinkedList();
	public DLinkedList C = new DLinkedList();
	public DLinkedList R = new DLinkedList();
	public DLinkedList u = new DLinkedList();
	public DLinkedList v = new DLinkedList();
	
	
  public DLinkedList arrToList(int[][]arr ) {
	  DLinkedList result = new DLinkedList();
	  for (int i=0 ; i< arr[0].length ; i++) {

		  result.add(new Point (arr[0][i],arr[1][i]));  
	  }
	  return result;  
  }

  public void sort(int[][] terms){
	  int temp ;
	  for (int K=0 ; K< terms[0].length;K++) {
		  for (int j=K+1 ;j<terms[0].length;j++) {
			  if (terms[1][K]< terms[1][j]) {
				  temp= terms[1][K];
				  terms[1][K]=terms[1][j];
				  terms[1][j]=temp;
				  temp= terms[0][K];
				  terms[0][K]=terms[0][j];
				  terms[0][j]=temp;
			
			  }
		  }
	  }
  }
  public int[][]  listToArr(DLinkedList list ) {
	  Dnode i=list.head;
	 int  [][] arr = new int [2][list.size()];
	 int j=0 ;
	  while (i != null) {
		 arr[0][j]= ((Point)i.element).x ;
		 arr[1][j]= ((Point)i.element).y ; 
		  i=i.next; j++;
	  }
	  return arr;
  }
  public void setPolynomial(char poly, int[][] terms) {
	   
	  sort(terms);
	  
	  if(poly == 'A'|| poly=='a' )
      { A=arrToList(terms);} 
	  else if(poly == 'B'|| poly=='b' )
	  { B=arrToList(terms);} 
	  else if(poly == 'C'|| poly=='c' )
	  { C=arrToList(terms);}
	  else { throw new RuntimeException("Error enter a valid character!");}
	 
  }
 public String print(char poly) {
	  if(poly == 'A'|| poly=='a' )
      { u=A;} 
	  else if(poly == 'B'|| poly=='b' )
	  { u=B;} 
	  else if(poly == 'C'|| poly=='c' )
	  { u=C;}
	  else if(poly == 'R' || poly=='r')
	  { u=R;}
	  else { throw new RuntimeException("Error enter a valid character!");}
	  if(u.isEmpty()) {
		  return("This is an empty list!");
	  }
	 Dnode i = u.head;
	 String y = new String();
	 y="";
	 int p= ((Point)i.element).y;
	 while (i != null ) {
		 if (p==1 || p == 0) {
			 
			 if(p == 1) {
			 		y=y+Integer.toString(((Point)i.element).x )+"X";
			 }	 
			 else {
			 		y=y+Integer.toString(((Point)i.element).x );
			 }
			 		i=i.next;
			if(i != null) {
			  p= ((Point)i.element).y;
			  y+="+";
			}
		 }
		 else {
		  y=y+Integer.toString(((Point)i.element).x )+"X^"+Integer.toString(p);
	      i=i.next;
	      if (i != null) {
	      p = ((Point)i.element).y;
	      y+= "+";
	      }
		 }
	 }
	
	 return y ;
  }
  
 public void clearPolynomial(char poly) {
  if(poly == 'A' || poly=='a')
  { A.clear();} 
  else if(poly == 'B' || poly=='b')
  { B.clear();} 
  else if(poly == 'C' || poly=='c')
  { C.clear();}
  else { throw new RuntimeException("Error enter a valid character!");}
  }
  public float evaluatePolynomial(char poly, float value) {
	  if(poly == 'A' || poly=='a')
      { u=A;} 
	  else if(poly == 'B'|| poly=='b' )
	  { u=B;} 
	  else if(poly == 'C' || poly=='c')
	  { u=C;}
	  else { throw new RuntimeException("Error enter a valid input !");}
	  if(u.head==null) {
		  throw new RuntimeException("Error enter a valid input !");
	  }
	  else {
	  Dnode i = u.head;
	  float result=0;
	  while (i !=null ) {
		  result = (float) (result + ((((Point)i.element).x) * (Math.pow(value,(float)(((Point)i.element).y)))));
		    i=i.next;
		 }
	  return result ;
  }}
  public int[][] add(char poly1, char poly2){
	  R.clear();
	  if(poly1 == 'A' || poly1=='a')
      { u=A;} 
	  else if(poly1 == 'B' || poly1=='b')
	  { u=B;} 
	  else if(poly1 == 'C' || poly1=='c')
	  { u=C;}
	  else {throw new RuntimeException("Error enter a valid character!"); }
	  if(poly2 == 'A' || poly2=='a')
      { v=A;} 
	  else if(poly2 == 'B'|| poly2=='b')
	  { v=B;} 
	  else if(poly2 == 'C' || poly2=='c')
	 { v=C;}
	  else {throw new RuntimeException("Error enter a valid character!"); }
	  Dnode i = u.head;
	  Dnode x = v.head;
	  while (i != null && x!= null ) {
	  if(((Point)i.element).y >((Point)x.element).y) {
	  R.add(i.element);
	  i = i.next;
	  }
	  else if (((Point)i.element).y <((Point)x.element).y) {
	  R.add(x.element);
	  x=x.next;
	  }
	  else {
	   	  
	   Object a = new Object();
	   a= new Point();
	   ((Point)a).x = ((Point)i.element).x + ((Point)x.element).x ; 
	   ((Point)a).y =  ((Point)i.element).y;
		  R.add(a);
		  i=i.next;
		  x=x.next;
	  }
	  }
	  if (i == null) {
		  while (x != null) {
			  R.add(x.element);
			  x=x.next;
		  }
	  }
	   if (x == null) {
		  while (i != null) {
			  R.add(i.element);
			  i=i.next;
		  }
	  }
	   for (int t =0;t < R.size();t++ ) {
		   if( ((Point)R.get(t)).x == 0 ){
			   R.remove(t);
		   }
	   }
	   
	  return listToArr(R);
  
  }	  
 public int[][] subtract(char poly1, char poly2){
		  R.clear();
		  if(poly1 == 'A' || poly1=='a')
	      { u=A;} 
		  else if(poly1 == 'B' || poly1=='b')
		  { u=B;} 
		  else if(poly1 == 'C' || poly1=='c')
		  { u=C;}
		  else {throw new RuntimeException("Error enter a valid character!"); }
		  if(poly2 == 'A' || poly2=='a')
	      { v=A;} 
		  else if(poly2 == 'B'|| poly2=='b')
		  { v=B;} 
		  else if(poly2 == 'C' || poly2=='c')
		 { v=C;}
		  else {throw new RuntimeException("Error enter a valid character!"); }
		  Dnode i = u.head;
		  Dnode x = v.head;
		  while (i != null && x!= null ) {
		  if(((Point)i.element).y >((Point)x.element).y) {
		  R.add(i.element);
		  i = i.next;
		  }
		  else if (((Point)i.element).y <((Point)x.element).y) {
			  Object a = new Object();
			   a = new Point();  
			   ((Point)a).x = -((Point)x.element).x ; 
			   ((Point)a).y =  ((Point)x.element).y;
		  R.add(a);
		  x=x.next;
		  }
		  else {
		   	  
		   Object a = new Object();
		   a = new Point();
		   ((Point)a).x = ((Point)i.element).x - ((Point)x.element).x ; 
		   ((Point)a).y =  ((Point)i.element).y;
			  R.add(a);
			  i=i.next;
			  x=x.next;
		  }
		  }
		  if (i == null) {
			   Point temp = new Point();
			  while (x != null) {
				  temp.x=-((Point)x.element).x;
				  temp.y= ((Point)x.element).y;
				  R.add(temp);
				  x=x.next;
			  }
		  }
		   if (x == null) {
			   while (i != null) {
				  R.add(i.element);
				  i=i.next;
			  }
		  }
		   for (int t =0;t < R.size();t++ ) {
			   if( ((Point)R.get(t)).x == 0 ){
				   R.remove(t);
			   }
		   }
		   
		   
		  return listToArr(R);
	  

	  }
 public int[][] multiply(char poly1, char poly2){
	 R.clear();
	 if(poly1 == 'A' || poly1=='a')
     { u=A;} 
	  else if(poly1 == 'B' || poly1=='b')
	  { u=B;} 
	  else if(poly1 == 'C' || poly1=='c')
	  { u=C;}
	  else {throw new RuntimeException("Error enter a valid character!"); }
	  if(poly2 == 'A' || poly2=='a')
     { v=A;} 
	  else if(poly2 == 'B'|| poly2=='b')
	  { v=B;} 
	  else if(poly2 == 'C' || poly2=='c')
	 { v=C;}
	  else {throw new RuntimeException("Error enter a valid character!"); }
	
	  for (int k=0;k<u.size();k++ ) {
		  for (int j=0;j<v.size();j++) {
			   int c1=((Point)u.get(k)).x;
			   int c2=((Point)v.get(j)).x;
			   int p1 = ((Point)u.get(k)).y;
			   int p2 = ((Point)v.get(j)).y;
			   	Object a = new Object();
				 a = new Point();
			   ((Point)a).x =  c1 * c2 ; 
			   ((Point)a).y = p1 + p2 ;
				  R.add(a);
		 }
		
	  }	
	 
	  for (int k=0;k<R.size();k++ ) {
		  for (int j=k+1;j<R.size();) {
			   if( ((Point)R.get(k)).y == ((Point)R.get(j)).y ){
					Object a = new Object();
					 a = new Point();
				   ((Point)a).x = ((Point)R.get(k)).x + ((Point)R.get(j)).x ;
				   ((Point)a).y = ((Point)R.get(k)).y;
				   R.set(k, a);
				   R.remove(j);
				   continue ;
			   }
			   j++;
		  }
	  }		  
			  
	   
	   for (int i =0;i < R.size();i++ ) {
		   if( ((Point)R.get(i)).x == 0 ){
			   R.remove(i);
		   }
	   }
	   int [][] terms = new int [2][R.size()];
	   terms = listToArr(R);
	   sort(terms);
	   R=arrToList(terms);

	   
		return terms;  
	  }
 
 }