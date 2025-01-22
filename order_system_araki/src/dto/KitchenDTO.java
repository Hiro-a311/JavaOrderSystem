package dto;

//オーダー(厨房)情報を保持するクラス
public class KitchenDTO {
	private int seatId;
	private String goodsId;
	private int orderNum;
	private boolean orderFlag;

	public KitchenDTO() {
	}

	public KitchenDTO(int seatId, String goodsId, int orderNum, boolean orderFlag) {
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

	public boolean isOrderFlag() {
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

	public void setOrderFlag(boolean orderFlag) {
		this.orderFlag = orderFlag;
	}


}
