package com.demo.config;

import com.demo.controller.HelloController;
import com.demo.controller.StudentController;
import com.demo.model.Student;
import com.demo.service.StudentService;
import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * @author Cshuzhuo
 * @date 2018-10-12 09:29
 */
public class DemoConfig extends JFinalConfig {


    @Override
    public void configConstant(Constants constants) {
        //开发模式设置 ture
        constants.setDevMode(true);
        //设置渲染视图类型为 JSP
        constants.setViewType(ViewType.JSP);

    }

    @Override
    public void configRoute(Routes routes) {
        //设置访问 controller 访问的前缀,比如访问 StudentController 的 delete 方法,访问请求为 /student/delete,当访问/student 默认调用index 方法
        routes.add("/", HelloController.class);
        routes.add("/student", StudentController.class);

    }

    @Override
    public void configPlugin(Plugins plugins) {
        loadPropertyFile("common_config.txt");//读取配置文件
        C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),getProperty("jdbcUser"),getProperty("jdbcPassword"));
        plugins.add(c3p0Plugin);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);
        activeRecordPlugin.addMapping("student", Student.class);//添加相关model配置
    }

    /**
     * 配置 JFinal  的全局拦截器，全局拦截器将拦截所有 action  请求，除非使用@Clear 在 Controller 中清除
     * @param interceptors
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    /**
     * 此方法用来配置 JFinal 的 Handler，
     * 如下代码配置了名为 ResourceHandler 的处理器，Handler 可以接管所有 web 请求，并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩 展
     * @param handlers
     */
    @Override
    public void configHandler(Handlers handlers) {

    }

    /**
     * 在系统启动完成后回调方法
     */
    @Override
    public void afterJFinalStart() {
        super.afterJFinalStart();
    }

    /**
     * 系 统 关 闭 前 回 调该方法
     */
    @Override
    public void beforeJFinalStop() {
        super.beforeJFinalStop();
    }
}
