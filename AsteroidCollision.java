// Crux of the problem: An asteroid is only as useful as its existence.
import java.util.*;
class AsteroidCollision {
    
    public static int[] asteroidCollide(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int ast: asteroids) {
            int flag = 0;
            //if stack not empty, incoming asteroid is moving left and top element is moving right
            while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                if (stack.peek() < -ast) {
                    stack.pop(); //important if you have a chain of asteroids moving right, to pop.
                    continue;
                } else if (stack.peek() == -ast) {
                    stack.pop(); // if both asteroids are the same weight then both will be destroyed in one go.
                }
                else {
                    // if asteroid at the top moving to the right, is greater than the incoming asteroid, then incoming asteroid will be destroyed
                	flag=1;
                	break;
                }
            }
            // push incoming asteroid only if it is not destroyed by top asteroid, which will happen if both move left, or top moves left and incoming asteroid moves right. 
            if(flag == 0) stack.push(ast);
            
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
    
    
    public static void main (String Args[]) {
    	int a[] = {-99,10,-11,4,2,3,200,-25,1,24,-66,65,-100,-102,11,-201,-7};
    	int[] ans = Driver.asteroidCollide(a);
    	for (int t = ans.length - 1; t >= 0; --t) {
	    	System.out.println(ans[t]);
        }
    }
    
}