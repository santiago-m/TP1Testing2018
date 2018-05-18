package ejercicio5;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;


@RunWith (Parameterized.class)
public class CalTest_ejc {
	
	public int m1, d1, m2, d2, y, expected;
	
	public CalTest_ejc (int v11, int v12, int v21, int v22, int year, int expected){
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
		return Arrays.asList (new Object [][] { /* 0 */ {1, 1, 1, 1, 1, 0}, 
												/* 1 */ {1, 1, 3, 1, 2100, 59}, 
												/* 2 */ {1, 1, 3, 1, 2016, 60},
												/* 3 */ {1, 1, 3, 1, 2000, 60},
												/* 4 */ {1, 1, 3, 1, 2, 59}
											  }); 
	}
	


	@Test 
	public void dayTest() {
		int temp = Cal.cal (m1, d1, m2, d2, y);
		assertTrue ("Wrong number of days, expected: " + expected + " obtained: " + temp , expected == temp);
	}
}