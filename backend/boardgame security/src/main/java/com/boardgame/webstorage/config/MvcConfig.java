package com.boardgame.webstorage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("img", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath2 = uploadDir.toFile().getAbsolutePath();

        String uploadPath = "C:/Users/A11339223/Downloads/java projects/java-education/backend/boardgame security/src/main/resources/static/img";
       // C:\Users\A11339223\Downloads\java projects\java-education\backend\boardgame security\src\main\resources\static\img


        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");

        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    }
}
