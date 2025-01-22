package dto;
//商品一覧情報を保持するクラス
public class GoodsDTO {
	private String goodsId;
	private String goodsName;
	private int goodsPrice;
	private String goodsClass;
	private String goodsPic;
	private boolean goodsFlag;

	//デフォルトコンストラクタ
	public GoodsDTO() {}

	//コンストラクタ生成
	/**
	 * @param goodsId
	 * @param goodsName
	 * @param goodsPrice
	 * @param goodsClass
	 * @param goodsPic
	 * @param goodsFlag
	 */
	public GoodsDTO(String goodsId, String goodsName, int goodsPrice, String goodsClass, String goodsPic,
			boolean goodsFlag) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsClass = goodsClass;
		this.goodsPic = goodsPic;
		this.goodsFlag = goodsFlag;
	}
	
	//getter,setter
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsClass() {
		return goodsClass;
	}

	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public boolean isGoodsFlag() {
		return goodsFlag;
	}

	public void setGoodsFlag(boolean goodsFlag) {
		this.goodsFlag = goodsFlag;
	}
}
