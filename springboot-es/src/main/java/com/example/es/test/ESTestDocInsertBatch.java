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

        request.add(new IndexRequest().index("person").id("1006").source(XContentType.JSON,"name","王五1","sex","男","age",30L));
        request.add(new IndexRequest().index("person").id("1007").source(XContentType.JSON,"name","王五2","sex","男","age",30L));
        request.add(new IndexRequest().index("person").id("1008").source(XContentType.JSON,"name","王五3","sex","女","age",40L));
        request.add(new IndexRequest().index("person").id("1009").source(XContentType.JSON,"name","王五33","sex","男","age",20L));
        request.add(new IndexRequest().index("person").id("1010").source(XContentType.JSON,"name","王五44","sex","女","age",50L));

        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(response.getTook());
        System.out.println(response.getItems());

        restHighLevelClient.close();
    }
}
