package com.chan.fileupload.controller;

import com.chan.fileupload.service.FileStorageService;
import com.chan.fileupload.service.FileStorageServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RequestMapping("/api/v1/files")
@RestController
public class FileUploadcontroller {
    private final FileStorageService fileStorageService;

    public FileUploadcontroller(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
  public HashMap<String,Object> uploadFile(@RequestPart("file") MultipartFile file){
        System.out.println("method call in Post method");
        HashMap<String,Object>respone=new HashMap<>();
        respone.put("payload",fileStorageService.uploadSingleFile(file));
        return respone;
  }


}
