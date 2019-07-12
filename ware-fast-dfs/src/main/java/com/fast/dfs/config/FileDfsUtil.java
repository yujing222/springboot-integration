package com.fast.dfs.config;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

@Component
public class FileDfsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileDfsUtil.class);
    @Resource
    private FastFileStorageClient storageClient ;
    /**
     * 上传文件
     */
    public String upload(MultipartFile multipartFile) throws Exception{
        String originalFilename = multipartFile.getOriginalFilename().
                                  substring(multipartFile.getOriginalFilename().
                                  lastIndexOf(".") + 1);
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                              multipartFile.getInputStream(),
                              multipartFile.getSize(),originalFilename , null);
        return storePath.getFullPath() ;
    }

    /**
     * 删除文件
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            LOGGER.info("fileUrl == >>文件路径为空...");
            return;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
