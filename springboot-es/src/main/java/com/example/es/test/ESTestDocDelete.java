package com.example.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author xin
 * @create 2021/10/24 23:40
 * @description
 **/
public class ESTestDocDelete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 查询数据
        DeleteRequest request = new DeleteRequest();
        request.index("person").id("1001");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());

        restHighLevelClient.close();
    }
}
