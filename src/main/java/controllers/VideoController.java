package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Book;
import models.Video;
import responses.ApiResponse;
import services.VideoService;

@RestController
@RequestMapping("/api/v1")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	@Autowired
	private ApiResponse apiResponse;
	
	@PostMapping("/videos")
	public HashMap<String, Object> createBook(@Valid @RequestBody  Video video) {
		videoService.saveVideo(video);
		return apiResponse.apiResponse(true, 200, "Book has been created");
	}
	
	@GetMapping(value = "/videos")  
	public List<Video> getVideos(){
		return videoService.getVideos();
	}
	
	@GetMapping("/videos/{id}")
	public ResponseEntity<Video> getVideoByID(@PathVariable Integer id) {
	    try {
	    	Video video = videoService.getVideoById(id);
	        return new ResponseEntity<Video>(video, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/videos/{id}")
	public HashMap<String, Object>  deleteVideoByID(@PathVariable Integer id) {
		videoService.deleteVideoById(id);
		return apiResponse.apiResponse(true, 200, "Book has been deleted successfully");
		
	}
	
}
