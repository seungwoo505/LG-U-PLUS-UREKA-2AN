package com.lsw.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.shop.dto.Member;

@RestController
public class MemberController {
	
	static List<Map<String, String>> list = new ArrayList<>();
	
	@PostMapping("/insertMember")
	public ResponseEntity<String> insertMember(@RequestBody Member member) {
		Map<String, String> map = new HashMap<>();
		map.put("email", member.getEmail());
		map.put("pw", member.getPwd());
		
		list.add(map);
		
		return ResponseEntity.status(HttpStatus.OK).body(member.getEmail() + "님 가입을 환영합니다.");
	}

	
	@PostMapping("/selectMember")
	public ResponseEntity<String> selectMember(@RequestBody Member member) {
		for(Map<String, String> map : list) {
			if(map.get("email").equals(member.getEmail()) && map.get("pw").equals(member.getPwd())) {
				return ResponseEntity.status(HttpStatus.OK).body(map.get("email") + "님 환영합니다.");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("아이디나 패스워드가 일치하지않습니다.");
	}
}