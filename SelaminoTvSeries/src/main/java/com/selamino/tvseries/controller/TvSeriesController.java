package com.selamino.tvseries.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.selamino.tvseries.service.TvSeriesService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest")
public class TvSeriesController {
	
	
		
		@Autowired
		private TvSeriesService TvService;
		
		
		
		
		/*@RequestMapping(value="/getMovieList", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Object getMovieList(HttpServletRequest request){
			System.out.println("www");
			//String token = request.getHeader("Authorization").substring(7);
			//System.out.println(token);
			
			return movieService.getMovieList();
			
		}*/
		
		@RequestMapping(value="/getTvSeriesList", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Object getTvSeriesList(HttpServletRequest request){
			//String token = request.getHeader("Authorization").substring(7);
			System.out.println(request.getContentType());
			
			return TvService.getTvSeriesList();
			
		}
		
		@RequestMapping(value="/getEpisodesList", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody Object getMEpisodesList(@RequestBody String data){
			
			return TvService.getMEpisodesList(data);
			
		}
		
		
		
		
		
}

