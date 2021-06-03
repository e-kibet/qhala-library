package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}
