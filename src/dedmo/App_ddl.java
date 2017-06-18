package dedmo;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * Created by admin on 2017/6/17.
 */
public class App_ddl {

    //自动建表
    @Test
    public void testCreate() {
        //创建配置类管理对象
        Configuration config = new Configuration();

        //加载主配置文件
        config.configure();

        //创建工具类对象
        SchemaExport export = new SchemaExport(config);

        //自动建表

        //参数1，是否在控制台打印建表语句
        //参数2，是否执行脚本
        export.create(true, true);
    }
}
