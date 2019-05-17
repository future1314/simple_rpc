package com.viewscenes.netsupervisor.configurer.rpc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by MACHENIKE on 2018-12-03.
 */
@Component
@Slf4j
public class RpcScannerConfigurer implements BeanDefinitionRegistryPostProcessor {

    String basePackage = "com.viewscenes.netsupervisor.service";
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        log.info("BeanDefinitionRegistryPostProcessor-----------postProcessBeanDefinitionRegistry@@@@@---");
        ClassPathRpcScanner scanner = new ClassPathRpcScanner(beanDefinitionRegistry);

        scanner.setAnnotationClass(null);
        scanner.registerFilters();

        scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS));
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("BeanDefinitionRegistryPostProcessor-----------postProcessBeanFactory-----------");
    }
}
