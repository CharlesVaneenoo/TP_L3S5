/* The following code was generated by JFlex 1.6.1 */

/* Exemple 1 */
package exemple1;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/exemple1/exemple1.lex</tt>
 */
class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\12\0\1\0\1\6\1\6\1\6\34\0\1\3\1\3\1\0\1\3"+
    "\1\0\1\3\12\2\7\0\32\4\4\0\1\5\1\0\32\4\12\0"+
    "\1\6\44\0\1\1\12\0\1\1\4\0\1\1\5\0\27\1\1\0"+
    "\37\1\1\0\u01ca\1\4\0\14\1\16\0\5\1\7\0\1\1\1\0"+
    "\1\1\201\0\5\1\1\0\2\1\2\0\4\1\1\0\1\1\6\0"+
    "\1\1\1\0\3\1\1\0\1\1\1\0\24\1\1\0\123\1\1\0"+
    "\213\1\10\0\246\1\1\0\46\1\2\0\1\1\7\0\47\1\110\0"+
    "\33\1\5\0\3\1\55\0\53\1\43\0\2\1\1\0\143\1\1\0"+
    "\1\1\17\0\2\1\7\0\2\1\12\0\3\1\2\0\1\1\20\0"+
    "\1\1\1\0\36\1\35\0\131\1\13\0\1\1\30\0\41\1\11\0"+
    "\2\1\4\0\1\1\5\0\26\1\4\0\1\1\11\0\1\1\3\0"+
    "\1\1\27\0\31\1\107\0\23\1\121\0\66\1\3\0\1\1\22\0"+
    "\1\1\7\0\12\1\17\0\20\1\4\0\10\1\2\0\2\1\2\0"+
    "\26\1\1\0\7\1\1\0\1\1\3\0\4\1\3\0\1\1\20\0"+
    "\1\1\15\0\2\1\1\0\3\1\16\0\2\1\23\0\6\1\4\0"+
    "\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0\2\1\1\0"+
    "\2\1\37\0\4\1\1\0\1\1\23\0\3\1\20\0\11\1\1\0"+
    "\3\1\1\0\26\1\1\0\7\1\1\0\2\1\1\0\5\1\3\0"+
    "\1\1\22\0\1\1\17\0\2\1\43\0\10\1\2\0\2\1\2\0"+
    "\26\1\1\0\7\1\1\0\2\1\1\0\5\1\3\0\1\1\36\0"+
    "\2\1\1\0\3\1\17\0\1\1\21\0\1\1\1\0\6\1\3\0"+
    "\3\1\1\0\4\1\3\0\2\1\1\0\1\1\1\0\2\1\3\0"+
    "\2\1\3\0\3\1\3\0\14\1\26\0\1\1\64\0\10\1\1\0"+
    "\3\1\1\0\27\1\1\0\20\1\3\0\1\1\32\0\2\1\6\0"+
    "\2\1\43\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0"+
    "\5\1\3\0\1\1\40\0\1\1\1\0\2\1\17\0\2\1\22\0"+
    "\10\1\1\0\3\1\1\0\51\1\2\0\1\1\20\0\1\1\21\0"+
    "\2\1\30\0\6\1\5\0\22\1\3\0\30\1\1\0\11\1\1\0"+
    "\1\1\2\0\7\1\72\0\60\1\1\0\2\1\14\0\7\1\72\0"+
    "\2\1\1\0\1\1\2\0\2\1\1\0\1\1\2\0\1\1\6\0"+
    "\4\1\1\0\7\1\1\0\3\1\1\0\1\1\1\0\1\1\2\0"+
    "\2\1\1\0\4\1\1\0\2\1\11\0\1\1\2\0\5\1\1\0"+
    "\1\1\25\0\4\1\40\0\1\1\77\0\10\1\1\0\44\1\33\0"+
    "\5\1\163\0\53\1\24\0\1\1\20\0\6\1\4\0\4\1\3\0"+
    "\1\1\3\0\2\1\7\0\3\1\4\0\15\1\14\0\1\1\21\0"+
    "\46\1\1\0\1\1\5\0\1\1\2\0\53\1\1\0\u014d\1\1\0"+
    "\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0\51\1\1\0"+
    "\4\1\2\0\41\1\1\0\4\1\2\0\7\1\1\0\1\1\1\0"+
    "\4\1\2\0\17\1\1\0\71\1\1\0\4\1\2\0\103\1\45\0"+
    "\20\1\20\0\125\1\14\0\u026c\1\2\0\21\1\1\0\32\1\5\0"+
    "\113\1\6\0\10\1\7\0\15\1\1\0\4\1\16\0\22\1\16\0"+
    "\22\1\16\0\15\1\1\0\3\1\17\0\64\1\43\0\1\1\4\0"+
    "\1\1\103\0\130\1\10\0\51\1\1\0\1\1\5\0\106\1\12\0"+
    "\37\1\61\0\36\1\2\0\5\1\13\0\54\1\25\0\7\1\70\0"+
    "\27\1\11\0\65\1\122\0\1\1\135\0\57\1\21\0\7\1\67\0"+
    "\36\1\15\0\2\1\12\0\54\1\32\0\44\1\51\0\3\1\12\0"+
    "\44\1\153\0\4\1\1\0\4\1\3\0\2\1\11\0\300\1\100\0"+
    "\u0116\1\2\0\6\1\2\0\46\1\2\0\6\1\2\0\10\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\37\1\2\0\65\1\1\0"+
    "\7\1\1\0\1\1\3\0\3\1\1\0\7\1\3\0\4\1\2\0"+
    "\6\1\4\0\15\1\5\0\3\1\1\0\7\1\53\0\1\6\1\6"+
    "\107\0\1\1\15\0\1\1\20\0\15\1\145\0\1\1\4\0\1\1"+
    "\2\0\12\1\1\0\1\1\3\0\5\1\6\0\1\1\1\0\1\1"+
    "\1\0\1\1\1\0\4\1\1\0\13\1\2\0\4\1\5\0\5\1"+
    "\4\0\1\1\64\0\2\1\u0a7b\0\57\1\1\0\57\1\1\0\205\1"+
    "\6\0\4\1\3\0\2\1\14\0\46\1\1\0\1\1\5\0\1\1"+
    "\2\0\70\1\7\0\1\1\20\0\27\1\11\0\7\1\1\0\7\1"+
    "\1\0\7\1\1\0\7\1\1\0\7\1\1\0\7\1\1\0\7\1"+
    "\1\0\7\1\120\0\1\1\u01d5\0\2\1\52\0\5\1\5\0\2\1"+
    "\4\0\126\1\6\0\3\1\1\0\132\1\1\0\4\1\5\0\51\1"+
    "\3\0\136\1\21\0\33\1\65\0\20\1\u0200\0\u19b6\1\112\0\u51cd\1"+
    "\63\0\u048d\1\103\0\56\1\2\0\u010d\1\3\0\20\1\12\0\2\1"+
    "\24\0\57\1\20\0\37\1\2\0\106\1\61\0\11\1\2\0\147\1"+
    "\2\0\4\1\1\0\36\1\2\0\2\1\105\0\13\1\1\0\3\1"+
    "\1\0\4\1\1\0\27\1\35\0\64\1\16\0\62\1\76\0\6\1"+
    "\3\0\1\1\16\0\34\1\12\0\27\1\31\0\35\1\7\0\57\1"+
    "\34\0\1\1\20\0\5\1\1\0\12\1\12\0\5\1\1\0\51\1"+
    "\27\0\3\1\1\0\10\1\24\0\27\1\3\0\1\1\3\0\62\1"+
    "\1\0\1\1\3\0\2\1\2\0\5\1\2\0\1\1\1\0\1\1"+
    "\30\0\3\1\2\0\13\1\7\0\3\1\14\0\6\1\2\0\6\1"+
    "\2\0\6\1\11\0\7\1\1\0\7\1\1\0\53\1\1\0\4\1"+
    "\4\0\2\1\132\0\43\1\35\0\u2ba4\1\14\0\27\1\4\0\61\1"+
    "\u2104\0\u016e\1\2\0\152\1\46\0\7\1\14\0\5\1\5\0\1\1"+
    "\1\0\12\1\1\0\15\1\1\0\5\1\1\0\1\1\1\0\2\1"+
    "\1\0\2\1\1\0\154\1\41\0\u016b\1\22\0\100\1\2\0\66\1"+
    "\50\0\14\1\164\0\5\1\1\0\207\1\44\0\32\1\6\0\32\1"+
    "\13\0\131\1\3\0\6\1\2\0\6\1\2\0\6\1\2\0\3\1"+
    "\43\0\14\1\1\0\32\1\1\0\23\1\1\0\2\1\1\0\17\1"+
    "\2\0\16\1\42\0\173\1\u0185\0\35\1\3\0\61\1\57\0\40\1"+
    "\20\0\21\1\1\0\10\1\6\0\46\1\12\0\36\1\2\0\44\1"+
    "\4\0\10\1\60\0\236\1\142\0\50\1\10\0\64\1\234\0\u0137\1"+
    "\11\0\26\1\12\0\10\1\230\0\6\1\2\0\1\1\1\0\54\1"+
    "\1\0\2\1\3\0\1\1\2\0\27\1\12\0\27\1\11\0\37\1"+
    "\141\0\26\1\12\0\32\1\106\0\70\1\6\0\2\1\100\0\1\1"+
    "\17\0\4\1\1\0\3\1\1\0\33\1\54\0\35\1\3\0\35\1"+
    "\43\0\10\1\1\0\34\1\33\0\66\1\12\0\26\1\12\0\23\1"+
    "\15\0\22\1\156\0\111\1\u03ba\0\65\1\113\0\55\1\40\0\31\1"+
    "\32\0\44\1\51\0\43\1\3\0\1\1\14\0\60\1\16\0\4\1"+
    "\25\0\1\1\45\0\22\1\1\0\31\1\204\0\57\1\46\0\10\1"+
    "\2\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0\5\1"+
    "\3\0\1\1\37\0\5\1\u011e\0\60\1\24\0\2\1\1\0\1\1"+
    "\270\0\57\1\121\0\60\1\24\0\1\1\73\0\53\1\u01f5\0\100\1"+
    "\37\0\1\1\u01c0\0\71\1\u0507\0\u0399\1\u0c67\0\u042f\1\u33d1\0\u0239\1"+
    "\7\0\37\1\161\0\36\1\22\0\60\1\20\0\4\1\37\0\25\1"+
    "\5\0\23\1\u0370\0\105\1\13\0\1\1\102\0\15\1\u4060\0\2\1"+
    "\u0bfe\0\153\1\5\0\15\1\3\0\11\1\7\0\12\1\u1766\0\125\1"+
    "\1\0\107\1\1\0\2\1\2\0\1\1\2\0\2\1\2\0\4\1"+
    "\1\0\14\1\1\0\1\1\1\0\7\1\1\0\101\1\1\0\4\1"+
    "\2\0\10\1\1\0\7\1\1\0\34\1\1\0\4\1\1\0\5\1"+
    "\1\0\1\1\3\0\7\1\1\0\u0154\1\2\0\31\1\1\0\31\1"+
    "\1\0\37\1\1\0\31\1\1\0\37\1\1\0\31\1\1\0\37\1"+
    "\1\0\31\1\1\0\37\1\1\0\31\1\1\0\10\1\u1034\0\305\1"+
    "\u053b\0\4\1\1\0\33\1\1\0\2\1\1\0\1\1\2\0\1\1"+
    "\1\0\12\1\1\0\4\1\1\0\1\1\1\0\1\1\6\0\1\1"+
    "\4\0\1\1\1\0\1\1\1\0\1\1\1\0\3\1\1\0\2\1"+
    "\1\0\1\1\2\0\1\1\1\0\1\1\1\0\1\1\1\0\1\1"+
    "\1\0\1\1\1\0\2\1\1\0\1\1\2\0\4\1\1\0\7\1"+
    "\1\0\4\1\1\0\4\1\1\0\1\1\1\0\12\1\1\0\21\1"+
    "\5\0\3\1\1\0\5\1\1\0\21\1\u1144\0\ua6d7\1\51\0\u1035\1"+
    "\13\0\336\1\u3fe2\0\u021e\1\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05f0\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\5\2\1\0\2\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[10];
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
    "\0\0\0\7\0\16\0\25\0\7\0\34\0\43\0\52"+
    "\0\61\0\70";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[10];
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
    "\1\2\1\3\1\4\1\5\1\6\1\2\11\0\1\3"+
    "\2\0\1\3\4\0\1\4\5\0\1\3\1\7\1\0"+
    "\1\6\1\10\3\0\1\7\1\0\1\11\1\10\3\0"+
    "\1\12\1\0\1\12\4\0\1\11\1\0\1\11\4\0"+
    "\1\12\1\0\1\12\1\10\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[63];
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
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\2\1\1\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[10];
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
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2218) {
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
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
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
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
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
   * Internal scan buffer is resized down to its initial length, if it has grown.
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
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
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


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
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


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Yytoken yylex() throws java.io.IOException {
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

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { 
            }
          case 3: break;
          case 2: 
            { return new Yytoken(yytext());
            }
          case 4: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
