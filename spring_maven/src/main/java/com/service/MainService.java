package main.java.com.service;

import main.java.com.vo.basicVO;
import main.java.com.vo.ocidVO;
import main.java.com.vo.overallVO;

public interface MainService {
	String selectTest() throws Exception;
	
	ocidVO selectOcid(String name) throws Exception;
	
	basicVO selectCharBasic(String ocid) throws Exception;
	
	overallVO selectMainRanking() throws Exception;
}
