package miniproject.vo;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String email_id;
	private String email_domain;
	private String basic_addr;
	private String detail_addr;
	private String type;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserVO(String id, String password, String name, String email_id, String email_domain, String basic_addr,
			String detail_addr, String type) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email_id = email_id;
		this.email_domain = email_domain;
		this.basic_addr = basic_addr;
		this.detail_addr = detail_addr;
		this.type = type;
	}
	
	public UserVO(String id,String name){
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}

	public String getBasic_addr() {
		return basic_addr;
	}

	public void setBasic_addr(String basic_addr) {
		this.basic_addr = basic_addr;
	}

	public String getDetail_addr() {
		return detail_addr;
	}

	public void setDetail_addr(String detail_addr) {
		this.detail_addr = detail_addr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", email_id=" + email_id
				+ ", email_domain=" + email_domain + ", basic_addr=" + basic_addr + ", detail_addr=" + detail_addr
				+ ", type=" + type + "]";
	}


	
}
