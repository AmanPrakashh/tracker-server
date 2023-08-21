package com.example.trackerserver.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


@Controller
public class TrackerController {

    @GetMapping("/getjson")
   public ResponseEntity<String> getJson() throws IOException
    {
        // Load the JSON file from the resources directory
        Resource resource = new ClassPathResource("data.json");
        byte[] jsonData = Files.readAllBytes(resource.getFile().toPath());

        // Convert byte array to String
        String jsonResponse = new String(jsonData, StandardCharsets.UTF_8);
        return ResponseEntity.ok().body(jsonResponse);
    }
}
