package com.khanhhq.learning.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoadImageController {
	@Value("${image-path}")
	private String IMAGE_PATH;

	@RequestMapping(value = "load_image/{image_name}")
	public void loadImage(HttpServletResponse response, @PathVariable("image_name") String imageName)
			throws IOException {
		File imageFile = new File(IMAGE_PATH + imageName);
		response.setHeader("Content-Length", String.valueOf(imageFile.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + imageFile.getName() + "\"");

		Files.copy(imageFile.toPath(), response.getOutputStream());
	}
}
