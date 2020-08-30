package com.tutorial.businessRule.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessRequest implements Serializable {

private List<BusinessRuleModel>	listOfSku;

public List<BusinessRuleModel> getListOfSku() {
	return listOfSku;
}

public void setListOfSku(List<BusinessRuleModel> listOfSku) {
	this.listOfSku = listOfSku;
}
}
