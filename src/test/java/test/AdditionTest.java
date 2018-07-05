package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import source.Addition;


public class AdditionTest {

	/*@Test
	public void testAdd() {
		Addition addition = new Addition(5,6);
		Assert.assertTrue(addition.add() == 14);
	}*/
	
	@Test
	public void testPrint() {
		//Addition addition = new Addition(5,6);
		 java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();

		  System.setOut(new java.io.PrintStream(out));
		
		  
		//String s1 = sc.nextLine();
		Addition.print();
		Assert.assertEquals("Hello", out.toString());		
		// sc.close();
	}
}
