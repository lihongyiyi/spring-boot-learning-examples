package com.hongy.elasticsearch.controller;

import com.hongy.elasticsearch.dto.ArticleSearchDTO;
import com.hongy.elasticsearch.entity.JobboleArticle;
import com.hongy.elasticsearch.repository.JobboleArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 18:44.
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private JobboleArticleRepository jobboleArticleRepository;

    @PostMapping
    @RequestMapping("/query")
    @ResponseBody
    public String query(@RequestBody ArticleSearchDTO articleSearchDTO) {
        // 根据title查询
        List<JobboleArticle> list = jobboleArticleRepository.findByTitle(articleSearchDTO.getTitle());

        // 根据title进行分页查询
        Page<JobboleArticle> list2 = jobboleArticleRepository.findByTitle(articleSearchDTO.getTitle(), PageRequest.of(0, 10));

        // 根据id查询
        JobboleArticle article = jobboleArticleRepository.findById(articleSearchDTO.getId()).orElse(null);
        return "SUCCESS";
    }
}