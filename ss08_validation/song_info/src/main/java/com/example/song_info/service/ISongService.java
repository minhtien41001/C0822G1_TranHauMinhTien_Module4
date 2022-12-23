package com.example.song_info.service;

import com.example.song_info.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {

    Page<Song> findALl(Pageable pageable);

    void save(Song song);
}
