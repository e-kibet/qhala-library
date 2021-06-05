package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Book;
import models.UserLibrary;
import repositories.UserLibraryRepository;

@Service
public class UserLibraryService {
	
	@Autowired
	private UserLibraryRepository userLibraryRepository;

	public void saveUserLibrary(UserLibrary userLibrary) {
		userLibraryRepository.save(userLibrary);
}

}