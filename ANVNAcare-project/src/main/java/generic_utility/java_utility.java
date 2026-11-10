package generic_utility;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class java_utility {
	public static String getcurrentdatetime() {
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("hhmmss_ddMMyyyy");
		String time=now.format(dtf);
		return time;
		
		
	}

}
