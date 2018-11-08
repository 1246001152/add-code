package com.myself.code.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.myself.code.config.QrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 二维码便捷工具类
 * Created by MySelf on 2018/11/7.
 */
@Component
public class CreateQRCodeUtil {

    @Autowired
    private QrCode qrCode;

    /**
     * 创建二维码图片，并返回相对的地址
     * @param content 二维码的自定义内容
     * @param name 二维码的图片名称
     * @return 二维码的名称
     */
    public String create(String content,String name){
        //定义二维码参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, qrCode.getCharaset());
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        //生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,qrCode.getWidth(),qrCode.getHeight(),hints);
            Path file = new File(qrCode.getParents()+name+qrCode.getSuffixname()).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,qrCode.getFormat(),file);
            return file.getFileName().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
