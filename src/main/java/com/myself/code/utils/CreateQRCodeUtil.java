package com.myself.code.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Created by MySelf on 2018/11/7.
 */
public class CreateQRCodeUtil {

    private static final int WIDTH = 300;

    private static final int HEIGHT = 300;

    private static final String FORMAT = "png";

    public static String create(String content,String name){
        //定义二维码参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        //生成二维码
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,WIDTH,HEIGHT,hints);
            Path file = new File("E:\\Git项目/addcode/src/main/resources/static/img/"+name+".png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,FORMAT,file);
            return file.getFileName().toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
