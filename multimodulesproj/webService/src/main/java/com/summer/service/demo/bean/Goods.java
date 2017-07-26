package com.summer.service.demo.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by zhangxz on 2017/7/14.
 */
public class Goods {

    @NotNull(message = "商品id不能为空")
    private Integer goodsId;

    @NotEmpty(message = "商品编号不能为空")
    private String goodsNumber;

    @NotBlank(message = "成本加不能为空")
    private String goodsName;


    private Double costPrice;


    private Date createTime;
    private Integer inventoryAmount;

    //新增库存数量
    private Integer addInventoryAmount;

    public Integer getAddInventoryAmount() {
        return addInventoryAmount;
    }

    public void setAddInventoryAmount(Integer addInventoryAmount) {
        this.addInventoryAmount = addInventoryAmount;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Integer inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
