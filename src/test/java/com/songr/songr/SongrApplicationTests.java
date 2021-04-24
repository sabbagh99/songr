package com.songr.songr;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {
	@Test
    public void testAlbum() {

		Album siaAlbum = new Album("This Is Acting", "Sia", 3, 1354, "https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg");
		controllerSongr controller = new controllerSongr();
        assertEquals("Album name='This Is Acting', Artist name ='Sia', songCount=3, length=1354", siaAlbum.toString());
        assertEquals("This Is Acting",siaAlbum.getTitle());
        assertEquals("Sia",siaAlbum.getArtist());
        assertEquals(3,siaAlbum.getSongCount());
        assertEquals(1354,siaAlbum.getLength());
        assertEquals("https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg",siaAlbum.getImageUrl());
        assertEquals("HELLO WORLD",controller.toUpperCase("hello world"));


        siaAlbum.setTitle("NO NAME");
		siaAlbum.setArtist("NO NAME");
		siaAlbum.setImageUrl("NO IMAGE");
		siaAlbum.setSongCount(0);
		siaAlbum.setLength(0);
		assertTrue(siaAlbum.getTitle() == "NO NAME");
		assertTrue(siaAlbum.getArtist() == "NO NAME");
		assertTrue(siaAlbum.getImageUrl() == "NO IMAGE");
		assertTrue(siaAlbum.getLength() == 0);
		assertTrue(siaAlbum.getSongCount() == 0);


	}

	@Autowired
	private SongController controller;

	@Test
	public void testSong() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHelloWorldPage () throws Exception {

		this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void  testAlbumPage() throws Exception {
		this.mockMvc.perform(get("/albums")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Album ID")));
	}

	@Test
	public void  testAddSong() throws Exception {
		this.mockMvc.perform(get("/addSong")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Song name")));
	}

//	@Test
//	public void  testSongPostReq() throws Exception {
//		this.mockMvc.perform(post("/songs")).andDo(print()).andExpect(status().isFound());
//	}
}
