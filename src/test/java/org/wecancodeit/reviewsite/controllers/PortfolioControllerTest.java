package org.wecancodeit.reviewsite.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;

public class PortfolioControllerTest {

	@InjectMocks
	private PortfolioController underTest;

	@Mock
	private PortfoliosRepository portfolioRepo;

	@Mock
	private Portfolio portfolio;

	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddPortfolioToModel() throws Exception {
		Long portfolioId = 1L;
		when(portfolioRepo.findById(portfolioId)).thenReturn(Optional.of(portfolio));

		underTest.getPortfolio(portfolioId, model);

		verify(model).addAttribute("Portfolio", portfolio);
	}

}
