import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Project3Test {

	@Test
	public void pushTest() {
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		assertEquals(stack.top.value,Integer.valueOf(4));	
	}
	
	@Test
	public void sizeTest() {
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.pop();
		assertEquals(stack.size(),3);
	}
	
	@Test
	public void isEmptyTest() {
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(5);
		stack.pop();
		assertEquals(stack.isEmpty(),true);
	}
	
	@Test
	public void popTest1() {
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.pop();
		assertEquals(stack.size(),2);		
	}

	@Test
	public void popTest2() {
		Stack<Integer> stack= new Stack<Integer>();
		Assertions.assertThrows(NoSuchElementException.class,()->stack.pop());	
	}
		
	@Test
	public void peekTest1() {
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(6);
		stack.push(7);
		stack.push(8);
		int temp = stack.peek();
		assertEquals(temp,8);	
	}
	
	@Test
	public void peekTest2() {
		Stack<Integer> stack= new Stack<Integer>();
		Assertions.assertThrows(NoSuchElementException.class,()->stack.peek());	
	}
	
	@Test
	public void clearTest() {
		Stack<Integer> stack= new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.clear();
		assertEquals(stack.isEmpty(),true);
	}
	
	@Test
	public void analyzeCommandTest() {
		AmongUs among= new AmongUs();
		among.analyzeCommand("Hello");
		among.analyzeCommand("a/m");
		among.analyzeCommand("i/p /3");
		among.analyzeCommand("d/3/4");
		among.analyzeCommand("u");
		among.analyzeCommand("a/e");
		among.analyzeCommand("d/5/7");
		assertEquals(among.stack.peek(),"Help me");
	}
	
		
	@Test
	public void insertTest() {
		AmongUs among= new AmongUs();
		among.stack.push("hello");
		among.insert(" csci", 5);
		assertEquals("hello csci",among.stack.peek());
	}
	
	@Test
	public void deleteTest() {
		AmongUs among= new AmongUs();
		among.stack.push("hello");
		among.delete(0,5);
		assertEquals("",among.stack.peek());
	}
	
	@Test
	public void appendTest() {
		AmongUs among= new AmongUs();
		among.stack.push("hello");
		among.append("ooo");
		assertEquals("helloooo",among.stack.peek());
	}
	
	@Test
	public void undoTest1() {
		AmongUs among= new AmongUs();
		among.stack.push("hello");
		among.insert(" csci", 5);
		among.delete(0,6);
		among.append("ooo");
		among.undo();
		assertEquals("csci",among.stack.peek());
	}
	
	@Test
	public void undoTest2() {
		AmongUs among= new AmongUs();
		among.stack.push("hello");
		among.undo();
		assertEquals("hello",among.stack.peek());
	}

}
