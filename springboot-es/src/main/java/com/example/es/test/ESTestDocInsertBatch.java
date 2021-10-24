package com.example.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author xin
 * @create 2021/10/24 23:42
 * @description 批量保存
 **/
public class ESTestDocInsertBatch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 批量插入数据
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("person").id("1001").source(XContentType.JSON,"name","张三","sex","男","age",30L));
        request.add(new IndexRequest().index("person").id("1002").source(XContentType.JSON,"name","李四","sex","男","age",30L));
        request.add(new IndexRequest().index("person").id("1003").source(XContentType.JSON,"name","王五","sex","女","age",40L));
        request.add(new IndexRequest().index("person").id("1004").source(XContentType.JSON,"name","孙六","sex","男","age",20L));
        request.add(new IndexRequest().index("person").id("1005").source(XContentType.JSON,"name","钱七","sex","女","age",50L));

        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getItems());

        restHighLevelClient.close();
    }
}
