package com.tutorial.businessRule.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.businessRule.model.AppConstants;
import com.tutorial.businessRule.model.BusinessRequest;
import com.tutorial.businessRule.model.BusinessRuleModel;
import com.tutorial.businessRule.promotion.PromotionRule;

@Service
public class BusinessRuleServiceImpl implements BusinessRuleService {

	@Autowired
	private PromotionRule promoRule;

	public Integer calculatePriceForSku(BusinessRequest request) {
		List<BusinessRuleModel> listOfSkus = request.getListOfSku();
		int totalPriceOfSku = 0;
		
	
		
		boolean isPromotionForC = listOfSkus.stream()
				.anyMatch(model -> model.getSKU().equalsIgnoreCase(AppConstants.SKUC));
				
		boolean isPromotionForD = 	listOfSkus.stream()
				.anyMatch(model -> model.getSKU().equalsIgnoreCase(AppConstants.SKUD));		
		
		if (isPromotionForC && isPromotionForD) {
			totalPriceOfSku += 30;
			listOfSkus.removeIf(model -> model.getSKU().equalsIgnoreCase(AppConstants.SKUC));
			listOfSkus.removeIf(model -> model.getSKU().equalsIgnoreCase(AppConstants.SKUD));
		}
		for (BusinessRuleModel model : listOfSkus) {
			if (model.getSKU().equalsIgnoreCase(AppConstants.SKUA) && model.getCount() >= 3) {
				totalPriceOfSku += promoRule.calculateValueForPromotionA(model);
			}
			else if (model.getSKU().equalsIgnoreCase(AppConstants.SKUB) && model.getCount() >= 2) {
				totalPriceOfSku += promoRule.calculateValueForPromotionB(model);
			} else {
				totalPriceOfSku += promoRule.calculateValueForNormal(model);
			}

		}
		return totalPriceOfSku;
	}

}
