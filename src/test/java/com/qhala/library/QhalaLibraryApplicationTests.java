package com.qhala.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith( SpringExtension.class)
@AutoConfigureMockMvc
class QhalaLibraryApplicationTests {

	@Test
	void contextLoads() {
	}
	
	 @Autowired
	 private MockMvc mockMvc;
	 
	    @Test
	    public void addsNewUser() throws Exception {
	        String newRide = "{\"first_name\":\"Monorail\",\"last_name\":\"AMos.\",\"email\":\"testcase@user.com\",\"msisdn\":25470090900,\"password\":\"1234\"}";
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(newRide)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andReturn();
	    }

}
