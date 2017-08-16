package com.risk.service.exlive;

import com.risk.model.exliverealtimedata.ExliveRealTimeData;
import com.risk.service.IMongoService;

public interface ExliveRealTimeDataService extends IMongoService<ExliveRealTimeData>{

	ExliveRealTimeData findById(String id);
	
}
