/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ast
 */
@Entity
public class Book implements Serializable {

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", author=" + author + ", genre=" + genre + ", publisher=" + publisher + ", name=" + name + ", content=" + content + ", pageCount=" + pageCount + ", isbn=" + isbn + ", publishYear=" + publishYear + ", image=" + image + ", descr=" + descr + ", rating=" + rating + ", voteCount=" + voteCount + ", viewDate=" + viewDate + ", addDate=" + addDate + '}';
    }

	@Id
	private Long id;
	@ManyToOne(targetEntity=Author.class)
	@JoinColumn(name="author_id")
	private Author author;
	@ManyToOne(targetEntity=Genre.class)
	@JoinColumn(name = "genre_id")
	private Genre genre;
	@ManyToOne(targetEntity=Publisher.class)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	private String name;
	private byte[] content;
	private int pageCount;
	private String isbn;
	private int publishYear;
	private byte[] image;
	private String descr;
	private Integer rating;
	private Long voteCount;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date viewDate;
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date addDate;
	
    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    public Book(Author author, Genre genre, Publisher publisher, String name, byte[] content, int pageCount, String isbn, int publishYear) {
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishYear = publishYear;
    }

    public Book(Long id, Author author, Genre genre, Publisher publisher, String name, int pageCount, String isbn, int publishYear, byte[] image, String descr, Integer rating, Long voteCount, Date viewDate, Date addDate) {
        this.id = id;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.rating = rating;
        this.voteCount = voteCount;
        this.viewDate = viewDate;
        this.addDate = addDate;
    }

    public Book(Author author, Genre genre, Publisher publisher, String name, byte[] content, int pageCount, String isbn, int publishYear, byte[] image, String descr, Integer rating, Long voteCount, Date viewDate, Date addDate) {
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.image = image;
        this.descr = descr;
        this.rating = rating;
        this.voteCount = voteCount;
        this.viewDate = viewDate;
        this.addDate = addDate;
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return this.publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Long getVoteCount() {
		return this.voteCount;
	}

	public void setVoteCount(Long voteCount) {
		this.voteCount = voteCount;
	}

	public Date getViewDate() {
		return this.viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}

