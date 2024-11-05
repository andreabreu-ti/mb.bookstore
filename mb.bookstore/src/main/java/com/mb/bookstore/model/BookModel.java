package com.mb.bookstore.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true)
	private String title;

	
	/**
	 * @ManyToOne Definindo muitos livros para uma editora
	 * @JoinColumn Especificar qual que vai ser a chave estrangeira relacionado TB_BOOK
	 * Relacionamento bidirecional, deve ser realizado também na TB_PUBLISHER
	 */
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private PublisherModel publisher;

	public PublisherModel getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherModel publisher) {
		this.publisher = publisher;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
