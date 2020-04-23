package com.util.vinit.String;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class StringUtil {
  public static final String EMPTY = "";
  
  public static final String NEW_LINE = "\n";
  
  public static final String appendLine(String argText) {
    return appendLine(argText, "");
  }
  
  public static final String appendLine(String argText, String argNewLine) {
    return argText + "\n" + argNewLine;
  }
  
  public static final StringBuilder appendLine(StringBuilder argText) {
    return appendLine(argText, "");
  }
  
  public static final StringBuilder appendLine(StringBuilder argText, String argNewLine) {
    return argText.append("\n").append(argNewLine);
  }
  
  public static final String center(String argTarget, int argLength) {
    return center(argTarget, argLength, " ");
  }
  
  public static final String center(String argTarget, int argLength, String argPadding) {
    if (argTarget == null)
      return argTarget; 
    if (argPadding.length() == 0)
      throw new IllegalArgumentException(); 
    StringBuilder out = new StringBuilder(argLength);
    out.append(argTarget);
    if (out.length() < argLength) {
      int padIndex = 0;
      while (true) {
        out.insert(0, argPadding.charAt(padIndex));
        if (out.length() >= argLength)
          break; 
        out.append(argPadding.charAt(padIndex));
        if (out.length() >= argLength)
          break; 
        padIndex++;
        if (padIndex > argPadding.length() - 1)
          padIndex = 0; 
      } 
    } 
    return out.toString();
  }
  
  public static final String combine(String primary, String secondary, int offset, boolean insert) {
    return combine(new StringBuffer(primary), secondary, offset, insert);
  }
  
  public static final String combine(StringBuffer primary, String secondary, int offset, boolean insert) {
    if (isEmpty(secondary))
      return (primary != null) ? primary.toString() : null; 
    if (primary == null)
      primary = new StringBuffer(); 
    if (offset >= primary.length())
      return primary.append(secondary).toString(); 
    if (offset < 0)
      offset = 0; 
    return insert ? primary.insert(offset, secondary).toString() : primary.replace(offset, offset + secondary.length(), secondary).toString();
  }
  
  public static final String combine(StringBuffer primary, StringBuffer secondary, int offset, boolean insert) {
    return combine(primary, nonNull(secondary), offset, insert);
  }
  
  public static final String combine(StringBuilder primary, String secondary, int offset, boolean insert) {
    if (isEmpty(secondary))
      return (primary != null) ? primary.toString() : null; 
    if (primary == null)
      primary = new StringBuilder(); 
    if (offset >= primary.length())
      return primary.append(secondary).toString(); 
    if (offset < 0)
      offset = 0; 
    return insert ? primary.insert(offset, secondary).toString() : primary.replace(offset, offset + secondary.length(), secondary).toString();
  }
  
  public static final String combine(StringBuilder primary, StringBuilder secondary, int offset, boolean insert) {
    return combine(primary, nonNull(secondary), offset, insert);
  }
  
  public static String ensureFirstLowerCase(String argString) {
    if (isEmpty(argString))
      return argString; 
    return Character.toLowerCase(argString.charAt(0)) + argString.substring(1);
  }
  
  public static String ensureFirstUpperCase(String argString) {
    if (isEmpty(argString))
      return argString; 
    return Character.toUpperCase(argString.charAt(0)) + argString.substring(1);
  }
  
  public static final boolean equivalentIgnoreCase(String argObj1, String argObj2) {
    boolean equivalent = false;
    if (argObj1 != null && argObj2 != null && argObj1.equalsIgnoreCase(argObj2)) {
      equivalent = true;
    } else {
      equivalent = (argObj1 == null && argObj2 == null);
    } 
    return equivalent;
  }
  
  public static final String fill(char argFillChar, int argFillCount) {
    return fill(Character.toString(argFillChar), argFillCount);
  }
  
  public static final String fill(String argFillString, int argFillCount) {
    return fill(new StringBuilder(argFillCount), argFillString, argFillCount).toString();
  }
  
  public static final StringBuffer fill(StringBuffer argFillString, int argFillCount) {
    return fill(new StringBuffer(argFillCount), argFillString.toString(), argFillCount);
  }
  
  public static final StringBuffer fill(StringBuffer argFillBuffer, String argFillString, int argFillCount) {
    for (int i = 0; i < argFillCount; i++)
      argFillBuffer.append(argFillString); 
    return argFillBuffer;
  }
  
  public static final StringBuilder fill(StringBuilder argFillString, int argFillCount) {
    return fill(new StringBuilder(argFillCount), argFillString.toString(), argFillCount);
  }
  
  public static final StringBuilder fill(StringBuilder argFillBuffer, String argFillString, int argFillCount) {
    for (int i = 0; i < argFillCount; i++)
      argFillBuffer.append(argFillString); 
    return argFillBuffer;
  }
  
  public static final byte[] getBytes(String argString) {
    return getBytes(argString, "UTF-8");
  }
  
  public static final byte[] getBytes(String argString, String argEncoding) {
    try {
      return argString.getBytes(argEncoding);
    } catch (Exception ex) {
      return argString.getBytes();
    } 
  }
  
  public static String intersperse(String argOriginalString, String argStringToIntersperse) {
    return intersperse(argOriginalString, argStringToIntersperse, 1);
  }
  
  public static String intersperse(String argOriginalString, String argStringToIntersperse, int interval) {
    if (interval < 1)
      throw new IllegalArgumentException("interval must be positive but was: " + interval + ". argOriginalString: " + argOriginalString + " argStringToIntersperse: " + argStringToIntersperse); 
    if (isEmpty(argOriginalString))
      return argOriginalString; 
    StringBuilder buff = new StringBuilder(argStringToIntersperse.length() * 2);
    for (int ii = 0; ii < argOriginalString.length(); ii++) {
      if (ii != 0 && ii % interval == 0)
        buff.append(argStringToIntersperse); 
      buff.append(argOriginalString.charAt(ii));
    } 
    return buff.toString();
  }
  
  public static final boolean isBoolean(String argString) {
    return (Boolean.TRUE.toString().equalsIgnoreCase(argString) || Boolean.FALSE.toString().equalsIgnoreCase(argString));
  }
  
  public static final boolean isEmpty(CharSequence argSeq) {
    return (argSeq == null || argSeq.length() == 0 || argSeq.toString().trim().equals(""));
  }
  
  public static final boolean isEmpty(String argString) {
    return (argString == null || argString.trim().equals(""));
  }
  
  public static final boolean isPositiveDigit(String argString) {
    String pattern = "[\\d]+";
    return (argString != null) ? argString.matches(pattern) : false;
  }
  
  public static final String join(Collection<?> argSource, String argDelimiter) {
    StringBuilder buf = new StringBuilder(argSource.size() * 32);
    for (Iterator<?> iter = argSource.iterator(); iter.hasNext(); ) {
      Object elem = iter.next();
      if (elem != null) {
        buf.append(elem);
        if (iter.hasNext() && argDelimiter != null)
          buf.append(argDelimiter); 
      } 
    } 
    return buf.toString();
  }
  
  public static final String join(Object[] argSource, String argDelimiter) {
    return join(argSource, argDelimiter, 0, argSource.length - 1);
  }
  
  public static final String join(Object[] argSource, String argDelimiter, int argStart, int argEnd) {
    StringBuilder buf = new StringBuilder(100);
    for (int i = argStart; i <= argEnd; i++) {
      buf.append(argSource[i].toString());
      if (i < argEnd)
        buf.append(argDelimiter); 
    } 
    return buf.toString();
  }
  
  public static final String left(String argText, int argLength) {
    if (argText == null)
      return null; 
    if (argLength < 0)
      throw new IllegalArgumentException(); 
    argLength = Math.min(argLength, argText.length());
    return argText.substring(0, argLength);
  }
  
  public static final String leftPad(String argTarget, int argLength, char argPadChar) {
    return leftPad(new StringBuilder(argTarget), argLength, argPadChar).toString();
  }
  
  public static final StringBuffer leftPad(StringBuffer argTarget, int argLength, char argPadChar) {
    while (argTarget.length() < argLength)
      argTarget.insert(0, argPadChar); 
    return argTarget;
  }
  
  public static final StringBuilder leftPad(StringBuilder argTarget, int argLength, char argPadChar) {
    while (argTarget.length() < argLength)
      argTarget.insert(0, argPadChar); 
    return argTarget;
  }
  
  public static final String leftPadSpaces(String argTarget, int argLength) {
    return leftPad(argTarget, argLength, ' ');
  }
  
  public static final String leftPadZeros(long argTarget, int argLength) {
    return leftPad(Long.toString(argTarget), argLength, '0');
  }
  
  public static final String leftPadZeros(String argTarget, int argLength) {
    return leftPad(argTarget, argLength, '0');
  }
  
  public static final String ltrim(String argString) {
    if (argString == null)
      return null; 
    int stringLength = argString.length();
    int startOfKeep = 0;
    while (startOfKeep < stringLength)
      startOfKeep++; 
    return argString.substring(startOfKeep);
  }
  
  public static final String nonEmpty(Object argObj) {
    String toString = nonNull(argObj);
    return isEmpty(toString) ? null : toString;
  }
  
  public static final String nonNull(Object argObj) {
    if (argObj == null)
      return ""; 
    String toString = argObj.toString();
    return (toString != null) ? toString : "";
  }
  
  public static final String removeLeadingChar(String argString, char argLeadingChar) {
    if (isEmpty(argString))
      return argString; 
    while (argString.length() > 0 && 
      argString.charAt(0) == argLeadingChar)
      argString = argString.substring(1); 
    return argString;
  }
  
  public static final String removeLineFeeds(String argString, String argLineFeedReplacement) {
    String[] lines = argString.split("\r\n|[\r\n]");
    StringBuilder cleansed = new StringBuilder(argString.length());
    for (int ii = 0; ii < lines.length; ii++) {
      cleansed.append(lines[ii].trim());
      if (ii < lines.length - 1)
        cleansed.append(argLineFeedReplacement); 
    } 
    return cleansed.toString().trim();
  }
  
  public static final String removeNonAlphaNumeric(String argSource) {
    if (argSource == null)
      return null; 
    StringBuilder sb = new StringBuilder(argSource.length());
    for (int i = 0; i < argSource.length(); i++) {
      char c = argSource.charAt(i);
      if (Character.isLetterOrDigit(c))
        sb.append(c); 
    } 
    return sb.toString();
  }
  
  public static final StringBuffer replaceAll(StringBuffer argTarget, String argReplace, String argWith) {
    return replaceAll(argTarget, argReplace, argWith, 0);
  }
  
  public static final StringBuffer replaceAll(StringBuffer argTarget, String argReplace, String argWith, int argStart) {
    if (argReplace == null || "".equals(argReplace))
      return argTarget; 
    StringBuilder builder = new StringBuilder(argTarget.toString());
    replaceAll(builder, argReplace, argWith, argStart);
    argTarget.setLength(0);
    argTarget.append(builder.toString());
    return argTarget;
  }
  
  public static final StringBuilder replaceAll(StringBuilder argTarget, String argReplace, String argWith) {
    return replaceAll(argTarget, argReplace, argWith, 0);
  }
  
  public static final StringBuilder replaceAll(StringBuilder argTarget, String argReplace, String argWith, int argStart) {
    if (argReplace == null || "".equals(argReplace))
      return argTarget; 
    int found = argTarget.indexOf(argReplace, argStart);
    int replaceLength = argReplace.length();
    int replaceWithLength = argWith.length();
    while (found != -1) {
      argTarget.replace(found, found + replaceLength, argWith);
      if (found + replaceWithLength < argTarget.length())
        found = argTarget.indexOf(argReplace, found + replaceWithLength); 
    } 
    return argTarget;
  }
  
  public static final String replaceVariables(String argTarget, Map<? extends Object, ? extends Object> argVariableLookupMap) {
    return replaceVariables(new StringBuilder(argTarget), argVariableLookupMap).toString();
  }
  
  public static final StringBuffer replaceVariables(StringBuffer argTarget, Map<? extends Object, ? extends Object> argVariableLookupMap) {
    StringBuilder builder = new StringBuilder(argTarget.toString());
    replaceVariables(builder, argVariableLookupMap);
    argTarget.setLength(0);
    argTarget.append(builder.toString());
    return argTarget;
  }
  
  public static final StringBuilder replaceVariables(StringBuilder argTarget, Map<? extends Object, ? extends Object> argVariableLookupMap) {
    int foundStart = argTarget.indexOf("${");
    while (foundStart != -1) {
      int foundEnd = argTarget.indexOf("}", foundStart + 1);
      String variableName = argTarget.substring(foundStart + 2, foundEnd);
      if (argVariableLookupMap.containsKey(variableName)) {
        String variableValue = nonNull(argVariableLookupMap.get(variableName));
        argTarget.replace(foundStart, foundEnd + 1, variableValue);
      } 
      foundStart = argTarget.indexOf("${", foundStart + 1);
    } 
    return argTarget;
  }
  
  public static final String right(String argText, int argLength) {
    if (argText == null)
      return null; 
    if (argLength < 0)
      throw new IllegalArgumentException(); 
    argLength = Math.min(argLength, argText.length());
    return argText.substring(argText.length() - argLength, argText.length());
  }
  
  public static final String rightPad(String argTarget, int argLength, char argPadChar) {
    return rightPad(new StringBuffer(argTarget), argLength, argPadChar).toString();
  }
  
  public static final StringBuffer rightPad(StringBuffer argTarget, int argLength, char argPadChar) {
    while (argTarget.length() < argLength)
      argTarget.append(argPadChar); 
    return argTarget;
  }
  
  public static final StringBuilder rightPad(StringBuilder argTarget, int argLength, char argPadChar) {
    while (argTarget.length() < argLength)
      argTarget.append(argPadChar); 
    return argTarget;
  }
  
  public static final String rightPadSpaces(String argTarget, int argLength) {
    return rightPad(argTarget, argLength, ' ');
  }
  
  public static final String rtrim(String argString) {
    if (argString == null)
      return null; 
    int keepLength = argString.length() - 1;
    while (keepLength > 0)
      keepLength--; 
    return argString.substring(0, keepLength + 1);
  }
  
  public static String slice(String argString, int argStart, int argEnd) {
    if (argString == null)
      return null; 
    if (argString.length() == 0)
      return ""; 
    if (argString.length() < argStart)
      return ""; 
    if (argStart < 0)
      argStart = argString.length() + argStart; 
    if (argEnd < 0)
      argEnd = argString.length() + argEnd; 
    if (argEnd > argString.length())
      argEnd = argString.length(); 
    return argString.substring(argStart, argEnd);
  }
  
  public static final String[] split(String argSource, char argSplitOn) {
    int found = argSource.indexOf(argSplitOn);
    if (found == -1)
      return new String[] { argSource }; 
    List<String> parts = new ArrayList<>(4);
    int lastFound = 0;
    for (; found != -1; found = argSource.indexOf(argSplitOn, lastFound)) {
      parts.add(argSource.substring(lastFound, found));
      lastFound = found + 1;
    } 
    if (lastFound != argSource.length() || parts.size() == 0)
      parts.add(argSource.substring(lastFound, argSource.length())); 
    return parts.<String>toArray(new String[parts.size()]);
  }
  
 
  

  
  public static void toHtml(StringBuffer sb) {
    replaceAll(sb, "<", "&lt;");
    replaceAll(sb, ">", "&gt;");
    replaceAll(sb, "\r\n", "<br>");
    replaceAll(sb, "\r", "<br>");
    replaceAll(sb, "\n", "<br>");
    replaceAll(sb, " ", "&nbsp;");
    replaceAll(sb, "\t", "&nbsp;&nbsp;");
  }
  
  public static void toHtml(StringBuilder sb) {
    replaceAll(sb, "<", "&lt;");
    replaceAll(sb, ">", "&gt;");
    replaceAll(sb, "\r\n", "<br>");
    replaceAll(sb, "\r", "<br>");
    replaceAll(sb, "\n", "<br>");
    replaceAll(sb, " ", "&nbsp;");
    replaceAll(sb, "\t", "&nbsp;&nbsp;");
  }
  
  public static final String toLines(boolean argNewLineAtEnd, String... argLines) {
    String result = "";
    if (argLines != null)
      for (int i = 0, n = argLines.length; i < n; i++) {
        result = result + argLines[i];
        if (argNewLineAtEnd || i < n - 1)
          result = result + "\n"; 
      }  
    return result;
  }
  
  public static final String toLines(String... argLines) {
    return toLines(false, argLines);
  }
  
  public static final String trim(String argString, StringTrimType argTrimType) {
    if (argString == null)
      return null; 
    if (argTrimType == null)
      argTrimType = StringTrimType.NONE; 
    switch (argTrimType) {
      case NONE:
        return argString;
      case FULL:
        return argString.trim();
      case RIGHT:
        return rtrim(argString);
      case LEFT:
        return ltrim(argString);
    } 
    throw new IllegalArgumentException("invalid trim type [" + argTrimType + "]");
  }
  
  public static final String truncate(String argString, int argLen) {
    if (argString == null || argString.length() <= argLen)
      return argString; 
    if (argLen < 4)
      return argString.substring(0, argLen); 
    return argString.substring(0, argLen - 3) + "...";
  }
  
  public static final String unescape(String value) {
    if (value == null)
      return value; 
    StringBuilder sb = new StringBuilder(value);
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '\\' && i + 1 < sb.length())
        switch (sb.charAt(i + 1)) {
          case '\\':
            sb.replace(i, i + 2, "\\");
            break;
          case 'b':
            sb.replace(i, i + 2, "\b");
            break;
          case 'n':
            sb.replace(i, i + 2, "\n");
            break;
          case 'f':
            sb.replace(i, i + 2, "\f");
            break;
          case 'r':
            sb.replace(i, i + 2, "\r");
            break;
          case 't':
            sb.replace(i, i + 2, "\t");
            break;
          case '\'':
            sb.replace(i, i + 2, "'");
            break;
          case '"':
            sb.replace(i, i + 2, "\"");
            break;
          case 'u':
            try {
              String hexcode = sb.substring(i + 2, i + 6);
              char charValue = (char)Integer.parseInt(hexcode, 16);
              sb.replace(i, i + 6, Character.toString(charValue));
            } catch (Exception ex) {
              ex.printStackTrace();
            } 
            break;
          case '0':
          case '1':
          case '2':
          case '3':
          case '4':
          case '5':
          case '6':
          case '7':
            try {
              String octalcode = sb.substring(i + 1, i + 4);
              char charValue = (char)Integer.parseInt(octalcode, 8);
              sb.replace(i, i + 4, Character.toString(charValue));
            } catch (Exception ex) {
              ex.printStackTrace();
            } 
            break;
          default:
            System.out.println("problem unescaping " + value);
            break;
        }  
    } 
    return sb.toString();
  }
}

