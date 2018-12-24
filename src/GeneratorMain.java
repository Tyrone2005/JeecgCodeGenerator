import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hangutech.generator.GeneratorFacade;
import com.hangutech.generator.GeneratorProperties;

public class GeneratorMain {
    /**
     * 日志对象
     */
    private static Log logger = LogFactory.getLog(GeneratorMain.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            GeneratorFacade generatorFacade = new GeneratorFacade();
            //g.printAllTableNames(); //打印数据库中的表名称

            //generatorFacade.deleteOutRootDir(); // 删除生成器的输出目录
            
            generatorFacade.generateByTable("bc_sensitive_list","jeecg"); //表名+模板名
            
//            generatorFacade.generateByTable("BH_RELEVT_MATERIAL","jeecg");
            // //通过数据库表生成文件,template为模板的根目录
            //g.generateByAllTable("template"); // 自动搜索数据库中的所有表并生成文件,template为模板的根目录
            // g.generateByClass(Blog.class,"template_clazz");
            // g.deleteByTable("table_name", "template"); //删除生成的文件
            // 打开文件夹
            Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));

        } catch (Exception e) {
            logger.error("generate", e);
        }
    }
}
