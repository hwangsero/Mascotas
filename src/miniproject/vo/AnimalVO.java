package miniproject.vo;

public class AnimalVO {
	private String desertionNo;	//유기번호
	private String age;			//나이
	private String happendate;		//잃어버린날
	private String findplace;	//발견된날
	private String kind;		//품종
	private String color;		//색상
	private String weight;		//무게
	private String Feature;		//특징
	private String careNM;		//보호소이름
	private String careTel;		//보호소 전화번호
	private String careAddr;	//보호 장소
	private String office;		//담당자
	private String officetel; 	//담당자 연락처
	private String processState; //현재 상태
	private String filename; 	//썸네일 사진 경로
	private String popfile;		//사진 경로
	private String sex;			//성별
	private String neuter;		//중성화 여부
	private String notice;		//특이사항
	private String noticeNo;	//공고번호
	private String noticeSdt;	//공고시작일
	private String noticeEdt;	//공고종료일
	public AnimalVO() {
		
	}
	public String getDesertionNo() {
		return desertionNo;
	}
	public void setDesertionNo(String desertionNo) {
		this.desertionNo = desertionNo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHappendate() {
		return happendate;
	}
	public void setHappendate(String happendate) {
		this.happendate = happendate;
	}
	public String getFindplace() {
		return findplace;
	}
	public void setFindplace(String findplace) {
		this.findplace = findplace;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getFeature() {
		return Feature;
	}
	public void setFeature(String feature) {
		Feature = feature;
	}
	public String getCareNM() {
		return careNM;
	}
	public void setCareNM(String careNM) {
		this.careNM = careNM;
	}
	public String getCareTel() {
		return careTel;
	}
	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}
	public String getCareAddr() {
		return careAddr;
	}
	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPopfile() {
		return popfile;
	}
	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNeuter() {
		return neuter;
	}
	public void setNeuter(String neuter) {
		this.neuter = neuter;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeSdt() {
		return noticeSdt;
	}
	public void setNoticeSdt(String noticeSdt) {
		this.noticeSdt = noticeSdt;
	}
	public String getNoticeEdt() {
		return noticeEdt;
	}
	public void setNoticeEdt(String noticeEdt) {
		this.noticeEdt = noticeEdt;
	}
	public AnimalVO(String desertionNo, String age, String happendate, String findplace, String kind, String color,
			String weight, String feature, String careNM, String careTel, String careAddr, String office,
			String officetel, String processState, String filename, String popfile, String sex, String neuter,
			String notice, String noticeNo, String noticeSdt, String noticeEdt) {
		super();
		this.desertionNo = desertionNo;
		this.age = age;
		this.happendate = happendate;
		this.findplace = findplace;
		this.kind = kind;
		this.color = color;
		this.weight = weight;
		this.Feature = feature;
		this.careNM = careNM;
		this.careTel = careTel;
		this.careAddr = careAddr;
		this.office = office;
		this.officetel = officetel;
		this.processState = processState;
		this.filename = filename;
		this.popfile = popfile;
		this.sex = sex;
		this.neuter = neuter;
		this.notice = notice;
		this.noticeNo = noticeNo;
		this.noticeSdt = noticeSdt;
		this.noticeEdt = noticeEdt;
	}
	@Override
	public String toString() {
		return "AnimalVO [desertionNo=" + desertionNo + ", age=" + age + ", happendate=" + happendate + ", findplace="
				+ findplace + ", kind=" + kind + ", color=" + color + ", weight=" + weight + ", Feature=" + Feature
				+ ", careNM=" + careNM + ", careTel=" + careTel + ", careAddr=" + careAddr + ", office=" + office
				+ ", officetel=" + officetel + ", processState=" + processState + ", filename=" + filename
				+ ", popfile=" + popfile + ", sex=" + sex + ", neuter=" + neuter + ", notice=" + notice + ", noticeNo="
				+ noticeNo + ", noticeSdt=" + noticeSdt + ", noticeEdt=" + noticeEdt + "]";
	}
	
}
