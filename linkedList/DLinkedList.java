package eg.edu.alexu.csd.datastructure.linkedList;

public class DLinkedList implements ILinkedList {
	
	public class Dnode {
		   public Object element;
		   public Dnode next = null;
		   public Dnode prev = null;
		}

	public Dnode head = null;
	public Dnode tail = null;
	public int size =0;
	
	public void add(int index, Object element) {
		if(index>=0 && index<=size) {
		Dnode i = head;
		Dnode newNode = new Dnode();
		newNode.element=element;
		if(head==null) {
			head=newNode;
			tail=newNode;
			newNode.next=null;
			newNode.prev=null;
			size++;
		}
		else if(index==0) {
			newNode.next=i;
			i.prev=newNode;
			head=newNode;
			size++;
		}
		else if(index == size) {
			add(element);
		}
		else {
		for(int j=0;j<index;j++) {
			i=i.next;
		}
		newNode.prev=i.prev;
		i.prev.next=newNode;
		newNode.next=i;
		i.prev=newNode;
		size++;
		}
	} else throw new RuntimeException("Out of bounds");
	}
	public void add(Object element) {
		Dnode i = head;
		Dnode newNode = new Dnode();
		newNode.element=element;
		if(head==null) {
			head=newNode;
			tail=newNode;
			newNode.next=null;
			newNode.prev=null;
			size++;
		}
		else {
			for(int j=0;j<size-1;j++) {
				i=i.next;
			}
			i.next=newNode;
			newNode.prev=i;
			tail=newNode;
			newNode.next=null;
			size++;
		}
		
		
	}
	public Object get(int index) {
		Dnode i = head;
		if(index>=0 && index<size) {
		if(index==0) {
			return i.element;
		}
		else {
			for(int j=0;j<index;j++) {
				i=i.next;
			}
			return i.element;
		} 
	} else {
		return null;
	}
	}
	public void set(int index, Object element) {
		Dnode i = head;
		Dnode x =tail;
		if(index>=0 && index <= size-1) {
			if(index==0) {
				i.element=element;
			}
			else if (index==size-1) {
				x.element=element;
			}
			else {
				for(int j=0;j<index;j++) {
					i=i.next;
				}
				i.element=element;
			}
		}
		else throw new RuntimeException("Out of bounds");
	}
	public void clear() {
		head=null;
		tail=null;
		size=0;
	}
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void remove(int index) {
		if(index <0 || index >= size) {
			throw new RuntimeException("Out of bounds") ;
		}
		else {
			Dnode i = head;
			Dnode x =tail;
			if (index ==0 ) {
				i.next.prev=null;
				head = i.next;
			}
			else if (index == size-1) {
				x.prev.next=null;
				tail=i.prev;
			}
			else {
			for(int j=0;j<index;j++) {
				i=i.next;
			}
			i.prev.next=i.next;
			i.next.prev=i.prev;
		}
			size --;
		}
	}
	
public int size() {
		return size;
}

public ILinkedList sublist(int fromIndex, int toIndex) {
		DLinkedList list = new DLinkedList();
		Dnode i=head;
		Dnode x=tail;
		if(toIndex<fromIndex || fromIndex <0 || toIndex <0) {
			throw new RuntimeException("Error");
		}else if(toIndex>=size && fromIndex >=0) {
			for(int j=0;j<fromIndex;j++) {
				i=i.next;
			}
			list.head=i;
			i.prev=null;
			list.tail=x;
			list.size=size-fromIndex;
			return (ILinkedList) list;
		}
		else if(toIndex<size && fromIndex>=0) {
			for(int j=0;j<fromIndex;j++) {
				i=i.next;
			}
			list.head=i;
			i.prev=null;
			for(int j=size-1;j>toIndex;j--) {
				x=x.prev;
			}
			list.tail=x;
			x.next=null;
			list.size=toIndex-fromIndex;
			
			return (ILinkedList) list;
		}
		return null;
}
public boolean contains(Object o) {
	Dnode i = head;
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