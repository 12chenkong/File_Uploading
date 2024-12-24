package com.chan.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class FileStorageServiceImp implements FileStorageService{
    String fileStorageLocation="fileStorage/images";
    @Override
    public String uploadSingleFile(MultipartFile file) {
        Path imageStoragePath=Path.of(fileStorageLocation);
        String newFileName=null;

        try {
            if(!Files.exists(imageStoragePath)){
                System.out.println("file created");
                Files.createDirectories(imageStoragePath);
            }
             //fileStorage/images/2345345.jpng
             newFileName= UUID.randomUUID()+"."+file.getOriginalFilename().split("\\.")[1];
            Path imageFullPath=imageStoragePath.resolve(newFileName);
            Files.copy(file.getInputStream(),imageFullPath, StandardCopyOption.REPLACE_EXISTING);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Fail to upload file!!!");
        }
        return newFileName;

    }

    @Override
    public List<String> uploadMutipleFiles(MultipartFile[] files) {
        return List.of();
    }
}
