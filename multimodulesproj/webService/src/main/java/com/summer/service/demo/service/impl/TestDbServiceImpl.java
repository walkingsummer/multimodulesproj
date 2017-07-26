package com.summer.service.demo.service.impl;

import com.summer.service.demo.bean.BasePage;
import com.summer.service.demo.bean.Goods;
import com.summer.service.demo.dao.TestDbConnDao;
import com.summer.service.demo.service.TestDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxz on 2017/7/13.
 */

@Service("testDbServiceImpl")
public class TestDbServiceImpl implements TestDbService {

    @Autowired
    private TestDbConnDao testDbConnDao;

    public int testDBConn() {
        return testDbConnDao.testDBConn();
    }

    public Goods getGoodsById(Map<String, Object> map) {
        return testDbConnDao.getGoodsById(map);
    }

    public int addGoods(Goods goods) {
        return testDbConnDao.addGoods(goods);
    }

    public List<Goods> getGoodsList(BasePage basePage) {
        return testDbConnDao.getGoodsList(basePage);
    }

    public int addInventory(int goodsId, int inventory) {
        return testDbConnDao.addInventory(goodsId, inventory);
    }

    public int deleteGoods(Goods goods) {
        return testDbConnDao.deleteGoods(goods);
    }

    @Transactional
    public int testTransaction(Goods goods) {

        int tp1 = testDbConnDao.addInventory(goods.getGoodsId(), goods.getAddInventoryAmount());
        if(tp1>0){
            throw new RuntimeException("add inventory");
        }

        return 0;
    }
}
