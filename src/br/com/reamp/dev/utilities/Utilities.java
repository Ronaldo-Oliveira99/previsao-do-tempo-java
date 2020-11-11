package br.com.reamp.dev.utilities;

import java.sql.Date;

public class Utilities {
	
	public void setDates(int timeStamp) {
		
		Date date = new Date(timeStamp);
		date.setTime((int)timeStamp*1000);
		
	}

}
