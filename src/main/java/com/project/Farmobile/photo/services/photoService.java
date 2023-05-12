    package com.project.Farmobile.photo.services;

    import com.project.Farmobile.aws.S3Service;
    import com.project.Farmobile.photo.data.photo;
    import org.springframework.stereotype.Service;
    import com.project.Farmobile.photo.services.photoRepo;
    import org.springframework.web.multipart.MultipartFile;

    import java.io.IOException;

    @Service
    public class photoService {
        private final photoRepo photoRepo;
        private final S3Service s3Service;

        public photoService(photoRepo photoRepo, S3Service s3Service) {
            this.photoRepo = photoRepo;
            this.s3Service = s3Service;
        }

        public photo upload(MultipartFile file) throws IOException {
            String link = s3Service.uploadPhoto(file);
            photo newPhoto = photoRepo.save(new photo(link));
            return newPhoto;
        }
    }
