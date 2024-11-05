package com.mb.bookstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false, unique = true)
	private String name;

	/**
	 * @JsonProperty = Access.WRITE_ONLY =
	 * @OneToMany = Definir que uma editora pode ter vários livros 
	 * Set<BookModel> =
	 *            Poderia ser utilizado Lista, porém quando trabalhado com vários
	 *            relacionamentos, dentro de uma mesma entidade pode ter problemas
	 *            com o list.
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
	private Set<BookModel> books = new HashSet<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
