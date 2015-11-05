package com.onlineshodh.model;

import java.util.Comparator;

import com.onlineshodh.entity.BusinessDetailsEntity;

public class BusinessComparator implements Comparator<BusinessDetailsEntity> {

	@Override
	public int compare(BusinessDetailsEntity o1, BusinessDetailsEntity o2) {
		return o2.getRank().compareTo(o1.getRank());
	}
}
