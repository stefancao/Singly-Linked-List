/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: assignment1
 * Filename : MyList.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 

public class MyList {

	//Node class
	// NOTE: changed it to public ONLY for testing next and previous methods in Main
	public class Node{
		
		// private fields for Node class
		private char value;
		private Node next;
		
		
		// default constructor for Node class
		public Node(){
			this.next = null;
		}
		
		
		// Accessor method
		public char getElement(){
			return value;
		}
		public Node getNext(){
			return next;
		}
		
		// Modifier methods
		public void setElement(char v){
			value = v;
		}
		public void setNext(Node n){
			next = n;
		}
		
	}	// end line Node class
	
	
	// private field for MyList class
	private Node head;
	
	// this accessor method is only used to test previous and next methods
	public Node getHead(){
		return head;
	}
	
	// constructor - instatiates this list as a deep copy of rhs
	MyList(MyList rhs){
		
		// setting the first element to the head
		head = new Node();
		head.setElement(rhs.get(0));
		
		// copying the rest of the elements to the new list
		for(int i = 1; i < rhs.size(); i++){
			Node newNode = new Node();
			
			// calling pushBack method which pushes all the new elements at the end of list
			pushBack(rhs.get(i));
		}	
	}
	
	// constructor - instatiats this list as a deep copu of charArray
	MyList(char[] charArray, int n){
		
		// Creating head node and putting its value
		head = new Node();
		head.setElement(charArray[0]);
		
		// instantiates a curr node to traverse across the list
		Node curr = new Node();
		
		// setting the first curr to head
		curr = head;
		
		for(int i = 1; i < n; i++){
			
			// creating a new node
			Node newNode = new Node();
			
			// setting the next element to new node
			curr.setNext(newNode);
			
			// setting the element value
			newNode.setElement(charArray[i]);
			
			// setting curr = newNode to traverse to the next one
			curr = newNode;
		}
	}
	
	
	// Methods for MyList class
	
	// remove the node (element) given an index -  return true if able to remove, false if coudln't remove
	boolean remove(int index){
		
		// if user inputs an index that is out of bound, return false
		if((index < 0) || (index > size()-1)){
			System.out.println("Index is out of bound!");
			return false;
		}
		
		// case where index is 0, first element in list
		else if(index == 0){
				
			// if there is only one element left
			if(size() == 1){
				head = null;
				return true;	
			}
			
			else{
				
				// Instantiating a 'current' node to use to traverse across the list
				Node curr = head;
					
				head = curr.getNext();
					
				// putting to null to de-access the node to let garbage collector take it
				curr.setNext(null);

				return true;
			}
		}
			
		// case where user wants to remove node at the end of the list
		else if (index+2 > size()){
				
			// Instantiating a 'current' node to use to traverse across the list
			Node curr = head;
			
			// traverse across the list
			for(int i = 0; i < (index-1); i++){
				curr = curr.getNext();
			}
			
			// putting to null to de-access the node to let garbage collector take it
			curr.setNext(null);
			
			return true;	
		}
			
		// case removing anywhere between two existing nodes
		else{
				
			// Instantiating a 'current' node to use to traverse across the list
			Node curr = head;
							
			// traverse across the list
			for(int i = 0; i < (index-1); i++){
				curr = curr.getNext();
			}
				
				
			// creating a tempNode
			Node tempNode = new Node();
			tempNode.setNext(curr.getNext().getNext());
			
			// putting to null to de-access the node to let garbage collector take it
			curr.getNext().setNext(null);
		
			// connecting the two nodes where the removed nodes were between together
			curr.setNext(tempNode.getNext());
				
			return true;
		}
	}
	
	// remove a node (element) given a char value - return true if able to remove, false if coudln't remove
	boolean remove(char value){
		
		// boolean if element exist or not
		boolean isElement = false;
				
		// Instantiating a 'current' node to use to traverse across the list
		Node curr = head;
				
		// local index to find the index of the object
		int lcIndex = 0;
				
		// going through the list to find object
		while(lcIndex < size()){

			// if finds object, break the loop and set isElement true
			if (value == (curr.getElement())){
				isElement = true;
				break;	
			}
	
			curr = curr.getNext();
			lcIndex++;
		}
				
		// if object found, use method remove(index) to remove object
		if(isElement){
			remove(lcIndex);
			return true;
		}
				
		// if can't find object return false
		else{
			System.out.println("Cannot find the element!");
			return false;
		}		
	}
	
	// removing all nodes (elements) that have the value given
	boolean removeAll(char value){
		
		// boolean if element exist or not
		boolean isElement = false;
		
		// boolean to continue the while loop or not
		boolean isNotEnd = true;				
		
		// Instantiating a 'current' node to use to traverse across the list
		Node curr = head;
						
		//local index to find the index of the object
		int lcIndex = 0;
						
		// going through the list to find object
		
		while(isNotEnd){
			lcIndex = 0;
			curr = head;
			
			while(lcIndex<size()){
	
				// if current has reached to the end of the list, end the while loop
				if(curr.getNext() == null){
					isNotEnd = false;
				}
			
				// if finds object, break the loop and set isElement true, and remove element
				if (value == (curr.getElement())){
					remove(lcIndex);
					isElement = true;
					
					break;
				}
				
				curr = curr.getNext();
				lcIndex++;
			}
		}
				
		// if could find any element one or more, return true
		if(isElement){
			return true;
		}
						
		// if can't find object return false
		else{
			System.out.println("Cannot find the element!");
			return false;
		}	
	}

	// getting the previous node given a current node
	Node previous(Node curr){
		Node temp_curr = head;
		while(true){
			
			// break and return if finding that the next node is curr
			if(temp_curr.getNext() == curr){
				break;
			}
			
			// else continue to traverse across the list
			else{
				temp_curr = temp_curr.getNext();
			}
		}
		return temp_curr;
	}
	
	// getting the next node given a current node
	Node next(Node curr){
		Node temp_curr = head;
		while(true){
			
			// if find the current node, then return the next node
			if(temp_curr == curr){
				break;
			}
			
			// else continue to traverse across the list
			else{
				temp_curr = temp_curr.getNext();
			}
		}
		
		// return the next node
		return temp_curr.getNext();
	}
	
	// boolean returning true or false depending if the list contains the given value
	boolean contains(char value){
		
		boolean isContains = false;
		Node curr = head;
			
		// going through the entire list
		while(curr != null){
			
			// comparing if the value given is the same as any element in the list
			if(value == (curr.getElement())){
				
				// if find set isContains to true and break
				isContains = true;
				break;	// don't need to search more if already found one
			}
		
			curr = curr.getNext();
		}

		return isContains;
	}
	
	// get the element given and index
	char get(int index){

		// check if index is out of bound
		if((index < 0) || (index > size()-1)){
			return '\u0000';	// null for char
		}
	
		// else find the element
		else{
			
			// Instantiating a 'current' node to use to traverse across the list
			Node curr = head;
			
			// going through the list
			for(int i = 0; i < index; i++){
				curr = curr.getNext();
			}
			
			// getting the current element and return it	
			return curr.getElement();
		}
	}
	
	// setting a new value of the element given an index
	void set (int index, char value){
		
		// check if index is out of bound
		if((index < 0) || (index > size()-1)){
			System.out.println("Index is out of bound!");
		}
		
		else{
			// Instantiating a 'current' node to use to traverse across the list
			Node curr = head;
					
			for(int i = 0; i < index; i++){
				curr = curr.getNext();
			}
			
			curr.setElement(value);
		}

	}
	
	// equals method checking if a list given is exactly the same as this list
	boolean equals(MyList llist){
		
		boolean isNotEqual = false;
		
		// creating 2 curr nodes that is set to head
		Node this_curr = head;
		Node llist_curr = llist.head;
		
		// checking if the size is the same, if not then it means not identical list
		if(size() != llist.size()){
			return false;
		}
		
		// else go through the list and check each element
		else{
			
			while(this_curr != null){
				
				// if one element is not equal, then the list is not the same
				if(this_curr.getElement() != llist_curr.getElement()){
					isNotEqual = true;
				}
				
				this_curr = this_curr.getNext();
				llist_curr = llist_curr.getNext();
				
			}
		}
		
		// return false if it's not equal
		if(isNotEqual){
			return false;
		}
		
		// return true if they are identical
		else{
			return true;
		}
	}
	
	// pushing node (element) at the beginning of the list
	void pushFront(char value){
	
		Node newNode = new Node();

		Node curr = head;
				
		// adding the new node in the beginning of the list	
		newNode.setNext(curr);
		newNode.setElement(value);
		
		// setting the new node as the head
		head = newNode;
	}
	
	// pushing node (element) at the end of the list
	void pushBack(char value){
		
		Node newNode = new Node();

		Node curr = head;
		
		// traverse across the list
		for(int i = 0; i < (size()-1); i++){
			curr = curr.getNext();
		}
		
		// adding the new node at the end of list
		curr.setNext(newNode);
		newNode.setElement(value);
		
		// setting the next node to null to indicate end of list
		newNode.setNext(null);
	}
	
	// poping (removing) the first node or element at the beginning of list
	void popFront(){
		
		// if user inputs an index that is out of bound,
		if(size() == 0){
			System.out.println("List is Empty!");
		}
		else{
			
			// if there is only one element in the list
			if(size() == 1){
				head = null;	// indicating the list is empty
			}
			else{
				
				// Instantiating a 'current' node to use to traverse across the list
				Node current = head;
				
				head = current.getNext();
				
				// putting to null to de-access the node to let garbage collector take it
				current.setNext(null);	
			}
		}
	}
	
	// poping (removing) the last node or element at the end of the list
	void popBack(){
		
		// if the list is already empty
		if(size() == 0){
			System.out.println("List is Empty!");
		}
		else{
			
			// if there is only one element left
			if(size() == 1){
				head = null;
			}
			else{
				// Instantiating a 'current' node to use to traverse across the list
				Node current = head;
							
				// traverse across the list
				for(int i = 0; i < (size()-2); i++){
					current = current.getNext();
				}
							
				// putting to null to de-access the node to let garbage collector take it
				current.setNext(null);
			}
		}
	}
	
	// swapping 2 elements given 2 indexes to swap with
	void swap (int i, int j){
		
		// checking that the indexes are not out of bound
		if((i < 0) || (i > size()-1) || ((j < 0) || (j > size()-1))){
			System.out.println("Index is out of bound!");
		}
		else{
			
			// setting one element to temp
			char temp = get(i);
			
			// overwrite i with element j
			set(i, get(j));
			
			// puttint i value which was stored in temp to j
			set(j, temp);	
		}	
	}
	
	// inserting a new node given an index and a value
	void insertAtPos(int i, char value){
		
		// checking that the index is valid
		if((i < 0) || (i > size()) ){
			System.out.println("Index is out of bound!");
		}
		else{
	
			// if user wants to add in the beginning of list
			if(i == 0){
			
				// call pushFront method
				pushFront(value);
			}
					
			// if user wants to add at the end of list
			else if((i+1) > size()){
				
				// call pushBack method
				pushBack(value);
			}
					
			// otherwise put the new node somewhere in between any two existing nodes that user wants
			else{
				
				// Instantiating a new Node
				Node newNode = new Node();
				
				// Instantiating a 'current' node to use to traverse across the list
				Node curr = head;		// starting at head node
				
				// traverse across the list
				for(int j = 0; j < i; j++){
					curr = curr.getNext();
				}
						
				// adding new node between two existing nodes
				previous(curr).setNext(newNode);
				newNode.setElement(value);
				newNode.setNext(curr);
			}
		}		
	}
	
	// inserting a node after a given index
	void insertAfter(int i, char value){
		
		// call insertAtPos with an index i+1
		insertAtPos(i+1, value);
	}

	// inserting a node before a given index
	void insertBefore(int i, char value){
		
		// call insertAtPos with an index i-1
		insertAtPos(i-1, value);
	}

	// getting a sublist of this list from a given index(inclusive) to a toIndex (exclusive)
	MyList subList(int fromIndex, int toIndex){

		// checking that the indexes are not out of bound
		if((fromIndex < 0) || (fromIndex > size()-1) || ((toIndex < 0) || (toIndex > size()-1))){
			System.out.println("Index is out of bound!");
			return null;
		}
		else{
		
			// creating a char temp array
			char[] tempArray = new char[toIndex-fromIndex];
			
			// starting from the given from index to toIndex
			for (int i = 0; i < (toIndex-fromIndex); i++){
				tempArray[i] = get(fromIndex+i);
			}
			
			// creating a new templist and putting the chararray into that list
			MyList tempMyList = new MyList(tempArray,toIndex-fromIndex);
			return tempMyList;
		}
	}
	
	// finding the position of the first occurrence of value in this list
	int find(char value){
		
		boolean isFind = false;
		int lcIndex = 0;
		
		Node current = head;
	
		// going through the list to find object
		while(lcIndex<size()){

			// if finds object, break the loop and set isFind true
			if (value == (current.getElement())){
				isFind = true;
				break;		// don't need to check anymore
			}
					
			current = current.getNext();
			lcIndex++;
		}
		
		if(isFind){
			return lcIndex;
		}
		else{
			System.out.println("Cannot find the character!");
			return -1;		// return -1 if cannot find it
		}
	}
	
	// fidning the position of the first occurrence of a given sublist
	int find(MyList queryStr){
		
		
		boolean isFind = false;
		
		Node curr = head;
		
		Node queryStr_curr = queryStr.head;
		
		int lcIndex = 0;
		
		while(curr != null){
			
			// checking if the element is the same
			if(curr.getElement() == queryStr_curr.getElement()){
			
				// if same call subList to make sure that the rest are the same too
				MyList temp = subList(lcIndex, lcIndex+queryStr.size());
				isFind = temp.equals(queryStr);
				
				// if they are the same, break 
				if(isFind){
					break;
				}
	
			}
			
			lcIndex++;
			curr = curr.getNext();
		}
		
		if(isFind){
			return lcIndex;
		}
		else{
			System.out.println("Cannot find queryStr in List");
			return -1;
		}
	}
	
	// returning an array containing all of the items in this list in proper sequence
	char[] toArray(){
		
		// creating a temp array
		char[] tempArray = new char[size()];
		 Node curr = head;
		 
		 int lcIndex = 0;
		 
		 // going through the list
		 while(curr != null){
			 
			 // putting the elements in the array
			 tempArray[lcIndex] = curr.getElement();
			 curr = curr.getNext();
			 lcIndex++;
		 }
		 
		 return tempArray;	
	}
	
	// reversing the order of the list
	void reverse(){
		
		// creating a temp Node
		Node temp = null;
		Node curr = head;
		while (curr != null){
			
			// creating a next node to remember the next node
			Node next = curr.getNext();
			
			// setting current's next to temp
			curr.setNext(temp);
			
			// setting temp to current
			temp = curr;
			
			// setting current to next
			curr = next;
		}
		
		// setting head with the new head
		head = temp;
	}
	
	// returns the number of items in the list
	int size(){
		int sizeCounter = 0;
		Node curr = head;
		
		// going through the list and see how many times have to do so, which indicates in a counter
		while(curr != null){
			sizeCounter++;
			curr = curr.getNext();
		}
		return sizeCounter;
	}
	
	// printing out all the elements in the list
	void print(){
		Node curr = head;
		while(curr != null){
			System.out.println(curr.getElement());
			curr = curr.getNext();
		}
	}
	
	// putting the list into a string
	public String toString(){
		
		// creating a temp array
		char[] tempArray = new char[size()];
		tempArray = toArray();
		
		// convert the char array to string
		String temp = new String(tempArray);
		
		return temp;
	}
	
} 	// end of MyList class

