package cloud.kai.com.kaicloud.com.kaicloud.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/22.
 */
public class TelUtils {
    /**
     *
     * @param mobiles 字符串
     * @return 检测是否是合法手机号码
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern tel = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = tel.matcher(mobiles);
        return m.matches();
    }
}
