import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Jukebox { //usually is searched by albums
    private static Jukebox instance_ = null;
    private ArrayList<Artist> artists;
    private Queue<Song> toPlay;
    public Jukebox(ArrayList<Artist> artists){
            this.artists = artists;
            this.toPlay = new LinkedList<Song>();
    }
    public Jukebox(){
            this.artists = new ArrayList<Artist>();
            this.toPlay = new LinkedList<Song>();
    }
    public Jukebox getInstance() {
        if (instance_ == null)
            instance_ = new Jukebox();
        return instance_; 
    }
    public Artist getArtist(String name){
        for (Artist a : artists) {
            if (a.getName() == name) return a;
        }
        return null;
    }

    public void playSong(String name, String artist, String album){
        Artist a = getArtist(artist);
        if (a != null){
            Album alb = a.getAlbum(album);
            if (alb != null){
                Song s = alb.getSong(name);
                if (s != null) toPlay.add(s);
                }
            }
        System.out.println("err: not in system");
    }
	
}

class Artist{
    private String name;
    private ArrayList<Album> albums;
    public Artist(String name, ArrayList<Album> albums){
            this.name = name;
            this.albums = albums;
    }
    public String getName() { return this.name; }
    public Album getAlbum(String name) {
	for (Album album : albums){
		if (album.getName() == name) return album;
    }
    System.out.println("err: no album by this name from this artist");
    return null;
    }
}

class Album{
    private String name;
    private Artist artist;
    private ArrayList<Song> songs;
    public Album(String name, ArrayList<Song> songs){
        this.name = name;
        this.songs = songs;
    }
    public String getName() { return this.name; }
    public Song getSong(String name) {
        for (Song s : songs) {
            if (s.getName() == name) return s;
        }
        System.out.println("err: Song not in this album");
        return null;
    }
    public Artist getArtist() { return this.artist; }
}

class Song {
    private String name;
    private String genre;
    private Artist artist;
    public Song(String n, String g, Artist artist){
	this.name = n;
	this.genre = g;
	this.artist = artist;
    }
    public String getName(){ return this.name; }
    public String getGenre(){ return this.genre; }
    public Artist getArtist() { return this.artist; }
}
