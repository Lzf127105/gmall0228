package com.atguigu.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Lzf
 * @create 2019-06-22 16:58
 */
public class MyFastdfsUploadUtils {

    public static String uploadImage(MultipartFile file){
        //获取/tracker.conf在项目运行时的真实路径(不能加斜杆)
        //（在打包成jar时，部署在linux上会出现路径问题。要放在安装目录下）
        String httpPath = "http://192.168.184.129";

        //1、读取配置
        String conf = MyFastdfsUploadUtils.class.getClassLoader()
                .getResource("tracker.conf").getFile();

        try {
            ClientGlobal.init(conf);
        }catch (Exception e){
            e.printStackTrace();
        }

        //2、获取tracker服务
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = null;
        try {
            connection = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3、获取storage服务
        StorageClient storageClient = new StorageClient(connection, null);

        //4、开始上传
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf(".") + 1);


        try {
            String[] paths = storageClient.upload_file(file.getBytes(), extName, null);
            for (String path : paths) {
                httpPath = httpPath+"/"+path;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return httpPath;
    }
}
