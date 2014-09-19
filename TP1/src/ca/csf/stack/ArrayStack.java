/**
 * 
 */
package ca.csf.stack;

/**
 * @author Francois
 */
public class ArrayStack implements Stack {

	private int size;
	private int maxSize;
	private Object[] object;

	public ArrayStack() {
		size = 0;
		maxSize = 2;
		object = new Object[maxSize];
	}

	public boolean isEmpty() {
		if (size > 0) {
			return false;
		} else {
			return true;
		}

	}

	public void push(Object object) {
		if (size == maxSize) {
			maxSize *= 2;
			Object[] buffer = this.object;
			this.object = new Object[maxSize];
			for (int i = 1; i < buffer.length; i++) {
				this.object[i - 1] = buffer[i - 1];
			}

		}
		this.object[size] = object;
		size++;
	}

	public Object pop() {
		if (size > 0) {
			Object buffer = this.object[size - 1];
			this.object[size - 1] = null;
			size--;
			return buffer;
		} else {
			return null;
		}

	}

	public Object peek() {
		if (size > 0) {
			return this.object[size - 1];
		} else {
			return null;
		}

	}

	public Object getAt(int i) {

		return this.object[size - i - 1];
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		this.object = new Object[2];
		size = 0;
		maxSize = 2;
	}

}
