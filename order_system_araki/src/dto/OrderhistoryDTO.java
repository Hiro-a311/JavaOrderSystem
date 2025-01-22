package dto;

//注文履歴情報を保持するクラス
public class OrderhistoryDTO {
	private int seatId;
	private String goodsId;
	private int orderNum;
	private int orderFlag;

	public OrderhistoryDTO() {
	}

	public OrderhistoryDTO(int seatId, String goodsId, int orderNum, int orderFlag) {
		super();
		this.seatId = seatId;
		this.goodsId = goodsId;
		this.orderNum = orderNum;
		this.orderFlag = orderFlag;
	}

	public int getSeatId() {
		return seatId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public int getOrderFlag() {
		return orderFlag;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}



}
