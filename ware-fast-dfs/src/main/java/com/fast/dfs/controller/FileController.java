package com.fast.dfs.controller;

import com.fast.dfs.config.FileDfsUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;

@RestController
public class FileController {
    @Resource
    private FileDfsUtil fileDfsUtil ;
    /**
     * http://localhost:7010/swagger-ui.html
     * http://192.168.72.130/group1/M00/00/00/wKhIgl0n4AKABxQEABhlMYw_3Lo825.png
     */
    @ApiOperation(value="上传文件", notes="测试FastDFS文件上传")
    @RequestMapping(value = "/uploadFile",headers="content-type=multipart/form-data", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile (@RequestParam("file") MultipartFile file){
        String result ;
        try{
            String path = fileDfsUtil.upload(file) ;
            if (!StringUtils.isEmpty(path)){
                result = path ;
            } else {
                result = "上传失败" ;
            }
        } catch (Exception e){
            e.printStackTrace() ;
            result = "服务异常" ;
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 文件删除
     */
    @RequestMapping(value = "/deleteByPath", method = RequestMethod.GET)
    public ResponseEntity<String> deleteByPath (){
        String filePathName = "group1/M00/00/00/wKhIgl0n4AKABxQEABhlMYw_3Lo825.png" ;
        fileDfsUtil.deleteFile(filePathName);
        return ResponseEntity.ok("SUCCESS") ;
    }

}
