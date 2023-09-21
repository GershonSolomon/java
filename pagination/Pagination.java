package Com.Product.Pagination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pagination {

	public void pagination(int pageNumber) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(ProductPagination.urlForDB, ProductPagination.userName,
					ProductPagination.passwordForDb);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int pageSize = 10;

		try {
			String query = "SELECT * FROM product ORDER BY product_id ASC LIMIT ? OFFSET ? ";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, pageSize);
			preparedStatement.setInt(2, (pageNumber - 1) * pageSize);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("product_id");
				String name = resultSet.getString("product_name");
				long categoryId = resultSet.getLong("category_id");
				float price = resultSet.getFloat("price");
				long supplierId = resultSet.getLong("supplier_id");
				float quantity = resultSet.getFloat("quantity");

				System.out.println("ID: " + id + ", Name: " + name + " category ID: " + categoryId + " price: " + price
						+ " SupplierID: " + supplierId + " quantity: " + quantity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
