package ca.csf.stack;

public class LinkedListStackNode {
	
	private Object object;
	private LinkedListStackNode previousStackNode;
	
	public LinkedListStackNode(Object object,LinkedListStackNode previousStackNode){
		this.object = object;
		this.previousStackNode = previousStackNode;
	}

	public Object getObject(){
		return object;
	}
	
	public LinkedListStackNode getPreviousStackNode(){
		return  previousStackNode;
	}
}
