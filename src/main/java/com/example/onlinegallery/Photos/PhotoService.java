package com.example.onlinegallery.Photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public void addPhoto(Photo photo) {
        System.out.println(photo.getTitle());
        System.out.println(photo.getUrl());
        if (photo.getTitle() != null && photo.getTitle() != "") {
            if (photo.getUrl() != null && photo.getUrl() != "") {
                photoRepository.save(photo);
            } else {
                throw new IllegalStateException("The url is invalid");
            }
        } else {
            throw new IllegalStateException("The title is invalid");
        }
    }

    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public void updatePhoto(Long id, String title, String url) {
        Photo photoToEdit = photoRepository.findById(id).orElseThrow(()-> new IllegalStateException("The photo does not exists"));

        if(title != null && title != ""){
            photoToEdit.setTitle(title);
        }else{
            throw new IllegalStateException("The title it's invalid");
        }

        if(url != null && url != ""){
            photoToEdit.setUrl(url);
        }else{
            throw new IllegalStateException("The url it's invalid");
        }

        photoRepository.save(photoToEdit);

    }

    public void deletePhoto(Long id) {
        if(photoRepository.existsById(id)){
            photoRepository.deleteById(id);
        }else{
            throw new IllegalStateException("The Photo do not exists");
        }
    }
}
