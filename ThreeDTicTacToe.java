/**
 * 
 *
 * @paula hodgkins 
 * @version 1.00 15/02/011
 */

import java.util.Scanner;  



public class ThreeDTicTacToe {
    
    private int xCoord,yCoord,zCoord;
    private int userID, xValue, yValue, zValue;
    boolean verbose = false;//for debugging
    private final int [][] ticTacToe = new int [9][3];
    boolean invalidNumber = true; // determines if more input is needed
    boolean invalidX = true; // determines if more input is needed
    boolean invalidY = true; // determines if more input is needed
    boolean invalidZ = true; // determines if more input is needed
    boolean marked = true; // use to indicate if position taken
    boolean matches, matchesHorizontal, matchesVertical, matchesDiagonal, matches3DVertical, matches3DDiagonalCheck; //use to indicate if there is a match
    boolean play = true; //use to mark whether play should continue
    public int turns=1; //use to total the number of turns taken in the game
    private int emptySpots;//use to total the number of empty spots on the board
    // private int [][] ticTacToe = {{1,0,0},{0,1,0},{1,0,0},{0,0,0},{0,1,0},{1,0,1},{0,0,0},{0,1,0},{1,0,1}};//to test for wins
    //private int [][] ticTacToe = {{1,2,1},{2,1,2},{1,2,2},{2,1,1},{1,2,2},{2,1,1},{2,1,2},{0,2,1},{0,2,1}};//to test full array, no matches
    Scanner input = new java.util.Scanner(System.in);
    
        
     public static void main(String[] args) {
       
       ThreeDTicTacToe game = new ThreeDTicTacToe();
       game.playGame();
       
    }//end main
     
     
     
    public ThreeDTicTacToe()
    {
    	this.initializeArray(ticTacToe);
    	userID=1;
    }
    

    public final void initializeArray(int ticTacToe[][])//set all to 0, so no null values
    {
        for (int[] ticTacToe1 : ticTacToe) {
            for (int column = 0; column < ticTacToe1.length; column++) {
                ticTacToe1[column] = 0;
            }
        }
    	
    }
   
    public void setXCoord (){
        
        System.out.printf("Player %d, your turn. ", getUserID());
        invalidX=true;//reset the value 
        do
      	{
         try // read the x-coordinate
         {
                       
           System.out.print( "Please enter the x-coordinate (1, 2 or 3): " );
           xCoord=input.nextInt();
           
            if (xCoord < 1 || xCoord > 3)//test for valid coordinates
        	{
        		System.out.print("That is not a valid value. Enter either 1, 2, or 3. Please try again.\n");	
        	}
        	
        	else
        	{
                    invalidX = false;
                    setXValue();
        	}
        	
         } // end try
         catch ( Exception e )
         {
           System.out.println("You must enter an integer. Enter either 1, 2, or 3. Please try again.\n" );
            input.nextLine(); // discard input so user can try again
            invalidX = true;
         } // end catch
         
      } while ( invalidX ); // end do...while
  
    }//end setXCoord
    
 public void setYCoord (){
     invalidY=true;//reset the value 
    do
      {
         try // read the y-coordinate
         {
                       
           System.out.print( "Please enter the y-coordinate (1, 2 or 3): " );
           yCoord=input.nextInt();
         
            if (yCoord < 1 || yCoord > 3)//test for valid coordinates
        	{
        		System.out.print("That is not a valid value. Enter either 1, 2, or 3. Please try again.\n");        		
        	}
        	
        	else
        	{
        	   invalidY = false; // input successful; end looping
        	}
        	           
         } // end try
         catch ( Exception e )
         {
           System.out.println("You must enter an integer. Enter either 1, 2, or 3. Please try again.\n" );
            input.nextLine(); // discard input so user can try again
            invalidY = true;
         } // end catch
         
      } while ( invalidY ); // end do...while
          
    }//end setYCoord
    
    
  public void setZCoord (){
      invalidZ=true;//reset the value 
        do
      {
         try // read the z-coordinate
         {
                       
           System.out.print( "Please enter the z-coordinate (1, 2 or 3): " );
           zCoord=input.nextInt();
         
            if (zCoord < 1 || zCoord > 3)//test for valid coordinates
        	{
        		System.out.print("That is not a valid value. Enter either 1, 2, or 3. Please try again.\n ");	
        	}
        	
        	else
        	{
                    invalidZ = false; // input successful; end looping
        	}        	
            
         } // end try
         catch ( Exception e )
         {
           System.out.println("You must enter an integer. Enter either 1, 2, or 3. Please try again.\n" );
            input.nextLine(); // discard input so user can try again
            invalidZ = true;
         } // end catch
         
      } while ( invalidZ ); // end do...while
 
       
       
    }//end setZCoord
   
    public void setUserID()
    {
    	//use mod value of var turns. if 0, then player 2,
    	userID=getTurns();
    	userID=userID %2;
    	if (userID==0)
    	{
    		userID=2;
    	} 
    	
    	else
    	{
    		userID=1;
    	}
    }
    
    public void setTurns()
    {
    	turns++;
    }
    
    public int getTurns()
    {
    	return turns;
    }
    
    public int getXCoord()
    {
    	return xCoord;
    } 
    
     public int getYCoord()
    {
    	return yCoord;
    } 
    
     public int getZCoord()
    {
    	return zCoord;
    } 
    
    public int getUserID()
    {
    	return userID;
    }
    
    
    public static void outputArray( int[][] array )
   {
        System.out.println(); // start new line of output
      // loop through array's rows
      for ( int row = 0; row < array.length; row++ ) 
      {    	 
         // loop through columns of current row
         for ( int column = 0; column < array[ row ].length; column++ )
            System.out.printf( "%d  ", array[ row ][ column ] );

         System.out.println(); // start new line of output
        if(row == 2 || row == 5)//print a line between the z planes
         { 
         	System.out.println("-------");
         }
 
      } // end outer for 
      System.out.println(); // start new line of output
      
   } // end method outputArray

	public void showArray()
	{
		if (turns > 1)
                {
                    System.out.println("Here's the updated game board.");
                }
                ThreeDTicTacToe.outputArray(ticTacToe);
	}

	public int convertYCoord()
	{
		yValue=this.getYCoord();
		zValue=this.getZCoord();
		
		zValue = (zValue * 3)-1; //minus 1 to prevent out of bounds
		
		if (yValue == 3)
		{
			yValue = zValue-2;
		}
	
		else if ((yValue ==2) && (zValue !=2))
		{
			yValue = zValue-1;
		}
		
		else if(yValue==1)
		{
			yValue = zValue;
		}
		
		else if ((yValue ==2) && (zValue ==2))
		{
			yValue = 1;
		}
		
		return yValue;
		
	}//end convertYCoord

public void welcome()
{
        System.out.println("Welcome to 3D Tic Tac Toe. This is a game for two players. \nPositions are indicated using the x,y,z, coordinate format.\nEach coordinate location is determined by a number: 1, 2 or 3. ");
        System.out.println("X is left to right, Y is bottom to top, Z is across the three planes. \nFor example, if you enter 1,1,1, your position is in the first column, third row down.");
        System.out.println("Or, if you enter 1,1,2, your position is in the first column, sixth row down.");
        System.out.println("Available spaces are marked with zeros.\nOtherwise the number in the spot indicates which player marked the spot.\n");
	System.out.println("Here's the game board.");
	showArray();
}

public void setXValue()
{
	xValue = xCoord-1;
}

public int getXValue()
{
	return xValue;
}

public int getYValue()
{
	yValue = convertYCoord();
	return yValue;
}

public void setCoordinate()
{
	do
	{
		yValue=getYValue();
		xValue=getXValue();
		System.out.println("Checking availability.....");
		//put a little delay between check
		try {
			Thread.sleep(1000);                 //1000 milliseconds is one second.
			} 
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
		try //to catch any array out of bounds error
                {	
		if (ticTacToe[yValue][xValue] == 0)
		{
			ticTacToe[yValue][xValue] = userID;//mark the spot with the user ID.
			marked = true;//to set loop condition
			System.out.println("Your selection was marked.");
			setTurns();//increment number of turns
			matchesHorizontal=horizontalCheck(yValue,xValue,ticTacToe);
			if (!matchesHorizontal)
			{	matchesVertical=verticalCheck(yValue,xValue,ticTacToe);
				if (!matchesVertical)
				{	matchesDiagonal=diagonalCheck(yValue,xValue,ticTacToe);
					if(!matchesDiagonal)
					{	matches3DVertical=threeDVerticalCheck(yValue,xValue,ticTacToe);
						if(!matches3DVertical)
							matches3DDiagonalCheck=threeDDiagonalCheck(yValue,xValue,ticTacToe);
					}
				
				}
			}
			showArray();
		
			if(matchesHorizontal || matchesVertical || matchesDiagonal || matches3DVertical || matches3DDiagonalCheck)
			{
				System.out.printf("Congratulations, Player %d, you won!\n", userID);
				play=false;
			}
	
		}//end  test conditions for match

	else
	{
		System.out.println("That position is taken. Select another.");
		getAllCoordinates();
		marked = false;
	}
                
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Sorry. There was a problem with your entry. Please try again.");
        }
                
	}while(!marked);
	

}//end setCoordinate

public void getAllCoordinates()
{
	setXCoord();
    setYCoord();
    setZCoord();
	
}

public boolean horizontalCheck (int y, int x, int [][] array )
{
	if(verbose)
	{
		System.out.println( "In horizontal check method\n" );
		System.out.printf( "The value of y that is passed is: %d x is: %d \n", y, x);
		System.out.printf( "The value of y1 is: %d y2 is: %d y3 is: %d\n", array[y][0], array[y][1], array[y][2] );
	}
	
		
	if ((array[y][0] == userID) && (array[y][1] == userID) && (array[y][2] == userID))
	{
		matches=true;
	}
	else
	{
		matches = false;
	}
	
	return matches;
}//end horizontalCheck

public boolean verticalCheck (int y, int x, int [][] array )
{
	if(verbose)
	{
		System.out.println( "In vertical check method\n" );
		System.out.printf( "The value of y that is passed is: %d x is: %d \n", y, x);
		System.out.printf( "The value of 6x is: %d 7x is: %d 8x is: %d \n", array[6][x], array[7][x], array[8][x] );
	} 
	
	if ((array[6][x] == userID) && (array[7][x] == userID) && (array[8][x] == userID))
	{
				matches=true;
	}
	else if ((array[3][x] == userID) && (array[4][x] == userID) && (array[5][x] == userID))
	{
				matches=true;
	}
	else if ((array[0][x] == userID) && (array[1][x] == userID) && (array[2][x] == userID))
	{
				matches=true;
	}
	else
	{
		matches = false;
	}
	
	return matches;
	
}//end verticalCheck

public boolean diagonalCheck(int y, int x, int [][] array )
{
	if(verbose)
	{
		System.out.println( "In diagonal check method\n" );
		System.out.printf( "The value of y that is passed is: %d x is: %d \n", y, x);
	} 

	if( (y==8) || (y==5) || (y==2) )
	{
		if(verbose)
		{
			System.out.println( "In 8,5,2 test" );
			System.out.printf( "The value of y0 is: %d y-1 is: %d y-2 is: %d \n", array[y][1], array[y-1][1], array[y-2][2] );
		}
		if((array[y][0]==userID) && (array[(y-1)][1]==userID) && (array[(y-2)][2]==userID))//diagonal left to right
		{
			matches=true;
		}
				
		
		else if ((array[y][2]==userID) && (array[(y-1)][1]==userID) && (array[(y-2)][0]==userID))//diagonal right to left
		{
			matches=true;
		}
		
		else 
		{
			matches=false;
		}	
		 		
	}//end if for diagonal top to bottom	

	
	if( (y==0) || (y==3) || (y==6) )
	{
		if(verbose)
		{
			System.out.println( "In 0,3,6 test" );
			System.out.printf( "The value of y0 is: %d y+1 is: %d y+2 is: %d \n", array[y][0], array[y+1][1], array[y+2][2] );
		}
		if((array[y][0]==userID) && (array[(y+1)][1]==userID) && (array[(y+2)][2]==userID))//left to right
		{
			matches=true;	
		}
				
		
		else if ((array[y][2]==userID) && (array[(y+1)][1]==userID) && (array[y+2][0]==userID))//right to left
		{
			matches=true;
		}
		
		else 
		{
			matches=false;
		}	
		 		
	}//end if for diagonal bottom to top
	
	
	if( (y==1) || (y==4) || (y==7) )
	{
		if(verbose)
		{
			System.out.println( "In 1,4,7 test" );	
		}
		if((array[y][1]==userID) && (array[(y+1)][2]==userID) && (array[(y-1)][0]==userID))//right to left 
		{
			matches=true;
			
			if(verbose)
			{
				System.out.println( "In 1,4,7 test, right to left" );
				System.out.printf( "The value of y0 is: %d y+1 is: %d y-1 is: %d \n", array[y][1], array[y+1][1], array[y-1][2] );
			}//end verbose	
		}
				
		
		else if ((array[y][1]==userID) && (array[(y+1)][0]==userID) && (array[y-1][2]==userID))//left to right
		{
			if(verbose)
			{
				System.out.println( "In 1,4,7 test, left to right" );
				System.out.printf( "The value of y0 is: %d y+1 is: %d y-1 is: %d \n", array[y][0], array[y+1][1], array[y-1][2] );
			}
			
			matches=true;
		}
		
		else 
		{
			matches=false;
		}	
		 		
	}//end if for center
	
	
	return matches;
	
}//end method diagonalCheck

public boolean threeDVerticalCheck(int y, int x, int [][] array )
{
	if(verbose)
	{
		System.out.println( "In 3D vertical check method\n" );
	} 

	if ((array[6][x] == userID) && (array[3][x] == userID) && (array[0][x] == userID))
	{
			matches=true;
	}

	else if ((array[7][x] == userID) && (array[4][x] == userID) && (array[1][x] == userID))
	{
			matches=true;
	}

	else if ((array[8][x] == userID) && (array[5][x] == userID) && (array[2][x] == userID))
	{
			matches=true;
	}
	
	else
	{
		matches=false;
	}
	
	return matches;	
	
}//end method threeDVerticalCheck

public boolean threeDDiagonalCheck(int y, int x, int [][] array )
{
	if(verbose)
	{
		System.out.println( "In 3D diagonal check method\n" );
		System.out.printf( "The value of y that is passed is: %d x is: %d \n", y, x);
	} 

	if( (y==8) || (y==0) )
	{
		if(verbose)
		{
			System.out.println( "In 8,0 test" );
			//System.out.printf( "The value of y0 is: %d y-1 is: %d y-2 is: %d \n", array[0][0], array[8][2], array[4][1] );
		}
		if((array[0][0]==userID) && (array[8][2]==userID) && (array[4][1]==userID))//diagonal left to right
		{
                     if(verbose)
                    {
                            System.out.println( "In 8,0 test, left to right" );
                            System.out.printf( "The values of y: %d, %d, %d \n", array[0][0], array[8][2], array[4][1] );
                    }
			matches=true;
		}
				
		
		else if ((array[0][2]==userID) && (array[8][0]==userID) && (array[4][1]==userID))//diagonal right to left
		{
                    if(verbose)
                    {
                            System.out.println( "In 8,0 test, right to left" );
                            System.out.printf( "The values of y: %d, %d, %d \n", array[0][2], array[8][0], array[4][1] );
                    }
                        matches=true;
		}
		
		else 
		{
			matches=false;
		}	
		 		
	}//end if for diagonal top to bottom	

	
	else if( (y==2) || (y==6) )
	{
		if(verbose)
		{
			System.out.println( "In 2,6 test" );
		//	System.out.printf( "The value of y0 is: %d y+1 is: %d y+2 is: %d \n", array[y][0], array[y+1][1], array[y+2][2] );
		}
		if((array[2][0]==userID) && (array[6][2]==userID) && (array[4][1]==userID))//left to right
		{
			matches=true;	
		}
				
		
		else if ((array[2][2]==userID) && (array[6][0]==userID) && (array[4][1]==userID))//right to left
		{
			matches=true;
		}
		
		else 
		{
			matches=false;
		}	
		 		
	}//end if for diagonal bottom to top
	
	else
	{
		matches=false;
	}
	
		
	return matches;
	
}//end method 3D diagonalCheck


public void playGame()
{   
    welcome();
	do{  
            emptySpots=verifyGameSlots(ticTacToe);
            if(verbose)
		{
                    System.out.printf( "The value of emptySpots is: %d \n", emptySpots );
		}
		if (emptySpots > 0)
		{       
                        setUserID();
                     	getAllCoordinates();
			setCoordinate();		
		}
		else
		{
			play=false;
		}
	}while(play);
	
	System.out.println("Game over.");
}


 public int verifyGameSlots( int[][] array )
   {
   	emptySpots=0;//reset for each iteration
       // loop through array's rows
      for ( int row = 0; row < array.length; row++ ) 
      {    	 
         // loop through columns of current row
         for ( int column = 0; column < array[ row ].length; column++ )
            if( array[ row ][ column ] == 0)
            {
            	emptySpots++;//increment the number of empty spots in the game
            }
     
      } // end outer for 
    return emptySpots;
      
   } // end method verifyGameSlots



}//end class