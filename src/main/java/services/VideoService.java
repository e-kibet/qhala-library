package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import models.Video;
import repositories.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	
	public List<Video> getVideos(){
		return (List<Video>) videoRepository.findAll();
	}
	
	public void saveVideo(Video video) {
		videoRepository.save(video);
	}
	
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid book with id %s", id)));
    }
    
    public void deleteVideoById(Integer id) {
    	videoRepository.deleteById(id);
    }
	
	
}
