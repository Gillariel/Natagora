/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.util;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.hystrix.Hystrix;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.AbstractConfiguration;

/**
 *
 * @author foers
 */
public class HystrixReset {
    public static void reset(){
        Hystrix.reset(1, TimeUnit.SECONDS);
        if (ConfigurationManager.getConfigInstance() instanceof DynamicConfiguration) {
            ((DynamicConfiguration) ConfigurationManager.getConfigInstance())
                    .stopLoading();
        } else if (ConfigurationManager.getConfigInstance() instanceof ConcurrentCompositeConfiguration) {
            ConcurrentCompositeConfiguration config =
                    ((ConcurrentCompositeConfiguration) ConfigurationManager
                            .getConfigInstance());
            for (AbstractConfiguration innerConfig : config.getConfigurations()) {
                if (innerConfig instanceof DynamicConfiguration) {
                    ((DynamicConfiguration) innerConfig).stopLoading();
                }
            }
        }
    }
}
