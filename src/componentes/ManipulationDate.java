package componentes;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class ManipulationDate {

	public static void main(String[] args)  throws ParseException {

				
		DateFormat sdf  = new SimpleDateFormat("dd-MM-yyyy");
		String banco = "19-03-85";
		
		Calendar cal = new GregorianCalendar();
		System.out.println(banco);
		Date d1 = new Date(sdf.parse(banco).getTime());
		Date atual = new Date();
		cal.setTime(d1);
		cal.add(Calendar.MONTH, -1);
		Date vigencia = new Date(sdf.parse(banco).getTime());
		
		
		System.out.println("Atual: "+sdf.format(atual));
		System.out.println("Mes Anterior: "+sdf.format((cal).getTime()));
		System.out.println("Vigencia: "+sdf.format(vigencia));
		System.out.println(d1);

		
		if (banco.length() > 3) {

			if(sdf.format(atual).equalsIgnoreCase(sdf.format(vigencia)))
				System.out.println("iguais");
			if((cal.getTime().before(atual) && vigencia.after(atual)) || sdf.format(atual).equalsIgnoreCase(sdf.format(vigencia)))
			{
				System.out.println("Sua vigencia expira:"+sdf.format(vigencia));
			}else if(vigencia.before(atual)){
				System.out.println("Vigencia expirou em "+sdf.format(vigencia));
			}else
				System.out.println("Vigencia tem mais de 1 mes para expirar");	
		} else
		System.out.println("Erro: tamanha inválido");
	}
}