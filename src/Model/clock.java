/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author quality2016
 */
public class clock {
	private int hour;
	private int minutes;
	private int seconds;

	public clock() {
		System.out.println(LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":"
				+ LocalDateTime.now().getSecond());
	}

	public String getTime() {
		return (LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":"
				+ LocalDateTime.now().getSecond());
	}
}
