package cloud.ffeng.user.common.util;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @User luKP
 * @Date 2023/10/22 16:39
 * @Function 日期转换工具
 **/
public class DateUtils {
    /**
     * 初始化不同的时间类型，采用ThreadLocal来保证线程安全问题
     */
    private static final ThreadLocal<SimpleDateFormat> toS = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    private static final ThreadLocal<SimpleDateFormat> toM = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm"));
    private static final ThreadLocal<SimpleDateFormat> toH = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH"));
    private static final ThreadLocal<SimpleDateFormat> toDay = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    private static final ThreadLocal<SimpleDateFormat> toMoth = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM"));
    private static final ThreadLocal<SimpleDateFormat> toYear = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy"));
    private static final Map<String, ThreadLocal<SimpleDateFormat>> threadLocals = new HashMap<>();

    static {
        threadLocals.put("yyyy-MM-dd HH:mm:ss", toS);
        threadLocals.put("yyyy-MM-dd HH:mm", toM);
        threadLocals.put("yyyy-MM-dd HH", toH);
        threadLocals.put("yyyy-MM-dd", toDay);
        threadLocals.put("yyyy-MM", toMoth);
        threadLocals.put("yyyy", toYear);
    }

    /**
     * 获取指定日期格式的SimpleDateFormat实例
     *
     * @param format
     * @return
     */
    private static SimpleDateFormat getDateFormat(String format) {
        return threadLocals.get(format).get();
    }

    /**
     * 按照指定要求获取时间类型转换器
     *
     * @param format
     * @return
     */
    public static SimpleDateFormat getStrDateFormat(String format) {
        if (format.equals("") || Objects.isNull(format)) {
            return null;
        }
        return getDateFormat(format);
    }

    /**
     * 获取当前的时间
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * 获取系统时间戳
     */
    public static long getMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 获取指定日期格式的时间
     */
    public static String getSpecifyDate(String format) {
        if (format.equals("") || Objects.isNull(format)) {
            return null;
        }
        String dateFormat = "";
        try {
            dateFormat = getStrDateFormat(format).format(getNow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateFormat;
    }

    /**
     * 获取开始时间
     */
    public static Date getStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取结束时间
     */
    public static Date getEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

}
