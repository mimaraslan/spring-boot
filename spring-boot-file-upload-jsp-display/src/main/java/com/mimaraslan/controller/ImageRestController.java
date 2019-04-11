package com.mimaraslan.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
@RestController
public class ImageRestController {
 
	private static String baseFolderPath = System.getProperty("user.dir")+"/src/main/resources/static/";

    //method for uploading single file
    @RequestMapping(value = "/upload/file", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("fileName") MultipartFile fileName) {
 
        File uploadedFile = new File(baseFolderPath, fileName.getOriginalFilename());
 
        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(fileName.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Object>("File Uplaoded succesfully", HttpStatus.OK);
    }
     
     
    //method for uploading multiple files
    @RequestMapping(value = "/upload/multiplefiles", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadmultipleFile(@RequestParam("fileNames") MultipartFile[] fileNames) {
        FileOutputStream fileOutputStream = null;
 
        for (MultipartFile multipartFile : fileNames) {
 
            File uploadedFile = new File(baseFolderPath, multipartFile.getOriginalFilename());
 
            try {
                uploadedFile.createNewFile();
                fileOutputStream = new FileOutputStream(uploadedFile);
                fileOutputStream.write(multipartFile.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<Object>("All file Uplaoded succesfully", HttpStatus.OK);
    }
 
    
    //method for downloading file
    @RequestMapping(value = "/download/file/{fileName:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Object> downloadFile(@PathVariable String fileName, HttpServletResponse response) {
 
        String filePath = baseFolderPath + fileName;
        Path path = Paths.get(filePath);
        Resource resource = null;
 
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
 
        if (resource.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
            // return new ResponseEntity<Object>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("File Not Found ", HttpStatus.OK);
        }
    }
    
   
    
    //method for uploading single file and downloading file
    @RequestMapping(value = "/upload/download/file", 
		    		method = RequestMethod.POST, 
		    		consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
		    		produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Object> uploadFile2(@RequestParam("fileName") MultipartFile fileName, HttpServletResponse response) {
 
        File uploadedFile = new File(baseFolderPath, fileName.getOriginalFilename());
 
        //uploading single file
        try {
            uploadedFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(fileName.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        //downloading single file
        String filePath = baseFolderPath + fileName.getOriginalFilename();
        Path path = Paths.get(filePath);
        Resource resource = null;
 
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
 
        if (resource.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
            // return new ResponseEntity<Object>("File Uplaoded succesfully", HttpStatus.OK);
            // return new ResponseEntity<Object>(resource, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("File Not Found ", HttpStatus.OK);
        }
    }
    
}