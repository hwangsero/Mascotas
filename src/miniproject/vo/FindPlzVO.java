package miniproject.vo;

public class FindPlzVO {
private int no;
private int printno;
private String cate;
private String race;
private String sex;
private String age;
private String name;
private String lostDate;
private String lostSpot;
private String feature;
private String etc;
private String writer;
private String tel;
private int view_cnt;
private String reg_date;

public FindPlzVO() {
	super();
	// TODO Auto-generated constructor stub
}




public FindPlzVO(int no, String cate, String race, String sex, String age, String name, String lostDate,
		String lostSpot, String feature, String etc, String writer, String tel) {
	super();
	this.no = no;
	this.cate = cate;
	this.race = race;
	this.sex = sex;
	this.age = age;
	this.name = name;
	this.lostDate = lostDate;
	this.lostSpot = lostSpot;
	this.feature = feature;
	this.etc = etc;
	this.writer = writer;
	this.tel = tel;
}




public FindPlzVO(int no, int printno, String cate, String race, String sex, String age, String name, String lostDate,
		String lostSpot, String feature, String etc, String writer, String tel, int view_cnt, String reg_date) {
	super();
	this.no = no;
	this.printno = printno;
	this.cate = cate;
	this.race = race;
	this.sex = sex;
	this.age = age;
	this.name = name;
	this.lostDate = lostDate;
	this.lostSpot = lostSpot;
	this.feature = feature;
	this.etc = etc;
	this.writer = writer;
	this.tel = tel;
	this.view_cnt = view_cnt;
	this.reg_date = reg_date;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public int getPrintno() {
	return printno;
}
public void setPrintno(int printno) {
	this.printno = printno;
}
public String getCate() {
	return cate;
}
public void setCate(String cate) {
	this.cate = cate;
}
public String getRace() {
	return race;
}
public void setRace(String race) {
	this.race = race;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLostDate() {
	return lostDate;
}
public void setLostDate(String lostDate) {
	this.lostDate = lostDate;
}
public String getLostSpot() {
	return lostSpot;
}
public void setLostSpot(String lostSpot) {
	this.lostSpot = lostSpot;
}
public String getFeature() {
	return feature;
}
public void setFeature(String feature) {
	this.feature = feature;
}
public String getEtc() {
	return etc;
}
public void setEtc(String etc) {
	this.etc = etc;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public int getView_cnt() {
	return view_cnt;
}
public void setView_cnt(int view_cnt) {
	this.view_cnt = view_cnt;
}
public String getReg_date() {
	return reg_date;
}
public void setReg_date(String reg_date) {
	this.reg_date = reg_date;
}




@Override
public String toString() {
	return "FindPlzVO [no=" + no + ", printno=" + printno + ", cate=" + cate + ", race=" + race + ", sex=" + sex
			+ ", age=" + age + ", name=" + name + ", lostDate=" + lostDate + ", lostSpot=" + lostSpot + ", feature="
			+ feature + ", etc=" + etc + ", writer=" + writer + ", tel=" + tel + ", view_cnt=" + view_cnt
			+ ", reg_date=" + reg_date + ", getNo()=" + getNo() + ", getPrintno()=" + getPrintno() + ", getCate()="
			+ getCate() + ", getRace()=" + getRace() + ", getSex()=" + getSex() + ", getAge()=" + getAge()
			+ ", getName()=" + getName() + ", getLostDate()=" + getLostDate() + ", getLostSpot()=" + getLostSpot()
			+ ", getFeature()=" + getFeature() + ", getEtc()=" + getEtc() + ", getWriter()=" + getWriter()
			+ ", getTel()=" + getTel() + ", getView_cnt()=" + getView_cnt() + ", getReg_date()=" + getReg_date()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}



}
