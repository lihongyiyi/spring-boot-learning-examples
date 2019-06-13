package com.hongy.elasticsearch.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Author lihongy
 * @Created by on 2019/06/12 18:49.
 * @Description:
 */
@Data
@Builder
public class ArticleSearchDTO {

    private String id;

    private String title;
}