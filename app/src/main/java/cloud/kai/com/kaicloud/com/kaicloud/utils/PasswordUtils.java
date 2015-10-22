package cloud.kai.com.kaicloud.com.kaicloud.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/22.
 */
public class PasswordUtils {

    public static boolean isEffectivePassword(String mobiles) {
        Pattern pas = Pattern.compile("^[\\@A-Za-z0-9\\!\\#\\$\\%\\^\\&\\*\\.\\~]{8,16}$");
        Matcher m = pas.matcher(mobiles);
        return m.matches();
    }
}
