package quiz.quiz02.Song;

import java.util.ArrayList;

public class Song {
	
	// 사고의 흐름
	// 가수명 > 앨범명 > 제목 > 가사, 곡 길이(초단위)
	String[] lyrics = new String[2];
	int[] playtime = new int[2];
	
	ArrayList songName;
	String[] songNameV = new String[2];
	
	ArrayList album;
	String[] albumV = new String[2];
	
	ArrayList singer;
	String[] singerV = new String[2];
	
	Song() {
		this.songName.add(songNameV);
		this.songName.add(lyrics);
		this.songName.add(playtime);
		
		this.album.add(albumV);
		this.album.add(songName);
		
		this.singer.add(singerV);
		this.singer.add(album);
		
	}
	
	void SongLyricsInput(String lyrics, int index){
		this.lyrics[index] = lyrics;
	}
	
	void SongPlaytimeInput(int playtime, int index) {
		this.playtime[index] = playtime;
	}
	void SongNameInput(String songNameV, int index) {
		this.songNameV[index] = songNameV;
	}
	void SongNameInput(ArrayList songName, int index) {
		this.songName.add(songName);
	}
	void albumInput(String albumV, int index) {
		this.albumV[index] = albumV;
	}
	
}
