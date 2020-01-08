package util;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:33 on 2020/1/6
 * @version V0.1
 * @classNmae StringUtils
 */
public class StringUtils {

    public static boolean isBlank(String str){
        if(str==null||str.trim().length()==0){
            return true;
        }
        return false;
    }
}
