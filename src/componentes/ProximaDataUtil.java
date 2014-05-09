package componentes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProximaDataUtil {

	public static void main(String[] args) {
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date atual = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(atual);
//		cal.add(Calendar.DATE, +1);
		
		if (cal.get(Calendar.DAY_OF_WEEK) == 7)
			cal.add(Calendar.DATE, +2);
		else if (cal.get(Calendar.DAY_OF_WEEK) == 1)
			cal.add(Calendar.DATE, +1);
		
		System.out.println(sdf.format((cal).getTime()));
		
	}
}
