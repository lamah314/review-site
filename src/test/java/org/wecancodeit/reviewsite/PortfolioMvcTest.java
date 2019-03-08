package org.wecancodeit.reviewsite;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewsite.controllers.PortfolioController;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(PortfolioController.class)
public class PortfolioMvcTest {
	 
	    @Resource
	    private MockMvc mvc;
	 
	    @MockBean
	    private PortfoliosRepository portfolioRepo;
	 
	    @MockBean
	    private ReviewsRepository reviewRepo;
	 
	    @MockBean
	    private ReviewTagsRepository reviewTagsRepo;
	 
	    @Mock
	    private Portfolio portfolio;
	    
	    @Test
	    public void shouldRouteToIndiviualPortfolioView() throws Exception {
	        Long portfolioId = 1L;
	        when(portfolioRepo.findById(portfolioId)).thenReturn(Optional.of(portfolio));
	        mvc.perform(get("/portfolios/1")).andExpect(view().name(is("portfolios/individualPortfolio")));
	    }
	     
//	    @Test
//	    public void shouldBeOkForIndividualPortfolio() throws Exception {
//	    	Long portfolioId = 1L;
//	    	when(portfolioRepo.findById(portfolioId)).thenReturn(Optional.of(portfolio));
//	    	mvc.perform(get("/portfolios/1")).andExpect(status().isOk());
//	    }
//	     
//	    @Test
//	    public void shouldPutSinglePortfolioIntoModel() throws Exception {
//	    	Long portfolioId = 1L;
//	        when(portfolioRepo.findById(portfolioId)).thenReturn(Optional.of(portfolio));
//	        mvc.perform(get("/portfolios/1")).andExpect(model().attribute("Portfolio", is(portfolio)));
//	    }
}
