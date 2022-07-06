package com.example.onlinegallery.Photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/photos")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping
    public List<Photo> getPhotos(){
        return photoService.getPhotos();
    }

    @PutMapping(path = "{id}")
    public void updatePhoto(@PathVariable("id") Long id ,@RequestBody Photo photo){
        photoService.updatePhoto(id, photo.getTitle(), photo.getUrl());
    }

    @PostMapping
    public void addPhoto(@RequestBody Photo photo){
        photoService.addPhoto(photo);
    }

    @DeleteMapping(path = "{id}")
    public void addPhoto(@PathVariable("id") Long id){
        photoService.deletePhoto(id);
    }
}
