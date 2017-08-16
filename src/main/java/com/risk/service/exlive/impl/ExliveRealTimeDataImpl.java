package com.risk.service.exlive.impl;

import org.springframework.stereotype.Service;

import com.risk.model.exliverealtimedata.ExliveRealTimeData;
import com.risk.service.exlive.ExliveRealTimeDataService;
import com.risk.service.impl.MongoServiceImpl;

@Service(value="exliveRealTimeService")
public class ExliveRealTimeDataImpl extends MongoServiceImpl<ExliveRealTimeData> implements ExliveRealTimeDataService {

	@Override
	public ExliveRealTimeData findById(String id) {
		return super.findById(id);
	}

}
