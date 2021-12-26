package jp.co.internous.sirius.model.domain.dto;
/**
 * cart.htmlに表示するためのDTO
 * @author shiro-369
 *
 */
public class CartDto {
	
	// tbl_cart.id
	private int id;
	//mst_product.image_full_path
	private String imageFullPath;
	//mst_product.product_name
	private String productName;
	//mst_product.price
	private int price;
	//tbl_cart.product_count
	private int productCount;
	//mst_product.price * tbl_cart.product_count
	private int subtotal;
	
	/**
	 * カートIDを取得
	 * @return カートID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * カートIDを設定
	 * @param id カートID
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 画像のフルパスを取得
	 * @return 　画像のフルパス
	 */
	public String getImageFullPath() {
		return imageFullPath;
	}
	
	/**
	 * 画像のフルパスを設定
	 * @param imageFullPath 画像のフルパス
	 */
	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}
	
	/**
	 * 商品名を取得
	 * @return 商品名
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 商品名を設定
	 * @param productName 商品名
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * 商品価格を取得
	 * @return 商品価格
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 商品価格を設定
	 * @param price 商品価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * 商品個数を取得
	 * @return 商品個数
	 */
	public int getProductCount() {
		return productCount;
	}
	/**
	 * 商品個数を設定
	 * @param productCount 商品個数
	 */
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
	/**
	 * 商品の小計を取得
	 * @return 商品小計
	 */
	public int getSubtotal() {
		return subtotal;
	}
	
	/**
	 * 商品の小計を設定
	 * @param subtotal 商品小計
	 */
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
}
