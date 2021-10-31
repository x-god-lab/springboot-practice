package com.example.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author xin
 * @create 2021/10/24 23:32
 * @description
 **/
public class ESTestDocGet {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 查询数据
        GetRequest request = new GetRequest();
        request.index("person").id("1010");
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);

        System.out.println(response.getSource());
        System.out.println(response.getSourceAsString());

        restHighLevelClient.close();
    }
}
