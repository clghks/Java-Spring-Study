package com.clghks.spring;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Sawon")
public class SawonController {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@RequestMapping
	public String index(Model model){
		String sql = "SELECT * FROM contacts";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		model.addAttribute("model", list);
		
		return "/sawonView";
	}
	
	
}
