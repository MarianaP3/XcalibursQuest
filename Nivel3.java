import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Nivel3 extends Niveles
{ 
    private int xOffset = 0;  
    private final static int SWIDTH = 1200; 
    private final static int SHEIGHT = 800;  
    private final static int WWIDTH = 3600;  
    private GreenfootImage bimg;
    public Nivel3()
    {        
        //super(SWIDTH, SHEIGHT, 1, false);    
        bimg = new GreenfootImage("FondoRuinas.png");    
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
            GreenfootImage imagen = new GreenfootImage("PlatRuinas.png");
            Plataform p = new Plataform();
            p.setImagen(imagen);
            addObject(p, i, 768);
        } 
        //Plataformas
        for(int i=400; i<=600; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 568);
        }
        for(int i=340; i<=532; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 208);
        }
        for(int i=700; i<=900; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 408);
        }
        for(int i=1000; i<=1200; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 250);
        }
        for(int i=1300; i<=1500; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 480);
        }
        for(int i=1600; i<=1800; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 300);
        }
        for(int i=1700; i<=1900; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 600);
        }
        for(int i=2000; i<=2200; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 400);
        }
        for(int i=2250; i<=2600; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 200);
        }
        for(int i=2250; i<=2450; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 560);
        }
        for(int i=2550; i<=2850; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 450);
        }
        for(int i=2950; i<=3150; i+=60){
            PlatRuinas p = new PlatRuinas();
            addObject(p, i, 300);
        }
    }
    public int NumNivel(){
        return 3;
    }
}
