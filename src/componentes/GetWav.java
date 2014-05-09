package componentes;

import com.audium.server.AudiumException;
import com.audium.server.session.ActionElementData;
import com.audium.server.voiceElement.*;
import com.audium.server.xml.ActionElementConfig;
import java.util.ArrayList;
import java.util.Collections;

public class GetWav extends ActionElementBase
    implements ElementInterface
{

    public GetWav()
    {
    }

    public String getElementName()
    {
        return "WittelSayBrazilianCurrency";
    }

    public String getDisplayFolderName()
    {
        return "Wittel";
    }

    public String getDescription()
    {
        return "Este elemento ir\341 retornar o Wave a ser tocado";
    }

    public Setting[] getSettings()
        throws ElementException
    {
        Setting settingArray[] = new Setting[13];
        settingArray[0] = new Setting("Entrada", "Valor", "Este \351 o valor a ser transformado em wav", true, true, true, 3);
        settingArray[1] = new Setting("Retorno", "NomeVariavel", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[1].setDefaultValue("resultado");
        settingArray[2] = new Setting("Retorno2", "NomeVariavel2", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[2].setDefaultValue("resultado2");
        settingArray[3] = new Setting("Retorno3", "NomeVariavel3", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[3].setDefaultValue("resultado3");
        settingArray[4] = new Setting("Retorno4", "NomeVariavel4", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[4].setDefaultValue("resultado4");
        settingArray[5] = new Setting("Retorno5", "NomeVariavel5", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[5].setDefaultValue("resultado5");
        settingArray[6] = new Setting("Retorno6", "NomeVariavel6", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[6].setDefaultValue("resultado6");
        settingArray[7] = new Setting("Retorno7", "NomeVariavel7", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[7].setDefaultValue("resultado7");
        settingArray[8] = new Setting("Retorno8", "NomeVariavel8", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[8].setDefaultValue("resultado8");
        settingArray[9] = new Setting("Retorno9", "NomeVariavel9", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[9].setDefaultValue("resultado9");
        settingArray[10] = new Setting("Retorno10", "NomeVariavel10", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[10].setDefaultValue("resultado10");
        settingArray[11] = new Setting("Retorno11", "NomeVariavel11", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[11].setDefaultValue("resultado11");
        settingArray[12] = new Setting("Retorno12", "NomeVariavel12", "Variavel que ir\341 receber o resultado", true, true, true, 3);
        settingArray[12].setDefaultValue("resultado12");
        return settingArray;
    }

    public ElementData[] getElementData()
        throws ElementException
    {
        return null;
    }

    public void doAction(String name, ActionElementData actionData)
        throws AudiumException
    {
        try
        {
            GetWav acessoMetodos = new GetWav();
            ArrayList setRetornoArray = new ArrayList();
            String sub = "";
            ActionElementConfig config = actionData.getActionElementConfig();
            String input = config.getSettingValue("Entrada", actionData);
            String resultName = config.getSettingValue("Retorno", actionData);
            String resultName2 = config.getSettingValue("Retorno2", actionData);
            String resultName3 = config.getSettingValue("Retorno3", actionData);
            String resultName4 = config.getSettingValue("Retorno4", actionData);
            String resultName5 = config.getSettingValue("Retorno5", actionData);
            String resultName6 = config.getSettingValue("Retorno6", actionData);
            String resultName7 = config.getSettingValue("Retorno7", actionData);
            String resultName8 = config.getSettingValue("Retorno8", actionData);
            String resultName9 = config.getSettingValue("Retorno9", actionData);
            String resultName10 = config.getSettingValue("Retorno10", actionData);
            String resultName11 = config.getSettingValue("Retorno11", actionData);
            String resultName12 = config.getSettingValue("Retorno12", actionData);
            String reais = acessoMetodos.getReais(input);
            sub = acessoMetodos.verificaGrupoTresAlgarismos(reais);
            setRetornoArray = acessoMetodos.converteNumerosEmWav(sub, input);
            setRetornoArray = acessoMetodos.setCentavos(setRetornoArray, input);
            String sub1 = ((String)setRetornoArray.get(0)).toString();
            actionData.setElementData(resultName, sub1);
            if(((String)setRetornoArray.get(1)).toString() != "")
            {
                String sub2 = ((String)setRetornoArray.get(1)).toString();
                actionData.setElementData(resultName2, sub2);
            }
            if(((String)setRetornoArray.get(2)).toString() != "")
            {
                String sub3 = ((String)setRetornoArray.get(2)).toString();
                actionData.setElementData(resultName3, sub3);
            }
            if(((String)setRetornoArray.get(3)).toString() != "")
            {
                String sub4 = ((String)setRetornoArray.get(3)).toString();
                actionData.setElementData(resultName4, sub4);
            }
            if(((String)setRetornoArray.get(4)).toString() != "")
            {
                String sub5 = ((String)setRetornoArray.get(4)).toString();
                actionData.setElementData(resultName5, sub5);
            }
            if(((String)setRetornoArray.get(5)).toString() != "")
            {
                String sub6 = ((String)setRetornoArray.get(5)).toString();
                actionData.setElementData(resultName6, sub6);
            }
            if(((String)setRetornoArray.get(6)).toString() != "")
            {
                String sub7 = ((String)setRetornoArray.get(6)).toString();
                actionData.setElementData(resultName7, sub7);
            }
            if(((String)setRetornoArray.get(7)).toString() != "")
            {
                String sub8 = ((String)setRetornoArray.get(7)).toString();
                actionData.setElementData(resultName8, sub8);
            }
            if(((String)setRetornoArray.get(8)).toString() != "")
            {
                String sub9 = ((String)setRetornoArray.get(8)).toString();
                actionData.setElementData(resultName9, sub9);
                if(((String)setRetornoArray.get(9)).toString() != "")
                {
                    String sub10 = ((String)setRetornoArray.get(9)).toString();
                    actionData.setElementData(resultName10, sub10);
                }
                if(((String)setRetornoArray.get(10)).toString() != "")
                {
                    String sub11 = ((String)setRetornoArray.get(10)).toString();
                    actionData.setElementData(resultName11, sub11);
                }
                if(((String)setRetornoArray.get(11)).toString() != "")
                {
                    String sub12 = ((String)setRetornoArray.get(11)).toString();
                    actionData.setElementData(resultName12, sub12);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            actionData.setElementData("status", "failure");
        }
    }

    public ArrayList converteNumerosEmWav(String valor, String input)
    {
        GetWav acessoMetodos = new GetWav();
        ArrayList insereWav = new ArrayList();
        String recebeCasasDecimais = "";
        String recebeWav = "";
        int tamanhoValor = valor.length();
        if(input.equals("0") | input.equals("0.0") | input.equals("00"))
        {
            insereWav.add("000.wav");
            insereWav.add("Real.wav");
            return insereWav;
        }
        if(input.length() > 1 && (tamanhoValor == 0) | valor.contains(" ") | input.substring(0, 2).contains("0."))
            return insereWav;
        if((tamanhoValor == 0) | valor.contains(" "))
            return insereWav;
        for(int i = 0; i <= tamanhoValor; i++)
        {
            recebeWav = valor.substring(tamanhoValor - 3, tamanhoValor);
            if(valor.substring(tamanhoValor - 3, tamanhoValor).contains("000"))
            {
                tamanhoValor -= 3;
            } else
            {
                recebeCasasDecimais = getCasasDecimas(i, valor.substring(tamanhoValor - 3, tamanhoValor));
                insereWav.add(recebeCasasDecimais);
                if(!(recebeCasasDecimais.equals("Mil.wav") & recebeWav.toString().equals("001")))
                    insereWav.add((new StringBuilder(String.valueOf(recebeWav))).append(".wav").toString());
                if((i == 0) & (tamanhoValor > 3) && insereWav.toString().substring(3, 4).equals("0") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("100") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("200") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("300") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("400") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("500") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("600") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("700") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("800") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("900"))
                    insereWav.add("e.wav");
                if(recebeCasasDecimais.equals("Mil.wav") && recebeWav.substring(0, 1).equals("0") & recebeWav.substring(2, 3).equals("0") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("100") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("200") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("300") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("400") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("500") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("600") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("700") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("800") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("900") && insereWav.get(0).equals("Mil.wav"))
                    insereWav.add("e.wav");
                if(recebeCasasDecimais.equals("Milhao.wav") | recebeCasasDecimais.equals("Milhoes.wav") && recebeWav.substring(0, 1).equals("0") & recebeWav.substring(2, 3).equals("0") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("100") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("200") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("300") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("400") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("500") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("600") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("700") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("800") | valor.substring(tamanhoValor - 3, tamanhoValor).contains("900") && insereWav.get(0).equals("Milhao.wav") | insereWav.get(0).equals("Milhoes.wav"))
                    insereWav.add("e.wav");
                tamanhoValor -= 3;
            }
        }

        insereWav = acessoMetodos.getInverteArray(insereWav);
        insereWav = acessoMetodos.setDeReais(insereWav);
        return insereWav;
    }

    public String verificaGrupoTresAlgarismos(String valor)
    {
        int verificaArray = valor.length();
        for(int i = 0; i < verificaArray; i++)
        {
            if(verificaArray % 3 == 0)
                break;
            valor = (new StringBuilder("0")).append(valor).toString();
            verificaArray = valor.length();
        }

        return valor;
    }

    public String getCasasDecimas(int posicao, String valor)
    {
        String retorno = "";
        if(posicao == 1)
            retorno = "Mil.wav";
        if(posicao == 2)
            if(valor.contains("001"))
                retorno = "Milhao.wav";
            else
                retorno = "Milhoes.wav";
        if(posicao == 3)
            if(valor.contains("001"))
                retorno = "Bilhao.wav";
            else
                retorno = "Bilhoes.wav";
        return retorno;
    }

    public ArrayList getInverteArray(ArrayList Audios)
    {
        if(Audios.contains(""))
            Audios.remove("");
        Collections.reverse(Audios);
        if(Audios.get(0).equals("e.wav"))
            Audios.remove("e.wav");
        if(Audios.isEmpty() | Audios.contains(" ") | Audios.contains(""))
            Audios.add(" ");
        return Audios;
    }

    public ArrayList setDeReais(ArrayList vetor)
    {
        int tamanhoVetor = vetor.size();
        if((tamanhoVetor == 1) & vetor.get(0).toString().equals("001.wav"))
        {
            vetor.add("Real.wav");
            return vetor;
        }
        if(tamanhoVetor == 2 && vetor.get(tamanhoVetor - 1).equals("Bilhao.wav") || vetor.get(tamanhoVetor - 1).equals("Bilhoes.wav") || vetor.get(tamanhoVetor - 1).equals("Milhoes.wav") || vetor.get(tamanhoVetor - 1).equals("Milhao.wav"))
        {
            vetor.add("DeReais.wav");
            return vetor;
        } else
        {
            vetor.add("Reais.wav");
            return vetor;
        }
    }

    public ArrayList setCentavos(ArrayList vetor, String valor)
    {
        GetWav acessoMetodos = new GetWav();
        String sub = acessoMetodos.getCentavos(valor);
        int tamanhoVetor = vetor.size();
        if(!sub.equals("0") && !sub.equals("00"))
        {
            if(tamanhoVetor != 0)
                vetor.add("e.wav");
            sub = acessoMetodos.verificaGrupoTresAlgarismos(sub);
            vetor.add((new StringBuilder(String.valueOf(sub))).append(".wav").toString());
            if(sub.equals("001"))
                vetor.add("Centavo.wav");
            else
                vetor.add("Centavos.wav");
        }
        return vetor;
    }

    public String getCentavos(String centavos)
    {
        int pos = centavos.indexOf(",");
        int pos1 = centavos.indexOf(".");
        int tamanhoString = 0;
        if(pos > -1)
        {
            String stringPegaReaisVirgula[] = centavos.split(",");
            if(stringPegaReaisVirgula.length == 1)
                return "00";
            centavos = stringPegaReaisVirgula[1];
            tamanhoString = centavos.length();
            if(centavos.equals("00") || centavos.equals("00") || tamanhoString > 2)
                return "00";
            else
                return centavos;
        }
        if(pos1 > -1)
        {
            centavos = centavos.replace(".", ",");
            String stringPegaReaisPonto[] = centavos.split(",");
            if(stringPegaReaisPonto.length == 1)
                return "00";
            centavos = stringPegaReaisPonto[1];
            tamanhoString = centavos.length();
            if(centavos.equals("00") || tamanhoString > 2)
                return "00";
            else
                return centavos;
        } else
        {
            return "00";
        }
    }

    public String getReais(String reais)
    {
        int pos = reais.indexOf(",");
        int pos1 = reais.indexOf(".");
        if(pos > -1)
        {
            String stringPegaReaisVirgula[] = reais.split(",");
            reais = stringPegaReaisVirgula[0];
            return reais;
        }
        if(pos1 > -1)
        {
            reais = reais.replace(".", ",");
            String stringPegaReaisPonto[] = reais.split(",");
            reais = stringPegaReaisPonto[0];
            return reais;
        } else
        {
            return reais;
        }
    }
}
