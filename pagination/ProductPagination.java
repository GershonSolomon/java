package Com.Product.Pagination;

import java.util.Scanner;

public class ProductPagination {
	public static final String urlForDB = "jdbc:mysql://localhost:3306/super_market";
	public static final String userName = "root";
	public static final String passwordForDb = "Gero@2002";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter page number:");
		int pageNumber = scan.nextInt();
		Pagination pagination = new Pagination();
		pagination.pagination(pageNumber);

		int choice;
		System.out.println("Enter 1 to show next page");
		System.out.println("Enter 2 to exit");
		choice = scan.nextInt();
		do {

			if (choice == 1) {
				pageNumber = pageNumber + 1;
				pagination.pagination(pageNumber);
				System.out.println("Enter 1 to show next page");
				System.out.println("Enter 2 to exit");
				choice = scan.nextInt();

			} else {
				System.out.println("thank you");
			}

		} while (choice == 1);

	}
}
