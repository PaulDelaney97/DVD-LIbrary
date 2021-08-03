package com.pauldelaney.dvdlibrary.dto;

/**
 *
 * @author pauldelaney
 */
public class Dvd {

    // declare variables
    String title;
    String releaseDate;
    String mpaaRating;
    String directorName;
    String studio;
    String userNote;

    // Constructor: We construct a DVD using the title
    public Dvd(String title) {
        this.title = title;
    }

    //getters and setters: THere is no setTitle
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

}
