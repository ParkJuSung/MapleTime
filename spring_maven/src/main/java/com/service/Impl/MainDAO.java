package main.java.com.service.Impl;

import org.springframework.stereotype.Repository;

@Repository("mainDao")
public class MainDAO {

	public String selectTest() throws Exception {
		String test = "Hello World!";
		return test;
	}
}
