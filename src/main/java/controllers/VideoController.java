package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Video;
import services.VideoService;

@RestController
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping(value = "/videos")  
	public List<Video> getVideos(){
		return videoService.getVideos();
	}
}
