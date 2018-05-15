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
	public void addThenRemoveDoesNotChangeListSize(@SimpleIntListGen(minValue = -3, maxValue=3, minLength = 0, maxLength = 3) List<Integer> list) {
		assumeTrue(!list.isEmpty());
		
		SinglyLinkedList s = new SinglyLinkedList();
		SinglyLinkedList copy_of_s = new SinglyLinkedList();
		
		assumeTrue(s.getSize() == copy_of_s.getSize());
		
		s.addFirst(list.get(0));
		s.remove(list.get(0));
		
		assertTrue(s.getSize() == copy_of_s.getSize());
	}
	
	@Theory
	public void listStartsEmpty() {
		SinglyLinkedList s = new SinglyLinkedList();
		assertTrue(s.isEmpty());
	}
	
	@Theory
	public void copyContainsAllElementsOfOriginalNotEmpty(@SimpleIntListGen(minValue = -3, maxValue=3, minLength = 0, maxLength = 3) List<Integer> list) {
		assumeTrue(!list.isEmpty());
		
		SinglyLinkedList s = new SinglyLinkedList();
		
		for (int i = 0; i < list.size(); i++) {
			s.addFirst(i);
		}
		
		SinglyLinkedList copy_of_s = new SinglyLinkedList(s);
		
		boolean containsAll = false;
		
		Node current = s.getHeader().getNext();	
		while (current!=null){
			if(copy_of_s.contains(current.getValue())) {
				containsAll = true;
			}
			else {
				containsAll = false;
				break;
			}
			current = current.getNext();
		} 
		
		assertTrue(containsAll);
	}
	
	@Theory
	public void addThenRemoveInEmptyListRemainsItEmpty() {
		SinglyLinkedList s = new SinglyLinkedList();
		
		assumeTrue(s.isEmpty());
		
		s.addFirst(1);
		s.remove(1);
		
		assertTrue(s.isEmpty());
	}

}
