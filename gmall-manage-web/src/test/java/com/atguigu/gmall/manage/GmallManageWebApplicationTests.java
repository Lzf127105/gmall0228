package com.atguigu.gmall.manage;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws  Exception{

        //获取/tracker.conf在项目运行时的真实路径(不能加斜杆)
        //（在打包成jar时，部署在linux上会出现路径问题。要放在安装目录下）

        //1、读取配置
        String file = GmallManageWebApplicationTests.class.getClassLoader()
                .getResource("tracker.conf").getFile();

        ClientGlobal.init(file);

        //2、获取tracker服务
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer connection = trackerClient.getConnection();

        //3、获取storage服务
        StorageClient storageClient = new StorageClient(connection, null);

        //4、开始上传
        String[] paths = storageClient.upload_file("C:/video/222.jpg", "jpg", null);

        for (String path : paths) {
            System.out.println(path);
        }

    }

}
