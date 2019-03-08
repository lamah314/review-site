package org.wecancodeit.reviewsite.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

public class ReviewTagControllerTest {

	@InjectMocks
	private ReviewTagController underTest;

	@Mock
	private ReviewsRepository reviewRepo;

	@Mock
	private Review review;

	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddReviewToModel() {
		Long reviewId = 1L;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));

		underTest.getReview(model, reviewId);

		verify(model).addAttribute("Review", review);
	}
}
