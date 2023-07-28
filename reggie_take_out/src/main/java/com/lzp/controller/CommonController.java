package com.lzp.controller;

import com.lzp.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author: LZPing
 * @date: 2022-12-12 12:29
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //file是一个临时文件，需要转存到指定的位置，否则零食文件在请求结束后会自动的删除
        log.info("文件名:" + file.toString());
        String originalFilename = file.getOriginalFilename();
        String suffix = null;
        if (originalFilename != null) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String fileName = UUID.randomUUID() + suffix;
        try {
            file.transferTo(new File(basePath + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    @GetMapping("/download")
    public R<String> download(String name, HttpServletResponse response)  {
        log.info("图片回显: {}", name);
        FileInputStream fis = null;
        ServletOutputStream ops = null;
        try {
            fis = new FileInputStream(basePath + name);
            ops = response.getOutputStream();
//            response.setContentType("image/jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                ops.write(bytes, 0, len);
                ops.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                assert ops != null;
                ops.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return R.success("下载成功");

    }
}
