//StackOfIntegersLinkedList.java

/**
 * CS226 Homework 1
 * @author Joon Hyuck Choi
 * Date: Feb 11, 2015
 * Last edited: 16:36 02/11/15
 * email: jchoi100@jhu.edu
 */
public class StackOfIntegersLinkedList implements StackOfIntegers{

	//Instance variables
	/**
	 * The Node that will point to the first object of the list.
	 */
	private Node head;
	
	/**
	 * The Node that will point to the last object of the list.
	 */
	private Node tail; //for later implementation
	
	/**
	 * Counts how many objects are linked in the list.
	 */
	private int count;
	
	//Constructors
	/**
	 * Constructor that takes in no arguments.
	 */
	public StackOfIntegersLinkedList() {
		this.head = null;
		this.count = 0;
	} //end constructor
	
	//Methods
	/**
	 * Takes in an integer value in its parameter, creates a new Node instance, and "pushes" that instance to the front of the list.
	 * @param element The number that will be newly added to the front of the list.
	 */
	public void push(Integer element) {
		Node temp = new Node(element);
		temp.next = this.head;
		this.head = temp;
		this.count++;
	} //end push()

	/**
	 * Takes no arguments and removes the element that is currently at the top of the stack.
	 * @return The number that was popped with the call of the most recent pop() method.
	 */
	public Integer pop() { //does not work
		if (this.isEmpty()) { //check if stack is empty before doing pop()
			throw new StackEmptyException("empty stack on pop!");
		} //end if		
		Integer result = this.head.data; //save the Integer to be popped in a temporary variable
		this.head = this.head.next; //change the head pointer to point to the next element
		this.count--; //decrement the number of elements
		return result;
	} //end pop()

	/**
	 * Takes no arguments and lets the user see what value is currenlty at the top of the stack.
	 * @return the element currently at the top of the stack.
	 */
	public Integer peek() {
		if (this.isEmpty()) { //check if stack is empty before doing peek()
			throw new StackEmptyException("empty stack on peek!");
		} //end if	
		return this.head.data;
	} //end peek()

	/**
	 * Lets the user check if the list is empty or not.
	 * @return true if the list is empty and false if not.
	 */
	public boolean isEmpty() {
		return (this.count == 0);
	} //end isEmpty()

	/**
	 * @return the size of the list.
	 */
	public int size() {
		return this.count;
	} //end size()

	/**
	 * @return the String representation of the elements of the list. The top of the stack is printed at the right-most place.
	 */
	public String toString() {
		String result = "";
		Node temp = this.head;
		for(int i = 0; i < count; i++) { //using a for loop and a counter
			result = temp.data + " " + result;
			temp = temp.next;
		} //end for
		return result;
	} //end toString()
	
	//Inner Node class
	/**
	 * This is a class nested inside the StackOfIntegersLinkedList class that instantiates Nodes used in the outer class.
	 * @author Joon Hyuck Choi
	 *
	 */
	private class Node {
		
		/**
		 * The data value that will be in each Node.
		 */
		private Integer data;
		
		/**
		 * The pointer of each Node that points to the next element.
		 */
		private Node next;
		
		/**
		 * This constructor takes in no arguments.
		 */
		public Node() {
			this.data = null;
			this.next = null;
		} //end constructor1
		
		/**
		 * This constructor takes in the data that will be stored in a new Node instance.
		 * @param d the data that will be stored in the Node.
		 */
		public Node(Integer d) {
			this.data = d;
			this.next = null;
		} //end constructor2
		
		/**
		 * This constructor takes in two arguments: the data that will be stored in the new Node instance, and its next pointer.
		 * @param d the data that will be stored in the instance.
		 * @param n the next pointer of the created instance.
		 */
		public Node (Integer d, Node n) {
			this.data = d;
			this.next = n;
		} //end constructor3
		
	} //end nested class
	
} //end outer class
