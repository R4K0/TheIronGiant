package milosz;

public class Employee {
	private String PPS;
	private String FirstName;
	private String SecondName;
	private boolean Manager = false;
	
	public Employee(String pPS, String firstName, String secondName) {
		super();
		PPS = pPS;
		FirstName = firstName;
		SecondName = secondName;
	}
	
	public Employee(String pPS, String firstName, String secondName, boolean manager) {
		super();
		PPS = pPS;
		FirstName = firstName;
		SecondName = secondName;
		Manager = manager;
	}

	public String getPPS() {
		return PPS;
	}
	public void setPPS(String pPS) {
		PPS = pPS;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	public boolean isManager() {
		return Manager;
	}
	public void setManager(boolean manager) {
		Manager = manager;
	}
	
	public void makeActive() {
		IronGiant.setUser( this );
	}
}
