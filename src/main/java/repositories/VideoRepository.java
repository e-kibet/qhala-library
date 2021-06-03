package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, Integer> {

}
