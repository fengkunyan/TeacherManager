package cn.edu.bzu.trainwork.config;

import cn.edu.bzu.trainwork.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/**
        * 全局配置类
        *
        * @author wowx
        */
@Component
public class Global
{
    private static final Logger log = LoggerFactory.getLogger(Global.class);

    private static String name;
    private static String version;
    private static String profile;
    private static String copyrightYear;
    @Value("${Train.name}")
    public static void setName(String name) {
        Global.name = name;
    }
    @Value("${Train.version}")
    public static void setVersion(String version) {
        Global.version = version;
    }
    @Value("${Train.profile}")
    public static void setProfile(String profile) {
        Global.profile = profile;
    }
    @Value("${Train.copyrightYear}")
    public static void setCopyrightYear(String copyrightYear) {
        Global.copyrightYear = copyrightYear;
    }



    /**
     * 获取项目名称
     */
    public static String getName()
    {
        return StringUtils.nvl(name, "Train");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion()
    {
        return StringUtils.nvl(version, "1.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear()
    {
        return StringUtils.nvl(copyrightYear, "2019");
    }


    /**
     * 获取文件上传路径
     */
    public static String getProfile()
    {
        return profile;
    }


}
