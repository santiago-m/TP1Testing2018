package ejercicio5;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class)
public class CalTest_ejb {
	
	public int m1, d1, m2, d2, y, expected;
	
	public CalTest_ejb (int v11, int v12, int v21, int v22, int year, int expected){
		this.m1 = v11;
		this.d1 = v12;
		this.m2 = v21;
		this.d2 = v22;
		this.y = year;
		this.expected = expected;
	}
	
	@Parameters 
	public static Collection<Object[]> parameters() {
		//
		return Arrays.asList (new Object [][] { /* F  T,T */{1, 1, 2, 1, 2010, 31}, /* F  F,F */{1, 1, 2, 1, 2016, 31}, /* T   -,- */ {1, 1, 1, 1, 2016, 0}}); 
	}

	@Test 
	public void dayTest() {
		assertTrue ("Wrong number of days", expected == Cal.cal (m1, d1, m2, d2, y));
	}
}