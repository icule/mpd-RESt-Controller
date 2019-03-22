package iculesgate.mpd_controller.data;

import iculesgate.mpd_controller.annotation.MyStyle;
import org.immutables.value.Value;

/**
 * Created by icule on 14/07/17.
 */
@Value.Immutable
@MyStyle
public interface MusicInfoDefinition {
    String getFilename();

    String getTitle();

    String getArtist();

    Tag getTag() ;
}