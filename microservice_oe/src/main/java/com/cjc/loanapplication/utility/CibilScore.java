package com.cjc.loanapplication.utility;

import java.util.Random;

public class CibilScore {
	
	public static Long cibilScore()
	{
		Random r=new Random();
		Long cb=r.nextLong(650,900);
		
		return cb;
	}

}
