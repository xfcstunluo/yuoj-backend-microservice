package com.yupi.yuojbackendserviceclient.service;

import com.yupi.yuojbackendmodel.model.entity.Question;
import com.yupi.yuojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author lenovo
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-12-06 17:14:51
*/
@FeignClient(name = "yuoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient {

    /**
     *
     * @param questionId
     * @return
     */
    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSumbitById(@RequestParam("questionSubmitId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    boolean updateQuestionSumbitById(@RequestBody QuestionSubmit questionSubmit);
}
