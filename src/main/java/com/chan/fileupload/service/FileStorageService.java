package com.chan.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService {

    String uploadSingleFile(MultipartFile file);
    List<String> uploadMutipleFiles(MultipartFile[] files);
}
