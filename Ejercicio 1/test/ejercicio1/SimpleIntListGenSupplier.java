package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class SimpleIntListGenSupplier extends ParameterSupplier {

	public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
		SimpleIntListGen annotation = sig.getAnnotation(SimpleIntListGen.class);
		int min = annotation.min();
		int max = annotation.max();
		
		List<PotentialAssignment> listsOfIntegers = new ArrayList<PotentialAssignment>();
		Random rand;
		
		for (int i = 0; i < 10; i++) {
			rand = new Random();
			List<Integer> generatedList = new ArrayList<Integer>(); 
			
			for (int j = 0; j < 10; j++) {
				int k = rand.nextInt(min) + max;
				generatedList.add(k);
			}
			
			listsOfIntegers.add(PotentialAssignment.forValue("lista " + i, generatedList));
		}
		return listsOfIntegers;
	}
}
