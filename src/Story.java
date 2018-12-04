/* 
 * 1410 Team Assignment
 * by Ahmed Alghafli, Nathan Goldhardt, Tyler Shaw 
 * 12/6/16
 */

/**
 * Story is a class that holds all of the lengthy strings that are used in the interactive storybook, to declutter the Gui class. The constructors needs a string, the readers name, so that their name can be in the story. You must access the strings with the provided getters. The page numbering starts at 0.
 * @param name The readers name.
 */

public class Story {
    private String name, txtPage_0, txtPage_1, txtPage_2, txtPage_3, txtPage_4, txtPage_5, txtPage_6;
    
    public Story(String name)
	{
		this.name = name;
		
		this.txtPage_0 = 
		         "On your return trip from studying Saturn's rings, you hear a distress signal that seems to be coming from the surface of Mars.It's strange because there hasn't been a colony there in years. Even stranger, it's calling you by name: Help me, " + name + ", you're my only hope!";
		
		this.txtPage_1 = 
	            "You deftly land your ship near where the distress signal originated. You didn't notice anything strange on your fly-by, but there is a cave in front of you. Behind you is an abandoned rover from the early 21st century";

		this.txtPage_2 = 
	            "You continue your course to Earth. Two days later, you receive a transmission from HQ saying that they have detected some sort of anomaly on the surface of Mars near an abandoned rover. They ask you to investigate, but ultimately the decision is yours because your mission has already run much longer than planned and supplies are low.";

		this.txtPage_3 =
	            "Your EVA suit is equipped with a headlamp, which you use to navigate the cave. After searching for a while your oxygen levels are starting to get pretty low. You know you should go refill your tank, but there's a very faint light up ahead.";
	    
		this.txtPage_4 = 
	            "The rover is covered in dust and most of the solar panels are broken. But you are quite surprised to see the on-board system booted up and running.In fact, there is a message on the screen: " + name + ", come to 28.543436, -81.369031.\\\" Those coordinates aren't far, but you don't know if your oxygen will last there and back.";
	    
		this.txtPage_5 = 
	            "After a long walk slightly uphill, you end up at the top of a small crater. You look around, and are overjoyed to see your favorite android, %1$s-S1124. It had been lost on a previous mission to Mars! You take it back to your ship and fly back to Earth.";
	    
		this.txtPage_6 =
	            "You arrive home on Earth. While your mission was a success, you forever wonder what was sending that signal. Perhaps a future mission will be able to investigate...";
	}

    /**
     * Getter for reader's name.
     * @return name
     */
	public String getName()
	{
		return name;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 0
	 */
	public String getTxtPage_0()
	{
		return txtPage_0;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 1
	 */
	public String getTxtPage_1()
	{
		return txtPage_1;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 2
	 */
	public String getTxtPage_2()
	{
		return txtPage_2;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 3
	 */
	public String getTxtPage_3()
	{
		return txtPage_3;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 4
	 */
	public String getTxtPage_4()
	{
		return txtPage_4;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 5
	 */
	public String getTxtPage_5()
	{
		return txtPage_5;
	}

	/**
	 * Getter for text on a page
	 * @return text for page 6
	 */
	public String getTxtPage_6()
	{
		return txtPage_6;
	}
}