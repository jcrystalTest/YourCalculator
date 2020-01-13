package jcrystal.clients;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import jcrystal.json.JsonLevel;
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientLevel{
	public JsonLevel web() default JsonLevel.DEFAULT;
}
