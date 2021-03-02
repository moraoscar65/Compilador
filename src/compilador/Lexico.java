
package compilador;
import java_cup.runtime.Symbol;
import static compilador.TextAnalizer.erroresLexicos;

/**
 * 
 * @author Jorge-Pc
 */

public class Lexico implements java_cup.runtime.Scanner {

  
  public static final int YYEOF = -1;

 
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int TITULO = 8;
  public static final int YYINITIAL = 0;
  public static final int COMENTARIO2 = 4;
  public static final int CADENA = 6;
  public static final int COMENTARIO1 = 2;

  
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\50\1\46\1\0\2\50\22\0\1\45\1\0\1\44\5\0"+
    "\1\26\1\27\1\35\1\32\1\37\1\33\1\2\1\34\12\1\1\0"+
    "\1\40\1\0\1\25\1\0\1\47\1\0\2\3\1\21\14\3\1\5"+
    "\1\3\1\23\3\3\1\14\4\3\1\43\1\0\1\51\1\0\1\4"+
    "\1\0\1\15\1\3\1\12\1\3\1\11\1\24\2\3\1\17\4\3"+
    "\1\20\1\7\1\16\1\36\1\6\1\3\1\13\3\3\1\22\1\10"+
    "\1\3\1\30\1\0\1\31\43\0\1\42\35\0\1\41\21\0\1\3"+
    "\37\0\1\3\uff0e\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\6\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\1"+
    "\1\17\1\20\1\21\1\22\1\23\1\22\1\21\1\24"+
    "\1\25\1\26\1\27\2\30\2\31\1\32\1\0\5\3"+
    "\1\33\1\34\1\35\1\36\1\37\1\3\1\40\1\41"+
    "\13\3\1\42\3\3\1\43\1\44\1\45";

  private static int [] zzUnpackAction() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\52\0\124\0\176\0\250\0\322\0\374\0\u0126"+
    "\0\u0150\0\u017a\0\u01a4\0\u01ce\0\u01f8\0\322\0\322\0\322"+
    "\0\322\0\322\0\322\0\322\0\u0222\0\322\0\322\0\322"+
    "\0\u024c\0\322\0\322\0\u0276\0\322\0\322\0\u02a0\0\322"+
    "\0\322\0\322\0\322\0\322\0\u02ca\0\u02f4\0\322\0\u031e"+
    "\0\322\0\u0348\0\u0372\0\u039c\0\u03c6\0\u03f0\0\u041a\0\u0126"+
    "\0\322\0\322\0\322\0\u0348\0\u0444\0\u0126\0\u046e\0\u0498"+
    "\0\u04c2\0\u04ec\0\u0516\0\u0540\0\u056a\0\u0594\0\u05be\0\u05e8"+
    "\0\u0612\0\u063c\0\u0126\0\u0666\0\u0690\0\u06ba\0\u0126\0\u0126"+
    "\0\u0126";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\1\7\1\6\1\10\1\6\1\11\6\10\1\12"+
    "\1\10\1\13\2\10\1\14\1\10\1\15\1\10\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\10\1\27\1\30\1\31\1\6\1\32\1\33\2\34"+
    "\1\6\1\34\1\6\46\35\1\36\45\35\1\37\3\35"+
    "\1\40\3\35\44\41\1\42\1\41\1\43\3\41\1\44"+
    "\1\45\1\44\1\46\1\44\20\46\11\44\1\46\6\44"+
    "\1\47\1\50\1\44\1\50\1\51\53\0\1\7\1\52"+
    "\50\0\1\10\1\0\22\10\11\0\1\10\14\0\1\10"+
    "\1\0\3\10\1\53\4\10\1\54\11\10\11\0\1\10"+
    "\14\0\1\10\1\0\12\10\1\55\7\10\11\0\1\10"+
    "\14\0\1\10\1\0\3\10\1\56\16\10\11\0\1\10"+
    "\14\0\1\10\1\0\4\10\1\57\15\10\11\0\1\10"+
    "\14\0\1\10\1\0\22\10\11\0\1\60\47\0\1\61"+
    "\57\0\1\62\54\0\2\34\1\0\1\34\50\0\1\63"+
    "\3\0\1\45\51\0\1\46\1\0\22\46\11\0\1\46"+
    "\61\0\1\50\1\0\1\50\2\0\1\64\51\0\1\10"+
    "\1\0\4\10\1\65\15\10\11\0\1\10\14\0\1\10"+
    "\1\0\15\10\1\66\4\10\11\0\1\10\14\0\1\10"+
    "\1\0\3\10\1\67\16\10\11\0\1\10\14\0\1\10"+
    "\1\0\14\10\1\70\5\10\11\0\1\10\14\0\1\10"+
    "\1\0\15\10\1\71\4\10\11\0\1\10\14\0\1\10"+
    "\1\0\5\10\1\72\14\10\11\0\1\10\14\0\1\10"+
    "\1\0\20\10\1\73\1\10\11\0\1\10\14\0\1\10"+
    "\1\0\15\10\1\74\4\10\11\0\1\10\14\0\1\10"+
    "\1\0\10\10\1\75\11\10\11\0\1\10\14\0\1\10"+
    "\1\0\6\10\1\76\13\10\11\0\1\10\14\0\1\10"+
    "\1\0\6\10\1\77\13\10\11\0\1\10\14\0\1\10"+
    "\1\0\10\10\1\100\11\10\11\0\1\10\14\0\1\10"+
    "\1\0\6\10\1\101\13\10\11\0\1\10\14\0\1\10"+
    "\1\0\7\10\1\102\12\10\11\0\1\10\14\0\1\10"+
    "\1\0\21\10\1\103\11\0\1\10\14\0\1\10\1\0"+
    "\6\10\1\104\13\10\11\0\1\10\14\0\1\10\1\0"+
    "\17\10\1\105\2\10\11\0\1\10\14\0\1\10\1\0"+
    "\10\10\1\106\11\10\11\0\1\10\14\0\1\10\1\0"+
    "\3\10\1\107\16\10\11\0\1\10\14\0\1\10\1\0"+
    "\10\10\1\110\11\10\11\0\1\10\14\0\1\10\1\0"+
    "\4\10\1\111\15\10\11\0\1\10\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1764];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\7\1\7\11\1\1\3\11\1\1\2\11"+
    "\1\1\2\11\1\1\5\11\2\1\1\11\1\1\1\11"+
    "\1\0\6\1\3\11\26\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
String cadena="";
PintarPalabras pintar = new PintarPalabras();



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 146) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 36: 
          { pintar.pintaCeles(yychar,yylength());return new Symbol(Simbolo.contexto, yycolumn,yyline);
          }
        case 38: break;
        case 4: 
          { return new Symbol(Simbolo.igual, yycolumn,yyline);
          }
        case 39: break;
        case 28: 
          { pintar.pintaAzul(yychar,yylength()); yybegin(COMENTARIO1);
          }
        case 40: break;
        case 20: 
          { pintar.pintaNara(yychar,yylength()); cadena+=yytext();
          }
        case 41: break;
        case 16: 
          { pintar.pintaNara(yychar,yylength()); yybegin(CADENA); cadena+= yytext();
          }
        case 42: break;
        case 33: 
          { pintar.pintaMora(yychar,yylength()); return new Symbol(Simbolo.Var, yycolumn,yyline);
          }
        case 43: break;
        case 11: 
          { return new Symbol(Simbolo.divide, yycolumn,yyline);
          }
        case 44: break;
        case 9: 
          { return new Symbol(Simbolo.mas, yycolumn,yyline);
          }
        case 45: break;
        case 7: 
          { return new Symbol(Simbolo.llav_abre, yycolumn,yyline);
          }
        case 46: break;
        case 21: 
          { cadena+= yytext(); String tmp=cadena; cadena=""; yybegin(YYINITIAL);  return new Symbol(Simbolo.cadena, yychar,yyline,new String(tmp));
          }
        case 47: break;
        case 12: 
          { return new Symbol(Simbolo.multi, yycolumn,yyline);
          }
        case 48: break;
        case 19: 
          { yybegin(YYINITIAL);
          }
        case 49: break;
        case 25: 
          { cadena+=" ";
          }
        case 50: break;
        case 14: 
          { return new Symbol(Simbolo.pycoma, yycolumn,yyline);
          }
        case 51: break;
        case 24: 
          { pintar.pintaVerCla(yychar,yylength()); cadena+=yytext();
          }
        case 52: break;
        case 3: 
          { return new Symbol(Simbolo.id, yycolumn,yyline,new String(yytext()));
          }
        case 53: break;
        case 13: 
          { return new Symbol(Simbolo.coma, yycolumn,yyline);
          }
        case 54: break;
        case 30: 
          { pintar.pintaAzul(yychar,yylength()); yybegin(YYINITIAL);
          }
        case 55: break;
        case 10: 
          { return new Symbol(Simbolo.menos, yycolumn,yyline);
          }
        case 56: break;
        case 1: 
          { System.out.println("ERROR LEXICO:"+yytext()+ " Linea: "+(yyline+1)+" Columna: "+ (yycolumn+1)); 
 erroresLexicos.insertarError(yytext(),Integer.toString(yycolumn+1), Integer.toString(yyline+1), "El caracter no pertenece al lenguaje");
          }
        case 57: break;
        case 5: 
          { return new Symbol(Simbolo.par_abre, yycolumn,yyline);
          }
        case 58: break;
        case 31: 
          { return new Symbol(Simbolo.decimal, yycolumn,yyline,new String(yytext()));
          }
        case 59: break;
        case 26: 
          { pintar.pintaVerCla(yychar,yylength()); String tmp=cadena; cadena=""; yybegin(YYINITIAL); System.out.println("TITULO O CONTEXTO "+ tmp ); return new Symbol(Simbolo.titulo, yycolumn,yyline,new String(tmp));
          }
        case 60: break;
        case 34: 
          { pintar.pintaVerde(yychar,yylength()); return new Symbol(Simbolo.varref, yycolumn,yyline);
          }
        case 61: break;
        case 27: 
          { return new Symbol(Simbolo.raiz, yycolumn,yyline);
          }
        case 62: break;
        case 23: 
          { String tmp=yytext(); cadena =""; erroresLexicos.insertarError(tmp,Integer.toString(yycolumn+1), Integer.toString(yyline+1), "Titulo o contexto invalido"); yybegin(YYINITIAL);
          }
        case 63: break;
        case 8: 
          { return new Symbol(Simbolo.llav_cierra, yycolumn,yyline);
          }
        case 64: break;
        case 2: 
          { return new Symbol(Simbolo.numero, yycolumn,yyline,new String(yytext()));
          }
        case 65: break;
        case 32: 
          { return new Symbol(Simbolo.potencia, yycolumn,yyline);
          }
        case 66: break;
        case 35: 
          { return new Symbol(Simbolo.printer, yycolumn,yyline);
          }
        case 67: break;
        case 15: 
          { pintar.pintaVerCla(yychar,yylength()); yybegin(TITULO);
          }
        case 68: break;
        case 22: 
          { String tmp=cadena; cadena="";  erroresLexicos.insertarError(tmp,Integer.toString(yycolumn+1), Integer.toString(yyline+1), "Se esperaba cierre de cadena (\")."); 
      yybegin(YYINITIAL);
          }
        case 69: break;
        case 18: 
          { pintar.pintaAzul(yychar,yylength());
          }
        case 70: break;
        case 29: 
          { pintar.pintaAzul(yychar,yylength()); yybegin(COMENTARIO2);
          }
        case 71: break;
        case 37: 
          { pintar.pintaRojo(yychar,yylength()); return new Symbol(Simbolo.Proyecto, yycolumn,yyline);
          }
        case 72: break;
        case 17: 
          { 
          }
        case 73: break;
        case 6: 
          { return new Symbol(Simbolo.par_cierra, yycolumn,yyline);
          }
        case 74: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(Simbolo.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}