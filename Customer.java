
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hodgkinp
 */
public class Customer {
    private int arrivalTime;
    int arrive, service;
    private int serviceTime;
    private int currentTime;//current time is the x value in the for loop
    Random newTime= new Random();
    
    public Customer(){
        arrivalTime=0;
        serviceTime=0;
    }
    
    public Customer(int x){
        arrivalTime = x + (1 + newTime.nextInt(3));
        serviceTime=0;
    }
    
    public void setArrivalTime(int x){
        currentTime=x;
        arrive = 1+newTime.nextInt(3);
        arrivalTime = arrive + currentTime;//use time as an method to track actual wait times?
    }
       
    public int getArrivalTime(){
        return arrivalTime;
    }
    
     public void setServiceTime(int x){
         currentTime=x;
         service = 1+newTime.nextInt(3);
         serviceTime = service + currentTime;
    }   
    
    public int getServiceTime(){
        return serviceTime;
    }
}
