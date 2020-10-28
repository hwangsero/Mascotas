package miniproject.vo;

import java.io.Serializable;

public class BoardVO implements Serializable {
	private int no;
	private int printno;
	private String cate;
	private String race;
	private String com_cate;
	private String title;
	private String content;
	private String writer;
	private int view_cnt;
	private String reg_date;
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int printno, String cate, String race, String title, String writer, String content,
			int view_cnt, String reg_date) {
		super();
		this.printno = printno;
		this.cate = cate;
		this.race = race;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
	}
	
	public BoardVO(int no, int printno, String cate, String race, String title, String content, String writer,
			int view_cnt, String reg_date) {
		super();
		this.no = no;
		this.printno = printno;
		this.cate = cate;
		this.race = race;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
	}

	
	public BoardVO(int printno, String cate, String race, String com_cate, String title, String writer, 
					String content, int view_cnt, String reg_date) {
		super();
		this.printno = printno;
		this.cate = cate;
		this.race = race;
		this.com_cate = com_cate;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.view_cnt = view_cnt;
		this.reg_date = reg_date;
	}
	
	public BoardVO(int no, int printno, String cate, String race, String com_cate, String title, String content,
			String writer, int view_cnt, String reg_date) {
		super();
		this.no = no;
		this.printno = printno;
		this.cate = cate;
		this.race = race;
		this.com_cate = com_cate;
		this.title = title;
		this.content = content;
		this.writer = writer;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getCom_cate() {
		return com_cate;
	}

	public void setCom_cate(String com_cate) {
		this.com_cate = com_cate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", printno=" + printno + ", cate=" + cate + ", race=" + race + ", com_cate="
				+ com_cate + ", title=" + title + ", content=" + content + ", writer=" + writer + ", view_cnt="
				+ view_cnt + ", reg_date=" + reg_date + "]";
	}

	
	
	
}
