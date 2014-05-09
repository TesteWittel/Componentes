package componentes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataAnterior {

	public static void main(String[] args) throws Exception {
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String banco = "2012-10-05 03:00:00";
		Integer dia = 21;
		String n = Integer.toString(dia);
		Date d1 = new Date();
		Date atual = new Date();
//		Calendar cal = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
//		cal.setTime(d1);
//		cal.add(Calendar.DAY_OF_MONTH, -2);
//		Date limite = new Date(sdf.parse(banco).getTime());
//		int n = Integer.parseInt(dia);
		d.set(Calendar.DAY_OF_MONTH, dia);
		Date consulta = new Date();
			Calendar cal = Calendar.getInstance();  
			cal.setTime(atual);
			cal.setTime(d1);
	        cal.set(Calendar.DAY_OF_MONTH, dia);   
//	        cal.set(Calendar.MONTH, Integer.parseInt(month));   
//	        cal.set(Calendar.YEAR, Integer.parseInt(year));   

		
	System.out.println(sdf.format((cal).getTime()));
	System.out.println("Atual: "+sdf.format(atual));
//	System.out.println("Vigencia: "+sdf.format(limite));
	System.out.println(isDiaUtil(cal));
	cal.setTime(d1);
	cal.add(Calendar.DAY_OF_MONTH, -2);//limite
	
	if(dia >= 1 && dia <= 31){
		d.setTime(consulta);
        d.set(Calendar.DAY_OF_MONTH, dia);
	}
		if(!(consulta.before(atual) && dia < 31)){
			cal.setTime(d1);
			cal.add(Calendar.DAY_OF_MONTH, -2);//limite
		}if(!(consulta.after(atual) && dia >1)){
			if(cal.getTime().after(consulta)){
				System.out.println(consulta);
			}else{
				cal.setTime(d1);
				cal.set(Calendar.MONTH, 10);
				System.out.println(consulta);
			}
		}
		
	}
			
//	if(sdf.format(atual).equalsIgnoreCase(sdf.format(limite))){
//		System.out.println("IguaL");
//		cal.setTime(d1);
//		cal.set(Calendar.MONTH, 10);
//		System.out.println(sdf.format((cal).getTime()));
//	}
//	else{
//		System.out.println("Falso");
//		cal.setTime(d1);
//		cal.add(Calendar.DAY_OF_MONTH, -2);//limite
//		System.out.println(sdf.format((cal).getTime()));
//	}	
//	if(isDiaUtil(cal)==false)
//		System.out.println("Dia Inválido");
//	else
//			System.out.println("Válido");
	
	
	public static boolean isDiaUtil(Calendar cal) {   
        return !((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY));   
    } 
}