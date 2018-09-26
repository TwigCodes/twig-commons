package com.twigcodes.commons;

/**
 * 应用的常量，需要在全局可用的常量都应该在这个类中定义
 *
 * @author Peng Wang (wpcfan@gmail.com)
 */
public final class Constants {

    // Spring profiles for development, test and production
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    public static final String BASE_PACKAGE_NAME = "com.twigcodes";

    public static final String DEFAULT_TIME_ZONE = "Asia/Shanghai";
    public static final String DEFAULT_TIME_STAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private Constants() {
    }
}
