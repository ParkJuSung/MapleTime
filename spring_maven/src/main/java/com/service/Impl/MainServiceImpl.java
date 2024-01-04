package main.java.com.service.Impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import  java.util.Calendar;
import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import main.java.com.service.MainService;
import main.java.com.vo.basicVO;
import main.java.com.vo.ocidVO;
import main.java.com.vo.overallVO;

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
	
	@Override
	public ocidVO selectOcid(String name) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String ocidUrl = URL + "id?character_name=" + name;
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<>("Userinfo",headers);
        ResponseEntity<ocidVO> responseEntity = restTemplate.exchange(ocidUrl, HttpMethod.GET, entity, ocidVO.class);
        
        return responseEntity.getBody();
	}
	
	@Override
	public basicVO selectCharBasic(String ocid) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		// 1. 날짜 표시 format
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");    
		Calendar c1 = Calendar.getInstance(); 
	    c1.add(Calendar.DATE, -2); // 오늘날짜로부터 -1 
	    String yesterday = formatter.format(c1.getTime()); // String으로 저장
	    System.out.println("yesterday : " + yesterday);
		//String basicUrl = URL + "character/basic?ocid=" + ocid + "&date=" + formatedNow;
		UriComponents basicUrl =  UriComponentsBuilder.fromUriString("https://open.api.nexon.com/maplestory/v1/character/basic?ocid=" + ocid + "&date=" + yesterday).build(true);
		headers.set("x-nxopen-api-key", API_KEY);
		
		HttpEntity<String> entity = new HttpEntity<>("Userinfo",headers);
		System.out.println("basicUrl : " + basicUrl.toUri());
		System.out.println("basicUrl.getHost() : " + basicUrl.getHost());
		System.out.println("basicUrl.getQuery() : " + basicUrl.getQuery());
        ResponseEntity<basicVO> responseEntity = restTemplate.exchange(basicUrl.toUri(), HttpMethod.GET, entity, basicVO.class);
        
        return responseEntity.getBody();
	}
	
	
	@Override
	public overallVO selectMainRanking() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        // 현재 날짜 구하기        
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");    
		Calendar c1 = Calendar.getInstance(); 
	    c1.add(Calendar.DATE, -2); // 오늘날짜로부터 -1 
	    String yesterday = formatter.format(c1.getTime()); // String으로 저장
	    System.out.println("yesterday : " + yesterday);
		String overallUrl = URL + "ranking/overall?date=" + yesterday;
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<>("Userinfo",headers);
        ResponseEntity<overallVO> responseEntity = restTemplate.exchange(overallUrl, HttpMethod.GET, entity, overallVO.class);
        
        return responseEntity.getBody(); 
	}
	
	
}