package com.boardgame.webstorage.service;

import com.boardgame.webstorage.dto.AuthenticationRequest;
import com.boardgame.webstorage.dto.AuthenticationResponse;
import com.boardgame.webstorage.dto.UserResponseDTO;
import com.boardgame.webstorage.entity.PhotosEntity;
import com.boardgame.webstorage.entity.Role;
import com.boardgame.webstorage.entity.UserEntity;
import com.boardgame.webstorage.repositories.PhotoRepo;
import com.boardgame.webstorage.repositories.UserRepo;
//import com.boardgame.webstorage.security.JwtService;
import com.boardgame.webstorage.util.FileUploadUtil;
import com.boardgame.webstorage.util.ImageUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepo photoRepo;

    public int saveImage(MultipartFile multipartFile) throws IOException {
        log.debug("saveImage");
        try {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            // String uploadDir = "images/";

            // String uploadDir = "src/main/resources/static/img/";

            // FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

            PhotosEntity photosEntity = new PhotosEntity(multipartFile.getOriginalFilename(), null, multipartFile.getOriginalFilename(), multipartFile.getContentType(), ImageUtility.compressImage(multipartFile.getBytes()));
            return photoRepo.save(photosEntity).getId();

        } catch (Exception e) {
            log.debug(e);
            return -1;
        }

    }

    public ResponseEntity<byte[]> getImage(String name) {
        final PhotosEntity dbImage = photoRepo.findByName(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.getType()))
                .body(ImageUtility.decompressImage(dbImage.getImage()));

    }

    public PhotosEntity getImageDetails(String name) {
        final PhotosEntity dbImage = photoRepo.findByName(name);
        dbImage.setImage(ImageUtility.decompressImage(dbImage.getImage()));

        return dbImage;
    }

    /* public int createPhoto(String name, String value, String link) {
        PhotosEntity photosEntity = new PhotosEntity(name, value, link);
        log.debug("Photo creation: " + photosEntity);
        return photoRepo.save(photosEntity).getId();
    }*/


}
