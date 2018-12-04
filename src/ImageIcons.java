/* 
 * 1410 Team Assignment
 * by Ahmed Alghafli, Nathan Goldhardt, Tyler Shaw 
 * 12/6/16
 */

import javax.swing.ImageIcon;
/**
 * ImageIcons is an object that stores instantiated ImageIcons for use in an interactive storybook. The ImageIcons are public, so if you know the name, you can get the file.
 * No parameters needed.
 */
public class ImageIcons
{
	public ImageIcon main_title = new ImageIcon(AppInterface.class.getResource("/Image/main_title.png"));
	public ImageIcon page0 = new ImageIcon(AppInterface.class.getResource("/Image/page0.png"));
	public ImageIcon page1 = new ImageIcon(AppInterface.class.getResource("/Image/page1.png"));
	public ImageIcon page2 = new ImageIcon(AppInterface.class.getResource("/Image/page2.png"));
	public ImageIcon page3 = new ImageIcon(AppInterface.class.getResource("/Image/page3.png"));
	public ImageIcon page4 = new ImageIcon(AppInterface.class.getResource("/Image/page4.png"));
	public ImageIcon page5 = new ImageIcon(AppInterface.class.getResource("/Image/page5.png"));
	public ImageIcon page6 = new ImageIcon(AppInterface.class.getResource("/Image/page6.png"));

	public ImageIcons()
	{}
}
