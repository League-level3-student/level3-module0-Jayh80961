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

// you were debugging the cow counts.  at the end of class, the counts didn't
// print out fo some reason.  try to fix that first.  Can i try something? yes

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		int savex = 0;
		int savey = 0;
		int check1 = 0;
		int check2 = 0;
		int check3 = 0;
		int check4 = 0;// can i comment?...
		int[] head = {};
		// visit each cell in grid -> 
		// keep count of cows in the 4 different directions

		// there are multiple ways to write this code.  the way
		// you are doing it, (1) you don't need for loops right here and
		// (2)  the methods leftcow, etc, don't need parameters i and j.
		// can i show you what i mean?yes.  questions? okay
		//		for(int i=0;i<field.length;i++) {
		//			for(int j=0;i<field[i].length;j++) { // can i say something
		System.out.println("got here 1");
		check1 = check1 + leftcow(field); 
		System.out.println("got here 3");
		check2 = check2 + rightcow(field);
		check3 = check3 + upcow(field);
		check4 = check4 + downcow(field);

		// finish this section - call the correct method in each else if section
		if(check1 == 1) {
			// call a new method here that looks for and returns the
			// cell with the head of a COW in the rightcow direction
			//should I create a new method? yes.  it's a bit like the
			// rigtCow method that does a count.  BUT the new method
			// is a bit different - it returns the location of 
			// the head of the right cow.  ok?
			head = returnRightcow(field);
		}
		else if(check2 == 1) {
			// call a new method here that looks for the
			// cell with the head of a COW in the left direction
			head = returnleftcow(field);
		}
		else if(check3 == 1) {
			// etc
			head = returnupcow(field);
		}
		else if(check4 == 1) {
			head = returndowncow(field);
		}

		//			}
		//		}


		// can i say something?yes
		// do you r suggested to do?  emember what i  yes kind of 
		// make 4 more methods.  eg rightCowHead() is like rightCow90
		// but instead of counting cows it returns an int[] with the
		// location of the head.

		// then in your if-else if(check which is 1) above you
		// will only call the CowHead method that has just 1 cow.
		// questions? no  // dont need

		System.out.print("headd " + head[0] + " " + head[1]);

		return head;  // this should be 'head'

		// ok.  ready to debug? yes.  i suggest some print statements
		// like print out # of cows found in each direction and
		// the location of the head 
		// whaat SHOULD the count values be for right/left/up/down? 4/0/1/0
		// yeah.  so see if you can fix this okay

		// suggestion?  maybe run only one test at first and debug that one...
	}


	// can i say something?
	/*
    you already made methods called leftCow and rightCow - each returns a number of cows it found.
    Make 2 more methods (for up and for down).  Then call all 4 of them and see which
    one retunrs the number 1.  That's the direction of the wrong way cow.

    int rightNumCows = rightCow(field)
    int leftNumCows = leftCow(field)  etc.
	 */

	// I meant for the method 'rightCow' to check just
	// 3 cells for 'c' 'o' 'w', where the 'c' is at field[i][j]
	// and then also make methods 'leftcow', 'upcow', 'downcow'
	// questions?...oh okay got it
	// the method doesn't nee
	//d a pair of nested loops!
	// ok i think i see what you are doing.  this
	// method is keeping count of *all* the left cows
	// in the field - is that why you have a pair of
	// nested loops? what do you mean  
	public static int leftcow(final char[][] field) {
		System.out.println("got here 2");
		System.out.println("field size: " + field.length + " " + field[0].length);
		int count = 0;
		for(int k=0;k<field.length;k++) { 

			for(int m=0;m<field[k].length;m++) {

				// ArrayIndexOutofBoundsException
				if(m >= 2 && field[k][m]=='c'&&field[k][m-1]=='o'&&field[k][m-2]=='w') {
					count++; //wait so I am not 100% sure what I should exactly do
					// two ideas here: (1) if look left, there needs to be at least 2 cols to left,
					// so in this method, 'm' i
					// WAIT  s the col value and its only safe to look left
					// if m >= 2.  do you understand why? oh okay
					// second problem:  to look left, you stay in the same row 'k' but look
					// at columns to left 'm-1' and 'm-2'.  understand? yes.  ok fix this code
					// in all the methods 
				}

			}

		}
		System.out.print(count + " left cows");		// your print statements werre fine why are you changing them?
		return count;
	}
	public static int rightcow(final char[][] field) {
		int count = 0;
		for(int k=0;k<field.length;k++) {
			for(int m=0;m<field[k].length;m++) {

				// fix 'm <= 2' ... how avoid going over RIGHT edge of field .. understand?
				// now use this in returnrightcow... want me to do this? okay sure
				if(m < field[k].length - 2 &&field[k][m]=='c'&&field[k][m+1]=='o'&&field[k][m+2]=='w') {
					count++; 
				} 
			}
		} // for example this is ambiguous 
		// use th word "right" here!
		System.out.print(count + " right");
		return count;
	}
	public static int upcow(final char[][] field) {
		int count = 0;
		for(int k=0;k<field.length;k++) {
			for(int m=0;m<field[k].length;m++) {
				// use this in returnupcow...
				if(k >= 2 &&field[k][m]=='c'&&field[k-1][m]=='o'&&field[k-2][m]=='w') {
					count++; 
				} 
			}
		}
		System.out.print(count + " up cows");
		return count;
	}
	public static int downcow(final char[][] field) {
		int count = 0;
		for(int k=0;k<field.length;k++) {
			for(int m=0;m<field[k].length;m++) {  // fix DOWN test... its not k<= 2...
				// want me to fix? yes
				if(k < field.length - 2 &&field[k][m]=='c'&&field[k+1][m]=='o'&&field[k+2][m]=='w') {
					count++; 
				} 
			}
		}
		System.out.print(count + " down cows");
		return count;  // let me know if want help.. yes I fixed the m and k but I am not sure why it doesnt work
	}

	// ok now need to use those fixes above in the methods below also ill show you
	public static int[] returnRightcow(final char[][]field) {	///returnRightcow
		int savex= 0;
		int savey = 0;
		for(int k=0;k<field.length;k++) {
			for(int l=0;l<field[k].length;l++) {
				// no you test that above
				// let me show you..
				// here you need to test 'C' 'O' 'W' in RIGHT direction
				// no.  like this....

				// use this instead:
				// 			if(m < field[k].length - 2 &&field[k][m]=='c'&&field[k][m+1]=='o'&&field[k][m+2]=='w')
				if(l < field[k].length - 2 &&field[k][l]=='c'&&field[k][l+1]=='o'&&field[k][l+2]=='w')
				{
					// save values 'k' and 'l' - that's the loc of the head
					savex = k;
					savey = l;  // good
				}

			}
		}
		int[] result = {savey,savex};
		return result;
		// here - return an int[] array with savex, savey
		// great!!  now you need 3 more methods like this ...
		// returnLeftcow, Up and Down
	}
	public static int[] returnleftcow(final char[][]field) {	///returnRightcow
		int savex= 0;
		int savey = 0;
		for(int k=0;k<field.length;k++) {
			for(int l=0;l<field[k].length;l++) {
				// no you test that above
				// let me show you..
				// here you need to test 'C' 'O' 'W' in RIGHT direction
				// no.  like this....
				if(field[k][l]=='c'&&field[k-1][l]=='o'&&field[k-2][l]=='w') 
				{
					// save values 'k' and 'l' - that's the loc of the head
					savex = k;
					savey = l;  // good
				}

			}
		}
		int[] result = {savey,savex};
		return result;
		// here - return an int[] array with savex, savey
		// great!!  now you need 3 more methods like this ...
		// returnLeftcow, Up and Down
	}
	public static int[] returnupcow(final char[][]field) {	///returnRightcow
		int savex= 0;
		int savey = 0;
		for(int k=0;k<field.length;k++) {
			for(int l=0;l<field[k].length;l++) {
				// no you test that above
				// let me show you..
				// here you need to test 'C' 'O' 'W' in RIGHT direction
				// no.  like this....
				if(k >= 2 &&field[k][l]=='c'&&field[k-1][l]=='o'&&field[k-2][l]=='w') 
				{
					// save values 'k' and 'l' - that's the loc of the head
					savex = k;
					savey = l;  // good
				}

			}
		}
		int[] result = {savey,savex};
		return result;
		// here - return an int[] array with savex, savey
		// great!!  now you need 3 more methods like this ...
		// returnLeftcow, Up and Down
	}
	public static int[] returndowncow(final char[][]field) {	///returnRightcow
		int savex= 0;
		int savey = 0;
		for(int k=0;k<field.length;k++) {
			for(int l=0;l<field[k].length;l++) {
				// no you test that above
				// let me show you..
				// here you need to test 'C' 'O' 'W' in RIGHT direction
				// no.  like this....
				if(k < field.length - 2 &&field[k][l]=='c'&&field[k+1][l]=='o'&&field[k+2][l]=='w') {
					{
						// save values 'k' and 'l' - that's the loc of the head
						savex = k;
						savey = l;  // good
					}

				}
			}
			// here - return an int[] array with savex, savey
			// great!!  now you need 3 more methods like this ...
			// returnLeftcow, Up and Down
		}
		int[] result = {savey,savex};
		return result;
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
