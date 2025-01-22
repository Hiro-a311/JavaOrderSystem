package dto;

//仮注文の情報を保持
public class TempOrderDTO {

	private int seatId;
	private String goodsId;
	private int tempNum;

	//デフォルトコンストラクタ
	public TempOrderDTO() {

	}

	public TempOrderDTO(int seatId, String goodsId, int tempNum) {
		this.seatId = seatId;
		this.goodsId = goodsId;
		this.tempNum = tempNum;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getTempNum() {
		return tempNum;
	}

	public void setTempNum(int tempNum) {
		this.tempNum = tempNum;
	}


}
