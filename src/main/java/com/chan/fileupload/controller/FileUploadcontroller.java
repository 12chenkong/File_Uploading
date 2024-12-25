package com.chan.fileupload.controller;

import com.chan.fileupload.service.FileStorageService;
import com.chan.fileupload.service.FileStorageServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RequestMapping("/api/v1/files")
@RestController
public class FileUploadcontroller {

    private final FileStorageService fileStorageService;

    public String generateImagesUrl (String fileName, HttpServletRequest request){
        return String.format("%s://%s:%d/images/%s",
                request.getScheme(),request.getServerName(),request.getServerPort(),fileName);
    }

    public FileUploadcontroller(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
  public HashMap<String,Object> uploadFile(@RequestPart("file") MultipartFile file ,HttpServletRequest request){
        System.out.println("method call in Post method");
        HashMap<String,Object>respone=new HashMap<>();
        respone.put("payload",generateImagesUrl(fileStorageService.uploadSingleFile(file),request));
        return respone;
  }

  @PostMapping("/multiple")
    public HashMap<String,Object>uploadMultipleFiles(@RequestPart("files") MultipartFile[] files){
        HashMap<String,Object> respone=new HashMap<>();
        respone.put("Message","Successfully upload images");
        respone.put("status", HttpStatus.CREATED.value());
        respone.put("Playload ",fileStorageService.uploadMutipleFiles(files));
        return respone;
  }

  @DeleteMapping("/deleteFile/{filename}")
    public HashMap<String,Object> deleteFileByName(@PathVariable String filename){
        HashMap<String,Object> respone=new HashMap<>();
        respone.put("Message","successfully delete image");
        respone.put("status ",fileStorageService.deleteImage(filename));
        return respone;

  }



}
