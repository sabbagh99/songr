package com.songr.songr;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SongrApplicationTests {
	@Test
    public void testAlbum() {
		Album siaAlbum = new Album("This Is Acting", "Sia", 3, 1354, "https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg");
		helloWorld hello = new helloWorld();
        assertEquals("Album{title='This Is Acting', artist='Sia', songCount=3, length=1354, imageUrl='https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg'}", siaAlbum.toString());
        assertEquals("This Is Acting",siaAlbum.getTitle());
        assertEquals("Sia",siaAlbum.getArtist());
        assertEquals(3,siaAlbum.getSongCount());
        assertEquals(1354,siaAlbum.getLength());
        assertEquals("https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg",siaAlbum.getImageUrl());
        assertEquals("HELLO WORLD",hello.toUpperCase("hello world"));
        
        
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

}
