import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rest1 extends Actor
{
    private int hSpeed = 5;
    private int vSpeed = 2;
    private int acceleration = 1;
    private int jumpStrength = 24;
    private int counter = 0;
    private boolean spaceDown;
    private MouseInfo mi = Greenfoot.getMouseInfo();

    private int speedX = 1;  
    private static final int SPEED = 8;
    private static final int BOUNDARY = 100;

    GreenfootImage[] walkRight = new GreenfootImage[9];
    GreenfootImage[] walkLeft = new GreenfootImage[9];
    GreenfootImage[] jumpA = new GreenfootImage[9];
    //GreenfootImage[] fallA = new GreenfootImage[5];
    GreenfootImage[] attack = new GreenfootImage[14];
    GreenfootImage[] died = new GreenfootImage[7];

    public Rest1(){
        GreenfootImage imagen = new GreenfootImage("static.png");
        imagen.scale(imagen.getWidth()/4,imagen.getHeight()/4);
        setImage(imagen);
        initAnimationSprites();
    }

    public void act()
    {
        if(onGround()){
            GreenfootImage imagen = new GreenfootImage("static.png");
            imagen.scale(imagen.getWidth()/4,imagen.getHeight()/4);
            setImage(imagen);
        }

        checkKeys();    
        checkFall();
        boundedMove1();
        //boundedMove2();
        //boundedMove3();
        handleArrowKey();    
    }

    private void boundedMove1() {    
        if( speedX+getX() <= BOUNDARY) {      
            setLocation(BOUNDARY, getY()); 
            ((Niveles)getWorld()).shiftWorld(-speedX);
        } else if( speedX+getX() >= getWorld().getWidth()-BOUNDARY ) {      
            setLocation(getWorld().getWidth()-BOUNDARY, getY());
            ((Niveles)getWorld()).shiftWorld(-speedX);
        } else {      
            setLocation(getX()+speedX, getY());    
        }    speedX = 0;  
    }

    private void handleArrowKey() {    
        if( Greenfoot.isKeyDown("d") ) {      
            speedX = SPEED;  
            if(onGround()){
                animateRigth();
            }
            //animateRigth();
        }
        if( Greenfoot.isKeyDown("a") ) {      
            speedX = -SPEED; 
            if(onGround()){
                animateLeft();
            }
        }
    }

    public void checkKeys(){
        /*if(Greenfoot.isKeyDown("d")){
        animateRigth();
        setLocation (getX() + hSpeed, getY());
        }

        if(Greenfoot.isKeyDown("a")){
        animateLeft();
        setLocation (getX() - hSpeed, getY());
        }*/

        if(spaceDown != Greenfoot.isKeyDown("space")){ 
            spaceDown = !spaceDown;
            if(spaceDown && onGround()){
                jump();
                //Greenfoot.delay(20);
                animateJump();
            }
        }   
        if (Greenfoot.mousePressed(null)) {
            animateAttack();
        }
        if(Greenfoot.isKeyDown("q")){
            animateDie();
        }
        /*if(Greenfoot.mousePressed(null)){ 
        if(mi.getButton() == 1){
        //animateAttack();
        ataque();
        }
        }
        if(Greenfoot.mouseClicked(null)){ 
        if(mi.getButton() == 1){
        animateAttack();
        }
        }*/

    }

    public boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Plataform.class);
        return under != null;
    }

    public void fall(){
        detectPlataform();
        setLocation (getX(), getY() + vSpeed);
        vSpeed += acceleration;
    }

    public void checkFall(){
        if(onGround()){
            vSpeed = 0;
        }else{
            fall();
        }
    }

    public void jump(){
        vSpeed = -jumpStrength;
        fall();
    }

    public void detectPlataform(){
        for(int i = 0; i < vSpeed; i++){
            Actor plataform = getOneObjectAtOffset(0, getImage().getHeight()/2+i, Plataform.class);
            if(plataform != null){
                vSpeed = i;
            }
        }
    }

    public void initAnimationSprites(){
        for(int i=0; i<9; i++){
            int k=i+1;
            String name = "walk"+k+".png";
            walkRight[i] = new GreenfootImage(name);
            walkRight[i].scale(walkRight[i].getWidth()/4,walkRight[i].getHeight()/4);
            setImage(walkRight[i]);
        }
        for(int i=0; i<9; i++){
            int k=i+1;
            String name = "walk"+k+".png";
            walkLeft[i] = new GreenfootImage(name);
            walkLeft[i].scale(walkLeft[i].getWidth()/4,walkLeft[i].getHeight()/4);
            walkLeft[i].mirrorHorizontally();
            setImage(walkLeft[i]);
        }
        for(int i=0; i<9; i++){
            int k=i+1;
            String name = "jump"+k+".png";
            jumpA[i] = new GreenfootImage(name);
            jumpA[i].scale(jumpA[i].getWidth()/4,jumpA[i].getHeight()/4);
            setImage(jumpA[i]);
        }
        for(int i=0; i<7; i++){
            int k=i+1;
            String name = "die"+k+".png";
            died[i] = new GreenfootImage(name);
            died[i].scale(died[i].getWidth()/4,died[i].getHeight()/4);
            setImage(jumpA[i]);
        }
        //Los dos for es para la animacion de ataque
        for(int i=0; i<7; i++){
            int k=i+1;
            String name = "ataque"+k+".png";
            attack[i] = new GreenfootImage(name);
            attack[i].scale(attack[i].getWidth()/4,attack[i].getHeight()/4);
            setImage(attack[i]);
        }
        for(int i=0; i<7; i++){
            int k=i+1;
            int j=i+7;
            String name = "ataque"+k+".png";
            attack[j] = new GreenfootImage(name);
            attack[j].scale(attack[j].getWidth()/4,attack[j].getHeight()/4);
            setImage(attack[j]);
        }
    }

    public void animateAttack() {
        //String[] imagenes = {"ataque1.png", "ataque2.png", "ataque3.png", "ataque4.png", "ataque5.png", "ataque6.png", "ataque7.png"};  
        for (int i = 0; i < 10; i++) {
            setImage(attack[i]);
            Greenfoot.delay(2);
        }
    }
    public void animateDie() {
        //String[] imagenes = {"ataque1.png", "ataque2.png", "ataque3.png", "ataque4.png", "ataque5.png", "ataque6.png", "ataque7.png"};  
        for (int i = 0; i < 7; i++) {
            setImage(died[i]);
            Greenfoot.delay(4);
        }
    }

    /*public void animateJump() {
    //String[] imagenes = {"ataque1.png", "ataque2.png", "ataque3.png", "ataque4.png", "ataque5.png", "ataque6.png", "ataque7.png"};  
    for (int i = 0; i < 9; i++) {
    setImage(jumpA[i]);
    Greenfoot.delay(2);
    }
    }*/

    public void animateRigth(){
        setImage(walkRight[counter++ % 9]);
    }

    public void animateLeft(){
        setImage(walkLeft[counter++ % 9]);
    }

    public void animateJump(){
        setImage(jumpA[counter++ % 9]);
        //Greenfoot.delay(8);
    }

    /*public void animateAttack(){
    setImage(attack[counter++ % 7]);
    }*/

    public void animateFall(){
        setImage(attack[counter++ % 5]);
    }
}
