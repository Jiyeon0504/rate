package kr.ac.kopo.rate;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.rate.secret.Secret;


@Service
public class RateDAO {
	
	public List<RateVO> getRateList() throws JsonMappingException, JsonProcessingException{
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=" + (new Secret().getKey()) + "&data=AP01";
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		
		String responseBody = null;
		
		if(response.getStatusCode().is2xxSuccessful()) {
			responseBody = response.getBody();
			System.out.println(responseBody);
		} else {
			System.out.println("fail : " + response.getStatusCode());
		}
		
		List<RateVO> rateList = null;
		ObjectMapper mapper = new ObjectMapper();
		rateList = mapper.readValue(responseBody, new TypeReference<List<RateVO>>() {});
		
		return rateList;
	}

}
