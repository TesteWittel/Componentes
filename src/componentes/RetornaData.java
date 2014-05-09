package componentes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RetornaData {

	public static void main(String[] args) {
		
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dia = "21";
		Integer nDia = Integer.parseInt(dia);
		Date atual = new Date();
		Date consulta = new Date();
		Date limite = new Date();
		Calendar cal = Calendar.getInstance();  
		
		
		System.out.println(sdf.format(cal.getTime()));
		cal.set(Calendar.MONTH, 1);
		
		cal.setTime(consulta);
		cal.set(Calendar.DAY_OF_MONTH, nDia);
		consulta = cal.getTime();
		
		System.out.println(sdf.format(atual));
		
		if(nDia >= 1 && nDia <= 31){
			System.out.println("Válido");
			if(consulta.after(atual) || consulta.equals(atual) && nDia <= 31){
				System.out.println(sdf.format(consulta));
				System.out.println("Igual");
			}else{
				cal.setTime(limite);
				cal.add(Calendar.DAY_OF_MONTH, -2);//limite
				limite = cal.getTime();
//				System.out.println(sdf.format(limite));
				System.out.println("Diferente");
			
			if(consulta.before(atual) && nDia >=1){
					System.out.println("Valido Mes");
					if(limite.before(consulta) || limite.equals(consulta)){
						cal.setTime(consulta);
							if(isDiaUtil(cal)){
								
								System.out.println(sdf.format(consulta));
							}else{
								System.out.println("Domingo");
					}}else{
						cal.setTime(consulta);
						cal.add(Calendar.MONTH, 1);//limite
						consulta = cal.getTime();
						if(isDiaUtil(cal)){
							System.out.println(sdf.format(consulta));
							System.out.println("Mes acima");
						}else{
							System.out.println("Domingo");
					}
		    	}}else{
		    		System.out.println(sdf.format(consulta));
		    		System.out.println("Invalido Mes");
		    	}
			}}
		else
			System.out.println("Inválido");
	}
	public static boolean isDiaUtil(Calendar cal) {   
        return !((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY));   
    } 
}