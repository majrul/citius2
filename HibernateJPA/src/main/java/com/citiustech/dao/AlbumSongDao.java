package com.citiustech.dao;

import java.util.List;

import com.citiustech.entity.Album;
import com.citiustech.entity.Customer;
import com.citiustech.entity.Song;

public class AlbumSongDao extends GenericDao {

	public List<Album> findAlbumsByReleaseYear(int year) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select al from Album al where year(al.releaseDate) = :yr", Album.class)
				.setParameter("yr", year)
				.getResultList();		
	}
	
	public List<Song> findSongsByArtist(String artist) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select s from Song s where s.artist = :at", Song.class)
				.setParameter("at", artist)
				.getResultList();
	}
	
	//fetch all the albums in which Arijit Singh has sung a song
	public List<Album> findAlbumsByArtist(String artist) {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select a from Album a join a.songs s where s.artist = :at", Album.class)
				.setParameter("at", artist)
				.getResultList();		
	}
	
	//fetch all the songs copyrighted by Sony Music
	public List<Song> findSongsByCopyright(String copyright) {
		return entityManagerFactory
				.createEntityManager()
				//.createQuery("select s from Song s join s.album a where a.copyright = :copy", Song.class)
				.createQuery("select s from Song s where s.album.copyright = :copy", Song.class)
				.setParameter("copy", copyright)
				.getResultList();		
	}
	
	public List<Object[]> findAllSongsInfo() {
		return entityManagerFactory
				.createEntityManager()
				.createQuery("select s.title, s.artist, a.name from Song s join s.album a", Object[].class)
				.getResultList();
	}
}
