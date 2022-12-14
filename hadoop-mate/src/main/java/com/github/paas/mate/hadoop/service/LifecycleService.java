package com.github.paas.mate.hadoop.service;

import com.github.paas.mate.hadoop.config.HadoopConfig;
import com.github.paas.mate.hadoop.constant.PathConst;
import com.github.shoothzj.javatool.util.ShellUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Slf4j
@Service
public class LifecycleService {

    @Autowired
    private HadoopConfig hadoopConfig;

    @PostConstruct
    public void init() throws Exception {
        // change config
        genConfig();
        // start hadoop
        startHadoop();
    }

    /**
     *
     */
    public void genConfig() throws Exception {

    }

    public void startHadoop() throws Exception {
        switch (hadoopConfig.deployType) {
            case DATA:
                ShellUtil.executeScript(PathConst.HADOOP_START_DATA_SCRIPT);
                break;
            case NAME:
                ShellUtil.executeScript(PathConst.HADOOP_START_NAME_SCRIPT);
                break;
            case PSEUDO:
                ShellUtil.executeScript(PathConst.HADOOP_START_PSEUDO_SCRIPT);
                break;
            default:
                break;
        }
    }

}
