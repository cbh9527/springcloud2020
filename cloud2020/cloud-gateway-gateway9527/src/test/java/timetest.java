/**
 * @program: cloud2020
 * @description: 1
 * @author: chenbinghuang
 * @create: 2020-08-05 15:18
 */

import java.time.ZonedDateTime;

/**
 *
 * @className: timetest
 * @package: PACKAGE_NAME
 * @author: chenbinghuang
 * @date: 2020/8/5 15:18
 */
public class timetest {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime =ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //2020-08-05T15:19:14.006+08:00[Asia/Shanghai]
    }
}
