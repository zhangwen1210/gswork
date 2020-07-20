package com.servyou.gswork.service;

import com.alibaba.fastjson.JSONObject;
import com.servyou.gswork.po.Question;
import org.springframework.ui.Model;

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

    /**
     * 根据IM单号获取问题记录
     * @param im_number
     * @return
     */
    List<Question> getByIm(String im_number);

    /**
     * 根据RM单号获取问题记录
     * @param rm_number
     * @return
     */
    List<Question> getByRm(String rm_number);

    /**
     * 根据IM单号获取问题记录,模糊查询
     * @param im_number
     * @return
     */
    List<Question> getByImMohu(String im_number);

    /**
     * 首页各种统计值
     * @param model
     */
    void getIndexNumber(Model model);

    /**
     * 完成单子
     * @param imNumber
     * @return
     */
    boolean finishquestion(String imNumber);

    /**
     * 查询再版问题
     * @param zwxm
     * @return
     */
    List<Question> getMyZaibanQuestion(String zwxm);
}
