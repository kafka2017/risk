package com.risk.mongo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.risk.model.exliverealtimedata.ExliveRealTimeData;
import com.risk.service.exlive.ExliveRealTimeDataService;
import com.risk.utils.JSONHelper;

import test.SpringBaseTestCase;

public class MongoTest extends SpringBaseTestCase {

	@Autowired
	private ExliveRealTimeDataService mongoService;
	
	@Test
	public void qbyid(){
		ExliveRealTimeData ex = mongoService.findById("594120b6efdc8d184044b293");
		System.err.println(JSONHelper.toString(ex));
	}
	
}
