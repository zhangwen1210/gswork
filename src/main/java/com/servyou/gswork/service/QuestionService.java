package com.servyou.gswork.service;

import com.alibaba.fastjson.JSONObject;
import com.servyou.gswork.po.Question;

import java.util.List;

/**
 * @program: gswork->QuestionService
 * @description: 问题表接口服务层
 * @author: zhangwen
 * @create: 2020-05-28 11:37
 **/
public interface QuestionService {
    /**
     * 添加问题记录
     * @return
     */
    public boolean addQuestion(JSONObject jsonObject, String zwxm);

    /**
     * 根据IM问题单号检查是否已经添加了
     * @param im_number
     * @return
     */
    public boolean checkByIm(String im_number);

    /**
     * 获取全部问题记录
     * @return
     */
    List<Question> getAll();
}
