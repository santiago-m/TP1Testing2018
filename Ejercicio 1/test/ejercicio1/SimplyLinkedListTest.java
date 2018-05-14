package ejercicio1;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import java.util.*;

@RunWith (Theories.class)
public class SimplyLinkedListTest {

	@Theory
	public void addThenRemoveDoesNotChangeListSize(@SimpleIntListGen(min = 1, max=50) List<Integer> list)  // Parameters!
	{
		assumeTrue(!list.isEmpty());
		
		SinglyLinkedList s = new SinglyLinkedList();
		SinglyLinkedList copy_of_s = new SinglyLinkedList();
		
		assumeTrue(s.getSize() == copy_of_s.getSize());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString() + "\n");
		}
		
		s.addFirst(list.get(0));
		s.remove(list.get(0));
		
		assertTrue(s.getSize() == copy_of_s.getSize());
	}

}
