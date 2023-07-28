package com.lzp.httpclient;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzp.pojo.User;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Writer;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author: LZPing
 * @date: 2022-12-05 10:12
 * @Description
 */
@SpringBootTest
public class HttpClientDemo {
    @Test
    public void testGetDemo() throws IOException {
        CloseableHttpClient httpClient = null;
        URIBuilder uriBuilder = null;
        HttpGet get = null;
        CloseableHttpResponse response = null;
        try {
            //1.创建http工具（理解为 浏览器） 发送请求 ，解析响应
            httpClient = HttpClients.createDefault();
            //2.设置请求路径
            uriBuilder = new URIBuilder("http://localhost:8080/demo");
            //添加参数值
            uriBuilder.addParameter("Param", "zhansan");
            //3.创建httpGet请求对象
            get = new HttpGet(uriBuilder.build());
            //4.创建响应对象
            response = httpClient.execute(get);
            //5.由于响应体是字符串，因此把HttpEntity类型转换为字符串类型 ，病设置字符集编码
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            //6.输出结果
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            response.close();
            httpClient.close();
        }
    }


    @Test
    public void testPostDemo() throws IOException {
        try {
            //1.创建http工具（理解为 浏览器） 发送请求 ，解析响应
            CloseableHttpClient httpClient = httpClient = HttpClients.createDefault();
            //2.设置请求路径
            HttpPost post = new HttpPost("http://localhost:8080/demo");
            //post添加参数值
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("Param", "lisi"));
            //post设置编码格式
            HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
            //放到HttpPost对象中
            post.setEntity(httpEntity);
            //3.创建响应对象
            CloseableHttpResponse response = httpClient.execute(post);
            //5.由于响应体是字符串，因此把HttpEntity类型转换为字符串类型 ，病设置字符集编码
            String result = EntityUtils.toString(response.getEntity());
            //6.输出结果
            System.out.println(result);
            assert response != null;
            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReturnObject() {
        try {
            //1.创建http工具（理解为 浏览器） 发送请求 ，解析响应
            CloseableHttpClient httpClient = httpClient = HttpClients.createDefault();
            //2.设置请求路径
            HttpPost post = new HttpPost("http://localhost:8080/demo2");
            //post添加参数值
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("id", "10010"));
            params.add(new BasicNameValuePair("name", "wangwu"));
            //post设置编码格式
            HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
            //放到HttpPost对象中
            post.setEntity(httpEntity);
            //3.创建响应对象
            CloseableHttpResponse response = httpClient.execute(post);
            //5.由于响应体是字符串，因此把HttpEntity类型转换为字符串类型 ，病设置字符集编码
            String result = EntityUtils.toString(response.getEntity());
            //6.输出结果
            System.out.println(result);
//            将json格式转换为对象
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(result, User.class);
            System.out.println(user);
//            将对象转换为接送格式
            String UserJson = objectMapper.writeValueAsString(user);
            System.out.println(UserJson);
            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testReturnList() {
        try {
            //1.创建http工具（理解为 浏览器） 发送请求 ，解析响应
            CloseableHttpClient httpClient = httpClient = HttpClients.createDefault();
            //2.设置请求路径
            HttpPost post = new HttpPost("http://localhost:8080/demo3");
            //3.创建响应对象
            CloseableHttpResponse response = httpClient.execute(post);
            //4.由于响应体是字符串，因此把HttpEntity类型转换为字符串类型 ，病设置字符集编码
            String result = EntityUtils.toString(response.getEntity());
            //5.输出结果
            System.out.println(result);
            //字符串转集合类型
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, User.class);

            List<User> users = objectMapper.readValue(result, javaType);
            users.forEach(System.out::println);

            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testStream() {
        try {
            //1.创建http工具（理解为 浏览器） 发送请求 ，解析响应
            CloseableHttpClient httpClient = httpClient = HttpClients.createDefault();
            //2.设置请求路径
            HttpPost httpPost = new HttpPost("http://localhost:8080/demo4");
            List<User> listParam = new ArrayList<>();
            listParam.add(new User(1, "张三丰"));
            listParam.add(new User(2, "张无忌"));
            //字符串转集合类型
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonParam = objectMapper.writeValueAsString(listParam);
            StringEntity httpEntity = new StringEntity(jsonParam, ContentType.APPLICATION_JSON);
            httpPost.setEntity(httpEntity);
            //3.创建响应对象
            CloseableHttpResponse response = httpClient.execute(httpPost);
            //4.由于响应体是字符串，因此把HttpEntity类型转换为字符串类型 ，病设置字符集编码
            String result = EntityUtils.toString(response.getEntity());
            //5.输出结果
            System.out.println(result);
            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}