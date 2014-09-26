package ca.csf.stack;

public class LinkedListStack implements Stack{

	private int size;
	private LinkedListStackNode lastStackNode;
	
	public LinkedListStack(){
		size = 0;
		lastStackNode = null;
	}
		
	public boolean isEmpty() {
		if(size < 1){
			return true;
		} else {
			return false;
		}					
	}

	public void push(Object object) {
		LinkedListStackNode buffer = lastStackNode;
		lastStackNode = new LinkedListStackNode(object,buffer);
		size++;
	}

	public Object pop() {
		if(size != 0){
			Object buffer = lastStackNode.getObject();
			lastStackNode = lastStackNode.getPreviousStackNode();
			size--;
			return buffer;	
		}else if(size == 1){
			Object buffer = lastStackNode.getObject();
			lastStackNode = null;
			return buffer;
		}else {
			return null;
		}
			
	}

	public Object peek() {

		if(size !=0){
			return lastStackNode.getObject();
		}else {
			return null;
		}
		
	}

	public Object getAt(int i) {
		LinkedListStackNode buffer = lastStackNode;
		for (int j = 0; j < i; j++) {
				buffer = buffer.getPreviousStackNode();
		}
		return buffer.getObject();
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		while(size != 0){
			this.pop();
		}	
	}

}
