package to.msn.wings;


public class WingsUtil {
  private static String htmlEscape(String strVal){
  StringBuffer strResult=new StringBuffer();
  for(int i=0;i<strVal.length();i++){
    switch(strVal.charAt(i)){
    case '&' :
      strResult.append("&");
      break;
    case '<' :
      strResult.append("<");
      break;
    case '>' :
      strResult.append(">");
      break;
    default :
      strResult.append(strVal.charAt(i));
      break;
    }
  }
  return strResult.toString();
  }
}