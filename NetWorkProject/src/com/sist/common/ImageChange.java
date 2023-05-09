package com.sist.common;
import java.awt.*;

import javax.swing.ImageIcon;
public class ImageChange {
	public static Image getImage(ImageIcon i1,int width, int height) {
		Image deimg = i1.getImage().
				getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return deimg;
	}
}
