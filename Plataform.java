import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plataform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plataform extends ScrollingActor
{   
    public Plataform(){
        /*GreenfootImage imagen = getImage();
        imagen.scale((int)imagen.getHeight()+100, (int)imagen.getWidth()+100);
        setImage(imagen);*/
    }
    public GreenfootImage getImagen(){
        return this.getImage();
    }
    public void setImagen(GreenfootImage imagen){
        //imagen.scale((int)imagen.getHeight()+100, (int)imagen.getWidth()+100);
        setImage(imagen);
    }
}
