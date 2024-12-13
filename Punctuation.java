/*
 * Krish Kumar
 * 12-11-2024
 * Period 6
 * Punctuation.java
 * 
 * This program will edit Strings to only contain the words with punctuation
 * adjacent to or within them.
 * 
 * Pseudocode:
 * main method
 * 		new Punctuation object
 * 		call searchIt (skeleton method)
 * 
 * searchIt
 * 		D&I String words for original String to be edited
 * 		D&I String newWords to take in the editted String
 * 		newWords = call getPunctuationWords(words)
 * 		call printWords(newWords)
 * 
 * getPunctuationWords(String wordsIn)
 * 		D&I new String returnWords for returning formatted String
 * 		D&I new String textBlock for finding words
 * 		
 * 		sift through wordsIn with for loop:
 * 			check if charAt is not a space or if last char
 * 			if yes: check if last char, and if so, is it a space
 * 				depnding on how the above conditions work, different things will be necessary
 * 				(i.e. adding to textBlock, adding textBlock to returnWords and resetting)
 * 			if no: check if word has punctuation
 * 				if it does have punctuation, add textBlock to returnWords and reset it
 * 		return formatted String
 * 		
 * checkForPunctuation(String textBlockIn)
 * 		D&I new String with all punctuation listed
 * 		compare all characters of textBlockIn against said list with for loops
 * 		if textBlockIn contains punctuation: return true
 * 		if not: return false
 * 
 * printWords(String newWordsIn)
 * 		newlines
 * 		print newWordsIn
 * 		newlines 		
 */

public class Punctuation
{
	public static void main(String[] args) //main method
	{
		Punctuation p = new Punctuation(); //new Punctuation instance
		p.searchIt(); //call searchIt
	}
	
	public void searchIt() //skeleton method
	{
		//new String to be edited
		String words = "Blood, Sweat, and Tears by Winston Churchill " +
			"May 13, 1940" +
			"Mr. Speaker:" +
			"On Friday evening last I received His Majesty’s commission" +
			"to form a new  Administration. It was the evident wish and will" +
			" of Parliament and the nation that this should be conceived on the" +
			" broadest possible basis and that it should include all parties, " +
			"both those who supported the late Government and also the parties of " +
			"the Opposition.I have completed the most important part of this task." +
			" A War Cabinet has been formed of five Members, representing, with the " +
			"Liberal Opposition, the unity of the nation. The three party Leaders" +
			" have agreed to serve, either in the War Cabinet or in high executive " +
			"office. The three Fighting Services have been filled. It was necessary" +
			" that this should be done in one single day, on account of the extreme "
			+ "urgency and rigour of events. A number of other key positions were " +
			"filled yesterday, and I am submitting a further list to His Majesty tonight." +
			" I hope to complete the appointment of the principal Ministers during" +
			" tomorrow. The appointment of the other Ministers usually takes a little " +
			"longer, but I trust that, when Parliament meets again, this part of my task " +
			"will be completed, and that the Administration will be complete in all respects." +
			"Sir, I considered it in the public interest to suggest that the House should" +
			" be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in " +
			"accordance with the powers conferred upon him by the Resolution of the House. At " +
			"the end of the proceedings today, the Adjournment of the House will be proposed " +
			"until Tuesday, the 21st May, with, of course, provision for earlier meeting, " +
			"if need be. The business to be considered during that week will be notified to " +
			"Members at the earliest opportunity. I now invite the House, by the Resolution " +
			"which stands in my name, to record its approval of the steps taken and to declare " +
			"its confidence in the new Government." +
			"Sir, to form an Administration of this scale and complexity is a serious " +
			"undertaking in itself, but it must be remembered that we are in the preliminary " +
			"stage of one of the greatest battles in history, that we are in action at many " +
			"points in Norway and in Holland, that we have to be prepared in the " +
			"Mediterranean, that the air battle is continuous and that many preparations " +
			"have to be made here at home. In this crisis I hope I may be pardoned if I do " +
			"not address the House at any length today. I hope that any of my friends and " +
			"colleagues, or former colleagues, who are affected by the political " +
			"reconstruction, will make all allowances for any lack of ceremony with which " +
			"it has been necessary to act. I would say to the House, as I said to those " +
			"who’ve joined this government: \"I have nothing to offer but blood, toil, tears and sweat.\"" +
			"We have before us an ordeal of the most grievous kind. We have before us many, " +
			"many long months of struggle and of suffering. You ask, what is our policy? I will " +
			"say: It is to wage war, by sea, land and air, with all our might and with all the " +
			"strength that God can give us; to wage war against a monstrous tyranny, never " +
			"surpassed in the dark and lamentable catalogue of human crime. That is our policy. You " +
			"ask, what is our aim? I can answer in one word: victory. Victory at all costs, " +
			"victory in spite of all terror, victory, however long and hard the road may be; " +
			"for without victory, there is no survival. Let that be realised; no survival for " +
			"the British Empire, no survival for all that the British Empire has stood for, no " +
			"survival for the urge and impulse of the ages, that mankind will move forward towards its " +
			"goal. But I take up my task with buoyancy and hope. I feel sure that our cause will not be " +
			"suffered to fail among men. At this time I feel entitled to claim the aid of all, and I " +
			"say, \"Come then, let us go forward together with our united strength.\"";
		String newWords = new String(); //blank String used to take in editted String
		
		newWords = getPunctuationWords(words); //call getPunctuationWords to get new String
		printWords(newWords); //call printWords to print new String
	}
	
	public String getPunctuationWords(String wordsIn)
	{ //returns String with only punctuation words
		String returnWords = new String(); //new String for return
		String textBlock = new String(); //new String for text blocks (AKA words)
		
		for(int i=0; i<wordsIn.length(); i++) //sift through the inputted String
		{
			if(wordsIn.charAt(i) != ' ' || i == wordsIn.length()-1) //if char is in a word
			{
					textBlock += wordsIn.charAt(i); //add char to word
					if(i == wordsIn.length()-1) //check if last char
					{
						if(wordsIn.charAt(i) != ' ') //check if last char isn't space
						{
							returnWords += textBlock; //add word to return String
							textBlock = ""; //reset word
						}
					}
			}
			else //word terminated
			{
				if(checkForPunctuation(textBlock)) //check if word has punctuation
					returnWords += textBlock + " "; //add word to return String
				textBlock = ""; //reset word
			}
				
		}
		
		return returnWords; //return the formatted String
	}
	
	public void printWords(String newWordsIn)
	{ //prints the String inputted with newlines
		System.out.println("\n\n\n"); //newlines
		System.out.print(newWordsIn); //prints formatted String
		System.out.println("\n\n\n"); //newlines
	}
	
	public boolean checkForPunctuation(String blockIn)
	{ //checks for punctuation in the inputted word
		String punctuation = new String("./;:?!\'\"()-"); //String with punctuation symbols
		for(int i=0; i<blockIn.length(); i++) //sifts through word inputted
		{
			for(int j=0; j<punctuation.length(); j++) //checks char against each symbol
			{
				if(blockIn.charAt(i) == punctuation.charAt(j))
					return true; //returns true if punctuation found
			}
		}
		
		return false; //otherwise return false
	}
}
