package com.hongy.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 17:39.
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "jobbole", type = "article")
public class JobboleArticle {

    @Id
    private String id;

    @JsonAlias("comment_nums") // @JsonAlias注解可以解决属性名和es字段名不一致时的映射问题
    private Integer commentNums;

    private String content;

    @JsonAlias("create_date")
    private Date createDate;

    @JsonAlias("fav_nums")
    private Integer favNums;

    @JsonAlias("front_image_url")
    private List<String> frontImageUrl;

    @JsonAlias("praise_nums")
    private Integer praiseNums;

    private String tags;

    private String title;

    private String url;
}