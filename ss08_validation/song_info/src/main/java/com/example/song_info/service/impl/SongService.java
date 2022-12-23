package com.example.song_info.service.impl;

import com.example.song_info.model.Song;
import com.example.song_info.repository.ISongRepository;
import com.example.song_info.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Page<Song> findALl(Pageable pageable) {
        return iSongRepository.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }
}
