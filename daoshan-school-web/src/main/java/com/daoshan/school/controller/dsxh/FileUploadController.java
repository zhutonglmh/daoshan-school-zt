package com.daoshan.school.controller.dsxh;


import com.daoshan.school.utils.messagebody.MessageBody;
import com.daoshan.school.utils.uuid.UUIDUtils;
import com.oracle.webservices.internal.api.message.PropertySet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;

/**
 * 文件上传 controller
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {


    @Value("${custom.address.image}")
    private String urlImage;
    @RequestMapping(value = "/uploadImage"
            , method = RequestMethod.POST)
    @ResponseBody
    public MessageBody uploadHeadPic(MultipartFile file) {

        String url = "";
        String uuid = "";
        //如果上面的步骤中在结束前任意一步失败，那就直接失败了。
        FileOutputStream out = null;
        if (null == file || file.isEmpty()) {

            return MessageBody.getMessageBody(true,"失败");

        }else{
            //这里以用户ID作为文件夹
            url = urlImage; //new FileUtil().createImageDir( String.valueOf(uid));
            uuid = UUIDUtils.getUUID();
            url = url+uuid+".jpg";
            try {
                //获得二进制流并输出
                byte[] f = file.getBytes();
                out = new FileOutputStream(url);
                out.write(f);

            } catch (IOException e) {
                return MessageBody.getMessageBody(true,"失败");
            }finally {
                // 完毕，关闭所有链接
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("关闭流失败");
                }
            }
        }
        return MessageBody.getMessageBody(true,uuid);
    }

    /**
     * 视频上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadVedio"
            , method = RequestMethod.POST)
    @ResponseBody
    public MessageBody uploadVedio(MultipartFile file) {

        String url = "";
        String uuid = "";
        //如果上面的步骤中在结束前任意一步失败，那就直接失败了。
        FileOutputStream out = null;
        if (null == file || file.isEmpty()) {

            return MessageBody.getMessageBody(true,"失败");

        }else{
            //这里以用户ID作为文件夹
            url = urlImage; //new FileUtil().createImageDir( String.valueOf(uid));
            uuid = UUIDUtils.getUUID();
            url = url+uuid+".mp4";
            try {
                //获得二进制流并输出
                byte[] f = file.getBytes();
                out = new FileOutputStream(url);
                out.write(f);

            } catch (IOException e) {
                return MessageBody.getMessageBody(true,"失败");
            }finally {
                // 完毕，关闭所有链接
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("关闭流失败");
                }
            }
        }
        return MessageBody.getMessageBody(true,uuid);
    }

    @RequestMapping(value = "/getImage/{address}")
    public void readImage(HttpServletRequest request, HttpServletResponse response,@PathVariable(value = "address") String imagePath){

        try{
            String url = urlImage+imagePath+".jpg";
            File file = new File(url);
            if (file.exists()) {
                DataOutputStream temps = new DataOutputStream(response
                        .getOutputStream());
                DataInputStream in = new DataInputStream(
                        new FileInputStream(url));
                byte[] b = new byte[2048];
                while ((in.read(b)) != -1) {
                    temps.write(b);
                    temps.flush();
                }
                in.close();
                temps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取视频文件
     * @param request
     * @param response
     * @param imagePath
     */
    @RequestMapping(value = "/getVedio/{address}")
    public void readVedio(HttpServletRequest request, HttpServletResponse response,@PathVariable(value = "address") String imagePath){

        try{
            String url = urlImage+imagePath+".mp4";
            File file = new File(url);
            if (file.exists()) {
                DataOutputStream temps = new DataOutputStream(response
                        .getOutputStream());
                DataInputStream in = new DataInputStream(
                        new FileInputStream(url));
                byte[] b = new byte[2048];
                while ((in.read(b)) != -1) {
                    temps.write(b);
                    temps.flush();
                }
                in.close();
                temps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
