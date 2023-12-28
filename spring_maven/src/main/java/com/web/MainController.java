package main.java.com.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.com.service.MainService;
import main.java.com.vo.NickNameVO;
import main.java.com.vo.ocidVO;

@Controller
public class MainController {
 
	@Resource(name="mainService")
	private MainService mainService;
	
	@RequestMapping(value="/")
	public String test(Model model) throws Exception {
		System.out.println("controller");
		String test=mainService.selectTest();
		System.out.println(test);
		model.addAttribute("selectTableList", test);
		return "main/Main";
	}
	
	@RequestMapping(value="/getocid")
	public String getOcid(NickNameVO nickNameVo,Model model) throws Exception {
		
		System.out.println("getOcid controller");
		ocidVO test=mainService.selectOcid(nickNameVo.getNickName());
		System.out.println(test);
		model.addAttribute("ocidVO", test);
		return test.getOcid();
	}
}