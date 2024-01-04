package main.java.com.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.service.MainService;
import main.java.com.vo.NickNameVO;
import main.java.com.vo.basicVO;
import main.java.com.vo.ocidVO;
import main.java.com.vo.overallVO;

@Controller
public class MainController {
 
	@Resource(name="mainService")
	private MainService mainService;
	
	@RequestMapping(value="/test")
	public String test(Model model) throws Exception {
		System.out.println("controller");
		String test=mainService.selectTest();
		System.out.println(test);
		model.addAttribute("selectTableList", test);
		return "main/Main";
	}
	
	@RequestMapping(value="/")
	public String mainScreen() {
		
		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println("mainScreen controller");
		try {
			overallVO overallVo=mainService.selectMainRanking();
			
			ocidVO ocidVo = mainService.selectOcid(overallVo.getRanking().get(0).getCharacter_name());
			System.out.println("종합 랭킹 1위  character_name : " + overallVo.getRanking().get(0).getCharacter_name());
			System.out.println("종합 랭킹 1위  character_level : " + overallVo.getRanking().get(0).getCharacter_level());
			System.out.println("종합 랭킹 1위  class_name : " + overallVo.getRanking().get(0).getClass_name());
			basicVO basicVo = mainService.selectCharBasic(ocidVo.getOcid());
			

			System.out.println("종합 랭킹 1위  character_image : " + basicVo.getCharacter_image());
			
			mav.addObject("character_name", overallVo.getRanking().get(0).getCharacter_name());
			mav.addObject("character_level", overallVo.getRanking().get(0).getCharacter_level());
			mav.addObject("class_name", overallVo.getRanking().get(0).getClass_name());
			mav.addObject("character_image", basicVo.getCharacter_image());
		}catch (Exception e) {
			System.out.println("error message : " + e.getMessage());
			// TODO: handle exception
		}		
		return "main/Main";
	}
	@RequestMapping(value="/getocid")
	public String getOcid(NickNameVO nickNameVo,Model model) throws Exception {
		
		System.out.println("getOcid controller");
		System.out.println("nickNameVo : " + nickNameVo.getNickName());
		try {
			ocidVO ocidVo=mainService.selectOcid(nickNameVo.getNickName());
			System.out.println(nickNameVo.getNickName() + "의 ocid : " + ocidVo.getOcid());
			model.addAttribute("ocidVO", ocidVo);			
		}catch (Exception e) {
			System.out.println("error message : " + e.getMessage());
			// TODO: handle exception
		}

		return "main/Main";
		//return nickNameVo.getNickName();
	}
}