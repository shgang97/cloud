package com.library.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author: shg
 * @create: 2022-05-04 7:35 下午
 */
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    @Resource
    private AuthenticationManager manager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 这个方法是对客户端进行配置，一个验证服务器可以预设很多个客户端，
     * 之后这些指定的客户端就可以按照下面指定的方式进行验证
     * @param clients 客户端配置工具
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()   //这里我们直接硬编码创建，当然也可以像Security那样自定义或是使用JDBC从数据库读取
                .withClient("web")   //客户端名称，随便起就行
                .secret(encoder.encode("654321"))      //只与客户端分享的secret，随便写，但是注意要加密
                .autoApprove(false)    //自动审批，这里关闭，要的就是一会体验那种感觉
                .scopes("book", "user", "borrow")     //授权范围，这里我们使用全部all
                .authorizedGrantTypes("client_credentials", "password", "implicit", "authorization_code", "refresh_token");
        //授权模式，一共支持5种，除了之前我们介绍的四种之外，还有一个刷新Token的模式
        //这里我们直接把五种都写上，方便一会实验，当然各位也可以单独只写一种一个一个进行测试
        //现在我们指定的客户端就支持这五种类型的授权方式了
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .passwordEncoder(encoder)    //编码器设定为BCryptPasswordEncoder
                .allowFormAuthenticationForClients()  //允许客户端使用表单验证，一会我们POST请求中会携带表单信息
                .checkTokenAccess("permitAll()");     //允许所有的Token查询请求
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(manager);
        //由于SpringSecurity新版本的一些底层改动，这里需要配置一下authenticationManager，才能正常使用password模式
    }
}
