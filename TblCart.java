package jp.co.internous.sirius.model.domain;

import java.sql.Timestamp;


/**
 * tbl_cartテーブルのドメイン
 * @author shiro-369
 *
 */
public class TblCart {
	
	private int id;
	private int userId;
	private int productId;
	private int productCount;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
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
	
	/**
	 * 登録日時を取得
	 * @return 登録日時
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * 登録日時を設定
	 * @param createdAt 登録日時
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * 更新日時を取得
	 * @return 更新日時
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * 更新日時を設定
	 * @param updatedAt 更新日時
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


}
