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
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 


public class Main {

	public static void main(String[] args) {
		
		// creating a character array size 10
		char[] charArray = new char[10];
		charArray[0] = 'a';
		charArray[1] = 'b';
		charArray[2] = 'c';
		charArray[3] = 'd';
		charArray[4] = 'a';
		charArray[5] = 'f';
		charArray[6] = 'a';
		charArray[7] = 'a';
		charArray[8] = 'i';
		charArray[9] = 'j';
		
		System.out.println("*** Testing MyList Methods ***\n");
		
		
		// Testing MyList (char[] charArray, int n)
		System.out.println("\nLet's try the constructor MyList (char[] charArray, int n)...");
		System.out.println("The charArray is:\n"
				+ "charArray[0] = 'a';\n"
				+ "charArray[1] = 'b';\n"
				+ "charArray[2] = 'c';\n"
				+ "charArray[3] = 'd';\n"
				+ "charArray[4] = 'a';\n"
				+ "charArray[5] = 'f';\n"
				+ "charArray[6] = 'a';\n"
				+ "charArray[7] = 'a';\n"
				+ "charArray[8] = 'i';\n"
				+ "charArray[9] = 'j';\n");
		MyList newList = new MyList(charArray, charArray.length);
		System.out.println("Let's print out the List with the 'print' method");
		newList.print();
		int test_size = newList.size();
		System.out.println("Size of List is: " + test_size);
		
		// Testing MyList(MyList rhs)
		System.out.println("\nLet's try the constructor MyList(MyList rhs)...");
		System.out.println("MyList rhsList = new MyList(newList);");
		MyList rhsList = new MyList(newList);
		System.out.println("Let's print out the List with the 'print' method");
		rhsList.print();
		test_size = rhsList.size();
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing boolean remove(int index)
		System.out.println("\nNow let's try boolean remove(int index)...");
		System.out.println("newList.remove(0);");
		newList.remove(0);
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is:" + test_size);
		System.out.println("newList.remove(1000);");
		newList.remove(1000);
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing boolean remove(char value)
		System.out.println("\nNow let's try boolean remove(char value)...");
		System.out.println("newList.remove('c');");
		newList.remove('c');
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is:" + test_size);
		System.out.println("newList.remove('x');");
		newList.remove('x');
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing boolean removeAll(char value)
		System.out.println("\nNow let's try boolean removeAll(char value)...");
		System.out.println("newList.removeAll('a');");
		newList.removeAll('a');
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is:" + test_size);
		System.out.println("newList.removeAll('z');");
		newList.removeAll('x');
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing Node previous(Node curr) and Node next(Node curr)
		System.out.println("\nNow let's try Node previous(Node curr) and Node next(Node curr) methods...");
		char test = newList.getHead().getElement();
		System.out.println("newList.getHead().getElement() = "+ test);
		test = newList.next(newList.getHead()).getElement();
		System.out.println("newList.next(newList.getHead()).getElement() = "+ test);
		test = newList.previous(newList.next(newList.getHead())).getElement();
		System.out.println("newList.previous(newList.next(newList.getHead())).getElement() = "+ test);
		
		
		// Testing bool contains(char value)
		System.out.println("\nNow let's try bool contains(char value)...");
		boolean test_contains = newList.contains('f');
		System.out.println("newList.contains('f') = " + test_contains);
		test_contains = newList.contains('z');
		System.out.println("newList.contains('z') = " + test_contains);
		
		
		// Testing char get(int index)
		System.out.println("\nNow let's try char get(int index)...");
		char test_get = newList.get(3);
		if (test_get == '\u0000'){
			System.out.println("Index is out of bound!");
		}
		else{
			System.out.println("newList.get(3) = " + test_get);
		}
		System.out.println("Let's try newList.get(100)");
		test_get = newList.get(100);
		if (test_get == '\u0000'){
			System.out.println("Index is out of bound!");
		}
		else{
			System.out.println("newList.get(100) = " + test_get);
		}
		
		
		// Testing void set(int index, char value)
		System.out.println("\nLet's try void set(int index, char value)...");
		System.out.println("newList.set(1, 'p');");
		newList.set(1, 'p');
		System.out.println("Updated List...");
		newList.print();
		System.out.println("newList.set(-1, 'd');");
		newList.set(-1, 'd');
		System.out.println("Updated List...");
		newList.print();
		test_size = newList.size();
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing boolean equals(MyList llist)
		System.out.println("\nNow le'ts try boolean equals(MyList llist)...");
		System.out.println("I'll make a new list with the same elements as newList");
		System.out.println("The charArray is:\n"
				+ "charArray2[0] = 'b';\n"
				+ "charArray2[1] = 'p';\n"
				+ "charArray2[2] = 'f';\n"
				+ "charArray2[3] = 'i';\n"
				+ "charArray2[4] = 'j';");
		
		char[] charArray2 = new char[5];
		charArray2[0] = 'b';
		charArray2[1] = 'p';
		charArray2[2] = 'f';
		charArray2[3] = 'i';
		charArray2[4] = 'j';
		MyList newList2 = new MyList(charArray2, charArray2.length);
		System.out.println("newList.equals(newList2) = " + newList.equals(newList2));
		System.out.println("Now let's make anoter new list but not with same elements");
		System.out.println("The charArray is:\n"
				+ "charArray3[0] = 'b';\n"
				+ "charArray3[1] = 'd';\n"
				+ "charArray3[2] = 'l';\n"
				+ "charArray3[3] = 'r';\n"
				+ "charArray3[4] = 'q';");
		char[] charArray3 = new char[5];
		charArray3[0] = 'b';
		charArray3[1] = 'd';
		charArray3[2] = 'l';
		charArray3[3] = 'r';
		charArray3[4] = 'q';
		MyList newList3 = new MyList(charArray3, charArray3.length);
		System.out.println("newList.equals(newList3) = " + newList.equals(newList3));
		
		
		// Testing void pushFront(char value)
		System.out.println("\nNow let's try void pushFront(char value)...");
		System.out.println("newList.pushFront('s');");
		newList.pushFront('s');
		System.out.println("newList.pushFront('k');");
		newList.pushFront('k');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void pushBack(char value)
		System.out.println("\nNow let's try void pushBack(char value)...");
		System.out.println("newList.pushBack('a');");
		newList.pushBack('a');
		System.out.println("newList.pushBack('u');");
		newList.pushBack('u');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void popFront()
		System.out.println("\nNow let's try void popFront()...");
		System.out.println("newList.popFront();");
		newList.popFront();
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void popBack()
		System.out.println("\nNow let's try void popBack()...");
		System.out.println("newList.popBack();");
		newList.popBack();
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void swap(int i, int j)
		System.out.println("\nNow let's try void swap(int i, int j)...");
		System.out.println("newList.swap(3,5);");
		newList.swap(3,5);
		newList.print();
		System.out.println("newList.swap(2,1000);");
		newList.swap(2,1000);
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void insertAtPos(int i, char value)
		System.out.println("\nNow let's try void insertAtPos(int i, char value)...");
		System.out.println("newList.insertAtPos(4, 'm');");
		newList.insertAtPos(4, 'm');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		System.out.println("newList.insertAtPos(-3, 'n');");
		newList.insertAtPos(-3, 'n');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void insertAfter(int i, char value)
		System.out.println("\nNow let's try void insertAfter(int i, char value)...");
		System.out.println("newList.insertAfter(2, 'x')");
		newList.insertAfter(2, 'x');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		System.out.println("newList.insertAfter(1000, 'x')");
		newList.insertAfter(1000, 'x');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void insertBefore(int i, char value)
		System.out.println("\nNow let's try void insertBefore(int i, char value)...");
		System.out.println("newList.insertBefore(2, 'z');");
		newList.insertBefore(2, 'z');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		System.out.println("newList.insertBefore(-5, 'z');");
		newList.insertBefore(-5, 'z');
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing MyList subList(int fromIndex, int toIndex)
		System.out.println("\nNow let's try MyList subList(int fromIndex, int toIndex)...");
		System.out.println("MyList test_subList = newList.subList(2, 6);");
		MyList test_subList = newList.subList(2, 6);
		System.out.println("Printing out test_subList....");
		test_subList.print();
		test_size = test_subList.size();
		System.out.println("Size of List is: " + test_size);
		System.out.println("MyList test_subList = newList.subList(2, 1000);");
		test_subList = newList.subList(2, 1000);
		
		
		// Testing int find(char value)
		System.out.println("\nNow let's try int find(char value)...");
		System.out.println("Here's is newList again...");
		newList.print();
		System.out.println("newList.find('z') = " + newList.find('z'));
		System.out.println("newList.find('t');");
		int test_find = newList.find('t');
		System.out.println("newList.find('t') = " + test_find);
		
		
		// Testing int find(MyList queryStr)
		System.out.println("\nNow let's try int find(MyList queryStr)...");
		System.out.println("Let's create a list that is a sublist of newList");
		System.out.println("The charArray4 is:\n"
				+ "charArray4[0] = 'p';\n"
				+ "charArray4[1] = 'x';\n"
				+ "charArray4[2] = 'j';\n"
				+ "charArray4[3] = 'm';\n"
				+ "charArray4[4] = 'i';");
		char[] charArray4 = new char[5];
		charArray4[0] = 'p';
		charArray4[1] = 'x';
		charArray4[2] = 'j';
		charArray4[3] = 'm';
		charArray4[4] = 'i';
		System.out.println("MyList newList4 = new MyList(charArray4, charArray4.length);");
		MyList newList4 = new MyList(charArray4, charArray4.length);
		System.out.println("newList.find(newList4) = " + newList.find(newList4));
		System.out.println("Let's make another list that is NOT a sublist of newList");
		System.out.println("The charArray5 is:\n"
				+ "charArray4[0] = 's';\n"
				+ "charArray4[1] = 'w';\n"
				+ "charArray4[2] = 't';\n"
				+ "charArray4[3] = 'q';\n"
				+ "charArray4[4] = 't';");
		char[] charArray5 = new char[5];
		charArray5[0] = 's';
		charArray5[1] = 'w';
		charArray5[2] = 't';
		charArray5[3] = 'q';
		charArray5[4] = 't';
		System.out.println("MyList newList5 = new MyList(charArray5, charArray5.length);");
		System.out.println("newList.find(newList5);");
		MyList newList5 = new MyList(charArray5, charArray5.length);
		System.out.println("newList.find(newList5) = " + newList.find(newList5));
		
		
		// Testing Now let's try char[] toArray()
		System.out.println("\nNow let's try char[] toArray()...");
		System.out.println("char[] testArray = new char[newList.size()];\n"
					+ "testArray = newList.toArray();\n"
					+ "for(int i = 0; i < testArray.length; i++){\n"
					+ "\tSystem.out.println(testArray[i]);}");
		
		char[] testArray = new char[newList.size()];
		testArray = newList.toArray();
		for(int i = 0; i < testArray.length; i++){
			System.out.println(testArray[i]);
		}
		
		
		// Testing void reverse()
		System.out.println("\nNow let's try void reverse()...");
		newList.reverse();
		newList.print();
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing try size()
		System.out.println("\nNow let's try size() which we have already used thoughout this test...");
		test_size = newList.size();		
		System.out.println("Size of List is: " + test_size);
		
		
		// Testing void print()
		System.out.println("\nNow let's try void print() which we have already used thoughout this test...");
		newList.print();
		
		
		// Testing toString()
		System.out.println("\nLastly let's try String toString()...");
		String test_toString = newList.toString();
		System.out.println(test_toString);

	}

}
