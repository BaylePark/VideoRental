import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in);
	private static Controller controller = new Controller();

	public static void main(String[] args) {
		VRUI ui = new VRUI();

		boolean quit = false;
		while (!quit) {
			int command = ui.showCommand();
			switch (command) {
			case 0:
				quit = true;
				break;
			case 1:
				System.out.println("List of customers");
				controller.listCustomers();
				System.out.println("End of list");
				break;
			case 2:
				System.out.println("List of videos");
				controller.listVideos();
				System.out.println("End of list");
				break;
			case 3:
				System.out.println("Enter customer name: ");
				String name = scanner.next();
				controller.registerCustomer(name);
				break;
			case 4:
				System.out.println("Enter video title to register: ");
				String title = scanner.next();

				System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
				int videoType = scanner.nextInt();

				System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
				int priceCode = scanner.nextInt();
				controller.registerVideo(title, videoType, priceCode);
				break;
			case 5:
				System.out.println("Enter customer name: ");
				String customerName = scanner.next();

				System.out.println("Enter video title to return: ");
				String videoTitle = scanner.next();

				controller.rentVideo(customerName, videoTitle);
				break;
			case 6:
				System.out.println("Enter customer name: ");
				String customerName2 = scanner.next();

				System.out.println("Enter video title to return: ");
				String videoTitle2 = scanner.next();

				controller.returnVideo(customerName2, videoTitle2);
				break;
			case 7:
				System.out.println("Enter customer name: ");
				String customerName3 = scanner.next();
				controller.getCustomerReport(customerName3);
				break;
			case 8:
				System.out.println("Enter customer name: ");
				String name2 = scanner.next();

				controller.clearRentals(name2);
				break;
			case -1:
				controller.init();
				break;
			default:
				break;
			}
		}
		System.out.println("Bye");
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt();

		return command;
	}
}
