/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.network.mockup;

/**
 *
 * @author super
 */
public class Buoy {
    private double currentMag;
    private double currentDirection;
    private double xPos; 
    private double yPos;
    private double humidity; 
    private double percepitation;
    private double pathDis;
    private boolean safe;
    private double waveHeight;
    private double wind;
    
    public Buoy(){
        this.xPos = 0;
        this.yPos = 0;
    }//end of Buoy Constructor
    
    public Buoy(double x, double y){
        this.xPos = x;
        this.yPos = y;
    }//end of Buoy Constructor
    
    public double getCurrentMag(){ return this.currentMag; }
    public double getCurrentDirection(){ return this.currentDirection; }
    public double getXPos(){ return this.xPos; }
    public double getYPos(){ return this.yPos; }
    public double getHumidity(){ return this.humidity; }
    public double getPercepitation(){ return this.percepitation; }
    public double getPathDis(){ return this.pathDis; }
    public boolean getSafe(){ return this.safe; }
    public double getWaveHeight(){ return this.waveHeight;}
    public double getWind(){ return this.wind;}
    
    public void setCurrentMag(double a){ this.currentMag = a;}
    public void setCurrentDirection(double a){ this.currentDirection = a;}
    public void setHumidity(double a){ this.humidity = a;}
    public void setPercepitation(double a){ this.percepitation =  a;}
    public void setPathDis(double a){ this.pathDis = a;}
    public void setSafe(boolean a){ this.safe = a;}
    public void setWaveHeight(double a){ this.waveHeight = a;}
    public void setWind(double a){ this.wind = a;}
}
