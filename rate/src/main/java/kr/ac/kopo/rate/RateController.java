package kr.ac.kopo.rate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class RateController {
	
	@Autowired
	RateDAO dao;
	
	@RequestMapping("/rate")
	public String getRate(Model model) throws JsonMappingException, JsonProcessingException {
		List<RateVO> vo = dao.getRateList();
		model.addAttribute("rate",vo);
		
		
		return "rate";
		
	}
	

}
