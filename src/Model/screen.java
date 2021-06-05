/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class screen {
	String diabeticName;
	boolean power;
	self_test test;
	buffer_msgs msg;
	clock time;

	public void switchDeviceOn() {
		power = true;
	}

	public void displayMsgs() {
		ArrayList<String> availableMsgs = msg.getBufferedMsgs();
		for (String message : availableMsgs) {
			System.out.println(message);
		}
	}

	public void refreshDisplay() {
		time = new clock();
		System.out.println(time.getTime());
		displayMsgs();
	}

	public clock getTime() {
		time = new clock();
		return time;
	}

	void displaymessage1() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

}
