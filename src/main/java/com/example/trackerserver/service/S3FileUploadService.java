package com.example.trackerserver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.utils.IoUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
@Slf4j
public class S3FileUploadService {
    private final S3Client s3Client;

        public S3FileUploadService() {
            String awsAccessKeyId = "AKIA3GEHWVUOJ564I2GD";
            String awsSecretAccessKey = "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";
            AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(awsAccessKeyId, awsSecretAccessKey);
            AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(awsCredentials);

            // Create the S3 client
            s3Client = S3Client.builder()
                    .region(Region.AP_SOUTH_1) // Set your desired AWS region
                    .credentialsProvider(credentialsProvider)
                    .build();
        }


        public void uploadFileToS3() {
            String bucketName = "trackerv1";
            String objectKey = "aman.txt";
            File fileToUpload = new File("C:\\Users\\Admin\\Downloads\\tracker-server\\tracker-server\\src\\main\\resources\\aman.txt"); // Replace with your file path

            try {
                // Upload the file to S3
                PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build();

                PutObjectResponse response = s3Client.putObject(putObjectRequest, Paths.get(fileToUpload.getAbsolutePath()));

                // Handle the response if needed
                log.debug("File uploaded successfully. ETag: " + response.eTag());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }



    }