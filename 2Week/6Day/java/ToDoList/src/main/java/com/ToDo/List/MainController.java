package com.ToDo.List;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") // CORS 허용
@RestController
public class MainController {
	ArrayList<String> todos = new ArrayList<String>();
	
	@GetMapping("addTodo")
	public ArrayList<String> addTodo(@RequestParam String todo) {
		todos.add(todo);
		System.out.println(todo + "가 생성되었습니다.");
		return todos;
	}
	
	@GetMapping("deleteTodo")
	public ArrayList<String> deleteTodo(@RequestParam int index) {
		System.out.println(todos.get(index) + "가 제거되었습니다.");
		todos.remove(index);
		
		return todos;
	}
	
	@GetMapping("getTodo")
	public ArrayList<String> getTodo(){
		System.out.println(todos + "를 불러옵니다.");
		return todos;
	}
}