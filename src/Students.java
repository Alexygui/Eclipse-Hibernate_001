import java.util.Date;

//学生类
public class Students {
	private int sid; //学号
	private String naame;  //姓名
	private String gender;  //性别
	private Date birthday; //出生日期
	private String address;  //地址
	
	public Students() {}

	public Students(int sid, String naame, String gender, Date birthday, String address) {
		//super();
		this.sid = sid;
		this.naame = naame;
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

	public String getNaame() {
		return naame;
	}

	public void setNaame(String naame) {
		this.naame = naame;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
