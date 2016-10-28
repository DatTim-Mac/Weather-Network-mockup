/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weather.network.mockup;
import java.lang.Math;
/**
 *
 * @author super
 */
public class WeatherNetwork {
    static int N = 100;
    Buoy[] buoyNetwork = new Buoy[N];
    /*This is a constructor for the Weather Network System*/
    public WeatherNetwork(){ 
        int j = 0;
        for(int i = 0; i < N; i++, j++){
                buoyNetwork[i] = new Buoy(i , j);
                if(j == 24)
                    j = 0;
        }//end of outter for loop
    }//end of WeatherNetwork constructor
    
    /*The navigation function will calculate if the shortest route between a ship and it's destination is safe
    ~ let bX and bY represent the coordinates of the ship
    ~ let dX and dY represent the coordinates of the final destination
    ~ let r represent the maximum radius from the ship's path
    ~ let a represent the total number of buoy's*/
    public void navigation(double bX, double bY, double dX, double dY, double r, int a){
        Buoy[] goodBuoy = new Buoy[N];
        int numBuoy = 0;
        for(int i = 0; i < N; i++){
            if(this.goodBuoy(bX, bY, dX, dY, i, r) == true){
                goodBuoy[numBuoy] = buoyNetwork[i];
                numBuoy++;
            }
        }
        orderGoodBuoy(goodBuoy, numBuoy);
        for(int i = 0; i < numBuoy; i++){
            System.out.println("The buoy's detect the following along your path");
            printDetailsBuoy(i);
        }
    }//end of navigation function
    
    /*This function checks if the buoy is within a certain distance from the path*/
    private boolean goodBuoy(double xA, double xB, double yA, double yB, int buoyNum, double d){
        double m = (yB- yA)/(xB-xA);
        double n = -1/m;
        double b = yA-m*xA;
        double c = buoyNetwork[buoyNum].getYPos()-m*buoyNetwork[buoyNum].getXPos();
        double x = (c-b)/(m-n);
        double y = m*x+b;
        double r = Math.sqrt((y-buoyNetwork[buoyNum].getYPos())*(y-buoyNetwork[buoyNum].getYPos())+(x-buoyNetwork[buoyNum].getXPos())*(x-buoyNetwork[buoyNum].getXPos()));
        if(r<d){
            buoyNetwork[buoyNum].setPathDis(r);
            return true;
        }else
            return false;
    }
    
    
    private void orderGoodBuoy(Buoy[] a, int num){
        Buoy temp;
        for(int i = 0; i < num; i++){
            if(a[i].getPathDis() > a[i+1].getPathDis()){
                temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
    }
    
    /*The following function determines if a buoy is malfunctioning
    ~ let the a represent the buoy number*/
    public void errorCheck(int n){
        if(buoyNetwork[n].getCurrentDirection() > 3000||buoyNetwork[n].getCurrentDirection()<=0)
            buoyNetwork[n].setSafe(false);
        if(buoyNetwork[n].getCurrentMag() > 3000||buoyNetwork[n].getCurrentMag()<=0)
            buoyNetwork[n].setSafe(false);
        if(buoyNetwork[n].getHumidity() > 3000||buoyNetwork[n].getHumidity()<=0)
            buoyNetwork[n].setSafe(false);
        if(buoyNetwork[n].getPercepitation() > 3000||buoyNetwork[n].getPercepitation()<=0)
            buoyNetwork[n].setSafe(false);
        if(buoyNetwork[n].getWind() > 150||buoyNetwork[n].getWind()<=0)
            buoyNetwork[n].setSafe(false);
        if(buoyNetwork[n].getWaveHeight() > 1000||buoyNetwork[n].getWaveHeight()<=0)
            buoyNetwork[n].setSafe(false);
    }//end of errorChecking function
    
    public boolean safeCheck(){
        
        return false;
    }
    
    /*This following function outputs the entire buoy network
    ~ let n represent the number of rows of the buoy network
    ~ let m represent the numbers of columns of the buoy network*/
    public void displayNetwork(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0;  j < m; j++){
                
            }
        }
    }
    
    //this function outputs the data of the nth buoy
    public void printDetailsBuoy(int n){
        System.out.println("The Buoy's x coordinates is "+this.buoyNetwork[n].getXPos());
        System.out.println("The Buoy's y coordinates is "+this.buoyNetwork[n].getYPos());
        System.out.println("The Buoy measures a current mangitude of "+this.buoyNetwork[n].getCurrentMag());
        System.out.println("The Buoy measures a current direction of "+this.buoyNetwork[n].getCurrentDirection());
        System.out.println("The Buoy measures a humidity of "+this.buoyNetwork[n].getHumidity());
        System.out.println("The Buoy measures percipitation of "+this.buoyNetwork[n].getPercepitation());
        System.out.println("The Buoy measures a wind speed of "+this.buoyNetwork[n].getWind());
        System.out.println("The Buoy measures a wave height of "+this.buoyNetwork[n].getWaveHeight());
    }
}//end of weather network class
