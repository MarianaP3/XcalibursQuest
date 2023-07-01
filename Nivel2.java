import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Nivel2 extends Niveles
{ 
    private int xOffset = 0;  
    private final static int SWIDTH = 1200; 
    private final static int SHEIGHT = 800;  
    private final static int WWIDTH = 3600;  
    private GreenfootImage bimg;
    public Nivel2()
    {        
        //super(SWIDTH, SHEIGHT, 1, false);    
        bimg = new GreenfootImage("FondoDesierto.png");    
        shiftWorld(0);    
        prepare();
    }
    public void shiftWorld(int dx){
        if( (xOffset + dx) <= 0 && (xOffset + dx) >= SWIDTH - WWIDTH) {     
            xOffset += dx;      
            shiftWorldBackground(dx);      
            shiftWorldActors(dx);    
        }
    }
    public void shiftWorldBackground (int dx) {
        GreenfootImage bkgd = new GreenfootImage (SWIDTH, SHEIGHT) ;
        bkgd.drawImage (bimg, xOffset, 0) ;
        setBackground (bkgd) ;
    }
    public void shiftWorldActors(int dx) {    
        List<ScrollingActor> saList = getObjects(ScrollingActor.class);
        for( ScrollingActor a : saList ) {
            a.setAbsoluteLocation(dx);    
        }  
    }
    private void prepare(){
        addObject(new PuertaCerrada(),3450,642);
        Rest1 arturo = new Rest1();    
        addObject(arturo, 90, 670);

        //Piso
        for(int i = 30; i<3700; i+=64){
            GreenfootImage imagen = new GreenfootImage("PlatDesierto.png");
            Plataform p = new Plataform();
            p.setImagen(imagen);
            addObject(p, i, 768);
        } 
        for(int i=340; i<=532; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 568);
        }
        for(int i=540; i<=740; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 368);
        }
        for(int i=840; i<=1040; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 528);
        }
        for(int i=790; i<=990; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 200);
        }
        for(int i=1090; i<=1290; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 350);
        }
        for(int i=1300; i<=1500; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 600);
        }
        for(int i=1450; i<=1650; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 150);
        }
        for(int i=1600; i<=1800; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 450);
        }
        for(int i=1900; i<=2100; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 300);
        }
        for(int i=2050; i<=2250; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 550);
        }
        for(int i=2400; i<=2600; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 350);
        }
        for(int i=2550; i<=2750; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 610);
        }
        for(int i=2750; i<=2950; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 200);
        }
        for(int i=2850; i<=3050; i+=64){
            PlatDesierto p = new PlatDesierto();
            addObject(p, i, 450);
        }
    }
    public int NumNivel(){
        return 2;
    }
}
