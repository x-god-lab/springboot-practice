package com.example.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author xin
 * @create 2021/10/24 21:18
 * @description 删除索引
 **/
public class ESTestDeleteIndex {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 创建索引
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        AcknowledgedResponse delete
                = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);

        // 响应状态
        System.out.println(delete.isAcknowledged());

        restHighLevelClient.close();
    }
}
