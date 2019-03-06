package org.wecancodeit.reviewsite;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import org.wecancodeit.reviewsite.controllers.ReviewTagController;
import org.wecancodeit.reviewsite.models.ReviewTag;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewTagController.class)
public class ReviewTagMvcTest {

	@Resource
    private MockMvc mvc;
 
    @MockBean
    private ReviewTagsRepository reviewTagRepo;
 
    @Mock
    private ReviewTag reviewTag;
    
    @Test
    public void shouldRouteToIndiviualReviewTagView() throws Exception {
        Long reviewTagId = 1L;
        when(reviewTagRepo.findById(reviewTagId)).thenReturn(Optional.of(reviewTag));
        mvc.perform(get("/reviewTags/1")).andExpect(view().name(is("reviewTags/individualReviewTag")));
    }
     
    @Test
    public void shouldBeOkForIndividualReviewTag() throws Exception {
    	Long reviewTagId = 1L;
    	when(reviewTagRepo.findById(reviewTagId)).thenReturn(Optional.of(reviewTag));
    	mvc.perform(get("/reviewTags/1")).andExpect(status().isOk());
    }
     
    @Test
    public void shouldPutSingleReviewTagIntoModel() throws Exception {
    	Long reviewTagId = 1L;
        when(reviewTagRepo.findById(reviewTagId)).thenReturn(Optional.of(reviewTag));
     
        mvc.perform(get("/reviewTags/1")).andExpect(model().attribute("ReviewTag", is(reviewTag)));
    }
}
