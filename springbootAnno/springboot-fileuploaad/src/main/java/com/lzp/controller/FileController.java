package com.lzp.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: LZPing
 * @date: 2022-11-28 15:55
 * @Description
 */
@Controller
@RequestMapping("/file")
public class FileController {
    private static final String FILESERVER = "http://127.0.0.1:8090/upload/";

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> fileUpload(MultipartFile headPhoto) throws IOException {
        //创建Map用于给前台进行数据传送
        HashMap<String, String> map = new HashMap<>();
        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();
        //获取uuid值
        String uuid = UUID.randomUUID().toString();
        //获取后缀名
        //拼接新的文件名
        String newFileName = uuid.concat(originalFilename);
        //创建sun公司提供的jersey中的client对象
        Client client = Client.create();
        //跨服务器对文件进行存储
        WebResource resource = client.resource(FILESERVER + newFileName);
        //文件保存写入
        resource.put(String.class, headPhoto.getBytes());
        //上传成功后，将文件的名称何文件类型返回给浏·览器
        map.put("message", "文件上传成功");
        map.put("newFileName", FILESERVER + newFileName);
        map.put("fileType", headPhoto.getContentType());
        return map;
    }
}