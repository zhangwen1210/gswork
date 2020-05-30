package com.servyou.gswork.mapper;

import com.servyou.gswork.po.Question;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    Question selectByIm(String im_number);

    List<Question> getAll();
}