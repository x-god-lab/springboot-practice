package com.example.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author xin
 * @create 2021/10/24 23:51
 * @description
 **/
public class ESTestDocDeleteBatch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 批量插入数据
        BulkRequest request = new BulkRequest();

        request.add(new DeleteRequest().index("person").id("1001"));
        request.add(new DeleteRequest().index("person").id("1002"));
        request.add(new DeleteRequest().index("person").id("1003"));
        request.add(new DeleteRequest().index("person").id("1004"));
        request.add(new DeleteRequest().index("person").id("1005"));

        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getItems());

        restHighLevelClient.close();
    }
}
