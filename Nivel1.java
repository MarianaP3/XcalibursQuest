import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Nivel1 extends Niveles
{ 
    private int xOffset = 0;  
    private final static int SWIDTH = 1200; 
    private final static int SHEIGHT = 800;  
    private final static int WWIDTH = 3600;  
    private GreenfootImage bimg;
    public Nivel1()
    {        
        //super(SWIDTH, SHEIGHT, 1, false);    
        bimg = new GreenfootImage("FondoBosque.png");    
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
            GreenfootImage imagen = new GreenfootImage("PlatBosque.png");
            Plataform p = new Plataform();
            p.setImagen(imagen);
            addObject(p, i, 768);
        } 
        
        
        for(int i=340; i<=532; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 568);
        }
        for(int i=670; i<=862; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 370);
        }
        for(int i=1000; i<=1342; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 500);
        }
        for(int i=950; i<=1150; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 220);
        }
        for(int i=1400; i<=1600; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 600);
        }
        for(int i=1450; i<=1650; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 300);
        }
        for(int i=1650; i<=1850; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 468);
        }
        for(int i=2000; i<=2200; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 528);
        }
        for(int i=2100; i<=2300; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 328);
        }
        for(int i=2300; i<=2500; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 200);
        }
        for(int i=2500; i<=2800; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 500);
        }
        for(int i=2750; i<=2950; i+=64){
            PlatBosque p = new PlatBosque();
            addObject(p, i, 320);
        }
        
    }


    /*private void preparaMundo(){
    for(int i = 50; i<1300; i+=132){
    addObject(new Plataform(), i, 740);
    } 
    addObject(new Rest1(), 70, 610);
    }*/

}

