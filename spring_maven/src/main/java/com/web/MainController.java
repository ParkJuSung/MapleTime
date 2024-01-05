package main.java.com.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.service.MainService;
import main.java.com.vo.NickNameVO;
import main.java.com.vo.achievementRankingVO;
import main.java.com.vo.basicVO;
import main.java.com.vo.dojangRankingVO;
import main.java.com.vo.ocidVO;
import main.java.com.vo.overallRankingVO;
import main.java.com.vo.theseedRankingVO;

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
	public ModelAndView  mainScreen() {
		
		//ModelAndView mav = new ModelAndView("jsonView");
		ModelAndView mav = new ModelAndView("main/Main");
		
		System.out.println("mainScreen controller");
		try {
			/*overallRankingVO overallVo=mainService.selectOverallRanking();
			ocidVO ocidVo = mainService.selectOcid(overallVo.getRanking().get(0).getCharacter_name());
			
			System.out.println("종합 랭킹 1위  character_name : " + overallVo.getRanking().get(0).getCharacter_name());
			System.out.println("종합 랭킹 1위  character_level : " + overallVo.getRanking().get(0).getCharacter_level());
			System.out.println("종합 랭킹 1위  sub_class_name : " + overallVo.getRanking().get(0).getSub_class_name());
			basicVO basicVo = mainService.selectCharBasic(ocidVo.getOcid());
			

			System.out.println("종합 랭킹 1위  character_image : " + basicVo.getCharacter_image());

			mav.addObject("character_name", overallVo.getRanking().get(0).getCharacter_name());
			mav.addObject("character_level", overallVo.getRanking().get(0).getCharacter_level());
			mav.addObject("sub_class_name", overallVo.getRanking().get(0).getSub_class_name());
			mav.addObject("character_image", basicVo.getCharacter_image());*/
			
			dojangRankingVO dojangVo = mainService.selectDojangRanking();
			ocidVO dojang1stOcid = mainService.selectOcid(dojangVo.getRanking().get(0).getCharacter_name());
			basicVO dojang1stInfo = mainService.selectCharBasic(dojang1stOcid.getOcid());
			
			System.out.println("무릉 랭킹 1위  character_name : " + dojang1stInfo.getCharacter_name());
			System.out.println("무릉 랭킹 1위  character_level : " + dojang1stInfo.getCharacter_level());
			System.out.println("무릉 랭킹 1위  sub_class_name : " + dojang1stInfo.getCharacter_class());
			System.out.println("무릉 랭킹 1위  character_image : " + dojang1stInfo.getCharacter_image());
			
			mav.addObject("dojang1st_world_name",dojang1stInfo.getWorld_name());
			mav.addObject("dojang1st_character_name",dojang1stInfo.getCharacter_name());
			mav.addObject("dojang1st_character_leve",dojang1stInfo.getCharacter_level());
			mav.addObject("dojang1st_character_class",dojang1stInfo.getCharacter_class());
			mav.addObject("dojang1st_character_image",dojang1stInfo.getCharacter_image());
			mav.addObject("dojang1st_dojang_floor",dojangVo.getRanking().get(0).getDojang_floor());
			int m = Integer.parseInt(dojangVo.getRanking().get(0).getDojang_time_record()) / 60;
			int s = Integer.parseInt(dojangVo.getRanking().get(0).getDojang_time_record()) - 60*m;
			mav.addObject("dojang1st_time_m",m);
			mav.addObject("dojang1st_time_s",s);
			
			theseedRankingVO theseedVo = mainService.selectTheseedRanking();
			ocidVO theseed1stOcid = mainService.selectOcid(theseedVo.getRanking().get(0).getCharacter_name());
			basicVO theseed1stInfo = mainService.selectCharBasic(theseed1stOcid.getOcid());
			
			mav.addObject("theseed1st_world_name",theseed1stInfo.getWorld_name());
			mav.addObject("theseed1st_character_name",theseed1stInfo.getCharacter_name());
			mav.addObject("theseed1st_character_leve",theseed1stInfo.getCharacter_level());
			mav.addObject("theseed1st_character_class",theseed1stInfo.getCharacter_class());
			mav.addObject("theseed1st_character_image",theseed1stInfo.getCharacter_image());
			mav.addObject("theseed1st_dojang_floor",theseedVo.getRanking().get(0).getTheseed_floor());
			mav.addObject("theseed1st_time_record",theseedVo.getRanking().get(0).getTheseed_time_record());
			
			achievementRankingVO achievementVo = mainService.selectAchievementRanking();
			ocidVO achievement1stOcid = mainService.selectOcid(achievementVo.getRanking().get(0).getCharacter_name());
			basicVO achievement1stInfo = mainService.selectCharBasic(achievement1stOcid.getOcid());
			
			mav.addObject("achievement_world_name",achievement1stInfo.getWorld_name());
			mav.addObject("achievement_character_name",achievement1stInfo.getCharacter_name());
			mav.addObject("achievement_character_leve",achievement1stInfo.getCharacter_level());
			mav.addObject("achievement_character_class",achievement1stInfo.getCharacter_class());
			mav.addObject("achievement_character_image",achievement1stInfo.getCharacter_image());
			mav.addObject("achievement_dojang_floor",achievementVo.getRanking().get(0).getTrophy_grade());
			mav.addObject("achievement_time_record",achievementVo.getRanking().get(0).getTrophy_score());
		
		}catch (Exception e) {
			System.out.println("error message : " + e.getMessage());
			// TODO: handle exception
		}		
		return mav;
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