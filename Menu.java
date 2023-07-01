import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    GifImage myGif = new GifImage("menu.gif");
    Flecha flecha = new Flecha();
    private int op = 0;
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        preparaMundo();
        prepare();
    }

    private void preparaMundo(){
        addObject(new titulo(), 600, 150);
        addObject(new Play(), 600, 350);
        addObject(new Controles(), 600, 480);
        addObject(new Salir(), 580, 610);
        addObject(flecha, 380, 350);
        setBackground(myGif.getCurrentImage());
    }

    public void act(){
        setBackground(myGif.getCurrentImage());
        if(Greenfoot.isKeyDown("UP") && op != 0){
            op--;
            Greenfoot.delay(5);
        }
        if(Greenfoot.isKeyDown("DOWN") && op != 2){
            op++;
            Greenfoot.delay(5);
        }
        if(op >= 3){
            op = 0;
        }
        if(op < 0){
            op = 2;
        }
        flecha.setLocation(380, 350 + (op *  130));

        if(Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
            switch(op){
                case 0:
                    Greenfoot.setWorld(new Nivel1());
                    break;
                case 2:
                    Greenfoot.stop();
                    break;
            }
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
