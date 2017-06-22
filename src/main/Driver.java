/**
 * 
 * This is the main entry point for the Lottery program. This program is a simulation
 * of Georgia's Powerball lottery and is to show myself the odds of winning the
 * lottery, since I play the lottery often even though I know I shouldn't. See
 * Lottery.java for more info.
 * 
 */
package main;

import lotterySetup.Lottery;

/**
 * This class is the main entry point of the program.
 * 
 * @author Dustin Parker
 * 
 * @version December 2, 2014
 *
 */
public class Driver {

	/**
	 * This is the main entry point into the program, and is ALWAYS needed in
	 * EVERY program. Learn public main.
	 * 
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {

		/**
		 * This just creates an "object"/clone of the RouletteTable class and
		 * executes the RUN() method in it.
		 */
		Lottery tui = new Lottery();
		tui.run();

	}

}
