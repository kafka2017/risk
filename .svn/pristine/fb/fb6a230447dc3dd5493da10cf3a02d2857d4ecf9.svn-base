package com.risk.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.risk.service.IMongoService;

@Service
public class MongoServiceImpl<T> implements IMongoService<T> {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	/** 
     * 创建一个Class的对象来获取泛型的class 
     */  
    private Class<T> clz;  
      
    @SuppressWarnings("unchecked")  
    public Class<T> getClz(){  
        if (clz==null) {  
            clz=(Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);  
        }  
        return clz;  
    } 
	
	@Override
	public void dropAllIndexes() {
		mongoTemplate.indexOps(getClz()).dropAllIndexes();
	}

	@Override
	public List<IndexInfo> getIndexInfo() {
		return mongoTemplate.indexOps(getClz()).getIndexInfo();
	}

	@Override
	public List<T> findAll() {
		return mongoTemplate.findAll(getClz());
	}

	@Override
	public long findCount(Query query) {
		return mongoTemplate.count(query, getClz());
	}

	@Override
	public List<T> findList(Query query, Integer skip, Integer limit) {
		if (null != skip && null != limit) {
			query.skip(skip).limit(limit);
		}		
		return mongoTemplate.find(query, getClz());
	}

	@Override
	public List<T> findPageList(Query query, Integer currPage, Integer pageSize) {
		if(currPage==null||currPage.intValue()<1){
	    	currPage=1;
	    }
		if(pageSize==null||pageSize.intValue()<1){
			pageSize =10;
		}
		return findList(query,(currPage-1)*pageSize,pageSize);
	}

	@Override
	public T findById(String id) {
		return mongoTemplate.findById(id, getClz());
	}

	@Override
	public T findOne(Query query) {
		return mongoTemplate.findOne(query, getClz());
	}

	@Override
	public T insert(T entity) {
		mongoTemplate.insert(entity);
		return entity;
	}

	@Override
	public T save(T entity) {
		mongoTemplate.save(entity);
		return entity;
	}

	@Override
	public List<T> insertBatch(List<T> entitys) {
		mongoTemplate.insertAll(entitys);
		return entitys;
	}

	@Override
	public List<T> bulkWrite(List<T> entitys) {
		mongoTemplate.insertAll(entitys);
		return entitys;
	}

	@Override
	public void update(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, getClz());
	}

	@Override
	public void updateBatch(Query query, Update update) {
		mongoTemplate.updateMulti(query, update, getClz());
	}

	@Override
	public void delete(Query query) {
		mongoTemplate.remove(query, getClz());		
	}

	@Override
	public T findAndModify(Query query, Update update) {
		return mongoTemplate.findAndModify(query, update, getClz());
	}

	@Override
	public WriteResult upsert(Query query, Update update, Class<T> entityClass) {
		return mongoTemplate.upsert(query, update, entityClass);
	}

	@Override
	public WriteResult upsert(Query query, Update update, Class<T> entityClass, String collectionName) {
		return mongoTemplate.upsert(query, update, entityClass, collectionName);
	}

	@Override
	public <O> AggregationResults<O> aggregate(Aggregation aggregation, Class<T> inputType, Class<O> outputType) {
		return mongoTemplate.aggregate(aggregation, inputType, outputType);
	}

}
