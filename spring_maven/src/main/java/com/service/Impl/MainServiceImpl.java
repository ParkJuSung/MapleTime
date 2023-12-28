package main.java.com.service.Impl;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import main.java.com.service.MainService;
import main.java.com.vo.ocidVO;

@Service("mainService")
public class MainServiceImpl implements MainService{

	@Resource(name="mainDao")
	private MainDAO mainDao;
	
	final String API_KEY = "test_69a3982b5385651d5e45e3adce99dd7147035b0ee844b30fa11263300882abe8854e77de083664704fa29016d2c3983b";
	final String URL = "https://open.api.nexon.com/maplestory/v1/";
	
	
	@Override
	public String selectTest() throws Exception {
		System.out.println("serviceImpl");
		return mainDao.selectTest();
	}
	
	public ocidVO selectOcid(String name) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String ocidUrl = URL + "id?character_name=" + name;
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<>("Userinfo",headers);
        ResponseEntity<ocidVO> responseEntity = restTemplate.exchange(ocidUrl, HttpMethod.GET, entity, ocidVO.class);
        
        return responseEntity.getBody();
	}
}