package com.example.trackerserver.controller;
import com.example.trackerserver.service.S3FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TrackerController {

    @Autowired
    S3FileUploadService s3FileUploadService;

    @GetMapping("/getjson")
   public ResponseEntity<String> getJson() throws IOException
    {
        // Load the JSON file from the resources directory
        Resource resource = new ClassPathResource("com/example/trackerserver/data.json");
        byte[] jsonData = Files.readAllBytes(resource.getFile().toPath());


        List<Character > l1 = new ArrayList<>();
        l1.add('a');

        // Convert byte array to String
        String jsonResponse = new String(jsonData, StandardCharsets.UTF_8);
        return ResponseEntity.ok().body(jsonResponse);
    }


    @PostMapping("s3/save")
    public void saveToS3()
    {
        s3FileUploadService.uploadFileToS3();
    }
}
