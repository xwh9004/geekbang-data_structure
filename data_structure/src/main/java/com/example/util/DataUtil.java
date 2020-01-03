package com.example.util;

/**
 * <p><b>Description:</b>  初步实现利用末日算法计算出星期
 * 还有很多可以优化的空间
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:36 on 2020/1/3
 * @version V0.1
 * @classNmae DataUtil
 */
public class DataUtil {

    public static String[] WEEK = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    /**
     * 输入年月日快速获取星期
     * 改方法根据"末日算法"快速获取星期
     * 周一到周日 0-6;
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getDateOfWeek(int year, int month, int day) {
        if (month < 0 || month > 12) {
            return null;
        }
        if (day < 1 || day > 31) {
            return null;
        }
        int base_1900 = 2;   //1900年"末日"
        int[] base_month = {0, 0, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
        int base = getBaseDate(year);
        int week = 0;
        int week_base = base;
        //比3大的月份
        if (month > 1) {
            int month_base = base_month[month];
            if (day > month_base) {
                week = (base + (day - month_base)) % 7;

            } else if (day < month_base) {
                week = (base - (month_base - day) + 7) % 7;
            }

        } else {
            //一二月份
            int days = 0;
            int c = isLeapYear(year) ? 1 : 0;
            days = 28 + c + 31 * (1 - month) - day;
            week = (base + 7 - (days) % 7) % 7;
        }
        return WEEK[week];
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            } else {
                //闰年
                return true;
            }

        }
        return false;
    }

    /**
     * 获取指定年份中基准星期（2月最后一天的星期）
     *
     * @param year
     * @return
     */
    public static int getBaseDate(int year) {
        int base_year = 1900;
        int base_1900 = 2;   //1900年"末日"
        int base = base_1900;
        //获取末日基准星期
        if (year > base_year) {
            for (int i = 1; i <= year - base_year; i++) {
                if ((base_year + i) % 4 == 0) {
                    if ((base_year + i) % 100 == 0 && (base_year + i) % 400 != 0) {
                        base = (base + 1) % 7;
                    } else {
                        //闰年
                        base = (base + 2) % 7;
                    }
                } else {
                    base = (base + 1) % 7;
                }
            }
        } else if (year < base_year) {
            for (int i = base_year - 1; i >= year; i--) {
                if ((base_year - i) % 4 == 0) {
                    if ((base_year - i) % 100 == 0 && (base_year - i) % 400 != 0) {
                        base = (base + 6) % 7;

                    } else {
                        //闰年
                        base = (base + 5) % 7;
                    }

                } else {
                    base = (base + 6) % 7;
                }
            }
        }
        return base;
    }


    public static void main(String[] args) {
        System.out.println(WEEK[getBaseDate(2019)]);
        System.out.println(getDateOfWeek(2019, 1, 24));
    }
}
