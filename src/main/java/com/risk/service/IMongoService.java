package com.risk.service;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;


public interface IMongoService<T> {

	/**
	 * 删除所有索引
	 */
	void dropAllIndexes();
	
	/**
	 * 获取所有索引
	 * @return
	 */
	List<IndexInfo> getIndexInfo();
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 查询总数
	 * @param query
	 * @return
	 */
	long findCount(Query query);
	
	/**
	 * 分页查询
	 * @param query 查询条件
	 * @param skip  当前页
	 * @param limit 每页数
	 * @return
	 */
	List<T> findList(Query query, Integer skip, Integer limit);

	/**
	 * 分页查询
	 * @param query     查询条件
	 * @param currPage  当前页
	 * @param pageSize  每页数
	 * @return
	 */
	List<T> findPageList(Query query, Integer currPage, Integer pageSize);
	
	/**
	 * 查询单条
	 * @param id 主键
	 * @return
	 */
	T findById(String id);

	/**
	 * 查询单条
	 * @param query
	 * @return
	 */
	T findOne(Query query);
	
	/**
	 * 添加
	 * @param entity
	 * @return
	 */
	T insert(T entity);

	/**
	 * 有责更新、无责添加
	 * @param entity
	 * @return
	 */
	T save(T entity);
	
	/**
	 * 批量添加
	 * @param entitys
	 * @return
	 */
	List<T> insertBatch(List<T> entitys);
	
	List<T> bulkWrite(List<T> entitys);

	void update(Query query, Update update);
	
	void updateBatch(Query query, Update update);
	
	void delete(Query query);
	
	T findAndModify(Query query, Update update);
	
	WriteResult upsert(Query query, Update update, Class<T> entityClass);
	
	WriteResult upsert(Query query, Update update, Class<T> entityClass,String collectionName);
	
	/**
	 * 聚合运算
	 * @param aggregation
	 * @param inputType
	 * @param outputType
	 * @return
	 */
	<O> AggregationResults<O> aggregate(Aggregation aggregation, Class<T> inputType, Class<O> outputType);
}
