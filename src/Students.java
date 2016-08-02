import java.sql.Blob;
import java.util.Date;


//学生类
public class Students {
	private int sid; //学号
	private String sname;  //姓名
	private String gender;  //性别
	private Date birthday; //出生日期
	//private String address;  //地址
	private Blob picture; //照片
	private Address address; //地址
	
	public Students() {}

	public Students(int sid, String sname, String gender, Date birthday,Address  address) {
		//super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
