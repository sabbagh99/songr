package com.songr.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class helloWorld {

    @GetMapping("/")
    public String splashPage(){
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
public String getAlbums(Model m){
        Album siaAlbum = new Album("This Is Acting","Sia",3,1354,"https://www.colendri.lt/media/EshopProducts/150/Sia-This-Is-Acting-CD.jpg");
        Album taylorAlbum = new Album("Red","taylor swift",16,2880,"http://3.bp.blogspot.com/-DWhDa5J8KJ4/UGqSO-6_LLI/AAAAAAAABMk/p950ilISS5Y/s1600/Taylor%2BSwift%2BRED%2BSingle%2B%255B2012%255D.jpg");
        Album billieAlbum = new Album("dont smile at me","billie eilish",9,1620,"https://brennquenn.files.wordpress.com/2018/12/dont-long.jpg?w=720");
        List <Album> albums = new ArrayList<>();
        albums.add(siaAlbum);
        albums.add(taylorAlbum);
        albums.add(billieAlbum);
        m.addAttribute("albums",albums);
        return "albums.html";

    }
}
