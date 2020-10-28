package miniproject.vo;

public class BoardFileVO {
	private int no;
	private int boardNo;
	private String file_ori_name;
	private String file_save_name;
	
	public BoardFileVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardFileVO(int no, int boardNo, String file_ori_name, String file_save_name) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.file_ori_name = file_ori_name;
		this.file_save_name = file_save_name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getFile_ori_name() {
		return file_ori_name;
	}

	public void setFile_ori_name(String file_ori_name) {
		this.file_ori_name = file_ori_name;
	}

	public String getFile_save_name() {
		return file_save_name;
	}

	public void setFile_save_name(String file_save_name) {
		this.file_save_name = file_save_name;
	}

	@Override
	public String toString() {
		return "BoardFileVO [no=" + no + ", boardNo=" + boardNo + ", file_ori_name=" + file_ori_name
				+ ", file_save_name=" + file_save_name + "]";
	}	
}
