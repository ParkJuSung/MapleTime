package main.java.com.service;

import main.java.com.vo.GuildRankingVO;
import main.java.com.vo.UnionRankingVO;
import main.java.com.vo.achievementRankingVO;
import main.java.com.vo.basicVO;
import main.java.com.vo.dojangRankingVO;
import main.java.com.vo.ocidVO;
import main.java.com.vo.overallRankingVO;
import main.java.com.vo.theseedRankingVO;

public interface MainService {
	String selectTest() throws Exception;
	
	ocidVO selectOcid(String name) throws Exception;
	
	basicVO selectCharBasic(String ocid) throws Exception;
	
	overallRankingVO selectOverallRanking() throws Exception;
	
	UnionRankingVO selectUnionRanking() throws Exception;
	
	GuildRankingVO selectGuildRanking() throws Exception;
	
	dojangRankingVO selectDojangRanking() throws Exception;
	
	theseedRankingVO selectTheseedRanking() throws Exception;
	
	achievementRankingVO selectAchievementRanking() throws Exception;
}
