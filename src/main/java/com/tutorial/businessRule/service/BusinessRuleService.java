package com.tutorial.businessRule.service;

import com.tutorial.businessRule.model.BusinessRequest;

public interface BusinessRuleService {

	public Integer calculatePriceForSku(BusinessRequest request);
}
