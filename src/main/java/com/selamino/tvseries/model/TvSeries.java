package com.selamino.tvseries.model;

import java.io.Serializable;
import java.sql.Date;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;


@Entity
@Table(name = "tvseries")
public class TvSeries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("tvSeriesId")
    private int tvSeriesId;
    @SerializedName("mainTitle")
    private String mainTitle;
    @SerializedName("firstProdYear")
    private int firstProdYear;
    @SerializedName("gener")
    private String gener;
    @SerializedName("movieStory")
    private String movieStory;
    @SerializedName("coverImage")
    private String coverImage;
    @SerializedName("profileImage")
    private String profileImage;
    @SerializedName("description")
    private String description;
    @SerializedName("videoLink")
    private String videoLink;
    @SerializedName("directors")
    private String directors;
    @SerializedName("writer")
    private String writer;
    @SerializedName("actors")
    private String actors;

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getTvSeriesId() {
        return tvSeriesId;
    }

    public void setTvSeriesId(int tvSeriesId) {
        this.tvSeriesId = tvSeriesId;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public int getFirstProdYear() {
        return firstProdYear;
    }

    public void setFirstProdYear(int firstProdYear) {
        this.firstProdYear = firstProdYear;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getMovieStory() {
        return movieStory;
    }

    public void setMovieStory(String movieStory) {
        this.movieStory = movieStory;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "TvSeries{" +
                "tvSeriesId=" + tvSeriesId +
                ", mainTitle='" + mainTitle + '\'' +
                ", firstProdYear=" + firstProdYear +
                ", gener='" + gener + '\'' +
                ", movieStory='" + movieStory + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", description='" + description + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", directors='" + directors + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }
}
