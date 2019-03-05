package org.wecancodeit.reviewsite.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ReviewTag {
	@Id
	@GeneratedValue
	private Long id;
	private String tagName;


	@ManyToMany(mappedBy="reviewTags")
//	@JoinTable(name="review_ReviewTags", @JoinColumn())
	private Collection<Review> reviews;

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public ReviewTag() {}
	
	public ReviewTag(String tagName) {
		this.tagName = tagName;
	}

	public ReviewTag(String tagName, Review ...reviews) {
		this.tagName = tagName;
		this.reviews = Arrays.asList(reviews);
	}

	public void addReviewtoReviewTag(Review review) {
		reviews.add(review);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewTag other = (ReviewTag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReviewTags [id=" + id + ", tagName=" + tagName + "]";
	}

}
