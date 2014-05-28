import controller.RootDelegate;

public class Launch {

	public static void main(String[] args) {
		System.out.println("Launch: launch...");
		RootDelegate rootDelegate = new RootDelegate();
		rootDelegate.init();
		rootDelegate.start();
	}

}
