package com.example.trackerserver.controller;

import com.example.trackerserver.service.S3FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
    public class FileUploadController {

        private final S3FileUploadService s3FileUploadService;

        @Autowired
        public FileUploadController(S3FileUploadService s3FileUploadService) {
            this.s3FileUploadService = s3FileUploadService;
        }

//        @PostMapping("/upload")
//        public String uploadFileToS3(@RequestParam("file") MultipartFile file) {
//            String bucketName = "s3tracker/s3Saver/";
//            String objectKey = "C:\\Users\\Admin\\Downloads\\tracker-server\\tracker-server\\src\\main\\resources\\aman.txt";
//
//            try {
//                // Convert MultipartFile to File
//                File fileToUpload = File.createTempFile("tempFile", ".txt");
//                file.transferTo(fileToUpload);
//
//                // Upload the file to S3
//                s3FileUploadService.uploadFileToS3(bucketName, objectKey, fileToUpload);
//
//                return "File uploaded successfully!";
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "File upload failed!";
//            }
       // }
    }


