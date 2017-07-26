package com.summer.service.demo.bean;


import java.util.List;

/**
 * Created by zhangxz on 2017/7/14.
 */
public class GeneralPage<T> extends BasePage {

    private List<T> generalList;

    public GeneralPage(){}

    public GeneralPage(BasePage basePage){
        this.setPageNo(basePage.getPageNo());
        this.setPageSize(basePage.getPageSize());
    }

    public List<T> getGeneralList() {
        return generalList;
    }

    public void setGeneralList(List<T> generalList) {
        this.generalList = generalList;
    }
}
