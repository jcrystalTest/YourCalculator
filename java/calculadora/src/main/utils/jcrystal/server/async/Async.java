package jcrystal.server.async;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface Async{
	Q name();
	boolean namabled() default false;
	boolean timeable() default false;
	public enum Q{
		;
	}
}
