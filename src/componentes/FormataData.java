package componentes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormataData {

	public static void main(String[] args) throws ParseException {
		
		String banco = "19-MAR-13";
		
		
		if(banco.contains("JAN")){
			banco = banco.replace("JAN", "01");
			System.out.println(banco);
		}else
			if(banco.contains("FEB")){
				banco = banco.replace("FEB", "02");
				System.out.println(banco);
			}else
				if(banco.contains("MAR")){
					banco = banco.replace("MAR", "03");
					System.out.println(banco);
				}else
					if(banco.contains("APR")){
						banco = banco.replace("APR", "04");
						System.out.println(banco);
					}else
						if(banco.contains("MAY")){
							banco = banco.replace("MAY", "05");
							System.out.println(banco);
						}else
							if(banco.contains("JUN")){
								banco = banco.replace("JUN", "06");
								System.out.println(banco);
							}else
								if(banco.contains("JUL")){
									banco = banco.replace("JUL", "07");
									System.out.println(banco);
								}else
									if(banco.contains("AUG")){
										banco = banco.replace("AUG", "08");
										System.out.println(banco);
									}else
										if(banco.contains("SEP")){
											banco = banco.replace("SEP", "09");
											System.out.println(banco);
										}else
											if(banco.contains("OCT")){
												banco = banco.replace("OCT", "10");
												System.out.println(banco);
											}else
												if(banco.contains("NOV")){
													banco = banco.replace("NOV", "11");
													System.out.println(banco);
												}else
													if(banco.contains("DEC")){
														banco = banco.replace("DEC", "12");
														System.out.println(banco);
													}
		
		
	System.out.println(banco);
	String b = retornaAudio(banco);
	String a = retornaFull(banco);
	System.out.println(a);
	System.out.println(b);
		
	}
		
		public static String retornaFull(String banco) throws ParseException{
		
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date dt = new Date(df.parse(banco).getTime());
			
			banco = df.format(dt);
			if(banco.contains("00")){
				banco = banco.replace("00", "20");
			}
//			System.out.println(banco);
//			System.out.println("retorna completa");
			
			return banco;
		}
		
		public static String retornaAudio(String banco) throws ParseException{
			
			banco = banco.replace("-", "");
			
			return banco;
		}
		}		
