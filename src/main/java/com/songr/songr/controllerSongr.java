package com.songr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class controllerSongr {

    @Autowired
    RepositorySongr repositorySongr;

    @GetMapping("/")
    public String splashPage() {
        return "splashPage.html";
    }

    @GetMapping("/hello")
    public String ShowHelloWorld(Model m) {
        return "helloWorld.html";
    }

    @GetMapping("/capitalize/{sentence}")
    public String capitalize(Model m, @PathVariable("sentence") String word) {
        m.addAttribute("sentence", toUpperCase(word));
        return "capitalize.html";
    }

    public String toUpperCase(String word) {
        return word.toUpperCase();
    }

    @GetMapping("/albums")
    public String getAlbums(Model m) {
        m.addAttribute("albums", repositorySongr.findAll());
        System.out.println(repositorySongr.findAll());
//        Album siaAlbum = new Album("This Is Acting", "Sia", 3, 1354, "https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg");
//        Album taylorAlbum = new Album("Red", "taylor swift", 16, 2880, "http://3.bp.blogspot.com/-DWhDa5J8KJ4/UGqSO-6_LLI/AAAAAAAABMk/p950ilISS5Y/s1600/Taylor%2BSwift%2BRED%2BSingle%2B%255B2012%255D.jpg");
//        Album billieAlbum = new Album("dont smile at me", "billie eilish", 9, 1620, "https://brennquenn.files.wordpress.com/2018/12/dont-long.jpg?w=720");
//        List<Album> albums = new ArrayList<>();
//        albums.add(siaAlbum);
//        albums.add(taylorAlbum);
//        albums.add(billieAlbum);
//        m.addAttribute("albums", albums);
        return "albums.html";

    }

    @GetMapping("/addAlbum")
    public String getNewAlbum() {
        return "addAlbums.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam(value = "title") String title,
                                 @RequestParam(value = "artist") String artist,
                                 @RequestParam(value = "songCount") int songCount,
                                 @RequestParam(value = "length") int length,
                                 @RequestParam(value = "imageUrl") String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        repositorySongr.save(album);
        return new RedirectView("/albums");

    }
}
