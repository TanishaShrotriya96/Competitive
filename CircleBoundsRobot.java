import java.util.*;
import java.io.*;

public class CircleBoundsRobot
{
	public static boolean robotMoves(String dir)
	{	
		// north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;
        
        for (char i :dir.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];   
            }    
        }        
        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
	}
	
	public static boolean isRobotBounded(String dir) {	        
		char[] directions = dir.toCharArray();
		int x = 0 , y =0; 
		char d = 'N';
		for(int i=0; i<directions.length; i++) {
						
			if(directions[i]=='G') {
				if(d=='N') y = y + 1;
				if(d=='E') x = x + 1;
				if(d=='S') y = y - 1;
				if(d=='W') x = x - 1;
			}
			else if(directions[i]=='L') {
				if(d=='N') d = 'E';
				else if(d=='E') d = 'S';
				else if(d=='S') d = 'W';
				else if(d=='W') d = 'N';
			}
			else if(directions[i]=='R') {
				if(d=='N') d = 'W';
				else if(d=='W') d = 'S';
				else if(d=='S') d = 'E';
				else if(d=='E') d = 'N';
			}			
		}
		return (x == 0 && y == 0) || d!='N';
	}


	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		// enter directions
		String dir= in.nextLine();
		
		// my solution (brute force, not efficient)
		boolean res = CircleBoundsRobot.isRobotBounded(dir);
		// generic efficient solution
		boolean result = CircleBoundsRobot.robotMoves(dir);

		System.out.print(res);		
		System.out.print(result);

		
	}
}
