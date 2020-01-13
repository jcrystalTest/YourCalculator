package jcrystal.context;
public class CrystalContext{
	public static final ThreadLocal<CrystalContext> userThreadLocal = new ThreadLocal<>();
	public static void set(){
		userThreadLocal.set(new CrystalContext());
	}
	public static void clear(){
		userThreadLocal.remove();
	}
	public static CrystalContext get(){
		CrystalContext ret = userThreadLocal.get();
		if(ret == null){
			userThreadLocal.set(ret = new CrystalContext());
		}
		return ret;
	}
	private jcrystal.context.DataStoreContext DefaultDB;
	public jcrystal.context.DataStoreContext DefaultDB(){
		if(DefaultDB == null){
			DefaultDB = new jcrystal.context.DataStoreContext();
		}
		return DefaultDB;
	}
}
