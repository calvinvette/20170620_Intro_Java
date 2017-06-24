package com.trivera.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Map;

public class WeasleyConsoleStore {
	private static Map<String, Customer> customerMap = new Hashtable<>();
	private static BufferedReader input;
	private static Connection conn = null;

	public static Customer insertCustomerIntoDatabase(Customer c) {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost:1527/weasley;create=true", "calvin",
						"password");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("insert into customer (firstName, lastName, phoneNumber, email) values (" + "'"
						+ c.getFirstName() + "', '" + c.getLastName() + "', '" + c.getPhoneNumber() + "', '"
						+ c.getEmail() + "')");
				// The "Generated Keys" has the auto-incremented customerId in
				// it. Extract it out and update the
				// customer object with it.
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs != null && rs.next()) {
					c.setCustomerId(rs.getLong("customerId"));
				} else {
					System.out.println("No auto-generated keys!");
				}
				return c;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Customer addCustomer() {
		try {
			System.out.print("First Name:\t");
			String firstName = input.readLine();
			System.out.print("Last Name:\t");
			String lastName = input.readLine();
			System.out.print("Phone Number:\t");
			String phoneNumber = input.readLine();
			System.out.print("Email:\t\t");
			String email = input.readLine();
			Customer c = new Customer(firstName, lastName, phoneNumber, email);
			// The DB will change the customer by assigning its primary key
			// This could have been done with re-assignment or just usingthe
			// passed-by-reference customer to be modified
			// The re-assignment shouldn't be necessary for this local
			// application
			c = insertCustomerIntoDatabase(c);
			customerMap.put(lastName + "," + firstName, c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Customer searchByLastNameAndFirstName(String lastName, String firstName) {
		return customerMap.get(lastName + "," + firstName);
	}

	public static Customer updateCustomer() {
		System.out.println("Not implemented.");
		return null;
	}

	public static void listCustomers() {
		for (Customer customer : customerMap.values()) {
			System.out.println(customer);
		}
	}

	private static void dumpToFile() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("customers.txt"));
			for (Customer c : customerMap.values()) {
				// out.write(c.getCustomerId().toString());
				// out.write('\t');
				// out.write(c.getFirstName());
				// out.write('\t');
				// out.write(c.getLastName());
				// out.write('\t');
				// out.write(c.getPhoneNumber());
				// out.write('\t');
				// out.write(c.getEmail());
				// out.write('\n');
				out.println(c.getCustomerId() + "\t" + c.getFirstName() + "\t" + c.getLastName() + "\t"
						+ c.getPhoneNumber() + "\t" + c.getEmail());
				// out.flush();
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void readDumpFile() {
		int currentLineNum = 0;
		try {
			BufferedReader fileIn = new BufferedReader(new FileReader("customers.txt"));
			String line = null;
			while ((line = fileIn.readLine()) != null) {
				// System.out.println(line);
				currentLineNum++;
				String[] fields = line.split("\t");
				try {
					Customer c = new Customer(new Long(fields[0]), // It's a
																	// String,
																	// so we
																	// convert
																	// customerId
																	// to a
																	// number
							fields[1], // firstName
							fields[2], // lastName
							fields[3], // phoneNumber
							fields[4] // email
					);
					customerMap.put(fields[2] + "," + fields[1], c);
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + " on customers.txt line#" + currentLineNum);
				}
			}
			System.out.println("Read " + currentLineNum + " customers");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + " on customers.txt line#" + currentLineNum);
		}
	}

	public static void main(String[] args) {
		Statement stmt = null;
		try {
			// conn =
			// DriverManager.getConnection("jdbc:derby://localhost:1527/weasley",
			// "calvin", "password");
			// Need to launch the DB, create the DB and table first.
			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost:1527/weasley;create=true", "calvin",
						"password");
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
				while (rs.next()) {
					Long customerId = rs.getLong("customerId");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String phoneNumber = rs.getString("phoneNumber");
					String email = rs.getString("email");
					customerMap.put(lastName + "," + firstName,
							new Customer(customerId, firstName, lastName, phoneNumber, email));
				}
				rs.close();
			} catch (SQLException e) {
				System.out.println("Database can't connect - read and save to files locally instead!");
			}

			boolean done = false;
			input = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			System.out.println("Welcome to Weasley's!");
			printHelp();
			while (!done) {
				try {
					line = input.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				switch (line.toLowerCase()) {
				case "q":
				case "quit":
					done = true;
					break;
				case "a":
				case "add":
					addCustomer();
					break;
				case "l":
				case "list":
					listCustomers();
					break;
				case "f":
				case "find":
					try {
						System.out.println("LastName to find:\t");
						String lastName = input.readLine();
						System.out.println("FirstName to find:\t");
						String firstName = input.readLine();
						Customer found = searchByLastNameAndFirstName(lastName, firstName);
						System.out.println(found);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				// case "s":
				// case "save":
				// break;
				case "u":
				case "update":
					updateCustomer();
					break;
				case "d":
				case "dump":
					dumpToFile();
					break;
				case "r":
				case "read":
					readDumpFile();
					break;

				default:
					printHelp();
				}
			}
			System.out.println("Bye!");
//		} catch (SQLException e1) {
//			// e1.printStackTrace();
//			switch (e1.getErrorCode()) {
//			case 40000:
//				System.out.println("Database Does not exist. Need to create!");
//			default:
//				System.out.println("Unknown Error Code: " + e1.getErrorCode());
//				System.out.println(e1.getMessage());
//			}
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	private static void printHelp() {
		System.out.println("Unknown option!");
		System.out.println("a) Add customer");
		System.out.println("u) Update customer");
		System.out.println("l) List customers");
		System.out.println("d) dump customers to customers.txt file");
		System.out.println("r) read customers from customers.txt file");
		System.out.println("q) Quit");
	}

}
