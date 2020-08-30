package com.tutorial.businessRule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.businessRule.model.BusinessRequest;
import com.tutorial.businessRule.service.BusinessRuleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Promotion Engine")
@RequestMapping("businessRule")
public class BusinessRuleController {
	
	@Autowired
	private BusinessRuleService ruleService;

	@ApiOperation(value="Calculate Total Price",nickname="calculateTotalPrice",response=Integer.class)
	@PostMapping(value ="/calculateTotalPrice", produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Integer> calculatePriceWithPromotion(@ApiParam(value = "Request for calculation" ,required=true) @RequestBody BusinessRequest request){
		int totalCalculateForSku = 0;
		if(request!=null) {
			totalCalculateForSku = ruleService.calculatePriceForSku(request);
			return new ResponseEntity<>(totalCalculateForSku,HttpStatus.OK);
	 	}else
	 		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
	}
	
}
