/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.network.AdminUrls;
import com.helmo.al.natadmin.network.NetworkTimeOut;
import com.helmo.al.natadmin.network.Ping;
import com.helmo.al.natadmin.network.RESTUrls;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */
@RequestScoped
@ManagedBean
public class NetworkHandler {

    public boolean pingNatAdmin() {
        return Ping.pingURL("http://192.168.128.13:8081/NataRest", NetworkTimeOut.NORMAL);
    }
    
    public boolean pingNataMobile() {
        return Ping.pingURL("http://192.168.128.13:8081/NataRest", NetworkTimeOut.NORMAL);
    }
    
    public boolean pingNataRest() {
        return Ping.pingURL("http://192.168.128.13:8081/NataRest", NetworkTimeOut.NORMAL);
    }
    
    public boolean pingNataWeb() {
        return Ping.pingURL("http://192.168.128.13:8081/NataRest", NetworkTimeOut.NORMAL);
    }
    
    public String completeTestNatAdmin() {
        StringBuilder htmlResult = new StringBuilder();
        List<String> urls = AdminUrls.getAsList();
        Map<String, Boolean> pingsResults = Ping.multiplePingURL(urls, NetworkTimeOut.NORMAL);
        for(Map.Entry<String, Boolean> pingResult : pingsResults.entrySet()){
            htmlResult.append(
                pingResult.getValue()
                    ? "<h4><p>" + pingResult.getKey()/*.split(".")[0]*/ + " <i class=\"fa fa-check-circle-o text-success fa-2x\"></i></p></h4>"
                    : "<h4><p>" + pingResult.getKey()/*.split(".")[0]*/ + " <i class=\"fa fa-times-circle-o text-danger fa-2x\"></i></p></h4>"
            );
        }
        return htmlResult.toString();
    }
    
    /**
     * Make a complete test of all supposed active link of NataRest
     * Completly bind to his used view, do not use with another one !
     * @return Html value of the test
     */
    
    public String completeTestNataRest() {
        StringBuilder htmlResult = new StringBuilder();
        List<String> urls = RESTUrls.getAsList();
        Map<String, Boolean> pingsResults = Ping.multiplePingURL(urls, NetworkTimeOut.NORMAL);
        for(Map.Entry<String, Boolean> pingResult : pingsResults.entrySet()){
            htmlResult.append(
                pingResult.getValue()
                    ? "<h4><p>" + pingResult.getKey() + " <i class=\"fa fa-check-circle-o text-success fa-2x\"></i></p></h4>"
                    : "<h4><p>" + pingResult.getKey() + " <i class=\"fa fa-times-circle-o text-danger fa-2x\"></i></p></h4>"
            );
        }
        return htmlResult.toString();
    }
    
    public boolean completeTestNataMobile() {
        return true;
    }
    
    public boolean completeTestNataWeb() {
        return true;
    }
}
