package com.servyou.gswork.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.servyou.gswork.mapper.QuestionMapper;
import com.servyou.gswork.po.Question;
import com.servyou.gswork.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: gswork->QuestionServiceImpl
 * @description:
 * @author: zhangwen
 * @create: 2020-05-28 11:43
 **/
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public boolean addQuestion(JSONObject jsonObject, String zwxm) {
        Question question = new Question();
        question.setImNumber(jsonObject.getString("im_number"));
        question.setRmNumber(jsonObject.getString("rm_number"));
        question.setTitle(jsonObject.getString("title"));
        question.setLrry(zwxm);
        question.setLrrq(new Date());
        question.setStatus("处理中");
        int result = questionMapper.insert(question);
        if(result == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkByIm(String im_number) {
        Question question = questionMapper.selectByIm(im_number);
        if (question==null){
            return false;
        }else{
            return true;
        }

    }

    @Override
    public List<Question> getAll() {
        return questionMapper.getAll();
    }
}
