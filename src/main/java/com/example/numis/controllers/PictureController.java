package com.example.numis.controllers;
import com.example.numis.services.PictureService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PictureController {
    private final PictureService _service;
    public PictureController(PictureService service){
        _service=service;
    }
    @PostMapping("/pictures")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            _service.saveImage(file);
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload image.");
        }
    }
    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        byte[] imageData = _service.getImageById(id);
        if (imageData != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
