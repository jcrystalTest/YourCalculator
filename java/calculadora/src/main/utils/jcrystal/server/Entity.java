package jcrystal.server;
public class Entity{
	private Entity(){}
	public interface DefaultDB{
		public com.google.appengine.api.datastore.Entity getRawEntity();
		default void deleteTxn(){
			jcrystal.context.CrystalContext $ctx = jcrystal.context.CrystalContext.get();
			$ctx.DefaultDB().service.delete($ctx.DefaultDB().getTxn(), getRawEntity().getKey());
		}
		default void delete(){
			jcrystal.context.CrystalContext.get().DefaultDB().service.delete((com.google.appengine.api.datastore.Transaction)null, getRawEntity().getKey());
		}
		default com.google.appengine.api.datastore.Key getKey(){
			return getRawEntity().getKey();
		}
	}
}
