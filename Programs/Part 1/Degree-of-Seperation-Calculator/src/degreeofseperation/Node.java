/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package degreeofseperation;

/**
 *
 * @author mortimer
 */
public class Node {
    Node parent;
    String filmId;
    String[]starsInFilm;
    public Node(Node parentFilm,String filmId){
        this.setParent(parentFilm);
        this.setFilmId(filmId);
        this.setStarsInFilmArray();
    }
    public void setParent(Node film){
        this.parent = film;
    }
    public Node getParent(){
        return this.parent;
    }
    public void setFilmId(String filmId){
        this.filmId=filmId;
    }
    public String getFilmId(){
        return this.filmId;
    }
    public void setStarsInFilmArray(){
        this.starsInFilm=Interface.getAllStarsInFilm(this.filmId);
    }
    public String[]getStarsInFilm(){
        return this.starsInFilm;
    }

}
