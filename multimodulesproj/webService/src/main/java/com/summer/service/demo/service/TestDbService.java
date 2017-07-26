package com.summer.service.demo.service;

import com.summer.service.demo.bean.BasePage;
import com.summer.service.demo.bean.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxz on 2017/7/13.
 */
public interface TestDbService {
    int testDBConn();
    Goods getGoodsById(Map<String, Object> map);
    int addGoods(Goods goods);
    List<Goods> getGoodsList(BasePage basePage);
    int addInventory(int goodsId, int inventory);
    int deleteGoods(Goods goods);
    int testTransaction(Goods goods);
}
