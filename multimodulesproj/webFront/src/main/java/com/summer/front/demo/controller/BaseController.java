package com.summer.front.demo.controller;

import javax.validation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangxz on 2017/7/18.
 */
public class BaseController {

    public <T> Map<String, Object> validateReqParam(T t){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<T>> validate = validator.validate(t);
            for(ConstraintViolation constraintViolation: validate){
                map.put("code",1);
                map.put("msg", constraintViolation.getMessage());
                return map;
            }
        }catch (Exception e){
            map.put("code", 2);
            map.put("msg", e.getMessage());
            return map;
        }
        map.put("code",0);
        map.put("msg", "success");
        return map;
    }

}
