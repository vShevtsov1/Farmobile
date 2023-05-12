package com.project.Farmobile.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class S3Service {

    private final S3Client s3Client;

    private  String bucketName;

    private String keyID;

    private String accessKey;

    @Autowired
    public S3Service(@Value("${bucket.name}") String bucketName,
                     @Value("${AWS_ACCESS_KEY_ID}") String keyID,
                     @Value("${AWS_SECRET_ACCESS_KEY}") String accessKey) {
        this.bucketName = bucketName;
        this.keyID = keyID;
        this.accessKey = accessKey;
        AwsBasicCredentials credentials = AwsBasicCredentials.create(keyID, accessKey);
        this.s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(() -> credentials)
                .build();
    }

    public String uploadPhoto(MultipartFile file) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = uuid + fileExtension;
        InputStream inputStream = file.getInputStream();
        PutObjectRequest putRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .acl(ObjectCannedACL.PUBLIC_READ) // Set the ACL to public read access
                .contentType(file.getContentType()) // Set the content type of the file
                .build();
        PutObjectResponse response = s3Client.putObject(putRequest, RequestBody.fromInputStream(inputStream, file.getSize()));
        String photoUrl = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(filename)).toExternalForm();
        return photoUrl;
    }


    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        file.transferTo(convertedFile);
        return convertedFile;
    }
}
