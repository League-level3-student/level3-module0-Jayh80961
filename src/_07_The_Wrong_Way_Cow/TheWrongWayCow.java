/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
    	int savex = 0;
    	int savey = 0;// can i comment?...
    	// visit each cell in grid -> 
    	// keep count of cows in the 4 different directions
    	
        for(int i=0;i<field.length;i++) {
        	for(int j=0;i<field.length;j++) { 
        		if()) {
        			
        		}
        	}
        } 
        int[] result = {savex,savey};
        return result;
    } // can i say something?
    // I meant for the method 'rightCow' to check just
    // 3 cells for 'c' 'o' 'w', where the 'c' is at field[i][j]
    // and then also make methods 'leftcow', 'upcow', 'downcow'
    // questions?...oh okay got it
    // the method doesn't need a pair of nested loops!
    // ok i think i see what you are doing.  this
    // method is keeping count of *all* the left cows
    // in the field - is that why you have a pair of
    // nested loops? what do you mean  
    public static int leftcow(final char[][] field,int i, int j) {
		int count = 0;
    	for(int k=0;k<field.length;k++) {
			for(int l=0;l<field.length;l++) {
				if(field[k][l]=='C'&&field[k][l-1]=='O'&&field[k][l-2]=='W') {
					count++; 
				} 
			}
		}
    	return count;
    }
    public static boolean rightcow(final char[][] field, int i, int j) {
    	for(int k=0;k<field.length;k++) {
    		for(int l=0;l<field.length;l++) {
    			if(field[i][j]=='C'){
    				return true;
    			}
    		}
    	}
    	return false;
    }
}
/*  I am not sure how to use this boolean into the code
 * 
 * i'll answer that in a moment.  but first, what are your thoughts about
 * how to approach the overall problem?  would it help to look at the test
 * cases?  for example:
 * final char[][] field =  new char[][] {
      "c..........".toCharArray(),
      "o...c......".toCharArray(),
      "w...o.c....".toCharArray(),
      "....w.o....".toCharArray(),
      "......w.cow".toCharArray()
      
      see how there are 3 "down" cows, one "right" cow and no "left" or "up" cows.
      
 * 
 * boolean rightCow (field, i, j) 
 * 		this method would check in 'field' at cell [i][j] to see
 *      if it is the heead of a "right" cow.  it would return true if so.
 *      
 *  how do you think this method would be used in the code above?...
 *  If it returns true that means we can check the next two ones and see if it the wrong way cow
     No. I had in mind that "rightCow" meethod checks 3 cells for 'c' 'o' 'w',
     like your code on line 58 above.
     
      If there *is* a 'c' 'o' 'w' there, you still don't know if it is a
      WRONG WAY cow... do you understand how to determine if it is WRONG WAY?
      
      There is only one cow going the wrong way.  It could be an 'up' cow,
      'down' or 'right' or 'left'...how do you determine its the WRONG WAY?
      
      not sure?  you there?
      We can determine the wrong way by comparing it to other cows that are in the lists? There are lots of cows in the same way
      Can you be more specific - "compare" how? So basically using a double for loop, comparing each one another until all of the cows are compared in the array 
      I'm still not clear on "compare". can i explain what needs to happen? okay
      
      In every test case, there are zero or more cows in each of the 4 directions,
      right? yes.  how many cows are there in the "wrong way' direction? 1
      right.  so the double for loop needs to make a count of cows in
      each of the 4 directions.  Only AFTER the loops are done can you
      decide which is the 'wrong way' by looking for the count of 1.
      make sense? okay. 
      
      now if you make 4 methods, rightCow, leftCow, upCow, downCow, you
      can call these inside the for loops, checking each cell in the field.
      
      is this making sense so far?yes  does this help?yes.  ok.  then
      once you determine which is the 'wrong way', you need to go back in
      the field and find where its head is!
 *
 */
