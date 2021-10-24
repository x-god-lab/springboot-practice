package com.example.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;

/**
 * @author xin
 * @create 2021/10/24 21:13
 * @description 插入数据
 **/
public class ESTestDocInsert {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        // 插入数据
        IndexRequest request = new IndexRequest("person");

        request.index("person").id("1001");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("张三");
        personInfo.setSex("男");
        personInfo.setAge(30L);
        personInfo.setBirth(new Date());
        personInfo.setIdCardNo("342901200003062562");
        personInfo.setAddress("安徽省南京市北京区");
        personInfo.setEmail("56465@qq.com");
        personInfo.setPhone("195865863235");
        personInfo.setWork("律师");

        // 向Es中插入数据，必须将数据转为Json格式
        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(personInfo);
        request.source(personJson, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());
        System.out.println(response.getId());

        restHighLevelClient.close();
    }
}
