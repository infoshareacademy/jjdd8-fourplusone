package com.infoshareacademy;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExternalBook {


//   public static List<ExternalBook> getExternalBooks() {
//    return ExternalBook.externalBooks;
//}
 public static List<ExternalBook> externalBooks;



    @JsonProperty("has_audio")
    private boolean hasAudio;
    private String kind;
    private String author;
    private String epoch;
    private String title;
    private String url;
    @JsonProperty("cover_color")
    private String coverColor;
    private String liked;
    @JsonProperty("cover_thumb")
    private String coverThumb;
    private String cover;
    private String genre;
    @JsonProperty("full_sort_key")
    private String fullSortKey;
    private String href;
    @JsonProperty("simple_thumb")
    private String simpleThumb;
    private String slug;


    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public boolean getHasAudio() {
        return hasAudio;
    }

    public void setHasAudio(boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCoverColor() {
        return coverColor;
    }

    public void setCoverColor(String coverColor) {
        this.coverColor = coverColor;
    }

    public String getCoverThumb() {
        return coverThumb;
    }

    public void setCoverThumb(String coverThumb) {
        this.coverThumb = coverThumb;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFullSortKey() {
        return fullSortKey;
    }

    public void setFullSortKey(String fullSortKey) {
        this.fullSortKey = fullSortKey;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSimpleThumb() {
        return simpleThumb;
    }

    public void setSimpleThumb(String simpleThumb) {
        this.simpleThumb = simpleThumb;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
return " Title: "+title ;   }
}


