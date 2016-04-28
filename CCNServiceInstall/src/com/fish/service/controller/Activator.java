package com.fish.service.controller;

import com.fish.service.controller.impl.CCNServiceInstallImpl;
import edu.bupt.service.io.CCNIOManage;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by fish on 16-4-22.
 */
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference sr = bundleContext.getServiceReference(CCNIOManage.class.getName());
        if (sr != null){
            CCNIOManage manage = (CCNIOManage) bundleContext.getService(sr);
            if (manage != null){
                bundleContext.registerService(CCNServiceInstall.class.getName(), new CCNServiceInstallImpl(manage, bundleContext), null);
                System.out.println("CCN Service Installer registered.");
            }
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
