package componentes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NextDay {

	public static void main(String[] args) {
		
	
	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date atual = new Date();
	Calendar cal = new GregorianCalendar();
	cal.setTime(atual);
	cal.add(Calendar.DATE, +1);
	
	System.out.println(sdf.format((cal).getTime()));
	
	}
}
