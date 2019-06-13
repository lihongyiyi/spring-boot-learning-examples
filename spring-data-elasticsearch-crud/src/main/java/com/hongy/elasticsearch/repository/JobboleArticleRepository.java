package com.hongy.elasticsearch.repository;

import com.hongy.elasticsearch.entity.JobboleArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 18:11.
 * @Description:
 */
@Component
public interface JobboleArticleRepository extends ElasticsearchRepository<JobboleArticle, String> {
    List<JobboleArticle> findByTitle(String title);

    Page<JobboleArticle> findByTitle(String title, Pageable pageable);

    Optional<JobboleArticle> findById(String id);
}
