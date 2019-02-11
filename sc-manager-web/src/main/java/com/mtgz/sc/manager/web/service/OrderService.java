package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.util.RRException;
import com.mtgz.sc.manager.dao.mapper.OrderMapper;
import com.mtgz.sc.manager.dao.mapper.ShippingMapper;
import com.mtgz.sc.manager.dao.model.Order;
import com.mtgz.sc.manager.dao.model.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("orderService")
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShippingMapper shippingMapper;


    public Order queryObject(Integer id) {
        return orderMapper.queryObject(id);
    }


    public List<Order> queryList(Map<String, Object> map) {
        return orderMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return orderMapper.queryTotal(map);
    }


    public int save(Order order) {
        return orderMapper.save(order);
    }


    public int update(Order order) {
        return orderMapper.update(order);
    }


    public int delete(Integer id) {
        return orderMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return orderMapper.deleteBatch(ids);
    }


    public int confirm(Integer id) {
        Order order = queryObject(id);
        Integer shippingStatus = order.getShippingStatus();//发货状态
        Integer payStatus = order.getPayStatus();//付款状态
        if (2 != payStatus) {
            throw new RRException("此订单未付款，不能确认收货！");
        }
        if (4 == shippingStatus) {
            throw new RRException("此订单处于退货状态，不能确认收货！");
        }
        if (0 == shippingStatus) {
            throw new RRException("此订单未发货，不能确认收货！");
        }
        order.setShippingStatus(2);
        order.setOrderStatus(301);
        return orderMapper.update(order);
    }


    public int sendGoods(Order order) {
        Integer payStatus = order.getPayStatus();//付款状态
        if (2 != payStatus) {
            throw new RRException("此订单未付款！");
        }

        Shipping shipping = shippingMapper.queryObject(order.getShippingId());
        if (null != shipping) {
            order.setShippingName(shipping.getName());
        }
        order.setOrderStatus(300);//订单已发货
        order.setShippingStatus(1);//已发货
        return orderMapper.update(order);
    }
}
