package dto;

public class SeatDTO {
	private int	seatId;
	private String	memberId;
	private int	totalNum ;
	private int alcoholNum;

	//デフォルトコンストラクタ
	public SeatDTO() {}

	
	//コンストラクタ生成
	public SeatDTO(int seatId, String memberId, int totalNum, int alcoholNum) {
		super();
		this.seatId = seatId;
		this.memberId = memberId;
		this.totalNum = totalNum;
		this.alcoholNum = alcoholNum;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getAlcoholNum() {
		return alcoholNum;
	}

	public void setAlcoholNum(int alcoholNum) {
		this.alcoholNum = alcoholNum;
	}


}
