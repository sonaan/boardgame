package com.boardgame.webstorage.controller;

import com.boardgame.webstorage.dto.*;
import com.boardgame.webstorage.entity.PhotosEntity;
import com.boardgame.webstorage.service.PhotoService;
import com.boardgame.webstorage.service.UserService;
import com.boardgame.webstorage.util.FileUploadUtil;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/photo/")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    /*@PostMapping(value = "/new")
    public ResponseEntity<Integer> createPhoto(@RequestBody PhotoRequestDTO body) {
        return ResponseEntity.ok(photoService.createPhoto(body.getName(),body.getValue(),body.getLink()));
    }*/

    @PostMapping("/save")
    public int saveImage(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        return photoService.saveImage(multipartFile);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
        return photoService.getImage(name);
    }

    @GetMapping(path = {"info/{name}"})
    public PhotosEntity getImageDetails(@PathVariable("name") String name) throws IOException {
        return photoService.getImageDetails(name);
    }


}
