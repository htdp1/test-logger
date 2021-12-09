package net.kubepia.app;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        String msg = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n when an unknown printer took a galley of type and scrambled it to make a type specimen book.\n It has survived not only five centuries, but also the leap into electronic typesetting, \nremaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets \ncontaining Lorem Ipsum passages, and more recently with desktop publishing software like Aldus \nPageMaker including versions of Lorem Ipsum.";
        Map<String, String> env = System.getenv();
        int count = Integer.parseInt(env.get("RUN_COUNT"));
        int wait = Integer.parseInt(env.get("RUN_SLEEP"));

        for(int i=0;i<count;i++){
            try {
                TimeUnit.MILLISECONDS.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            String str = String.format("%s [count: %d]-%s", new Timestamp(date.getTime()), i, msg);
            System.out.println(padRightZeros(str, 23));
        }
        
    }

    public static String padRightZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder(inputString);
        if(length > inputString.length()) sb.append("0");
    
        return sb.toString();
    }
}
