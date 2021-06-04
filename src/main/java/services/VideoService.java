package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Book;
import models.Video;
import repositories.BookRepository;
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
        return videoRepository.findById(id).get();
    }
    
    public void deleteVideoById(Integer id) {
    	videoRepository.deleteById(id);
    }
	
	
}
