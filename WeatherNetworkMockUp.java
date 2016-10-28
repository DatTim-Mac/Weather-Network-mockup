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

import java.util.Random;
public class WeatherNetworkMockUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int N = 100;
        double r = 0;
        WeatherNetwork network1 = new WeatherNetwork();
        
        for (int i = 0; i < 100; i++){
            network1.buoyNetwork[i].setCurrentDirection(randomize(360));
            network1.buoyNetwork[i].setCurrentMag(randomize(3060));
            network1.buoyNetwork[i].setHumidity(randomize(3060));
            network1.buoyNetwork[i].setPercepitation(randomize(3060));
            network1.buoyNetwork[i].setWind(randomize(1000));
            network1.buoyNetwork[i].setWaveHeight(randomize(150));
            
        }
        
        for (int i = 0; i < N; i++){
            network1.errorCheck(i);
            network1.printDetailsBuoy(i);
        }
        
    }
    
    static double randomize(double Max){
        Random randomGen = new Random();
        double temp = 0;
        temp = Max*randomGen.nextDouble();
        return temp;
    }
}

