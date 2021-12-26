package jp.co.internous.sirius.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.sirius.model.domain.TblCart;
import jp.co.internous.sirius.model.domain.dto.CartDto;
import jp.co.internous.sirius.model.form.CartForm;

/**
 * tbl_cartテーブルにアクセスするDAO
 * @author shiro-369
 *
 */
@Mapper
public interface TblCartMapper {
	
	/**
	 * ユーザーIDに紐づくカート情報を取得
	 * @param userId ユーザーID
	 * @return カート情報リスト
	 */
	List<CartDto> findByUserId(int userId);

	/**
	 * ユーザーIDと商品IDに紐づくカート情報を取得
	 * @param userId
	 * @param productId
	 * @return  カート情報リスト
	 */
	@Select("SELECT * FROM tbl_cart WHERE user_id = #{userId} AND product_id = #{productId}")
	List<TblCart> findByUserIdAndProductId(@Param("userId") int userId, @Param("productId") int productId);
	
	/**
	 * ユーザーIDに紐づくカート情報の商品個数を更新
	 * @param f カート情報のForm
	 * @return 更新した件数
	 */
	@Update("UPDATE tbl_cart SET product_count = product_count + #{productCount},  updated_at = now() WHERE user_id = #{userId} and product_id = #{productId}")
	int tblCartUpdate(CartForm f);
	
	/**
	 * カート情報を登録
	 * @param f カート情報のForm
	 * @return 登録した件数
	 */
	@Insert("INSERT INTO tbl_cart (user_id, product_id, product_count) VALUES (#{userId}, #{productId}, #{productCount})")
	int tblCartInsert(CartForm f);
	
	/**
	 * チェックされたカートIDのカート情報を削除
	 * @param checkedIds チェックされたカートID
	 * @return 削除された件数
	 */
	int deleteCartById(@Param("checkedIds")List<String> checkedIds);
	
	/**
	 * ユーザーIDに紐づいているカート情報を削除
	 * @param userId ユーザーID
	 * @return true:削除成功、false:削除失敗
	 */
	@Delete("DELETE FROM tbl_cart WHERE user_id = #{userId}")
	boolean deleteCartByUserId(int userId);
	
	/**
	 * 仮ユーザーIDに紐づいているカート情報の件数を取得
	 * @param tmpUserId 仮ユーザーID
	 * @return カート情報件数
	 */
	@Select("SELECT count(user_id) FROM tbl_cart WHERE user_id = #{tmpUserId}")
	int findCountByUserId(int tmpUserId); 
	
	/**
	 * 仮ユーザーIDに紐づいているカート情報のユーザーIDを更新
	 * @param userId ユーザーID
	 * @param tmpUserId 仮ユーザーID
	 */
	@Update("UPDATE tbl_cart SET user_id = #{userId}, updated_at = now() WHERE user_id = #{tmpUserId}")
	void updateUserId(@Param("userId") int userId,@Param("tmpUserId") int tmpUserId);


}