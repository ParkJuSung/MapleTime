package main.java.com.service;

import main.java.com.vo.ocidVO;

public interface MainService {
	String selectTest() throws Exception;
	
	ocidVO selectOcid(String name) throws Exception;
}
