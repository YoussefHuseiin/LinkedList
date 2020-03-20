package eg.edu.alexu.csd.datastructure.linkedList;

public class SLinkedList implements ILinkedList {
	public class ListNode {
		  public Object element;
		  public ListNode next = null;
		}
	private  ListNode head = null;
	private int size =0;
	public void add(int index, Object element) {
		  
		  ListNode i = head;
		  ListNode newNode = new ListNode();
		  newNode.element=element;
		  if(index==0) {
			  newNode.next=head;
			  head=newNode;
			  size++;
		  }
		  else if(index<=size && index>=0){ 
			  for(int count=0;count<index-1;count++) {
				  i=i.next;
			  }
			  newNode.next=i.next;
			  i.next=newNode;
			  size++;  
		}
		  else { 
			  throw new RuntimeException("Out of bounds");
			  }
		}
	public void add(Object element) {
		ListNode i =head;
		ListNode newNode = new ListNode();
		  newNode.element=element;
		  if(size==0) {
			  head=newNode;
			  size++;
		  } else {
		  while(i.next != null) {
			  i=i.next;
		  }
		  newNode.next=null;
		  i.next=newNode;
          size++;	
		  } }
	public Object get(int index) {
		if (index >= size || index <0 ) {
			return null;
		}
		else {	ListNode i=head;
		for(int j=0;j<index;j++) {
			i=i.next;
		}
		return i.element;
	} 
		}
	public void set(int index, Object element) {
		ListNode i=head;
		if(index<size && index >=0) {
		for(int j=0;j<index;j++) {
			i=i.next;
		} 
		i.element =element;
	}
		else throw new RuntimeException("Out of bounds");
		}
	public void clear() {
		head =null;
	    size =0;
	}
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void remove(int index) {
		if(index<size && index >=0) {
			ListNode i = head;
			ListNode k = new ListNode();
			if(index==0) {
				head=i.next;
			}
			else  {
			for(int j=0;j<index-1;j++) {
				i=i.next;
						   }
			k=i.next;
			i.next=k.next;
		} 
		size--;
		}
		else throw new RuntimeException("Out of bounds");
	}
	public int size() {
		return size;
	}
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SLinkedList list = new SLinkedList();
		ListNode i=head;
		if(toIndex<fromIndex || fromIndex <0 || toIndex <0) {
			throw new RuntimeException("Error");
		}else if(toIndex>=size && fromIndex >=0) {
			for(int j=0;j<fromIndex;j++) {
				i=i.next;
			}
			list.head=i;
			list.size=size-fromIndex;
			return (ILinkedList) list;
		}
		else if(toIndex<size && fromIndex>=0) {
			for(int j=0;j<fromIndex;j++) {
				i=i.next;
			}
			list.head=i;
			list.size=toIndex-fromIndex;
			return (ILinkedList) list;
		}
		return null;
	}
	public boolean contains(Object o) {
		ListNode i = head;
		int flag=0;
		for(int j=0;j<size;j++) {
			if(i.element==o) {
				flag=1;
				break;
			}else {
				i=i.next;
			}
		}
		if (flag==0) {
			return false;
		}
		else {
			return true;
		}
	}
}
		

