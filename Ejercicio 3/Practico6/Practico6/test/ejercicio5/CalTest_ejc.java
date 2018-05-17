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
		return Arrays.asList (new Object [][] { /* F  T,T  F  */ {1, 1, 3, 1, 2010, 59}, 
												/* F  F,F  F  */ {1, 1, 3, 1, 2016, 60}, 
												/* T   _,_  T */ {1, 1, 1, 1, 2016, 0}
											  }); 
	}
	


	@Test 
	public void dayTest() {
		/*Cal.main(new String[0]);
		
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		String expect = outContent.toString();*/
		assertTrue ("Wrong number of days", expected == Cal.cal (m1, d1, m2, d2, y));
	}
	
	/*@Test
	public void methodShouldLaunchTheSpaceShuttle() {
	  StringWriter output = new StringWriter();
	  String input = "5\n"        // "Please enter another value!"
	               + "10\n"       // "Code accepted. Enter command:"
	               + "Shuttle\n"; // "Launching space shuttle..."
	  systemUnderTest.method(new Scanner(input), new PrintWriter(output));

	  assertThat(output.toString(), contains("Please enter another value!"));
	  assertTrue(systemUnderTest.spaceShuttleLaunched());
	}*/
}