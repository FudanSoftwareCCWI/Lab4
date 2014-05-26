package controller;

public class Launch {

	public static void main(String[] args) {
		System.out.println("Launch: launch...");
		RootController mainController = new RootController();
		mainController.init();
		mainController.start();
	}

}
