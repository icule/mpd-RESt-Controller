package iculesgate.mpd_controller.data;

import iculesgate.mpd_controller.data.Tag;

/**
 * Created by icule on 14/07/17.
 */
public class MusicInfo {
    private String filename;
    private String title;
    private String artist;
    private Tag tag;

    public MusicInfo(String filename, String title, String artist, Tag tag) {
        this.filename = filename;
        this.title = title;
        this.artist = artist;
        this.tag = tag;
    }

    public MusicInfo(String filename, String title, String artist) {
        this.filename = filename;
        this.title = title;
        this.artist = artist;
        this.tag = null;
    }

    public String getFilename() {
        return filename;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String toString() {
        return filename + " || " + title + " || " + artist + " || " + tag;
    }
}