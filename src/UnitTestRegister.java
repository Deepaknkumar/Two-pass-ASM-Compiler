import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit tests for COSC 121 Lab 2.
 * 	
 */
public class UnitTestRegister
{
	@Test
	public void accumulatorInheritance()
	{
		Accumulator acc = new Accumulator();
		assertTrue(acc instanceof Register);
	}
	
	@Test
	public void accumulatorConstructor()
	{
		Accumulator acc = new Accumulator(5);
		assertEquals(5, acc.getValue());
		
		acc = new Accumulator();
		assertEquals(0, acc.getValue());
	}
	
	@Test
	public void accumulatorMutator()
	{
		Accumulator acc = new Accumulator();
		acc.setValue(11);
		assertEquals(11, acc.getValue());
	}
	
	@Test
	public void accumulatorMultiply()
	{
		Accumulator acc = new Accumulator(11);
		acc.multiply(2);
		assertEquals(22, acc.getValue());
	}
		
	@Test
	public void accumulatorAdd()
	{
		Accumulator acc = new Accumulator(11);
		acc.add(8);
		assertEquals(19, acc.getValue());
	}
		
	@Test
	public void accumulatorSubtract()
	{
		Accumulator acc = new Accumulator(11);
		acc.subtract(6);
		assertEquals(5, acc.getValue());
	}
		
	@Test
	public void accumulatorDivide()
	{
		Accumulator acc = new Accumulator(24);
		acc.divide(3);
		assertEquals(8, acc.getValue());
	}
	
	@Test
	public void instructionRegisterInheritance()
	{
		InstructionRegister ir = new InstructionRegister();
		assertTrue(ir instanceof Register);
	}
	
	@Test
	public void instructionRegisterConstructor()
	{
		InstructionRegister ir = new InstructionRegister(5);
		assertEquals(5, ir.getValue());
		
		ir = new InstructionRegister();
		assertEquals(0, ir.getValue());
	}
	
	@Test
	public void instructionRegisterMutator()
	{
		InstructionRegister ir = new InstructionRegister(10);
		
		ir.setValue(11);
		assertEquals(11, ir.getValue());
	}
	
	@Test
	public void instructionRegisterGetOpcode()
	{
		InstructionRegister ir = new InstructionRegister();
		
		ir.setValue(899);
		assertEquals(8, ir.getOpcode());
		
		ir.setValue(798);
		assertEquals(7, ir.getOpcode());
		
		ir.setValue(1008);
		assertEquals(10, ir.getOpcode());
	}
	
	@Test
	public void instructionRegisterGetOperand()
	{
		InstructionRegister ir = new InstructionRegister();
		
		ir.setValue(899);
		//System.out.println(ir.getOperand());
		assertEquals(99, ir.getOperand());
		
		ir.setValue(798);
		assertEquals(98, ir.getOperand());
		
		ir.setValue(1008);
		assertEquals(8, ir.getOperand());
	}
	
	@Test
	public void programCounterInheritance()
	{
		ProgramCounter pc = new ProgramCounter();
		assertTrue(pc instanceof Register);
	}
	
	@Test
	public void programCounterConstructor()
	{
		ProgramCounter pc = new ProgramCounter(5);
		assertEquals(5, pc.getValue());
		
		pc = new ProgramCounter();
		assertEquals(0, pc.getValue());
	}
	
	@Test
	public void programCounterMutator()
	{
		ProgramCounter pc = new ProgramCounter(10);
		pc.setValue(11);
		assertEquals(11, pc.getValue());
	}
	
	@Test
	public void programCounterIncrement()
	{
		ProgramCounter pc = new ProgramCounter(6);
		
		pc.increment();
		assertEquals(7, pc.getValue());
	}
}
