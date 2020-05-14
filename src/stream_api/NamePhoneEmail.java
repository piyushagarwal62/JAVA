package stream_api;

/**
 * @author piyush.agarwal
 *
 */
public class NamePhoneEmail {

	String name;
	String phoneNum;
	String email;
	
	public NamePhoneEmail(String name, String phoneNum, String email) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return name + ":" + phoneNum + ":" + email;
	}
	
}
