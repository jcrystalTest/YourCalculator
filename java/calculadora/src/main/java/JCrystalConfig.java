import static jcrystal.JCrystalConfig.*;

import jcrystal.configs.clients.ClientType;

public class JCrystalConfig {
	
	private static String TEST_SERVER_URL = "http://localhost:8080/";
	
	private static String PROD_SERVER_URL = "https://yourserver.com/";
	
	public static void config(){
		//SERVER.firebaseKey = "your firebase key file.json";//It must be placed on WEB-INF
		
		addAngularExample();
		//addAndroidExample();
		//addSwiftiOSExample();
		//addMobileExample();
		//addFlutterExample();
	}
	private static void addAngularExample(){
		CLIENT.add(ClientType.TYPESCRIPT, "web")
			.setOutput("./calculator")
			.setServerUrl(TEST_SERVER_URL);
			//.setServerUrl(PROD_SERVER_URL);
	}
	private static void addAndroidExample(){
		CLIENT.addAndroid("android")
			//.enableFirebasCrashReporting()
			.setOutput("./androidgeneratedcode")
			.setServerUrl(TEST_SERVER_URL);
			//.setServerUrl(PROD_SERVER_URL);
	}
	private static void addSwiftiOSExample(){
		CLIENT.addiOS("swift")
			//.enableFirebasCrashReporting()
			.setOutput("./iosgeneratedcode")
			.setServerUrl(TEST_SERVER_URL);
			//.setServerUrl(PROD_SERVER_URL);
	}
	private static void addMobileExample(){//Combines android and iOS on one single client
		CLIENT.addMobile("mobile")
			.setOutputAndroid("./androidgeneratedcode")
			.setOutputiOS("./iosgeneratedcode")
			.setServerUrl(TEST_SERVER_URL);
			//.setServerUrl(PROD_SERVER_URL);
	}
	private static void addFlutterExample(){
		CLIENT.add(ClientType.FLUTTER, "flutter")
			.setOutput("./fluttergeneratedcode")
			.setServerUrl(TEST_SERVER_URL);
			//.setServerUrl(PROD_SERVER_URL);
	}
}
