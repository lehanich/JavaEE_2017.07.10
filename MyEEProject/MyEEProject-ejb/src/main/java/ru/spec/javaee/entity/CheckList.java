package ru.spec.javaee.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the CheckList database table.
 * 
 */
@Entity
@Table(name = "`CheckList`")
@NamedQuery(name = "CheckList.findAll", query = "SELECT c FROM CheckList c")
public class CheckList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "`text`", nullable = false, length = 1024)
	private String text;

	// @Column(name="`desc`",nullable=true, length=4096)
	// private String desc;

	// bi-directional many-to-one association to Option
	@OneToMany(mappedBy = "checkList", cascade = { CascadeType.ALL })
	private List<Option> options;

	public CheckList() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Option> getOptions() {
		return this.options == null ? 
				(this.options = new ArrayList<>()) : this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setCheckList(this);

		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setCheckList(null);

		return option;
	}

}