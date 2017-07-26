package com.summer.front.demo.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.summer.service.demo.bean.BasePage;
import com.summer.service.demo.bean.GeneralPage;
import com.summer.service.demo.bean.Goods;
import com.summer.service.demo.bean.Student;
import com.summer.service.demo.service.TestDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxz on 2017/7/12.
 */

@Controller
@RequestMapping("/demo")
public class StudentController extends BaseController{

    @Autowired
    private TestDbService testDbServiceImpl;

    private final static Log logger = LogFactory.getLog(StudentController.class);

    @RequestMapping("/student")
    public ModelAndView student(){
        return new ModelAndView("student", "command", new Student());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student student, ModelMap modelMap){
        logger.debug("==========addStudent" + JSON.toJSONString(student));
        modelMap.addAttribute("age", student.getAge());
        modelMap.addAttribute("id", student.getId());
        modelMap.addAttribute("name", student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getId());
        System.out.println(student.getName());
        return "result";
    }

    @RequestMapping(value ="/getStudent")
    public @ResponseBody
    Map<String, Object> getStudent(@RequestBody Student student){
        logger.debug("==========getStudent" + JSON.toJSONString(student));
        Student student1 = new Student();
        student1.setAge(student.getAge());
        student1.setId(student.getId());
        student1.setName(student.getName());
//        return student1;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("student", student);
        return map;
    }

    @RequestMapping(value="/testDBConn")
    public @ResponseBody int testDBConn(){
        return testDbServiceImpl.testDBConn();
    }

    @RequestMapping("/getGoodsById")
    public @ResponseBody
    Goods getGoodsById(@RequestBody Map<String ,Object> map){
        logger.debug("=========getGoodsById" + map);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id", id);
        return testDbServiceImpl.getGoodsById(map);
    }

    @RequestMapping("/addGoods")
    public @ResponseBody int addGoods(@RequestBody Goods goods){
        logger.debug("===========addGoods");
        return testDbServiceImpl.addGoods(goods);
    }

    @RequestMapping("/getGoodsList")
    public @ResponseBody Object getGoodsList(@RequestBody BasePage basePage){
        logger.debug("===============getGoodsList" + JSON.toJSONString(basePage));
        List<Goods> goodsList = testDbServiceImpl.getGoodsList(basePage);
        GeneralPage<Goods> goodsGeneralPage = new GeneralPage<Goods>(basePage);
        goodsGeneralPage.setGeneralList(goodsList);
        return goodsGeneralPage;
    }

    @RequestMapping("/addInventory")
    public @ResponseBody int addInventory(@RequestBody Goods goods){
        logger.debug("===========addInventory" + JSON.toJSONString(goods));
        return testDbServiceImpl.addInventory(goods.getGoodsId(), goods.getAddInventoryAmount());

    }

    @RequestMapping("/testTransaction")
    public @ResponseBody int testTransaction(@RequestBody Goods goods){
        logger.debug("===========testTransaction" + JSON.toJSONString(goods));
        return testDbServiceImpl.testTransaction(goods);

    }

    @RequestMapping("/deleteGoods")
    public @ResponseBody Object deleteGoods(@RequestBody @Valid Goods goods, BindingResult bindingResult){
        logger.debug("==============deleteGoods" + JSON.toJSONString(goods));
//        Map<String, Object> stringObjectMap = validateReqParam(goods);
//        if(!"0".equals(stringObjectMap.get("code").toString())){
//            System.out.println(stringObjectMap);
//            return -1;
//        }
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError: allErrors){
                System.out.println("=========errors:" + objectError);
            }
            return allErrors;
        }
        return 0;
//        return testDbServiceImpl.deleteGoods(goods);
    }

    @RequestMapping("/testHtml")
    public @ResponseBody Object testHtml(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test1", "hello world");
        map.put("test2", "hao a ");
        map.put("test3", "你瞅啥 ");
        return map;
    }


}
