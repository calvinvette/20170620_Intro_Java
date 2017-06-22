
public class Customer extends Object {
	private Long customerId = -1L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;

	/**
	 * No-arg CTORs are required by most frameworks like JAXB, JPA,
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct a new customer instance that has never been saved in the
	 * database. It will need to be customerDAO.insert()-ed later...
	 * 
	 * @param firstName - The customer's firstName (alphanumber, hyphens and apostrophes allowed)
	 * @param lastName
	 * @param phoneNumber
	 * @param email
	 */
	public Customer(String firstName, String lastName, String phoneNumber, String email) {
		// super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * Construct an existing customer that already exists in the database.
	 * 
	 * @param customerId - DB assigned (auto-incremented) primary key
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param email
	 */
	public Customer(Long customerId, String firstName, String lastName, String phoneNumber, String email) {
		// super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}
