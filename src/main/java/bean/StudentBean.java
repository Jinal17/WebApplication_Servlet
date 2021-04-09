
package main.java.bean;

/**
 * @author Justin Carlitti. This class represents the Java Bean of Student Form. 
 */
public class StudentBean {

	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

	// Instance variables related to the survey form attributes
	private String studentId;
	private String username;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNo;
	private String email;
	private String url;
	private String hsGradMonth;
	private String hsGradYear;
	private String likedMost;
	private String interested;
	private String comments;
	private String recommend;

	// Constructor
	public StudentBean(String studentId, String username, String streetAddress, String city, String state,
			String zipCode, String phoneNo, String email, String url,
			String hsGradMonth, String hsGradYear, String likedMost, String interested, String comments,
			String recommend) {

		this.studentId = studentId;
		this.username = username;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.email = email;
		this.url = url;
		this.hsGradMonth = hsGradMonth;
		this.hsGradYear = hsGradYear;
		this.likedMost = likedMost;
		this.interested = interested;
		this.comments = comments;
		this.recommend = recommend;
	}

//Getter Setter
	public String getStudentId() {

		return this.studentId;

	}

	public void setStudentId(String studentId) {

		this.studentId = studentId;

	}

	public String getUsername() {

		return this.username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getStreetAddress() {

		return this.streetAddress;

	}

	public void setStreetAddress(String streetAddress) {

		this.streetAddress = streetAddress;

	}

	public String getCity() {

		return this.city;

	}

	public void setCity(String city) {

		this.city = city;

	}

	public String getState() {

		return this.state;

	}

	public void setState(String state) {

		this.state = state;

	}

	public String getZipCode() {

		return this.zipCode;

	}

	public void setZipCode(String zipCode) {

		this.zipCode = zipCode;

	}

	public String getPhoneNo() {

		return this.phoneNo;

	}

	public void setPhoneNo(String phoneNo) {

		this.phoneNo = phoneNo;

	}

	public String getEmail() {

		return this.email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getUrl() {

		return this.url;

	}

	public void setUrl(String url) {

		this.url = url;

	}

	public String getHsGradMonth() {

		return this.hsGradMonth;

	}

	public void setHsGradMonth(String hsGradMonth) {

		this.hsGradMonth = hsGradMonth;

	}

	public String getHsGradYear() {

		return this.hsGradYear;

	}

	public void setHsGradYear(String hsGradYear) {

		this.hsGradYear = hsGradYear;

	}

	public String getLikedMost() {

		return this.likedMost;

	}

	public void setLikedMost(String likedMost) {

		this.likedMost = likedMost;

	}

	public String getInterested() {

		return this.interested;

	}

	public void setInterested(String interested) {

		this.interested = interested;

	}

	public String getComments() {

		return this.comments;

	}

	public void setComments(String comments) {

		this.comments = comments;

	}

	public String getRecommend() {

		return this.recommend;

	}

	public void setRecommend(String recommend) {

		this.recommend = recommend;

	}
}
