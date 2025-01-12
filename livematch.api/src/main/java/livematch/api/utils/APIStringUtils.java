package livematch.api.utils;

public class APIStringUtils {

	public static String DateTimeFormat(String yyyyMMddHHmmssmmm)      {
		String date = yyyyMMddHHmmssmmm.substring(6, 8)+ "-" + yyyyMMddHHmmssmmm.substring(4, 6)+"-"+yyyyMMddHHmmssmmm.substring(0, 4) ;
		return date;
	}

	public static String TimeFormat(String yyyyMMddHHmmssmmm) {
    	String time = yyyyMMddHHmmssmmm.substring(8,10)+ ":" + yyyyMMddHHmmssmmm.substring(10, 12)+":"+yyyyMMddHHmmssmmm.substring(12, 14) ;
    	return time;
    }

    public static String GetFormatData(String data) {
        String buffer = "";
        for (int i = 1; i <= data.length(); i++)
        {
            buffer = buffer + data.substring(i - 1, i);
            if (i % 4 == 0 && i < data.length()) buffer = buffer + "-";
        }
        return buffer;
    }

    public static String padLeftSpace(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(' ');
	    }
	    sb.append(inputString);

	    return sb.toString();
    }
}
