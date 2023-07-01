import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PuertaCerrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuertaCerrada extends ScrollingActor
{
    /**
     * Act - do whatever the PuertaCerrada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImagen();
    }
    public void setImagen(){
        if(getWorld() instanceof Nivel1){
            
        }
        if(isTouching(Rest1.class)){
            GreenfootImage imagen = new GreenfootImage("PuertaAbierta.png");
            setImage(imagen);
            if(Greenfoot.isKeyDown("e")){
                if(getWorld() instanceof Nivel1){
                    Greenfoot.setWorld(new Nivel2());
                }
                if(getWorld() instanceof Nivel2){
                    Greenfoot.setWorld(new Nivel3());
                }
                if(getWorld() instanceof Nivel3){
                    //Greenfoot.setWorld(new Nivel4());
                }
            }
        }else{
            GreenfootImage imagen = new GreenfootImage("PuertaCerrada.png");
            setImage(imagen);
        }
    }
}
