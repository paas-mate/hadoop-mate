package com.github.paas.mate.hadoop.config;

import com.github.paas.mate.hadoop.module.DeployType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class HadoopConfig {

    @Value("${DEPLOY_TYPE:PSEUDO}")
    public DeployType deployType;

}
