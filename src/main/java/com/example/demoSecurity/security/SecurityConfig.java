package com.example.demoSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: sunxiangxiang
 * @data: 2020-03-06
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义JSON格式返回
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailHander myAuthenticationFailHander;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //放行登陆所需资源
//                .antMatchers("/css/*.css").permitAll()

                //这就表示 /index这个页面不需要权限认证，所有人都可以访问
//                .antMatchers("/whoim").permitAll()

                .and()
                //对请求进行授权
                .authorizeRequests()

                //这就表示/whoim的这个资源需要有ROLE_ADMIN的这个角色才能访问。不然就会提示拒绝访问
//                .antMatchers("/whoim").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST,"/user/").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET,"/user/").hasRole("USER")
                //必须经过验证才能访问
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")

                //任何请求链接的访问均需验证权限，即：必须经过认证以后才能访问
//                .anyRequest().authenticated()

                .and()
                //设置登录页
                .formLogin().loginPage("/login")
                //提交表单后执行，对应login的action
                .loginProcessingUrl("/form")
                //登录成功默认页面
                .successHandler(myAuthenticationSuccessHandler)
                //登录失败提示页
                .failureHandler(myAuthenticationFailHander)
                .permitAll()

                .and()
                // 配置被拦截时的处理  这个位置很关键
                .exceptionHandling()
                //添加无权限时的处理
                .accessDeniedHandler(myAccessDeniedHandler)

                .and()
                //退出放行
                .logout().logoutSuccessUrl("/login")  //退出后访问

                .and()
                //关闭CSRF跨域
                .csrf().disable();

    }

    @Autowired
    private AuthenticationProvider provider;

    /*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/*.css").permitAll() //登陆所需资源
//                .antMatchers("/user/**").hasRole("USER")

                .and()
                //对请求进行授权
                .authorizeRequests()
                //任何请求链接的访问均需验证权限
                .anyRequest().authenticated()

                .and()
                //设置登录页
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/form")
                //登录成功默认页面
                .defaultSuccessUrl("/index")
                //登录失败提示页
                .failureUrl("/loginError").permitAll()

                .and()
                //退出放行
                .logout().logoutSuccessUrl("/login")  //退出后访问

                .and()
                //关闭CSRF跨域
                .csrf().disable();

    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(provider);

//        //可以设置内存指定的登录的账号密码,指定角色
//        //不加.passwordEncoder(new MyPasswordEncoder())
//        //就不是以明文的方式进行匹配，会报错
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("ADMIN")
//        .and()
//                .withUser("test").password("test123").roles("ADMIN");
//        //.passwordEncoder(new MyPasswordEncoder())。
//        //这样，页面提交时候，密码以明文的方式进行匹配。
//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("cxh").password("cxh").roles("ADMIN");
    }


}
