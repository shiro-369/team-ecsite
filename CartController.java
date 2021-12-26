package jp.co.internous.sirius.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.sirius.model.domain.TblCart;
import jp.co.internous.sirius.model.domain.dto.CartDto;
import jp.co.internous.sirius.model.form.CartForm;
import jp.co.internous.sirius.model.mapper.TblCartMapper;
import jp.co.internous.sirius.model.session.LoginSession;

/**
 * カート情報に関するコントローラー
 * @author shiro-369
 *
 */
@Controller
@RequestMapping("/sirius/cart")
public class CartController {
	
	@Autowired
	private LoginSession loginSession;
	@Autowired
	private TblCartMapper tblCartMapper;
	@Autowired
	private Gson gson;
	
	/**
	 * カート画面を初期表示
	 * @param m 画面表示用オブジェクト
	 * @return　カート画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		boolean loginFlag = loginSession.getLoginFlag();
		int userId = loginSession.getUserId();
		if(!loginFlag) {
			userId = loginSession.getTmpUserId();
		}
		List<CartDto> cartList = tblCartMapper.findByUserId(userId); 
		m.addAttribute("cartList",cartList);
		m.addAttribute("loginSession", loginSession);
		
		return "cart";
	}
	
	
	/**
	 * カート情報を削除
	 * @param checkedIdList 選択したカート情報のIDリスト
	 * @return true:削除成功、false:削除失敗
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/delete")
	@ResponseBody
	public boolean deleteApi(@RequestBody String checkedIdList) {
		int result = 0;
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		result = tblCartMapper.deleteCartById(checkedIds);	
		
		return result > 0;
	}
	
	/**
	 * カートに追加処理
	 * @param f カート情報のForm
	 * @param m 画面表示用オブジェクト
	 * @return カート画面
	 */
	@RequestMapping("/add")
	public String addCartApi(CartForm f, Model m) {
		boolean loginFlag = loginSession.getLoginFlag();
		int userId = loginSession.getUserId();
		if(!loginFlag) {
			userId = loginSession.getTmpUserId();
		}
		f.setUserId(userId);
		
		List<TblCart> tblCart = tblCartMapper.findByUserIdAndProductId(userId, f.getProductId());
		int result = 0;
		if(tblCart.size() > 0) {
			result = tblCartMapper.tblCartUpdate(f);
		} else {
			result = tblCartMapper.tblCartInsert(f);
		}
		if(result > 0){
			List<CartDto> cartList = tblCartMapper.findByUserId(userId); 
			m.addAttribute("cartList",cartList);
			m.addAttribute("loginSession", loginSession);
		}
		
		return "cart";
	}
	
	
}
