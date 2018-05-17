package ejercicio5;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class)
public class CalTest_eja {
	
	public int m1, d1, m2, d2, y, expected;
	
	public CalTest_eja (int v11, int v12, int v21, int v22, int year, int expected){
		this.m1 = v11;
		this.d1 = v12;
		this.m2 = v21;
		this.d2 = v22;
		this.y = year;
		this.expected = expected;
	}
	
	@Parameters 
	public static Collection<Object[]> parameters() {
		return Arrays.asList (new Object [][] { /* Base */            /* 0 */  {1, 1, 12, 31, 1, 364},
												/* Variando month2 */ /* 1 */  {1, 1, 1, 31, 1, 30},      /* 2 */ {1, 1, 2, 31, 1, 31},       /* 3 */ {1, 1, 4, 31, 1, 90},
												/* Variando month1 */ /* 4 */  {2, 1, 12, 31, 1, 333},    /* 5 */ {4, 1, 12, 31, 1, 274},
												/* Variando day1   */ /* 6 */  {1, 31, 12, 31, 1, 334},   /* 7 */ {1, 32, 12, 31, 1, 364},    /* 8 */ {1, 29, 12, 31, 1, 336}, /* 9 */ {1, 30, 12, 31, 1, 335},
												/* Variando day2   */ /* 10 */ {1, 1, 12, 0, 1, 334},     /* 11 */ {1, 1, 12, 1, 1, 334},     /* 12 */ {1, 1, 12, 29, 1 ,362}, /* 13 */ {1, 1, 12 , 30, 1, 363}, /* 14 */ {1, 1, 12, 31, 1, 364},
												/* Variando year   */ /* 15 */ {1, 1, 12, 31, 2016, 365},
											  }); 
	}

	@Test 
	public void dayTest() {
		assertTrue ("Wrong number of days", expected == Cal.cal (m1, d1, m2, d2, y));
	}
}