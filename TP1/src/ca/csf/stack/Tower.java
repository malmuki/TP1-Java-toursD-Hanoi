package ca.csf.stack;

public class Tower {

	private Stack stack;

	public Tower(Stack stack) {
		this.stack = stack;
	}

	public int getSize() {
		return stack.getSize();
	}

	public boolean addDisk(Disk disk) {
		if (this.stack.peek() == null
				|| ((Disk) this.stack.peek()).getLongueur() > disk
						.getLongueur()) {
			stack.push(disk);
			return true;
		} else {
			return false;
		}

	}

	public Disk getDiskOnTop() {

		return (Disk)stack.peek();
	}

	public Disk removeDisk() {

		return (Disk) stack.pop();
	}

	public Disk getDiskAt(int i) {

		return (Disk) stack.getAt(i);
	}

	public void clear() {
		stack.clear();

	}

}
