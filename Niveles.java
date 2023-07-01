import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Niveles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Niveles extends World
{

    public Niveles()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
    }
    public abstract void shiftWorld(int dx);
    public abstract void shiftWorldBackground (int dx);
    public abstract void shiftWorldActors(int dx);
}
