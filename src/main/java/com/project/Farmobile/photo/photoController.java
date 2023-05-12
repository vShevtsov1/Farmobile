package com.project.Farmobile.photo;

import com.project.Farmobile.photo.data.photo;
import com.project.Farmobile.photo.services.photoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(path = "/photo")
public class photoController {

    private final photoService photoService;

    public photoController(photoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping("/upload")
    private photo uploadPhoto(@RequestPart("file") MultipartFile file) throws IOException {
        return photoService.upload(file);
    }


}
