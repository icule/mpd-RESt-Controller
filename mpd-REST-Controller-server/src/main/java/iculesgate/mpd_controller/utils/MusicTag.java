package iculesgate.mpd_controller.utils;

import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;

import java.util.UUID;

public class MusicTag {
    private static MediaPlayerFactory factory = new MediaPlayerFactory();

    private static UUID getId(final String path) {
        MediaMeta meta = factory.getMediaMeta(path, true);
        try {
            return UUID.fromString(meta.getEncodedBy());
        }
        catch (Exception e) {
            return null;
        }
    }

    public static UUID getLibraryId(final String filepath) {
        return getId(filepath);
    }
}
