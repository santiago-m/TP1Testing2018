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
	public static Collection<Object[]> parameters() {	// Base {1, 1, 12, 31, 1, 364}
		return Arrays.asList (new Object [][] { /* 1 */{1, 1, 1, 31, 1, 30},      /* 2 */{1, 1, 12, 31, 1, 364},      /* 3 */ {1, 1, 2, 31, 1, 31}, /* 4 */{1, 1, 4, 31, 1, 90}, 
												/* 5 */{2, 1, 12, 31, 1, 333},    /* 6 */{4, 1, 12, 31, 1, 274},      /* 7 */ {1, 31, 12, 31, 1, 334}, /* 8 */{1, 1, 12, 1, 1, 334},
												/* 9 */{1, 1, 12, 31, 2016, 365}, /* 10 */{1, 1, 12 , 31, 2017, 364} }); 
	}

	@Test 
	public void dayTest() {
		assertTrue ("Wrong number of days", expected == Cal.cal (m1, d1, m2, d2, y));
	}
}