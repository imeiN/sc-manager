package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.util.R;
import com.mtgz.sc.manager.dao.mapper.CouponGoodsMapper;
import com.mtgz.sc.manager.dao.mapper.CouponMapper;
import com.mtgz.sc.manager.dao.mapper.UserCouponMapper;
import com.mtgz.sc.manager.dao.mapper.UserMapper;
import com.mtgz.sc.manager.dao.model.Coupon;
import com.mtgz.sc.manager.dao.model.CouponGoods;
import com.mtgz.sc.manager.dao.model.User;
import com.mtgz.sc.manager.dao.model.UserCoupon;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-19 12:53:26
 */
@Service("couponService")
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserCouponMapper userCouponMapper;
    @Autowired
    private CouponGoodsMapper couponGoodsMapper;
    @Autowired
    private UserMapper userMapper;


    public Coupon queryObject(Integer id) {
        return couponMapper.queryObject(id);
    }


    public List<Coupon> queryList(Map<String, Object> map) {
        return couponMapper.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return couponMapper.queryTotal(map);
    }


    public int save(Coupon coupon) {
        return couponMapper.save(coupon);
    }


    public int update(Coupon coupon) {
        return couponMapper.update(coupon);
    }


    public int delete(Integer id) {
        return couponMapper.delete(id);
    }


    public int deleteBatch(Integer[] ids) {
        return couponMapper.deleteBatch(ids);
    }


    public R publish(Map<String, Object> params) {
        // 发放方式 0：按订单发放 1：按用户发放 2:商品转发送券 3：按商品发放 4:新用户注册  5：线下发放 6评价好评红包（固定或随机红包）
        Integer sendType = MapUtils.getInteger(params, "sendType");
        Integer couponId = MapUtils.getInteger(params, "couponId");
        if (null == sendType) {
            return R.error("发放方式不能为空");
        }
        if (null == couponId) {
            return R.error("优惠券不能为空");
        }
        if (1 == sendType) {
            String userIds = MapUtils.getString(params, "userIds"); // 下发用户逗号分割
            if (StringUtils.isEmpty(userIds)) {
                return R.error("用户不能为空");
            }
            //是否发送短信通知
            boolean sendSms = "true".equals(MapUtils.getString(params, "sendSms"));
            for (String strUserId : userIds.split(",")) {
                if (StringUtils.isEmpty(strUserId)) {
                    continue;
                }
                Integer userId = Integer.valueOf(strUserId);
                UserCoupon userCouponVo = new UserCoupon();
                userCouponVo.setUserId(userId);
                userCouponVo.setCouponId(couponId);
                userCouponVo.setCouponNumber("1");
                userCouponVo.setAddTime(new Date());
                userCouponMapper.save(userCouponVo);
                if (sendSms) {
                    User user = userMapper.queryObject(userId);
                    // todo 发送短信

                }
            }
        } else if (3 == sendType) {
            String goodsIds = MapUtils.getString(params, "goodsIds"); // 下发商品逗号分割
            if (StringUtils.isEmpty(goodsIds)) {
                return R.error("商品Id不能为空");
            }
            for (String goodsId : goodsIds.split(",")) {
                if (StringUtils.isEmpty(goodsId)) {
                    continue;
                }
                CouponGoods couponGoodsVo = new CouponGoods();
                couponGoodsVo.setCouponId(couponId);
                couponGoodsVo.setGoodsId(Integer.valueOf(goodsId));
                couponGoodsMapper.save(couponGoodsVo);
            }
        } else {
            return R.error("此类优惠券不支持手动发放");
        }
        return R.ok("发放成功");
    }
}
