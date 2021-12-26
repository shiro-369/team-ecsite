package jp.co.internous.sirius.model.form;

import java.io.Serializable;
/**
 * カートフォーム
 * @author shiro-369
 *
 */
public class CartForm implements Serializable {
	private static final long serialVersionUID = -4635102325048501117L;
	private int userId;
	private int productId;
	private int productCount;
	
	/**
	 * ユーザーIDを取得
	 * @return ユーザーID
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * ユーザーIDを設定
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * 商品IDを取得
	 * @return 商品ID
	 */
	public int getProductId() {
		return productId;
	}
	
	/**
	 * 商品IDを設定
	 * @param productId 商品ID
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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

}
