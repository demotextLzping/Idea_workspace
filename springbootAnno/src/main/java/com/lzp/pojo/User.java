package com.lzp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author： LZPing
 * @date： 2022-11-27 10:57
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

//@ConfigurationProperties(prefix = "user")
//@Component
public class User {
    private String name;
    private Integer age;
}
