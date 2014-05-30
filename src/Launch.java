import wm.controller.RootController;

public class Launch {

	public static void main(String[] args) {
		System.out.println("Launch: launch...");
		RootController rootDelegate = new RootController();
		rootDelegate.init();
		rootDelegate.start();
	}

}
