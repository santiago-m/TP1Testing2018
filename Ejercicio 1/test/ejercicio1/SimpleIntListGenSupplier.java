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
		int minValue = annotation.minValue();
		int maxValue = annotation.maxValue();
		int minLength = annotation.minLength();
		int maxLength = annotation.maxLength();
		
		
		List<PotentialAssignment> listsOfIntegers = new ArrayList<PotentialAssignment>();
		Random value = new Random();
		Random length = new Random();
		
		for (int i = 0; i < 10; i++) {
			int listSize = length.nextInt(maxLength) + minLength;
			List<Integer> generatedList = new ArrayList<Integer>(listSize); 
			
			for (int j = 0; j < listSize; j++) {
				int k = value.nextInt(maxValue) + minValue;
				generatedList.add(k);
			}
			
			listsOfIntegers.add(PotentialAssignment.forValue("lista " + i, generatedList));
		}
		return listsOfIntegers;
	}
}
