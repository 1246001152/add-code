package com.myself.code.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * QrCode配置文件读取Bean
 * Created by MySelf on 2018/11/8.
 */
@Data
@Component
@ConfigurationProperties(prefix = "qrcode")
public class QrCode {

    /** 前端资源监听路径 */
    private String handler;

    /** 资源存放父目录 */
    private String location;

    /** 资源存放父目录 */
    private String parents;

    /** 生成二维码的后缀名称 */
    private String suffixname = ".png";

    /** 生成二维码的字符编码 */
    private String charaset = "utf-8";

    /** 生成二维码的格式 */
    private String format = "png";

    /** 二维码的宽 */
    private int width = 300;

    /** 二维码的高 */
    private int height = 300;

}
