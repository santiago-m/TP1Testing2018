package ejercicio5;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class)
public class CalTest_eje {
	
	public int m1, d1, m2, d2, y, expected;
	
	public CalTest_eje (int v11, int v12, int v21, int v22, int year, int expected){
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
		return Arrays.asList (new Object [][] { /* 0 */  {2, 27, 3, 1, 2016, 3}, 
												/* 1 */  {2, 27, 3, 1, 2018, 2}, 
												/* 2 */  {2, 31, 3, 1, 2018, 28},
												/* 3 */  {2, 31, 3, 1, 2016, 29},
												/* 4 */  {2, 27, 2, 15, 2018, 12},
												/* 5 */  {4, 31, 5, 1, 2018, 30},
												/* 6 */  {4, 30, 5, 1, 2018, 1},
												/* 7 */  {0, 1, 1, 2, 2018, 1},
												/* 8 */  {1, 1, 13, 2, 2018, 1},
												/* 9 */  {1, 0, 1, 2 ,2018, 1},
												/* 10 */ {1, 1, 1, 32, 2018, 0}
											  }); 
	}

	@Test 
	public void dayTest() {
		int temp = Cal.cal (m1, d1, m2, d2, y);
		assertTrue ("Wrong number of days, expected: " + expected + " obtained: " + temp , expected == temp);
	}
}