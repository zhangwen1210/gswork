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
    public String index(Model model){
        logger.info("跳转首页");
        questionService.getIndexNumber(model);
        return "index";
    }

    /**
     *根据IM单号获取问题记录，使用模糊查询搜索
     * @return
     */
    @RequestMapping(value = "/getbyimhumber")
    public String getbyimhumber(Model model, String im_number){
        logger.info("根据IM单号查询问题记录");
        List<Question> questionList = questionService.getByImMohu(im_number);
        model.addAttribute("questionList",questionList);
        return "questionlist";
    }

    /**
     *根据rm单号获取问题记录
     * @return
     */
    @RequestMapping(value = "/getbyrmhumber")
    public String getbyrmhumber(Model model, String rm_number){
        logger.info("根据RM单号查询问题记录");
        List<Question> questionList = questionService.getByRm(rm_number);
        model.addAttribute("questionList",questionList);
        return "questionlist";
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, Model model){
        logger.info("退出登录");
        request.getSession().removeAttribute("loginUser");
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    /**
     * 我的处理中问题
     * @param model
     * @return
     */
    @RequestMapping(value = "/myzaiban")
    public String myzaiban(Model model, HttpServletRequest request){
        logger.info("查看我的处理中问题");
        User user = (User) request.getSession().getAttribute("loginUser");
        // 查询我的在办问题
        List<Question> zaibans = questionService.getMyZaibanQuestion(user.getZwxm());
        model.addAttribute("zaibans",zaibans);
        return "zaibanquestion";
    }


    /**
     * 关闭单子，修改状态
     * @param imNumber
     * @return
     */
    @RequestMapping(value = "/finishquestion")
    @ResponseBody
    public Map finishquestion(String imNumber){
        Map<String, Object> map = new HashMap();
        logger.info("关闭单子，参数为："+imNumber);
        boolean flag = questionService.finishquestion(imNumber);
        //boolean flag = true;
        map.put("reason",flag);
        return map;
    }

}
