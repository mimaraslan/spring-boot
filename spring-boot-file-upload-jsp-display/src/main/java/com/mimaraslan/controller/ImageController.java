package com.mimaraslan.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ImageController {

	private static String baseFolderPath = System.getProperty("user.dir")+"/src/main/resources/static/";

	@Value("${index.message:test}")
	private String message = "Image Upload";

	@GetMapping("/")
	public String viewIndex(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

    @GetMapping("/upload")
    public String viewUpload() {
        return "upload";
    }

    @PostMapping("/upload") 
    public String viewFileUpload(@RequestParam("fileName") MultipartFile fileName,
                                   RedirectAttributes redirectAttributes) {

        if (fileName.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:upload";
        }

        try {
            byte[] fileBytes = fileName.getBytes();
            
            Path filePath = Paths.get(baseFolderPath + fileName.getOriginalFilename());
            Files.write(filePath, fileBytes);
            
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded");
			redirectAttributes.addFlashAttribute("imageName", fileName.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/upload";
    }

}