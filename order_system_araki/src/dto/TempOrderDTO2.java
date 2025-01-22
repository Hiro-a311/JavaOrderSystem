package dto;

public class TempOrderDTO2 {
	private int goodsPrice;
	private String goodsName;
	private int tempNum;

	public TempOrderDTO2(int goodsPrice, String goodsName, int tempNum) {
		super();
		this.goodsPrice = goodsPrice;
		this.goodsName = goodsName;
		this.tempNum = tempNum;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getTempNum() {
		return tempNum;
	}

	public void setTempNum(int tempNum) {
		this.tempNum = tempNum;
	}


}
