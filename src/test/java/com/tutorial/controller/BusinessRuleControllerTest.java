package com.tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tutorial.businessRule.controller.BusinessRuleController;
import com.tutorial.businessRule.model.AppConstants;
import com.tutorial.businessRule.model.BusinessRequest;
import com.tutorial.businessRule.model.BusinessRuleModel;
import com.tutorial.businessRule.service.BusinessRuleService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessRuleControllerTest {
	
	@InjectMocks
	BusinessRuleController businessController;
	
	@Mock
	BusinessRuleService businessRuleService;
	
	@Mock
	AppConstants appConstants;
	
	@Test
	public void testForCalculatPrice() {
		BusinessRequest request = new BusinessRequest();
		List<BusinessRuleModel> listOfSkus = new ArrayList<BusinessRuleModel>();
	    listOfSkus.add(new BusinessRuleModel("A", 5));
	    listOfSkus.add(new BusinessRuleModel("B" , 5));
	    listOfSkus.add(new BusinessRuleModel("C", 1));
	    listOfSkus.add(new BusinessRuleModel("D", 1));
	    
	    request.setListOfSku(listOfSkus);
	    System.out.println(businessController.calculatePriceWithPromotion(request));
	}

}
