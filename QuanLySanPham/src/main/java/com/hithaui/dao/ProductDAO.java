package com.hithaui.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products")
public class ProductDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;

	@Nationalized
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "image_link", nullable = false)
	private String imageLink;

	@Nationalized
	@Column(name = "description", nullable = false, length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryDAO categoryDAO;

	@Nationalized
	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "price", nullable = false)
	private Integer price;

	@Column(name = "numberOfPage", nullable = false)
	private Integer numberOfPage;

	@CreationTimestamp
	private Timestamp createAt;

	@UpdateTimestamp
	private Timestamp updateAt;

	public ProductDAO() {
	}

	public ProductDAO(Integer id, String title, String imageLink, String description, CategoryDAO categoryDAO,
			String author, Integer price, Integer numberOfPage, Timestamp createAt, Timestamp updateAt) {
		super();
		this.id = id;
		this.title = title;
		this.imageLink = imageLink;
		this.description = description;
		this.categoryDAO = categoryDAO;
		this.author = author;
		this.price = price;
		this.numberOfPage = numberOfPage;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(Integer numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
}
