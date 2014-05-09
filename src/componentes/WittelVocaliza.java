package componentes;

import java.util.HashMap;

import com.audium.server.sayitsmart.SayItSmartBase;
import com.audium.server.sayitsmart.SayItSmartContent;
import com.audium.server.sayitsmart.SayItSmartDependency;
import com.audium.server.sayitsmart.SayItSmartDisplay;
import com.audium.server.sayitsmart.SayItSmartException;
import com.audium.server.sayitsmart.SayItSmartPlugin;

public class WittelVocaliza extends SayItSmartBase
    implements SayItSmartPlugin
{

    public void SpellingSayItSmart()
    {
    }

    public SayItSmartDisplay getDisplayInformation()
        throws SayItSmartException
    {
        String description = "This Example Say It Smart plugin spells data passed to it as input.";
        SayItSmartDisplay toReturn = new SayItSmartDisplay("spelling", "Soletrar Letras Mai\372culas & Min\372sculas", description);
        toReturn.addInputFormat("alphanum", "Alfanum\351rico", "The input data contains only alphanumeric characters, no punctuation (not even spaces or underscores).");
        toReturn.addInputFormat("all_char", "Alfanum\351rico com Pontua\347\343o", "The input data contains any character found in on a standard English keyboard. This is not ASCII as it covers only standard punctuation, not all 256 ASCII values.");
        toReturn.addOutputFormat("alpha_char", "Car\341cter a Car\341cter", "The output will be read back character by character.");
        toReturn.addOutputFormat("character", "Car\341cter a Car\341cter", "The output will be read back character by character.");
        toReturn.addFileset("alpha_fast", "Velocidade (Normal)", "This fileset speaks the output in a normal speed.");
        toReturn.addFileset("character_fast", "Velocidade (Normal)", "This fileset speaks the output in a normal speed.");
        return toReturn;
    }

    public SayItSmartDependency getFormatDependencies()
        throws SayItSmartException
    {
        SayItSmartDependency toReturn = new SayItSmartDependency("alphanum", new String[] {
            "alpha_char"
        });
        toReturn.addParent("all_char", new String[] {
            "character"
        });
        return toReturn;
    }

    public SayItSmartDependency getFilesetDependencies()
        throws SayItSmartException
    {
        SayItSmartDependency toReturn = new SayItSmartDependency("alpha_char", new String[] {
            "alpha_fast"
        });
        toReturn.addParent("character", new String[] {
            "character_fast"
        });
        return toReturn;
    }

    public SayItSmartContent convertToFiles(Object dataAsObject, String inputFormat, String outputFormat, String fileset)
        throws SayItSmartException
    {
        validateArguments(dataAsObject, inputFormat, outputFormat, fileset);
        String data = dataAsObject.toString();
        SayItSmartContent toReturn = new SayItSmartContent();
        int index;
        boolean asInOn;
        if(outputFormat.compareTo("alpha_char") == 0 || outputFormat.compareTo("character") == 0)
        {
            index = 1;
            asInOn = false;
        } else
        {
            index = 2;
            asInOn = true;
        }
        String outputPostfix = null;
        for(int i = 0; i < data.length(); i++)
        {
            char theChar = data.charAt(i);
            if(Character.isLetter(theChar) && asInOn)
                outputPostfix = "_as_in";
            else
                outputPostfix = "";
            String filsetPostfix;
            if(Character.isUpperCase(theChar))
                filsetPostfix = "_uppercase";
            else
            if(Character.isLetter(theChar))
                filsetPostfix = "_lowercase";
            else
                filsetPostfix = "";
            Object wordsAsObject = CHARACTERS.get(new Character(theChar));
            if(wordsAsObject == null)
                throw new SayItSmartException((new StringBuilder("Say It Smart Spelling Error - The input data \"")).append(data).append("\" must contain only characters found on a standard ").append("English keyboard in order to work with the \"").append(inputFormat).append("\" input format.").toString());
            if(inputFormat.compareTo("all_char") == 0)
            {
                String words[] = (String[])wordsAsObject;
                toReturn.add((new StringBuilder(String.valueOf(words[0]))).append(outputPostfix).append(filsetPostfix).toString(), words[index], false);
            } else
            if(Character.isLetterOrDigit(theChar))
            {
                String words[] = (String[])CHARACTERS.get(new Character(theChar));
                toReturn.add((new StringBuilder(String.valueOf(words[0]))).append(outputPostfix).append(filsetPostfix).toString(), words[index], false);
            } else
            {
                throw new SayItSmartException((new StringBuilder("Say It Smart Spelling Error - The input data \"")).append(data).append("\" must contain only letters and numbers in order ").append("work with the \"").append(inputFormat).append("\" input format.").toString());
            }
        }

        return toReturn;
    }

    public static void main(String args[])
        throws SayItSmartException
    {
        SpellingSayItSmart spell = new SpellingSayItSmart();
        System.out.println((new StringBuilder("\nData: abc123            Input Format: alphanum      Output Format: alpha_char       Fileset: alpha_fast         \nResult: ")).append(spell.convertToFiles("abc123", "alphanum", "alpha_char", "alpha_fast")).toString());
        System.out.println((new StringBuilder("\nData: Audiumcorp.com    Input Format: all_char      Output Format: character        Fileset: character_fast     \nResult: ")).append(spell.convertToFiles("Audiumcorp.com", "all_char", "character", "character_fast")).toString());
        try
        {
            System.out.println((new StringBuilder("\nData: abc 123         Input Format: alphanum        Output Format: alpha_char          Fileset: alpha_fast     \nResult:")).append(spell.convertToFiles("abc 123", "alphanum", "alpha_char", "alpha_fast")).toString());
        }
        catch(SayItSmartException e)
        {
            System.out.println((new StringBuilder("\nData: abc 123         Input Format: alphanum        Output Format: alpha_char          Fileset: alpha_fast     \nThis caused an error: ")).append(e).toString());
        }
        try
        {
            System.out.println((new StringBuilder("\nData: abc123          Input Format: alphanum        Output Format: character           Fileset: alpha_fast     \nResult:")).append(spell.convertToFiles("abc123", "alphanum", "character", "alpha_fast")).toString());
        }
        catch(SayItSmartException e)
        {
            System.out.println((new StringBuilder("\nData: abc123          Input Format: alphanum        Output Format: character           Fileset: alpha_fast     \nThis caused an error: ")).append(e).toString());
        }
        try
        {
            System.out.println((new StringBuilder("\nData: null            Input Format: all_char        Output Format: character           Fileset: character_fast  \nResult:")).append(spell.convertToFiles(null, "all_char", "character", "character_fast")).toString());
        }
        catch(SayItSmartException e)
        {
            System.out.println((new StringBuilder("\nData: null            Input Format: all_char        Output Format: character           Fileset: character_fast  \nThis caused an error: ")).append(e).toString());
        }
        try
        {
            System.out.println((new StringBuilder("\nData: 39\242             Input Format: all_char        Output Format: character           Fileset: character_fast  \nResult:")).append(spell.convertToFiles("39\242", "all_char", "character", "character_fast")).toString());
        }
        catch(SayItSmartException e)
        {
            System.out.println((new StringBuilder("\nData: 39\242             Input Format: all_char        Output Format: character           Fileset: character_fast  \nThis caused an error: ")).append(e).toString());
        }
    }

    public static final String ALPHANUM_INPUT_FORMAT = "alphanum";
    public static final String CHARACTER_INPUT_FORMAT = "all_char";
    public static final String ALPHANUM_OUTPUT_FORMAT = "alpha_char";
    public static final String CHARACTER_OUTPUT_FORMAT = "character";
    public static final String ALPHANUM_FAST_FILESET = "alpha_fast";
    public static final String CHARACTER_FAST_FILESET = "character_fast";
    public static final String CHARACTER_SLOW_FILESET = "character_slow";
    public static final String CHARACTER_AS_FAST_FILESET = "character_as_fast";
    public static final String CHARACTER_AS_SLOW_FILESET = "character_as_slow";
    public static final String ALPHANUM_INPUT_FORMAT_DISPLAY = "Alfanum\351rico";
    public static final String CHARACTER_INPUT_FORMAT_DISPLAY = "Alfanum\351rico com Pontua\347\343o";
    public static final String ALPHANUM_OUTPUT_FORMAT_DISPLAY = "Car\341cter a Car\341cter";
    public static final String CHARACTER_OUTPUT_FORMAT_DISPLAY = "Car\341cter a Car\341cter";
    public static final String ALPHANUM_FAST_FILESET_DISPLAY = "Velocidade (Normal)";
    public static final String CHARACTER_FAST_FILESET_DISPLAY = "Velocidade (Normal)";
    public static final String ALPHANUM_INPUT_FORMAT_DESCRIPTION = "The input data contains only alphanumeric characters, no punctuation (not even spaces or underscores).";
    public static final String CHARACTER_INPUT_FORMAT_DESCRIPTION = "The input data contains any character found in on a standard English keyboard. This is not ASCII as it covers only standard punctuation, not all 256 ASCII values.";
    public static final String ALPHANUM_OUTPUT_FORMAT_DESCRIPTION = "The output will be read back character by character.";
    public static final String CHARACTER_OUTPUT_FORMAT_DESCRIPTION = "The output will be read back character by character.";
    public static final String ALPHANUM_FAST_FILESET_DESCRIPTION = "This fileset speaks the output in a normal speed.";
    public static final String CHARACTER_FAST_FILESET_DESCRIPTION = "This fileset speaks the output in a normal speed.";
    public static HashMap CHARACTERS;

    static 
    {
        CHARACTERS = new HashMap();
        CHARACTERS.put(new Character('1'), new String[] {
            "1", "one", "one"
        });
        CHARACTERS.put(new Character('2'), new String[] {
            "2", "two", "two"
        });
        CHARACTERS.put(new Character('3'), new String[] {
            "3", "three", "three"
        });
        CHARACTERS.put(new Character('4'), new String[] {
            "4", "four", "four"
        });
        CHARACTERS.put(new Character('5'), new String[] {
            "5", "five", "five"
        });
        CHARACTERS.put(new Character('6'), new String[] {
            "6", "six", "six"
        });
        CHARACTERS.put(new Character('7'), new String[] {
            "7", "seven", "seven"
        });
        CHARACTERS.put(new Character('8'), new String[] {
            "8", "eight", "eight"
        });
        CHARACTERS.put(new Character('9'), new String[] {
            "9", "nine", "nine"
        });
        CHARACTERS.put(new Character('0'), new String[] {
            "0", "zero", "zero"
        });
        CHARACTERS.put(new Character('a'), new String[] {
            "a", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('A'), new String[] {
            "A", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('b'), new String[] {
            "b", "bee", "bee as in bill"
        });
        CHARACTERS.put(new Character('B'), new String[] {
            "B", "bee", "bee as in bill"
        });
        CHARACTERS.put(new Character('c'), new String[] {
            "c", "cee", "cee as in charlie"
        });
        CHARACTERS.put(new Character('C'), new String[] {
            "C", "cee", "cee as in charlie"
        });
        CHARACTERS.put(new Character('d'), new String[] {
            "d", "dee", "dee as in david"
        });
        CHARACTERS.put(new Character('D'), new String[] {
            "D", "dee", "dee as in david"
        });
        CHARACTERS.put(new Character('e'), new String[] {
            "e", "ee", "ee as in edgar"
        });
        CHARACTERS.put(new Character('E'), new String[] {
            "E", "ee", "ee as in edgar"
        });
        CHARACTERS.put(new Character('f'), new String[] {
            "f", "ef", "ef as in frank"
        });
        CHARACTERS.put(new Character('F'), new String[] {
            "F", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('g'), new String[] {
            "g", "gee", "gee as in george"
        });
        CHARACTERS.put(new Character('G'), new String[] {
            "G", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('h'), new String[] {
            "h", "aych", "aych as in henry"
        });
        CHARACTERS.put(new Character('H'), new String[] {
            "H", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('i'), new String[] {
            "i", "eye", "eye as in iris"
        });
        CHARACTERS.put(new Character('I'), new String[] {
            "I", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('j'), new String[] {
            "j", "jay", "jay as in john"
        });
        CHARACTERS.put(new Character('J'), new String[] {
            "J", "jay", "jay as in john"
        });
        CHARACTERS.put(new Character('k'), new String[] {
            "k", "kay", "kay as in karen"
        });
        CHARACTERS.put(new Character('K'), new String[] {
            "K", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('l'), new String[] {
            "l", "ell", "ell as in larry"
        });
        CHARACTERS.put(new Character('L'), new String[] {
            "L", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('m'), new String[] {
            "m", "em", "em as in michael"
        });
        CHARACTERS.put(new Character('M'), new String[] {
            "M", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('n'), new String[] {
            "n", "en", "en as in nancy"
        });
        CHARACTERS.put(new Character('N'), new String[] {
            "N", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('o'), new String[] {
            "o", "oh", "oh as in oscar"
        });
        CHARACTERS.put(new Character('O'), new String[] {
            "O", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('p'), new String[] {
            "p", "pee", "pee as in paul"
        });
        CHARACTERS.put(new Character('P'), new String[] {
            "P", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('q'), new String[] {
            "q", "que", "que as in quentin"
        });
        CHARACTERS.put(new Character('Q'), new String[] {
            "Q", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('r'), new String[] {
            "r", "are", "are as in robert"
        });
        CHARACTERS.put(new Character('R'), new String[] {
            "R", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('s'), new String[] {
            "s", "ess", "ess as in sam"
        });
        CHARACTERS.put(new Character('S'), new String[] {
            "S", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('t'), new String[] {
            "t", "tee", "tee as in terry"
        });
        CHARACTERS.put(new Character('T'), new String[] {
            "T", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('u'), new String[] {
            "u", "you", "you as in ursula"
        });
        CHARACTERS.put(new Character('U'), new String[] {
            "U", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('v'), new String[] {
            "v", "vee", "vee as in valerie"
        });
        CHARACTERS.put(new Character('V'), new String[] {
            "V", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('w'), new String[] {
            "w", "double you", "double you wendy"
        });
        CHARACTERS.put(new Character('W'), new String[] {
            "W", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('x'), new String[] {
            "x", "ex", "ex as in xray"
        });
        CHARACTERS.put(new Character('X'), new String[] {
            "X", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('y'), new String[] {
            "y", "why", "why as in yankee"
        });
        CHARACTERS.put(new Character('Y'), new String[] {
            "Y", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('z'), new String[] {
            "z", "zee", "zee as in zachery"
        });
        CHARACTERS.put(new Character('Z'), new String[] {
            "Z", "ay", "ay as in albert"
        });
        CHARACTERS.put(new Character('`'), new String[] {
            "grave_accent", "grave accent", "grave accent"
        });
        CHARACTERS.put(new Character('~'), new String[] {
            "til", "tilde", "tilde"
        });
        CHARACTERS.put(new Character('!'), new String[] {
            "exclamacao", "exclamation point", "exclamation point"
        });
        CHARACTERS.put(new Character('@'), new String[] {
            "arroba", "at sign", "at sign"
        });
        CHARACTERS.put(new Character('#'), new String[] {
            "tralha", "pound sign", "pound sign"
        });
        CHARACTERS.put(new Character('$'), new String[] {
            "cifrao", "dollar sign", "dollar sign"
        });
        CHARACTERS.put(new Character('%'), new String[] {
            "porcento", "percent sign", "percent sign"
        });
        CHARACTERS.put(new Character('^'), new String[] {
            "acentocircunflexo", "caret", "caret"
        });
        CHARACTERS.put(new Character('&'), new String[] {
            "ecomercial&", "ampersand", "ampersand"
        });
        CHARACTERS.put(new Character('*'), new String[] {
            "asteristico", "asterisk", "asterisk"
        });
        CHARACTERS.put(new Character('('), new String[] {
            "parentesesesquerdo", "left parenthesis", "left parenthesis"
        });
        CHARACTERS.put(new Character(')'), new String[] {
            "parentesesdireito", "right parenthesis", "right parenthesis"
        });
        CHARACTERS.put(new Character('-'), new String[] {
            "menos", "dash", "dash"
        });
        CHARACTERS.put(new Character('_'), new String[] {
            "sobrelinha", "underscore", "underscore"
        });
        CHARACTERS.put(new Character('='), new String[] {
            "igual", "equal sign", "equal sign"
        });
        CHARACTERS.put(new Character('+'), new String[] {
            "soma", "plus sign", "plus sign"
        });
        CHARACTERS.put(new Character('['), new String[] {
            "colcheteesquerda", "left bracket", "left bracket"
        });
        CHARACTERS.put(new Character('{'), new String[] {
            "chavedireita", "left curly brace", "left curly brace"
        });
        CHARACTERS.put(new Character(']'), new String[] {
            "colchetesdireita", "right bracket", "right bracket"
        });
        CHARACTERS.put(new Character('}'), new String[] {
            "chavedireita", "right curly brace", "right curly brace"
        });
        CHARACTERS.put(new Character('\\'), new String[] {
            "backslash", "backslash", "backslash"
        });
        CHARACTERS.put(new Character('|'), new String[] {
            "barravertical", "veritcal bar", "veritcal bar"
        });
        CHARACTERS.put(new Character(';'), new String[] {
            "semicolon", "semicolon", "semicolon"
        });
        CHARACTERS.put(new Character(':'), new String[] {
            "colon", "colon", "colon"
        });
        CHARACTERS.put(new Character('\''), new String[] {
            "apostrophe", "apostrophe", "apostrophe"
        });
        CHARACTERS.put(new Character('"'), new String[] {
            "double_quote", "double quote", "double quote"
        });
        CHARACTERS.put(new Character(','), new String[] {
            "comma", "comma", "comma"
        });
        CHARACTERS.put(new Character('<'), new String[] {
            "less_than_sign", "less than sign", "less than sign"
        });
        CHARACTERS.put(new Character('.'), new String[] {
            "period", "period", "period"
        });
        CHARACTERS.put(new Character('>'), new String[] {
            "greater_than_sign", "greater than sign", "greater than sign"
        });
        CHARACTERS.put(new Character('/'), new String[] {
            "slash", "slash", "slash"
        });
        CHARACTERS.put(new Character('?'), new String[] {
            "question_mark", "question mark", "question mark"
        });
        CHARACTERS.put(new Character(' '), new String[] {
            "space", "space", "space"
        });
        CHARACTERS.put(new Character('\t'), new String[] {
            "tab", "tab", "tab"
        });
        CHARACTERS.put(new Character('\n'), new String[] {
            "newline", "new line", "new line"
        });
        CHARACTERS.put(new Character('\r'), new String[] {
            "carriage_return", "carriage return", "carriage return"
        });
    }

	@Override
	public String[] getFilesetContents(String arg0) throws SayItSmartException {
		// TODO Auto-generated method stub
		return null;
	}
}
