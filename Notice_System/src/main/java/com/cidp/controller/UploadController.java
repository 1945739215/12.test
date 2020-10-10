 package com.cidp.controller;


import com.cidp.config.VideoConfig;
import com.cidp.pojo.Xyzyxz;
import com.cidp.pojo.result.Result;
import com.cidp.service.LoadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


 @RestController
@CrossOrigin
public class UploadController {
    @Autowired
    LoadService loadService;

     //多文件上传  传进项目里面
        @PostMapping("/uploadfile")
        //需要前端  传文件    标题   和  文件上传时间（字符型）
        public Result fileUpload(MultipartFile[] files, Model model, String fileDate, String fileTitle,String parts) {
            boolean isSuccess = true;
            System.out.println(fileTitle);

                if (files.length > 0) {
                    for (int i = 0; i < files.length; i++) {
                        MultipartFile file = files[i];
                        System.out.println("进入上传");

                        String fileName = file.getOriginalFilename();//文件名
                        String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀
                        // String filePath = "D://xyzyxz-files//";
                        String filePath =   "static/uploadfile/";
                        System.out.println(filePath);

                        //改成随机名字   下载的时候  根据id 获取fileName
                        fileName = UUID.randomUUID() + suffixName; //随机新文件名  存入到数据库中

                        //File saveFile = new File(VideoConfig.VIDEOHOME + filePath+fileName);                   //  linux 下使用
                        File dest = new File(VideoConfig.WINDOWVIDEOHOME + filePath+fileName);//  window 下使用
                        System.out.println(dest.getPath());
                        if (!dest.getParentFile().exists()) {
                            dest.getParentFile().mkdirs();
                        }
                        try {
                            file.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String filename = "static/uploadfile/" + fileName;
                        model.addAttribute("filename", filename);

                        com.cidp.pojo.Xyzyxz fileUpload = new com.cidp.pojo.Xyzyxz();
                        fileUpload.setFileName(fileName);
                        fileUpload.setFileUrl(VideoConfig.WINDOWVIDEOHOME+filePath + fileName);
                        fileUpload.setFileDate(fileDate);
                        fileUpload.setFileTitle(fileTitle);
                        fileUpload.setParts(parts);

                        System.out.println(fileUpload);
                        if (loadService.selectByFileTitle(fileUpload.getFileTitle())!=null) {
                            isSuccess = false;
                            return Result.error("文件已存在,不可以重复上传");
                        }else{

                                System.out.println("判断上传是否成功");
                                if (loadService.insertfile(fileUpload.getFileName(), fileUpload.getFileDate(), fileUpload.getFileUrl(),
                                        fileUpload.getFileTitle(),fileUpload.getParts()) < 1)
                                    isSuccess = false;

                        }
                    }
                } else if (files.length == 0) {
                    System.out.println("文件为空");
                    isSuccess = false;
                }


            return isSuccess ? Result.success() : Result.error("error");
        }



    /*//多文件上传到本地
    @PostMapping("/uploadfile")
    //需要前端  传文件    标题   和  文件上传时间（字符型）
    public Result fileUpload(MultipartFile[] files, Model model, String fileDate, String fileTitle) {
        boolean isSuccess = true;
        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];

                String fileName = file.getOriginalFilename();//文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀
                String filePath = "D://xyzyxz-files//";
                //改成随机名字   下载的时候  根据id 获取fileName
                fileName = UUID.randomUUID() + suffixName;//随机新文件名  存入到数据库中

                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String filename = "/xyzyxz-files/" + fileName;
                model.addAttribute("filename", filename);

                com.cidp.pojo.Xyzyxz fileUpload = new com.cidp.pojo.Xyzyxz();
                fileUpload.setFileName(fileName);
                fileUpload.setFileUrl(filePath + fileName);
                fileUpload.setFileDate(fileDate);
                fileUpload.setFileTitle(fileTitle);

                System.out.println(fileUpload);

                // 避免再上传同样的文件,会重复
                if (loadService.selectByFileName(fileUpload.getFileName())!=null) {
                     isSuccess = false;
                    return Result.error("文件已存在");
                }else{
                    //判断是否成功上传
                    if (loadService.insertfile(fileUpload.getFileName(), fileUpload.getFileDate(), fileUpload.getFileUrl(), fileUpload.getFileTitle()) < 1)
                        isSuccess = false;
                }
            }
        } else if (files.length == 0) {
            System.out.println("文件为空");
            isSuccess = false;
        }
        return isSuccess ? Result.success() : Result.error("error");
    }
*/
            /*//单文件上传
            @PostMapping("/uploadfile")
            //需要前端  传一个文件    标题   和  文件上传时间（字符型）
            public Result fileUpload(@RequestParam(value = "file") MultipartFile file,  Model model  ,String fileDate,String fileTitle) {
                        if (file.isEmpty()) {
                            System.out.println("文件为空");
                            return Result.error("文件为空");
                        }

                        String fileName = file.getOriginalFilename();//文件名
                        //String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀
                        String filePath = "D://xyzyxz-files//";
                        //fileName = UUID.randomUUID() + suffixName;//随机新文件名  存入到数据库中

                        File dest = new File(filePath + fileName);
                        if (!dest.getParentFile().exists()) {
                            dest.getParentFile().mkdirs();
                        }
                        try {
                            file.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        String filename = "/xyzyxz-files/" + fileName;
                        model.addAttribute("filename", filename);

                        com.cidp.pojo.Xyzyxz fileUpload = new com.cidp.pojo.Xyzyxz();
                        fileUpload.setFileName(fileName);
                        fileUpload.setFileUrl(filePath+fileName);
                        fileUpload.setFileDate(fileDate);
                        fileUpload.setFileTitle(fileTitle);

                        System.out.println(fileUpload);
                        loadService.insertfile(fileUpload.getFileName(),fileUpload.getFileDate(),fileUpload.getFileUrl(),fileUpload.getFileTitle());
                        return Result.SuccesswithObject("success",fileUpload);

                    }*/



    //显示上传的文件   （url:学院资源下载）
    @RequestMapping(value = "/xyzyxzfile",method = RequestMethod.POST)
    public Result showXyzyxz( String parts)
    {
        System.out.println(parts);
        List<Xyzyxz> showXyzyxz=new ArrayList<>();
        showXyzyxz = loadService.SelectByParts(parts);
        System.out.println(showXyzyxz);
        return Result.SuccesswithObject("success",showXyzyxz);
    }

    //根据id删除
    @RequestMapping(value = "/DeleteXyzy", method = RequestMethod.POST)
    public Result Delete(@RequestBody Xyzyxz xyzyxz) {
        System.out.println("删除");
        System.out.println(xyzyxz);
        loadService.DeleteById(xyzyxz.getFileId());  //不用fileUrl
        return Result.success();
    }




}
