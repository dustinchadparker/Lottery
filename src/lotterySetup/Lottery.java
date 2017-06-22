/**
 * 
 * A lottery ticket is generated with numNumbers numbers, each with a range of
 * numberRange, and a PowerBall with a range of powerBallRange. The user 'buys' 
 * numTicketsBought tickets for $2 each within the same parameters. The program 
 * then runs as if the user bought numTicketsBought tickets at one time. 
 * 
 * Lottery then outputs the winnings of each ticket (if any) and the total 
 * amount of winnings after spending numTicketsBought*$2. It used to, and 
 * can easily be changed, to 'buy' a ticket until the user wins, but it was
 * proven to be much less effective than 'buying' multiple tickets.
 * 
 * Moral: Don't play the lottery.
 * 
 */package lotterySetup;

import java.util.ArrayList;

/**
 * Instantiates all  necessary variables.
 *  
 * @author Charlie
 *
 */
public class Lottery {

	private int winOne = 0;
	private int winTwo = 0;
	private int winThree = 0;
	private int winFour = 0;
	private int winFive = 0;

	private int numTicketsBought = 3000000;
	private int countTickets = 0;
	private int numNumbers = 5;
	private int numberRange = 68;
	private int powerBallNums = 1;
	private int powerBallRange = 25;
	private int randNumber = 0;
	private boolean powerBall = false;
	private int winningNumbersCount = 0;
	private ArrayList<Integer> list = new ArrayList<>(); // winning lottery
															// ticket
	private ArrayList<Integer> ticket = new ArrayList<>(); // drawn lottery
	private int winFiveNoP = 0;
	private int winFourNoP = 0;
	private int winThreeNoP = 0;
	private int winP = 0;

	/**
	 * Generates a winning ticket.
	 */
	public Lottery() {

		// GENERATE THE WINNING LOTTERY TICKET
		this.list = new ArrayList<>();
		// adds numbers to the winning "lottery"

		this.randNumber = (int) (Math.random() * this.numberRange);
		this.list.add(this.randNumber);

		while (this.list.size() < (this.numNumbers + powerBallNums)) {

			int indexCount = 0;

			while (indexCount < this.list.size()) {

				if (this.list.get(indexCount) == this.randNumber) {
					this.list.remove(indexCount);
					indexCount = -1;
					this.randNumber = (int) (Math.random() * this.numberRange);
				}
				indexCount++;
			}

			this.list.add(this.randNumber);
			this.randNumber = (int) (Math.random() * this.numberRange);
		}

		this.list.remove(this.list.size() - 1);

		// adds powerBall to the winning "lottery"

		int randNumber1 = (int) (Math.random() * this.powerBallRange);
		this.list.add(randNumber1);

	}

	/**
	 * Generates 'bought' tickets and checks to see if ticket is a winner.
	 */
	public void run() {

		while (this.countTickets < numTicketsBought) {

			
			this.countTickets++;
			this.powerBall = false;
			this.winningNumbersCount = 0;

			// GENERATE THE DRAWN LOTTERY TICKET
			this.ticket = new ArrayList<>();

			this.randNumber = (int) (Math.random() * this.numberRange);
			this.ticket.add(this.randNumber);

			// adds numbers to the winning "lottery"
			while (this.ticket.size() < (this.numNumbers + powerBallNums)) {

				int indexCount = 0;

				while (indexCount < this.ticket.size()) {

					if (this.ticket.get(indexCount) == this.randNumber) {
						this.ticket.remove(indexCount);
						indexCount = -1;
						this.randNumber = (int) (Math.random() * this.numberRange);
					}
					indexCount++;
				}
				this.ticket.add(this.randNumber);
				this.randNumber = (int) (Math.random() * this.numberRange);
			}

			this.ticket.remove(this.ticket.size() - 1);

			// adds powerBall to the drawn "lottery"

			int randNumber2 = (int) (Math.random() * this.powerBallRange);
			this.ticket.add(randNumber2);

			// COMPARE WINNING/DRAWN TICKETS
			int winningNumbersPosition = 0;
			int powerBallPosition = this.list.size() - 1;

			// check for powerBallWin
			if (this.list.get(powerBallPosition) == this.ticket
					.get(powerBallPosition)) {
				this.powerBall = true;
			}

			// check for winningNumbers
			int positionMinusPower = this.list.size() - 2;

			while (winningNumbersPosition < (this.ticket.size() - 1)) {

				while (positionMinusPower > -1) {

					if (this.ticket.get(winningNumbersPosition) == this.list
							.get(positionMinusPower)) {
						this.winningNumbersCount++;
					}
					positionMinusPower--;

				}
				winningNumbersPosition++;
				positionMinusPower = this.list.size() - 2;
			}

			// CHECK WINNING AMOUNTS AND ADD for extra statistic purposes
			if (this.powerBall == true) {
				if (this.winningNumbersCount == 5) {
					this.winFive++;
				}
				if (this.winningNumbersCount == 4) {
					this.winFour++;
				}
				if (this.winningNumbersCount == 3) {
					this.winThree++;
				}
				if (this.winningNumbersCount == 2) {
					this.winTwo++;
				}
				if (this.winningNumbersCount == 1) {
					this.winOne++;
				}
				if (this.winningNumbersCount == 0) {
					this.winP++;
				}
			}

			if (this.powerBall == false && this.winningNumbersCount == 5) {
				this.winFiveNoP++;
			}
			if (this.powerBall == false && this.winningNumbersCount == 4) {
				this.winFourNoP++;
			}
			if (this.powerBall == false && this.winningNumbersCount == 3) {
				this.winThreeNoP++;
			}

		}

		// Print Winnings
		System.out
				.println("Winnings out of 300 Million tickets: ($600 Million)");
		System.out.println("Jackpot(s) =GrandPrize= : " + this.winFive);
		System.out.println("5 numbers   =$1 Million=: " + this.winFiveNoP);
		System.out.println("4* numbers  =  $50,000 =: " + this.winFour);
		System.out.println("4 numbers   =   $100   =: " + this.winFourNoP);
		System.out.println("3* numbers  =   $100   =: " + this.winThree);
		System.out.println("3 numbers   =    $7    =: " + this.winThreeNoP);
		System.out.println("2* numbers  =    $7    =: " + this.winTwo);
		System.out.println("1* number   =    $4    =: " + this.winOne);
		System.out.println("Powerball   =    $4    =: " + this.winP);

		System.out.println("TOTAL WINNINGS: $" + ((this.winFiveNoP * 1000000)
				+ (this.winFour * 50000) + (this.winFourNoP * 100) + (this.winThree
				* 100) + (this.winThreeNoP * 7) + (this.winTwo * 7) + (this.winOne
				* 4) + (this.winP * 4)));

	}
}
