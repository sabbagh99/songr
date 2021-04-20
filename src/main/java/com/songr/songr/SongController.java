package com.songr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    RepositorySongr repositorySongr;

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        m.addAttribute("songs", songRepository.findAll());
        return "song.html";
    }

    @GetMapping("/addSong")
    public String getNewSong() {
        return "addSong.html";
    }

//    @PostMapping("/songs")
//    public RedirectView addSong(@RequestParam(value = "title") String title,
//                                @RequestParam(value = "trackNumber") int trackNumber,
//                                @RequestParam(value = "length") int length,
//                                @RequestParam(value = "album") Album album){
//        Song song = new Song(title, length, trackNumber, album);
//        songRepository.save(song);
//        return new RedirectView("/songs");
//    }
    @PostMapping("/songs")
    public ResponseEntity<Song> addStudent(String title, int trackNumber, int length,Integer albumId){
        Album album = repositorySongr.findById(albumId).get();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        return new ResponseEntity(song, HttpStatus.OK);
    }


    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSong(@PathVariable(value = "id") Integer id) {
        Song song = songRepository.findById(id).get();
        return new ResponseEntity(song, HttpStatus.OK);
    }

}
