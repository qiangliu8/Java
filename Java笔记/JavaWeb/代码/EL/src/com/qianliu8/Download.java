package com.qianliu8;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Download extends HttpServlet {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String content ="这是需要Base64编码的内容";
        //黄健一个Base64编码器
//        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码操作
        String encodeString = Base64.getEncoder().encodeToString(content.getBytes(StandardCharsets.UTF_8));

        System.out.println(encodeString);

        //执行解码操作
        byte[] b = Base64.getDecoder().decode(encodeString);
        String decodeString = new String(b,"UTF-8");
        System.out.println(decodeString);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载的文件名
        String downloadFileName = "小米.jpg";
        //读取要下载的文件内容
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/"+downloadFileName);
        //在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        System.out.println(mimeType);
        //告诉客户端收到数据时候用于下载(使用响应头)
        //attachment表示附件
        //URL编码是把汉字转换成XX%XX的格式
        if (!req.getHeader("User-Agent").contains("Firefox")){
            //如果不是火狐，使用URL编码
            resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(downloadFileName,"UTF-8") );
        }else{
            //如果是火狐，使用Base64编码
            resp.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+Base64.getEncoder().encode(downloadFileName.getBytes("UTF-8")));
        }

        InputStream inputStream =  servletContext.getResourceAsStream("/file/"+downloadFileName);
//        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
//        //把下载的文件内容回传给客户端
//        //读取输入流中全部数据，赋值给输出流，输出给客户端
        IOUtils.copy(inputStream,outputStream);

    }
}
