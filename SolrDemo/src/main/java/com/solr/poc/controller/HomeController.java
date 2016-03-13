package com.solr.poc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.solr.poc.model.SearchEngine;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws SolrServerException
	 * @throws IOException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException, SolrServerException {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Locale locale, Model model) throws IOException, SolrServerException {
	/*	SearchEngine searchEngine = new SearchEngine();
		List filters = new ArrayList();
		//QueryResponse response = searchEngine.search(filters);
		QueryResponse response = searchEngine.searchByKeyword("id:book~");
		SolrDocumentList results = response.getResults();
		
		model.addAttribute("result",results);*/
	//	System.out.println(results);
		return "search";
	}
	@RequestMapping(value = "/searchResult", method = RequestMethod.POST)
	public String searchByKeyword(HttpServletRequest request,Locale locale, Model model,@RequestParam("keyword") String keyword) throws IOException, SolrServerException {
		SearchEngine searchEngine = new SearchEngine();

		String distance = request.getParameter("distance");
		String fuzzySearch = request.getParameter("fuzzySearch");
		
		String FUZZY_SEARCH_CHAR = "~";
		
		keyword = "title:" + keyword;
		if(fuzzySearch != null){
				keyword += FUZZY_SEARCH_CHAR;
				keyword += distance;
		}
		
		QueryResponse response = searchEngine.searchByKeyword(keyword);
		SolrDocumentList results = response.getResults();
		model.addAttribute("keyword",keyword);
		model.addAttribute("result",results);
		
		
		return "search";
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
}
