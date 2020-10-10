package com.cidp.controller;

import cn.hutool.core.lang.Assert;
import com.cidp.pojo.Xyzyxz;
import com.cidp.pojo.result.Result;
import com.cidp.service.LoadService;
import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.URLEncoder;
import java.util.function.BooleanSupplier;

@Controller
@RequestMapping("download")
public class    DownloadController {
    @Autowired
    LoadService loadService;

    @GetMapping("/{fileId}")//@GetMapping 组合注解
    public void download(@PathVariable Integer fileId, HttpServletResponse response) throws IOException {//@PathVaribale 获取url中的数据
              /*  Assert.notBlank(xyzyxz.getFileName(),"文件名不能为空！");
                String filePath = "D://xyzyxz-files//";
                System.out.println(filePath);*/
        Xyzyxz xyzyxz =  loadService.selectByFileId1(fileId);
        File file = new File(String.valueOf(loadService.selectByFileUrl(fileId)));//传fileId获取到fileUrl(mapper)进行下载
        System.out.println(loadService.selectByFileUrl(fileId));
        System.out.println(file.getName());
        System.out.println(file);
        response.setContentType("application/force-download");//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   下载弹出的确定保存提示框
        response.addHeader("Content-Disposition","attachment;fileName="+xyzyxz.getFileName());
//        response.setContentLength((int)file.length());
        response.setContentType("multipart/form-data");
        if (file.getParentFile().exists()) {

            InputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            try{ int len=0;
                while ((len = bis.read())!= -1){
                    out.write(len);
                    out.flush();
                }
                out.close();
//            try (FileInputStream fis = new FileInputStream(file); BufferedInputStream bis = new BufferedInputStream(fis)) {
//                OutputStream bos = response.getOutputStream();
//                int i = bis.read(buffer);
//                while (i != -1) {
//                    bos.write(buffer, 0, i);
//                    i = bis.read(buffer);
//                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                BufferedInputStream bis = new BufferedInputStream(fis);
                if (bis != null) {
                    try {
                        bis.close();//关闭文件
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
//                OutputStream bos = response.getOutputStream();
                if(out != null){
                    try {
                        out.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
