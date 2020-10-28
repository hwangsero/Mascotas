package miniproject.vo;

public class CommentVO {
	private int no;
	private String writer;
	private String pet_comment;
	private String type;
	private int parrent;
	private int parrent_no;
	private int board_no;
	private String reg_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void CommentVO() {

	}
	public CommentVO(int no, String writer, String pet_comment, String type, int parrent, int parrent_no,
			int board_no, String reg_date) {
		super();
		this.no = no;
		this.writer = writer;
		this.pet_comment = pet_comment;
		this.type = type;
		this.parrent = parrent;
		this.parrent_no = parrent_no;
		this.board_no = board_no;
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "CommentVO [no=" + no + ", writer=" + writer + ", pet_comment=" + pet_comment + ", type=" + type
				+ ", parrent=" + parrent + ", parrent_no=" + parrent_no + ", board_no=" + board_no + ", reg_date="
				+ reg_date + "]";
	}
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPet_comment() {
		return pet_comment;
	}
	public void setPet_comment(String pet_comment) {
		this.pet_comment = pet_comment;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getParrent() {
		return parrent;
	}
	public void setParrent(int parrent) {
		this.parrent = parrent;
	}
	public int getParrent_no() {
		return parrent_no;
	}
	public void setParrent_no(int parrent_no) {
		this.parrent_no = parrent_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int num) {
		this.board_no = num;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
}
