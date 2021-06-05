package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.UserLibrary;

public interface UserLibraryRepository extends JpaRepository<UserLibrary, Integer> {

}
