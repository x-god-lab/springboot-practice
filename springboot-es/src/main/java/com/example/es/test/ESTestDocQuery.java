package com.example.es.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author xin
 * @create 2021/10/25 0:23
 * @description
 **/
@Slf4j
public class ESTestDocQuery {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 1、查询索引中全部数据
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 2、条件查询 termQuery
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30L)));
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 3、分页查询
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        query.from(0);
//        query.size(2);
//        request.source(query);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 4、查询排序
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        query.sort("age", SortOrder.DESC);
//        request.source(query);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


        // 5、过滤字段
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//
//        String[] excludes = {"name"};
//        String[] includes = {};
//        query.fetchSource(includes,excludes);
//
//        request.source(query);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 6、组合查询
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder query = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30L));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("name","李四"));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("name","李四"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30L));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age",40L));
//
//
//
//        query.query(boolQueryBuilder);
//
//        request.source(query);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 7、范围查询
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder query = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30L);
//        rangeQuery.lt(40L);
//
//        query.query(rangeQuery);
//
//        request.source(query);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


        // 8、模糊查询
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder query = new SearchSourceBuilder();
//
//        query.query(QueryBuilders.fuzzyQuery("name", "王五").fuzziness(Fuzziness.TWO));
//
//        request.source(query);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }


//        // 9、高亮查询
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        MatchQueryBuilder termQueryBuilder = QueryBuilders.matchQuery("name", "李四");
//        builder.query(termQueryBuilder);
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>").postTags("</font>").field("name");
//
//        builder.highlighter(highlightBuilder);
//
//
//        request.source(builder);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//            System.out.println(hit);
//        }

//        // 10、聚合查询
//        SearchRequest request = new SearchRequest();
//
//        request.indices("person");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//
//        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 11、分组查询
        SearchRequest request = new SearchRequest();

        request.indices("person");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");

        builder.aggregation(aggregationBuilder);

        request.source(builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        restHighLevelClient.close();
    }
}
