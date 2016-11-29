package quantumplayerdev.quantumplayer.songLoader;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import quantumplayerdev.quantumplayer.Song;

public class SongLoader {

	public Song getSongFromFile(File file) {
		return loadSongFromFile(file);
	}

	public Song loadSongFromFile(File file) {
		AudioFile f = null;
		try {
			f = AudioFileIO.read(file);
		} catch (Exception e) {
			System.out.println("cant read file");
			e.printStackTrace();
		}
		Tag tag = f.getTag();
		AudioHeader audioHeader = f.getAudioHeader();
		// System.out.println(f.getAudioHeader().getEncodingType());
		Song song = new Song();
		song.setPath(file.getPath());
		song.setArtist(tag.getFirst(FieldKey.ARTIST));
		song.setAlbum(tag.getFirst(FieldKey.ALBUM));
		song.setTitle(tag.getFirst(FieldKey.TITLE));
		song.setYear(tag.getFirst(FieldKey.YEAR));
		return song;
	}

	public Song loadSongFromFileOld(File file) throws UnsupportedTagException, InvalidDataException, IOException {
		Mp3File mp3File = new Mp3File(file);
		Song song = new Song();
		song.setPath(mp3File.getFilename());
		ID3v1 tag = null;
		if (mp3File.hasId3v1Tag()) {
			tag = mp3File.getId3v1Tag();
		} else if (mp3File.hasId3v2Tag()) {
			tag = mp3File.getId3v2Tag();
		}

		song.setTitle(tag.getTitle());
		song.setAlbum(tag.getAlbum());
		song.setArtist(tag.getArtist());
		song.setYear(tag.getYear());
		if (mp3File.hasId3v2Tag()) {
		}
		return song;
	}
}
