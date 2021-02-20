package com.hithaui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Value("${url.abc}")
	public String url;
	
	@GetMapping("/")
	public String home() {
		System.out.println(url);
		return "Hello World";
	}
	
	@GetMapping("/{id}")
	public String home(@PathVariable("id") Integer id) {
		System.out.println(id);
		return "abc";
	}
	
	@GetMapping("/users")
	public List<Person> users(@RequestParam(name = "name", required = false) String nameSearch,
			@RequestParam(name = "age", required = false) Integer age){
		
		List<Person> list = new ArrayList<Person>();
		
		if(nameSearch != null) {
			List<Person> listSearchByName = new ArrayList<Person>();
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getName().toLowerCase().contains(nameSearch.toLowerCase()) &&
						list.get(i).getAge() == age) {
					listSearchByName.add(list.get(i));
				}
			}
			
			if(listSearchByName.size() > 0) {
				return listSearchByName;
			}
		}
		
		if(list.size() == 0) {
			throw new NotFoundException("Không có dữ liệu");
		}
		
		return list;
	}
	
	@PostMapping("/users/create")
	public List<Person> createNewPerson(@RequestBody List<Person> list) {
		return list;
	}
}
