/**
	 * Desenvolvido por: Wittel
	 * Desenvolvedor: Cleverson Saraiva Pires e Gianluca De Jesus
	 * Data 22/02/2013
	 * 
	 */	

package componentes;

import java.sql.*;
	import com.audium.server.AudiumException;
	import com.audium.server.voiceElement.ActionElementBase;
	import com.audium.server.voiceElement.ElementInterface;
	import com.audium.server.voiceElement.Setting;
	import com.audium.server.voiceElement.ElementData;
	import com.audium.server.voiceElement.ElementException;
	import com.audium.server.xml.ActionElementConfig;
import com.audium.server.session.ActionElementData;


public class WittelExecProcedure_info_cod5 extends ActionElementBase implements ElementInterface  
{
	
//	 This method returns the name of the action element that appears in Studio's Element view
    public String getElementName()
    {
        return "Wittel_ExecProc_Oracle_info_cod5";
    }
	// This method returns the name of a folder that will contain the action element 
	// in Studio's Element view. Use return null if you don't want it in a folder.
    public String getDisplayFolderName()
    {
        return "Wittel";
    }
	// This method returns a description of the element that will display in Studio
	// when the cursor hovers over the element in the Element view
    public String getDescription() 
    {
        return "Este elemento irá retornar a execução da stored procedure";
    }
    
    //This method returns the settings to display in the element's configuration view
	public Setting[] getSettings() throws ElementException 
	 {	 
	 	 //You must define the number of settings here
		 Setting[] settingArray = new Setting[16];
		 
       	//each setting must specify: real name, display name, description,
       	//is it required?, can it only appear once?, does it allow substitution?,
       	//and the type of entry allowed
       	
       	//Note that the settingArray starts indexing at 0
		 settingArray[0] = new Setting("Parametro1", "Valor1", 
						   "Primeiro parametro da Procedure",
						   true,   // It is required
						   true,   // It appears only once
						   true,   // It allows substitution
						   Setting.STRING);
		 
//		 settingArray[1] = new Setting("Parametro2", "Valor2", 
//				  "Segundo parametro da Procedure",
//				  true,   // It is required
//				  true,   // It appears only once
//				  true,   // It allows substitution
//				  Setting.STRING);	
		 settingArray[1] = new Setting("Retorno1", "Saida1", 
				  "Variavel que irá receber o resultado",
				  true,   // It is required
				  true,   // It appears only once
				  true,   // It allows substitution
				  Setting.STRING);	
		 settingArray[1].setDefaultValue("outcodexiste");
		 
		 settingArray[2] = new Setting("Retorno2", "Saida2", 
				  "Variavel que irá receber o resultado",
				  true,   // It is required
				  true,   // It appears only once
				  true,   // It allows substitution
				  Setting.STRING);	
		 settingArray[2].setDefaultValue("outvip");
		 
		 settingArray[3] = new Setting("Retorno3", "Saida3", 
				  "Variavel que irá receber o resultado",
				  true,   // It is required
				  true,   // It appears only once
				  true,   // It allows substitution
				  Setting.STRING);	
		 settingArray[3].setDefaultValue("outcgc");
		 
		 settingArray[4] = new Setting("Retorno4", "Saida4", 
				  "Variavel que irá receber o resultado",
				  true,   // It is required
				  true,   // It appears only once
				  true,   // It allows substitution
				  Setting.STRING);	
		 settingArray[4].setDefaultValue("outnome");
		 
		 settingArray[5] = new Setting("Retorno5", "Saida5", 
				  "Variavel que irá receber o resultado",
				  true,   // It is required
				  true,   // It appears only once
				  true,   // It allows substitution
				  Setting.STRING);	
		 settingArray[5].setDefaultValue("outgv");
		 
		 settingArray[6] = new Setting("Retorno6","Saida6",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[6].setDefaultValue("outtpmerc");
		 
		 
		 settingArray[7] = new Setting("Retorno7","Saida7",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[7].setDefaultValue("outtpneg");
		 
		 settingArray[8] = new Setting("Retorno8","Saida8",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[8].setDefaultValue("outuf");
		
		 settingArray[9] = new Setting("Retorno9","Saida9",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[9].setDefaultValue("outempresa");
		 
		 settingArray[10] = new Setting("Retorno10","Saida10",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[10].setDefaultValue("outsenha");
		 
		 settingArray[11] = new Setting("Retorno11","Saida11",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[11].setDefaultValue("outnumcontratoseguro");
		 
		 settingArray[12] = new Setting("Retorno12","Saida12",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[12].setDefaultValue("outdatafinalvigenciaseguro");
		 
		 settingArray[13] = new Setting("Retorno13","Saida13",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[13].setDefaultValue("outzonavenda");
		 
		 settingArray[14] = new Setting("Retorno14","Saida14",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[14].setDefaultValue("outemail");
		 
		 settingArray[15] = new Setting("Retorno15","Saida15",
				 "Variavel que irá receber o resultado",
				 true,
				 true,
				 true,
				 Setting.STRING);
		 settingArray[15].setDefaultValue("outpvcorpt");
		 
		return settingArray;
	 }

	/**
	 * This method returns an array of ElementData created by the element.
	 * It is not used in CVP 3.1, but is used in CVP4. This method should return null 
	 * if the action element does not create any Element Data.
	 */
    public ElementData[] getElementData() throws ElementException 
    {
        return null;
    }
    
    /**
	 * This is the run time code, executed by CVP VXML Server when it reaches the element 
	 * in the call flow. 
	 */
	public void	doAction(String name, ActionElementData actionData) throws AudiumException
	{ 
		/**
		 * Desenvolvido por: Wittel
		 * Desenvolvedor: Cleverson Saraiva Pires
		 * Data 07/12/2011
		 */
		
		ActionElementConfig config = actionData.getActionElementConfig();
		String codcliente = config.getSettingValue("Parametro1", actionData);
//		String input2 = config.getSettingValue("Parametro2", actionData);		
		String outcodexiste = config.getSettingValue("Retorno1", actionData);
		String outvip = config.getSettingValue("Retorno2", actionData);
		String outcgc = config.getSettingValue("Retorno3", actionData);
		String outnome = config.getSettingValue("Retorno4", actionData);
		String outgv = config.getSettingValue("Retorno5", actionData);
		String outtpmerc = config.getSettingValue("Retorno6", actionData);
		String outtpneg = config.getSettingValue("Retorno7", actionData);
		String outuf = config.getSettingValue("Retorno8", actionData);
		String outempresa = config.getSettingValue("Retorno9", actionData);
		String outsenha = config.getSettingValue("Retorno10", actionData);
		String outnumcontratoseguro = config.getSettingValue("Retorno11", actionData);
		String outdatafinalvigenciaseguro = config.getSettingValue("Retorno12", actionData);
		String outzonavenda = config.getSettingValue("Retorno13", actionData);
		String outemail = config.getSettingValue("Retorno14", actionData);
		String outpvcorpt = config.getSettingValue("Retorno15", actionData);

		
		try {
											
			// Carregando a string do driver de conexÃ£o
            String driver = "oracle.jdbc.OracleDriver";   

            //Metodo estastico para inicializar o driver JDBC (Arquivo inserido em Bibliotecas)   
            Class.forName(driver);   
            
            //Envia ao DriverManagr os dados para conectar ao banco de dados   
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.9.131:1521:XE","system","system");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@serv-crmdbp.ipiranga.com.br:1521:oracrm","uraprd","kradrolha");
                       
            // Procedure a ser executada
            //String SQL = "{CALL TESTE_ORACLE_WITTEL (?, ?, ?, ?, ?, ?)}";
            String SQL = "{CALL ura.pr_info_cod5 (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            
            // Recebe o comando SQL que será executado
            CallableStatement cs = conn.prepareCall(SQL);
            
            // Variaveis de entrada da stored procedure sendo setadas para a execução
//            cs.setInt(1, Integer.parseInt(codcliente));
              cs.setString(1, codcliente);	
//            cs.setInt(2, Integer.parseInt(input2));
            
            // Variaveis de saida da stored procedure sendo setada spara receber os retornos
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.registerOutParameter(10, Types.VARCHAR);
            cs.registerOutParameter(11, Types.VARCHAR);
            cs.registerOutParameter(12, Types.VARCHAR);
            cs.registerOutParameter(13, Types.VARCHAR);
            cs.registerOutParameter(14, Types.VARCHAR);
            cs.registerOutParameter(15, Types.VARCHAR);
            cs.registerOutParameter(16, Types.VARCHAR);
            
            // comando que executa a procedure
            cs.execute();
            
            // Variaveis recebendo o retorno da procedure           
//            Object outParam1 = cs.getInt(3);
//            Object outParam2 = cs.getInt(4);
//            Object outParam3 = cs.getInt(5);
//            String outParam4 = cs.getString(6);
            String outParam1 = cs.getString(2);
            String outParam2 = cs.getString(3);
            String outParam3 = cs.getString(4);
            String outParam4 = cs.getString(5);
            String outParam5 = cs.getString(6);
            String outParam6 = cs.getString(7);
            String outParam7 = cs.getString(8);
            String outParam8 = cs.getString(9);
            String outParam9 = cs.getString(10);
	        String outParam10 = cs.getString(11);
	        String outParam11 = cs.getString(12);
	        String outParam12 = cs.getString(13);
	        String outParam13 = cs.getString(14);
	        String outParam14 = cs.getString(15);
	        String outParam15 = cs.getString(16);
	            
            // Setando os retornos para o componente
            actionData.setElementData(outcodexiste, outParam1);
            actionData.setElementData(outvip, outParam2);
            actionData.setElementData(outcgc, outParam3);
            actionData.setElementData(outnome, outParam4);
            actionData.setElementData(outgv, outParam5);
            actionData.setElementData(outtpmerc, outParam6);
            actionData.setElementData(outtpneg, outParam7);
            actionData.setElementData(outuf, outParam8.toString());
            actionData.setElementData(outempresa, outParam9.toString());
            actionData.setElementData(outsenha, outParam10.toString());
            actionData.setElementData(outnumcontratoseguro, outParam11.toString());
            actionData.setElementData(outdatafinalvigenciaseguro, outParam12.toString());
            actionData.setElementData(outzonavenda, outParam13.toString());
            actionData.setElementData(outemail, outParam14.toString());
            actionData.setElementData(outpvcorpt, outParam15.toString());
            
            //Fechando conexão
            conn.close();
            
			// Tratamento de erro
			}catch (Exception e) {
			
			e.printStackTrace();
			actionData.setElementData(outcodexiste, "Erro");
			actionData.setElementData(outvip, "Erro");
            actionData.setElementData(outcgc, "Erro");
            actionData.setElementData(outnome, "Erro");
        	actionData.setElementData(outgv, "Erro");
			actionData.setElementData(outtpmerc, "Erro");
            actionData.setElementData(outtpneg, "Erro");
            actionData.setElementData(outuf, "Erro");
        	actionData.setElementData(outempresa, "Erro");
			actionData.setElementData(outsenha, "Erro");
            actionData.setElementData(outnumcontratoseguro, "Erro");
            actionData.setElementData(outdatafinalvigenciaseguro, "Erro");
        	actionData.setElementData(outzonavenda, "Erro");
			actionData.setElementData(outemail, "Erro");
            actionData.setElementData(outpvcorpt, "Erro");
		}	
	}
}
