package com.citiustech.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_album")
@NamedQuery(
		name = "albumsByReleaseYear",
		query = "select al from Album al where year(al.releaseDate) = :yr")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private LocalDate releaseDate;
	private String copyright;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Song> songs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
}
