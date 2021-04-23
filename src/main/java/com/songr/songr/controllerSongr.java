package com.songr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
        return "albums.html";

    }


    @GetMapping("/addAlbum")
    public String getNewAlbum() {
        return "addAlbums.html";
    }

//    @PostMapping("/albums")
//    public RedirectView addAlbum(@RequestParam(value = "title") String title,
//                                 @RequestParam(value = "artist") String artist,
//                                 @RequestParam(value = "songCount") int songCount,
//                                 @RequestParam(value = "length") int length,
//                                 @RequestParam(value = "imageUrl") String imageUrl) {
//        Album album = new Album(title, artist, songCount, length, imageUrl);
////        List<Song> song = (List<Song>) songRepository.findAll();
////        System.out.println(song);
////
////        Album album = new Album(title, artist, songCount, length, imageUrl,song);
//
//
//        repositorySongr.save(album);
//        return new RedirectView("/albums");
//
//    }

    @PostMapping("/albums")
    public ResponseEntity<Album> addStudent(String title, String artist,int songCount,int length,String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        repositorySongr.save(album);
        return new ResponseEntity(album, HttpStatus.OK);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable(value = "id") Integer id) {
        Album album = repositorySongr.findById(id).get();
        return new ResponseEntity(album, HttpStatus.OK);
    }


}
