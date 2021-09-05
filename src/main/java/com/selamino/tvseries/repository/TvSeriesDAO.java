package com.selamino.tvseries.repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.selamino.tvseries.model.TvSeries;
import com.selamino.tvseries.util.HelperClass;



@Repository
public class TvSeriesDAO {
	
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	    private HelperClass helper;
	 
	 private static final Logger LOG = LoggerFactory.getLogger(TvSeriesDAO.class);

	public List<TvSeries> getTvSeriesList() {
		String sql = "SELECT * from tvseries";
		List<TvSeries> list = (List<TvSeries>) jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<TvSeries>(TvSeries.class)) ;
		LOG.info("list of tv series returned are: "+ list.size());
		return list;
	}
	
	public Map<String, Object> getEpisodesList(int tvSeriesId){
		Map<String, Object> result = new HashMap<>();
		ArrayList<HashMap<String, Object>> griddata = new ArrayList<HashMap<String, Object>>();
		Object[] queryParams = new Object[] {tvSeriesId};
		int maxSeasonNumber = 0;
		String sqlMax = "select max(seasonNumber) from tvseriesseason where tvseriesId = ?";
		maxSeasonNumber = jdbcTemplate.queryForObject(sqlMax, new Object[]{tvSeriesId}, Integer.class);
		System.out.println("maxSeasonNumber "+maxSeasonNumber);
		String sql = "select s.seasonNumber, ep.episodeId, ep.title, ep.profile_image, group_concat(tg.gener SEPARATOR ', ')AS gener, ep.episodeNumber, ep.cover_image, ep.videoLink, ep.description, ep.price "
				+ "FROM tvseries tv "
				+ "join tvseriesseason s ON tv.tvseriesId = s.tvseriesId "
				+ "join episode ep ON ep.seasonId = s.seasonId "
				+ "join episodegenre tg ON ep.episodeId = tg.episodeId "
				+ "where tv.tvseriesId = ? group by ep.title, s.seasonNumber, ep.profile_image, ep.episodeNumber, ep.cover_image, ep.videoLink, ep.description, ep.episodeId, ep.price "
				+ "order by  ep.episodeNumber";
		/*String sql = "select tv.tvseriesId, tv.mainTitle, s.seasonNumber, ep.title, ep.profile_image, ep.prod_year, 
group_concat(tg.gener SEPARATOR ', ')AS gener, ep.episodeNumber, ep.cover_image, ep.description
FROM selamino.tvseries tv 
join selamino.tvseriesseason s ON tv.tvseriesId = s.tvseriesId 
join selamino.episode ep ON ep.seasonId = s.seasonId 
join selamino.episodegenre tg ON ep.episodeId = tg.episodeId 
where tv.tvseriesId = '101'
group by ep.title, s.seasonNumber, ep.profile_image, ep.prod_year, ep.episodeNumber, ep.cover_image, ep.description;; */
		 //order by episodeNumber
		//List<String> modelList = ;
		
		//result.put("gridModel", helper.getData(sql, queryParams));
		griddata = helper.getData(sql, queryParams);
		result.put("maxSeas", maxSeasonNumber);
		result.put("data", griddata);
		//System.out.println(result.toString());
		//System.out.println(result.);
		return result;
	}
	
	
	

}
