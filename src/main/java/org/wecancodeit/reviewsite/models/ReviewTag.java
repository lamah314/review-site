package org.wecancodeit.reviewsite.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ReviewTag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tagName;

	@ManyToMany(mappedBy = "reviewTags")
	private Set<Review> reviews = new HashSet<>();

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public ReviewTag() {}
	
	public ReviewTag(String tagName) {
		this.tagName = tagName;
		
	}

	public ReviewTag(String tagName, Set<Review> reviews) {
		this.tagName = tagName;
		this.reviews = reviews;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "ReviewTags [id=" + id + ", tagName=" + tagName + "]";
	}

}
