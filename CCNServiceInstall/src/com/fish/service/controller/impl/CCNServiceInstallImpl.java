package com.fish.service.controller.impl;

import com.fish.service.controller.CCNServiceInstall;
import edu.bupt.service.io.CCNIOManage;
import org.ccnx.ccn.io.CCNFileInputStream;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * Created by fish on 16-4-28.
 */
public class CCNServiceInstallImpl implements CCNServiceInstall {
    private CCNIOManage manage;
    private BundleContext bundleContext;
    private String servicePrefix = "ccnx:/";

    public CCNServiceInstallImpl(CCNIOManage manage, BundleContext bundleContext){
        this.manage = manage;
        this.bundleContext = bundleContext;
    }

    @Override
    public long installService(String serviceName) {
        CCNFileInputStream cfi = manage.getCCNFile(servicePrefix+serviceName+".jar");
        try {
            Bundle bundle = bundleContext.installBundle(serviceName, cfi);
            System.out.println("CCNServiceInstall: "+bundle.getSymbolicName()+" service install success!!");
            return bundle.getBundleId();
        } catch (BundleException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
