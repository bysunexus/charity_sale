package com.quyeying.framework.db;

import com.quyeying.charity.base.dto.Column;
import com.quyeying.charity.base.dto.DataTablesReq;
import com.quyeying.charity.base.dto.Order;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: bysun
 * Date: 2014/8/1
 * Time: 23:18
 */
public abstract class BaseRepository {
    protected MongoTemplate mongo;

    protected <T, E extends DataTablesReq> PageImpl<T> baseQuery(Class<T> clz, Criteria criteria, E dto) {

        // 构建查询
        Query query = new Query();
        query.addCriteria(criteria).with(dto.getPageRequest());
        // 查询总数
        long count = mongo.count(query, clz);
        // 添加排序
        if (null != dto.getOrder() && null != dto.getColumns()) {
            List<Order> orders = Arrays.asList(dto.getOrder());
            List<Column> columns = Arrays.asList(dto.getColumns());
            List<Sort.Order> orderList = new ArrayList<>(orders.size());
            for (Order order : orders) {
                Column column = columns.get(order.getColumn());
                if (null != column) {
                    Sort.Direction dir = "ASC".equalsIgnoreCase(order.getDir()) ? Sort.Direction.ASC : Sort.Direction.DESC;
                    if (StringUtils.isNotBlank(column.getData())) {
                        orderList.add(new Sort.Order(dir, column.getData()));
                    }
                }
            }

            if (!orderList.isEmpty())
                query.with(new Sort(orderList));
        }


        return new PageImpl<>(mongo.find(query, clz), dto.getPageRequest(), count);
    }

    public abstract void setMongo(MongoTemplate mongo);
}
