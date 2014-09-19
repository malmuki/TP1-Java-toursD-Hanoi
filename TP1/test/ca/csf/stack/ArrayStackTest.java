package ca.csf.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {

	private ArrayStack stack;

	@Before
	public void setUp() throws Exception {
		stack = new ArrayStack();
	}
	
	@Test
	public void whenStackCreated_thenStackIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void whenAddElementToStack_thenStackIsNotEmpty() {
		stack.push(new Object());
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void whenAddAndRemoveElementOnStack_thenStackIsEmpty() {
		stack.push(new Object());
		stack.pop();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void whenAddElementToStackAndPop_thenElementIsPoped() {
		Object object = new Object();
		
		stack.push(object);
		Object returnedObject = stack.pop();
		
		assertSame(object, returnedObject);
	}
	
	@Test
	public void whenAddTwoElementToStackAndPop_thenSecondElementIsPoped() {
		Object object1 = new Object();
		Object object2 = new Object();
		
		stack.push(object1);
		stack.push(object2);
		Object returnedObject = stack.pop();
		
		assertSame(object2, returnedObject);
		assertNotSame(object1, returnedObject);
	}
	
	@Test
	public void whenPopElementInEmptyStack_thenNullIsReturned() {
		Object returnedObject = stack.pop();
		
		assertNull(returnedObject);
	}
	
	@Test
	public void whenAddElementInStackAndPeek_thenElementIsReturned() {
		Object object = new Object();
		
		stack.push(object);
		Object returnedObject = stack.peek();
		
		assertSame(object, returnedObject);
	}
	
	@Test
	public void whenAddElementInStackAndPeek_thenStackIsNotPoppedAndThusNotEmpty() {
		stack.push(new Object());
		stack.peek();
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void whenPeekElementInEmptyStack_thenNullIsReturned() {
		Object returnedObject = stack.peek();
		
		assertNull(returnedObject);
	}
	
	@Test
	public void whenAddElementInStackAndGet_thenElementIsReturned() {
		Object object = new Object();
		
		stack.push(object);
		Object returnedObject = stack.getAt(0);
		
		assertSame(object, returnedObject);
	}
	
	@Test
	public void whenAddTwoElementsInStackAndGet_thenElementIsReturned() {
		Object object1 = new Object();
		Object object2 = new Object();
		
		stack.push(object1);
		stack.push(object2);
		Object returnedObject1 = stack.getAt(0);
		Object returnedObject2 = stack.getAt(1);
		
		assertSame(object2, returnedObject1);
		assertSame(object1, returnedObject2);
	}
	
	@Test
	public void whenAddElementInStackAndGet_thenStackIsNotPoppedAndThusNotEmpty() {
		stack.push(new Object());
		stack.getAt(0);
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void whenStackCreated_thenStackSizeIsZero() {
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void whenAddElementToStack_thenStackSizeRepresentsTheNumberOfElementsInStack() {
		stack.push(new Object());
		assertEquals(1, stack.getSize());
		stack.push(new Object());
		assertEquals(2, stack.getSize());
		stack.push(new Object());
		assertEquals(3, stack.getSize());
	}
	
	@Test
	public void whenRemoveElementInStack_thenStackSizeRepresentsTheNumberOfElementsInStack() {
		stack.push(new Object());
		stack.push(new Object());
		stack.push(new Object());
		
		stack.pop();
		assertEquals(2, stack.getSize());
		stack.pop();
		assertEquals(1, stack.getSize());
		stack.pop();
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void whenClearStackThatContainsElement_thenStackBecomeEmpty() {
		stack.push(new Object());
		
		stack.clear();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void whenClearStackThatContainsElement_thenStackSizeBecomeZero() {
		stack.push(new Object());
		
		stack.clear();
		
		assertEquals(0, stack.getSize());
	}

}
