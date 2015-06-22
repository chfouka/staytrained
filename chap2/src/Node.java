
public class Node {

	Node next;
	int data;
	public Node( int  d ){ data = d ; }
	
	void append( int n ){
		
		Node end = new Node(n);
		Node n = this;
		while( n.next != null)
			n = n.next;
		n.next = end;
	}
	
	
	
}
