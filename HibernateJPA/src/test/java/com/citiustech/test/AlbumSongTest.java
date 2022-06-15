package com.citiustech.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.AlbumSongDao;
import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Album;
import com.citiustech.entity.Song;

public class AlbumSongTest {

	@Test
	public void addingAnAlbum() {
		Album alb = new Album();
		alb.setName("Hits of 2021");
		alb.setReleaseDate(LocalDate.of(2021, 12, 10));
		alb.setCopyright("Sony Music");
		
		GenericDao dao = new GenericDao();
		dao.save(alb);
	}
	
	@Test
	public void addingSongToAnAlbum() {
		GenericDao dao = new GenericDao();
		Album alb = dao.findById(Album.class, 1);
		
		Song s = new Song();
		s.setTitle("Good 4 U");
		s.setArtist("Olivia Rodrigo");
		s.setDuration(3.45);
		s.setAlbum(alb);
		dao.save(s);
	}
	
	@Test
	public void addAlbumAlongWithSongs() {
		GenericDao dao = new GenericDao();
		
		Album album = new Album();
		album.setName("Hits of 2020");
		album.setReleaseDate(LocalDate.of(2020, 12, 15));
		album.setCopyright("Amazon Music");
				
		Song s1 = new Song();
		s1.setTitle("The Box");
		s1.setArtist("Roddy Rich");
		s1.setDuration(3.30);
		s1.setAlbum(album);
		
		Song s2 = new Song();
		s2.setTitle("Shivers");
		s2.setArtist("Ed Sheeran");
		s2.setDuration(4.30);
		s2.setAlbum(album);
		
		List<Song> songs = new ArrayList<>();
		songs.add(s1);
		songs.add(s2);
		album.setSongs(songs);
		
		dao.save(album);
	}
	
	@Test
	public void fetchSongsByCopyright() {
		AlbumSongDao dao = new AlbumSongDao();
		List<Song> songs = dao.findSongsByCopyright("Sony Music");
		songs.forEach(System.out::println);
	}

	@Test
	public void fetchSongsInfo() {
		AlbumSongDao dao = new AlbumSongDao();
		List<Object[]> songs = dao.findAllSongsInfo();
		songs.forEach(arr -> System.out.println(Arrays.toString(arr)));
	}
}
