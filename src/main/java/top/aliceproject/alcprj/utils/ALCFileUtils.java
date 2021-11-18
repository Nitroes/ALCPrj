package top.aliceproject.alcprj.utils;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class ALCFileUtils {
    //调试路径
    //private String Path= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
    //服务器路径
        private String Path= "/www/wwwroot/SpringBoot/ALCPrj/";

    public String saveFile(MultipartFile uploadFile, String userId, String fileName) throws IOException {
        String userPath="file/"+userId+"/";
        String suffix=uploadFile.getOriginalFilename();
        suffix=suffix.substring(suffix.lastIndexOf("."));
        fileName=fileName+suffix;
        File file=new File(Path+userPath,fileName);
        if(!file.exists()) file.mkdirs();
        uploadFile.transferTo(file);
        return "../"+userPath+fileName;
    }
}
