package ejercicio1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;


@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(SimpleIntListGenSupplier.class)
public @interface SimpleIntListGen {
	int min();
	int max();
}