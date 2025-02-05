package entities;

import java.util.Objects;

public class Song{
    //constructors
    public Song(Long id, String name, String artist, String album, String genere){
        //constructor call should be the first statement in constructor
        this(name, artist, album, genere);
        this.id = id;
    }
    public Song(String name, String artist, String album, String genere){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genere = genere;
    }


    //direct
    private Long id;
    private String name;
    private String artist;
    private String album;
    private String genere;
    //no relations

    //getters
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getArtist(){
        return artist;
    }
    public String getAlbum(){
        return album;
    }
    public String getGenere(){
        return genere;
    }
    //behaviours none of song

    @Override
    public String toString(){
        return String.format("Song [id=%d]",this.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this)
            return true;
        if(obj==null || obj.getClass() != this.getClass())
            return false;
        Song s = (Song) obj;
        return s.getId().equals(this.getId());
    }

}