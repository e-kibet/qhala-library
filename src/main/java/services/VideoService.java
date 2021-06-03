package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Video;
import repositories.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	
	public List<Video> getVideos(){
		return (List<Video>) videoRepository.findAll();
	}
	
	
}
