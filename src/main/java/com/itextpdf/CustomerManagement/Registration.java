

public class Registration {

	String Name;
	String Email;
	String Password;
	String CnfPassword;
	String Age;
	String Phone;
	

	// constructor using fields
	public Registration(String name, String emailL, String password, String cnfpassword, String age, String phone) {
		
		Name = name;
		Email = emailL;
		Password = password;
		CnfPassword = cnfpassword;
		Age = age;
		Phone = phone;
		
		
	}


	public Registration() {
	// TODO Auto-generated constructor stub
}

	// getter n setter
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAge() {
		return Age;
	}


	public void setAge(String age) {
		Age = age;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}

	 public String getCnfPassword() {
		return CnfPassword;
	}


	public void setCnfPassword(String cnfPassword) {
		CnfPassword = cnfPassword;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}

	@Override
	public String toString() {
		return "Registration [Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", CnfPassword="
				+ CnfPassword + ", Age=" + Age + ", Phone=" + Phone + "]";
	}


	
	

       
	

	
	
	
	
	
}
