package com.servyou.gswork.controller;

import com.alibaba.fastjson.JSONObject;
import com.servyou.gswork.po.Question;
import com.servyou.gswork.po.User;
import com.servyou.gswork.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: gswork->GsworkController
 * @description: 具体功能模块controller
 * @author: zhangwen
 * @create: 2020-05-27 19:41
 **/
@Controller
@RequestMapping(value = "/gswork")
public class GsworkController {

    private Logger logger = LoggerFactory.getLogger(GsworkController.class);

    @Autowired
    private QuestionService questionService;

    /**
     *跳转添加问题页面
     * @return
     */
    @RequestMapping(value = "/question")
    public String question(){
        return "addquestion";
    }


    @RequestMapping(value = "/addquestion")
    @ResponseBody
    public Map addquestion(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        Map<String, Object> map = new HashMap();
        User user = (User) request.getSession().getAttribute("loginUser");
        logger.info("前台参数:"+jsonObject.toJSONString()+"。当前操作用户"+user.getZwxm());
        if (questionService.checkByIm(jsonObject.getString("im_number"))){
            //返回true表示已经存在
            map.put("result",false);
        }else {
            boolean result = questionService.addQuestion(jsonObject, user.getZwxm());
            map.put("result",result);
        }
        return map;
    }

    @RequestMapping(value = "/questionlist")
    public String questionlist(Model model){
        logger.info("获取全部问题记录");
        List<Question> questionList = questionService.getAll();
        model.addAttribute("questionList",questionList);
        return "questionlist";
    }

    /**
     * 跳转首页
     * @param
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        logger.info("跳转首页");
        return "index";
    }

}
