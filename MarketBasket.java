
import java.util.ArrayList;
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
public class MarketBasket {
    static int longestWait; //to get the longest wait time
    ArrayList<Customer> customers = new ArrayList<>();
    Random newTime= new Random();
    static int maxLineSize =0; 
    int wait, startTime, currentTime, arrival, numCustomers, service;
    Customer c = new Customer ();
    boolean verbose = false;//for debugging
  
       
    //to show the data
    public static void showStats(){
        System.out.printf("The longest wait was %d minutes. The most customers in line at any one time was %d.", longestWait, maxLineSize);
    }
    
   
    public void processCustomers(){
         startTime = 1 + newTime.nextInt(3);
         c.setArrivalTime(startTime);//set the arrival time for the first customer
                    if(verbose){
                         System.out.printf("start time is: %d ", startTime);
                         System.out.printf("arrival time is: %d ", c.getArrivalTime());
                    }
         
        for( int x = 0; x < 720; x++ ){
                        if(verbose){
                         System.out.printf("in iteration %d of 720 for loop.\n", x);
                     }
            currentTime = x;
            if (currentTime == startTime){ //to start the first customer
                System.out.println("First customer arrived.");
                c.setServiceTime(x);//set the service time
                        if(verbose){
                                  System.out.printf("service time for first customer is: %d\n", c.getServiceTime());
                            }
                
                customers.add(0, c);//add the first customer to the array
                customers.add(new Customer(x));//add the second customer to array and set arrival time
                System.out.println("Second customer arrived.");
            }
            if (currentTime > startTime){
                for (int i = 0; i < customers.size(); i++)
                {   
                    arrival= (int) customers.get(i).getArrivalTime();
                            if(verbose){
                                    System.out.println("comparing arrival to current time");
                                    System.out.printf("current time is: %d ", currentTime);
                                    System.out.printf("arrival time is: %d\n", arrival);
                                }
                    if (arrival == currentTime){
                       
                        System.out.println("Customer arrived.");
                        customers.get(i).setServiceTime(currentTime);
                        
                                if(verbose){
                                    System.out.printf("the service time after arrival is: %d\n", customers.get(i).getServiceTime());
                                    System.out.printf("the size of the customer array is %d\n", customers.size());
                                }
                      
                        customers.add(new Customer(x));//add new customer and set arrival time  
                    }//end if
                }//end for of array list 
                
               if(!customers.isEmpty()){
                service = customers.get(0).getServiceTime(); //the person at the front of the line               
                if (service <= currentTime){
                    System.out.println("Customer service complete.");
                    wait = currentTime - customers.get(0).getArrivalTime();//get the wait time
                    
                                    if(verbose){
                                        System.out.printf("the arrival time of the item in the queue is %d\n", customers.get(0).getArrivalTime());    
                                        System.out.printf("the value of service in the queue is %d\n", service);
                                        System.out.printf("the value of current time is %d\n", currentTime);
                                    }

                                    if(verbose){
                                        System.out.printf("the wait time of the item in the queue is %d\n", wait);
                                        System.out.printf("the value of longest wait time is %d\n", longestWait);
                                    }
                   
                    if(wait > longestWait){//check the time in line
                        longestWait = wait;
                    }
                     
                                if(verbose){
                                       System.out.printf("the size of the queue after removal is %d\n", customers.size());
                                 }
                     
                     customers.remove(0);//only remove if the service time equals the current time
                    
                 }//end if
                 
                //get the max num of cusomters
                numCustomers = customers.size();
                
                            if(verbose){
                                        System.out.printf("the number of customers in the queue is %d\n", numCustomers);
                                       System.out.printf("the value of longest line size is %d\n", maxLineSize);
                                }
                
                if (numCustomers > maxLineSize)
                {
                    maxLineSize = numCustomers;
                }
            }//end if the line is not empty
               
            if(customers.isEmpty()){
                 customers.add(new Customer(x));//add new customer and set arrival time
            }//end if line empty
            
        }//end if current greater than start
            
      }//end 720 for
        
    }//end processCustomers
    
    
  public static void main(String[] args) {
        
        MarketBasket theBasket = new MarketBasket();
        theBasket.processCustomers();
        theBasket.showStats();
           
    }//end main   
    
    
}//end class


