package ru.spec.javaee.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;


/**
 * The persistent class for the Option database table.
 * 
 */
@Entity
@Table(name="`Option`")
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, name="id")
	private Long id;

	
	private Timestamp created;

	private Timestamp deleted;

	private Timestamp done;

	@Column(nullable=false, length=1024)
	private String text;

	//bi-directional many-to-one association to CheckList
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="checkListId", nullable=false)
	private CheckList checkList;

	public Option() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Timestamp deleted) {
		this.deleted = deleted;
	}

	public Timestamp getDone() {
		return this.done;
	}

	public void setDone(Timestamp done) {
		this.done = done;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public CheckList getCheckList() {
		return this.checkList;
	}

	public void setCheckList(CheckList checkList) {
		this.checkList = checkList;
	}

}