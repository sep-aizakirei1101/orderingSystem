package print.order.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(FormModel fm, Model model) {

		return "home";
	}

	//メニュー
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(FormModel fm, Model model) {
		return "menu";

	}

	//フレーム
	@RequestMapping(value = "/Frame", method = RequestMethod.GET)
	public String loga(FormModel fm, Model model) {
		return "Frame";

	}

	//開発トップ
	@RequestMapping(value = "/toppage1", method = RequestMethod.GET)
	public String logb(FormModel fm, Model model) {
		return "toppage1";

	}

	//管理トップ
	@RequestMapping(value = "/toppage2", method = RequestMethod.GET)
	public String logc(FormModel fm, Model model) {
		return "toppage2";

	}

	//パーツ注文
	@RequestMapping(value = "/partsod", method = RequestMethod.GET)
	public String logx(FormModel fm, Model model) {
		model.addAttribute("FormModel",fm);
		return "partsod";
	}

	@RequestMapping(value = "/kakunin", method = RequestMethod.POST)
	public String log(FormModel fm, Model model) {

		String partsA = fm.getPartsA();
		String partsB = fm.getPartsB();
		String partsC = fm.getPartsC();
		String partsD = fm.getPartsD();
		String partsE = fm.getPartsE();
		String month = fm.getMonth();
		String day = fm.getDay();
		String odname = fm.getOdname();

		String a = partsA;
		String b = partsB;
		String c = partsC;
		String d = partsD;
		String e = partsE;
		String f = month;
		String g = day;
		String h = odname;

		model.addAttribute("PartsA", partsA);
		model.addAttribute("PartsB", partsB);
		model.addAttribute("PartsC", partsC);
		model.addAttribute("PartsD", partsD);
		model.addAttribute("PartsE", partsE);
		model.addAttribute("Month", month);
		model.addAttribute("Day", day);
		model.addAttribute("Odname", odname);


		if(a=="" || b==""|| c==""|| d==""|| e==""|| f==""|| g==""|| h=="") {

			return"/miss";

		} else {

			return "/kakunin";
		}
	}

	//登録成功
	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public String logf(FormModel fm, Model model) {
		String hidden1 = fm.getHidden1();
		String hidden2 = fm.getHidden2();
		String hidden3 = fm.getHidden3();
		String hidden4 = fm.getHidden4();
		String hidden5 = fm.getHidden5();
		String hidden6 = fm.getHidden6();
		String hidden7 = fm.getHidden7();
		String hidden8 = fm.getHidden8();

		model.addAttribute("PartsA", hidden1);
		model.addAttribute("PartsB", hidden2);
		model.addAttribute("PartsC", hidden3);
		model.addAttribute("PartsD", hidden4);
		model.addAttribute("PartsE", hidden5);
		model.addAttribute("Month", hidden6);
		model.addAttribute("Day", hidden7);
		model.addAttribute("Odname", hidden8);


		List<Map<String, Object>>  list = jdbcTemplate.queryForList("select * from partstb");
		Object partsa = String.valueOf(list.get(0).get("stockparts"));
		Object partsb = String.valueOf(list.get(1).get("stockparts"));
		Object partsc = String.valueOf(list.get(2).get("stockparts"));
		Object partsd = String.valueOf(list.get(3).get("stockparts"));
		Object partse = String.valueOf(list.get(4).get("stockparts"));

		jdbcTemplate.execute(
				"update partstb set stockparts= '"+ hidden1 +"'+'"+ partsa +"' where partsid =1");

		jdbcTemplate.execute(
				"update partstb set stockparts= '"+ hidden2 +"'+'"+ partsb +"' where partsid =2");

		jdbcTemplate.execute(
				"update partstb set stockparts= '"+ hidden3 +"'+'"+ partsc +"' where partsid =3");

		jdbcTemplate.execute(
				"update partstb set stockparts= '"+ hidden4 +"'+'"+ partsd +"' where partsid =4");

		jdbcTemplate.execute(
				"update partstb set stockparts= '"+ hidden5 +"'+'"+ partse +"' where partsid =5");

		jdbcTemplate.execute(
				"insert into partsordertb(partsA, partsB,partsC,partsD,partsE,orderday1,orderday2,name) "
						+ "values ('"+hidden1+"','"+hidden2+"','"+hidden3+"','"+hidden4+"','"+hidden5+"','"+hidden6+"','"+hidden7+"','"+hidden8+"')");

		return "success";
	}

	//登録失敗
	@RequestMapping(value = "/miss", method = RequestMethod.GET)
	public String logg(FormModel fm, Model model) {
		return "miss";

	}

	//印刷
	@RequestMapping(value = "/printout", method = RequestMethod.POST)
	public String logh(FormModel fm, Model model) {

		String hidden1 = fm.getHidden1();
		String hidden2 = fm.getHidden2();
		String hidden3 = fm.getHidden3();
		String hidden4 = fm.getHidden4();
		String hidden5 = fm.getHidden5();
		String hidden6 = fm.getHidden6();
		String hidden7 = fm.getHidden7();
		String hidden8 = fm.getHidden8();

		model.addAttribute("PartsA", hidden1);
		model.addAttribute("PartsB", hidden2);
		model.addAttribute("PartsC", hidden3);
		model.addAttribute("PartsD", hidden4);
		model.addAttribute("PartsE", hidden5);
		model.addAttribute("Month", hidden6);
		model.addAttribute("Day", hidden7);
		model.addAttribute("Odname", hidden8);

		return "printout";

	}


}
