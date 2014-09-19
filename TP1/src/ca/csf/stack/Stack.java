package ca.csf.stack;

public interface Stack {
	
	Object pop();
	
	void push(Object object);
	
	Object peek();
	
	Object getAt(int position);
	
	void clear();
	
	boolean isEmpty();
	
	int getSize();
	
	String toString();
}
