package com.selamino.tvseries.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selamino.tvseries.model.FilmResponse;
import com.selamino.tvseries.model.TvSeries;
import com.selamino.tvseries.repository.TvSeriesDAO;



@Service
public class TvSeriesService {
	
	@Autowired 
	public TvSeriesDAO tvSeriesDAO;
	
	
	
	

	/*public Object getTvSeriesList() {
		
		FilmResponse filmResponse = new FilmResponse();
		int x = 0;
		try{
			Map<String, Object> response = new HashMap<>();
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> tvSeriesList = new HashMap<>();
			tvSeriesList = tvSeriesDAO.getTvSeriesList();	
		
		if(tvSeriesList.size() > 0){
			
			filmResponse.setSuccess(true);
			dataList.put("gridData", dataList1);
			dataList1.put("exists", daoResponse);
			list.add(dataList);
			filmResponse.put("data", filmResponse);
			filmResponse.setFilm(response);
		}else{
			filmResponse.setSuccess(false);
			filmResponse.setErrorCode("Something went wrong");
		}
	}catch(Exception exp){
		System.out.println(exp);
		filmResponse.setSuccess(false);
		filmResponse.setErrorCode("Something went wrong");
		}
			
		return null;
	}*/
	
public Object getTvSeriesList() {
		
		
			
			List<TvSeries> list = new ArrayList<>();
			
			list = tvSeriesDAO.getTvSeriesList();	
			
		
			
		return list;
	}

/* public Object getEpisodesList(String data) {
	FilmResponse filmResponse = new FilmResponse();
	try{
	JSONObject filObj = new JSONObject(data);
	int tvSeriesId = filObj.getInt("tvSeriesId");
	System.out.println(tvSeriesId+" kkkkkkkk");
	
	Map<String, Object> response = new HashMap<>();
	List<Map<String, Object>> list = new ArrayList<>();
	Map<String, Object> dataList = new HashMap<>();
	//Map<String, Object> dataList1 = new HashMap<>();
	dataList = tvSeriesDAO.getEpisodesList(tvSeriesId);
	if(dataList.size()>0){
		filmResponse.setSuccess(true);
		/*dataList.put("gridData", dataList1);
		dataList1.put("exists", daoResponse);
		list.add(dataList);
		response.put("data", list);
		filmResponse.setFilm(response);
	}else{
		filmResponse.setSuccess(false);
		filmResponse.setErrorCode("Something went wrong");
	}
}catch(Exception exp){
	System.out.println(exp);
	filmResponse.setSuccess(false);
	filmResponse.setErrorCode("Something went wrong");
	}
	
	
	return filmResponse;
}*/


public Object getMEpisodesList(String data) {
	FilmResponse filmResponse = new FilmResponse();
	Map<String, Object> response = new HashMap<>();
	Map<String, Object> dataList = new HashMap<String, Object>();
	try{
	JSONObject filObj = new JSONObject(data);
	int tvSeriesId = filObj.getInt("tvSeriesId");
	System.out.println(tvSeriesId+" kkkkkkkk");
	
	//Map<String, Object> response = new HashMap<>();
	List<Map<String, Object>> list = new ArrayList<>();
	
	//Map<String, Object> dataList1 = new HashMap<>();
	dataList = tvSeriesDAO.getEpisodesList(tvSeriesId);
	if(dataList.size()>0){
		filmResponse.setSuccess(true);
		/*dataList.put("gridData", dataList1);
		dataList1.put("exists", daoResponse);*/
		//list.add(dataList);
		response.put("data", dataList);
		filmResponse.setFilm(response);
	}else{
		filmResponse.setSuccess(false);
		filmResponse.setErrorCode("Something went wrong");
	}
}catch(Exception exp){
	System.out.println(exp);
	filmResponse.setSuccess(false);
	filmResponse.setErrorCode("Something went wrong");
	}
	
	
	return dataList;
}

}
