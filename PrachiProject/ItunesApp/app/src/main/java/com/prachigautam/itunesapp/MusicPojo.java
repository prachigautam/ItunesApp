package com.prachigautam.itunesapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amar on 01-08-2017.
 */

public class MusicPojo implements Serializable {

    int resultCount;
    List<Results> results;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results implements Serializable {

        @SerializedName("wrapperType")
        private String wrapperType;

        @SerializedName("kind")
        private String kind;
        @SerializedName("artistId")

        private Integer artistId;
        @SerializedName("collectionId")
        private Integer collectionId;
        @SerializedName("trackId")
        private Integer trackId;
        @SerializedName("artistName")
        private String artistName;
        @SerializedName("collectionName")
        private String collectionName;
        @SerializedName("trackName")
        private String trackName;
        @SerializedName("collectionCensoredName")
        private String collectionCensoredName;
        @SerializedName("trackCensoredName")
        private String trackCensoredName;
        @SerializedName("artistViewUrl")
        private String artistViewUrl;
        @SerializedName("collectionViewUrl")
        private String collectionViewUrl;
        @SerializedName("trackViewUrl")
        private String trackViewUrl;
        @SerializedName("previewUrl")
        private String previewUrl;
        @SerializedName("artworkUrl30")
        private String artworkUrl30;
        @SerializedName("artworkUrl60")
        private String artworkUrl60;
        @SerializedName("artworkUrl100")
        private String artworkUrl100;
        @SerializedName("collectionPrice")
        private Double collectionPrice;
        @SerializedName("trackPrice")
        private Double trackPrice;
        @SerializedName("releaseDate")
        private String releaseDate;
        @SerializedName("collectionExplicitness")
        private String collectionExplicitness;
        @SerializedName("trackExplicitness")
        private String trackExplicitness;
        @SerializedName("discCount")
        private Integer discCount;
        @SerializedName("discNumber")
        private Integer discNumber;
        @SerializedName("trackCount")
        private Integer trackCount;
        @SerializedName("trackNumber")
        private Integer trackNumber;
        @SerializedName("trackTimeMillis")
        private Integer trackTimeMillis;
        @SerializedName("country")
        private String country;
        @SerializedName("currency")
        private String currency;
        @SerializedName("primaryGenreName")
        private String primaryGenreName;
        @SerializedName("isStreamable")
        private Boolean isStreamable;


        public String getWrapperType() {
            return wrapperType;
        }

        public void setWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }

        public Integer getArtistId() {
            return artistId;
        }

        public void setArtistId(Integer artistId) {
            this.artistId = artistId;
        }

        public Integer getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(Integer collectionId) {
            this.collectionId = collectionId;
        }

        public Integer getTrackId() {
            return trackId;
        }

        public void setTrackId(Integer trackId) {
            this.trackId = trackId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getCollectionName() {
            return collectionName;
        }

        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public String getCollectionCensoredName() {
            return collectionCensoredName;
        }

        public void setCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
        }

        public String getTrackCensoredName() {
            return trackCensoredName;
        }

        public void setTrackCensoredName(String trackCensoredName) {
            this.trackCensoredName = trackCensoredName;
        }

        public String getArtistViewUrl() {
            return artistViewUrl;
        }

        public void setArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
        }

        public String getCollectionViewUrl() {
            return collectionViewUrl;
        }

        public void setCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
        }

        public String getTrackViewUrl() {
            return trackViewUrl;
        }

        public void setTrackViewUrl(String trackViewUrl) {
            this.trackViewUrl = trackViewUrl;
        }

        public String getPreviewUrl() {
            return previewUrl;
        }

        public void setPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
        }

        public String getArtworkUrl30() {
            return artworkUrl30;
        }

        public void setArtworkUrl30(String artworkUrl30) {
            this.artworkUrl30 = artworkUrl30;
        }

        public String getArtworkUrl60() {
            return artworkUrl60;
        }

        public void setArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
        }

        public String getArtworkUrl100() {
            return artworkUrl100;
        }

        public void setArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
        }

        public Double getCollectionPrice() {
            return collectionPrice;
        }

        public void setCollectionPrice(Double collectionPrice) {
            this.collectionPrice = collectionPrice;
        }

        public Double getTrackPrice() {
            return trackPrice;
        }

        public void setTrackPrice(Double trackPrice) {
            this.trackPrice = trackPrice;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getCollectionExplicitness() {
            return collectionExplicitness;
        }

        public void setCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
        }

        public String getTrackExplicitness() {
            return trackExplicitness;
        }

        public void setTrackExplicitness(String trackExplicitness) {
            this.trackExplicitness = trackExplicitness;
        }

        public Integer getDiscCount() {
            return discCount;
        }

        public void setDiscCount(Integer discCount) {
            this.discCount = discCount;
        }

        public Integer getDiscNumber() {
            return discNumber;
        }

        public void setDiscNumber(Integer discNumber) {
            this.discNumber = discNumber;
        }

        public Integer getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(Integer trackCount) {
            this.trackCount = trackCount;
        }

        public Integer getTrackNumber() {
            return trackNumber;
        }

        public void setTrackNumber(Integer trackNumber) {
            this.trackNumber = trackNumber;
        }

        public Integer getTrackTimeMillis() {
            return trackTimeMillis;
        }

        public void setTrackTimeMillis(Integer trackTimeMillis) {
            this.trackTimeMillis = trackTimeMillis;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getPrimaryGenreName() {
            return primaryGenreName;
        }

        public void setPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
        }

        public Boolean getStreamable() {
            return isStreamable;
        }

        public void setStreamable(Boolean streamable) {
            isStreamable = streamable;
        }
    }

}
