package edu.bupt.service.io.impl;

import edu.bupt.service.io.CCNIOManage;
import org.ccnx.ccn.CCNHandle;
import org.ccnx.ccn.config.ConfigurationException;
import org.ccnx.ccn.io.CCNFileInputStream;
import org.ccnx.ccn.io.CCNFileOutputStream;
import org.ccnx.ccn.io.RepositoryFileOutputStream;
import org.ccnx.ccn.protocol.ContentName;
import org.ccnx.ccn.protocol.MalformedContentNameStringException;

import java.io.IOException;

/**
 * Created by fish on 16-4-22.
 */
public class CCNIOImpl implements CCNIOManage {
    private CCNHandle ccnHandle;

    public CCNIOImpl(CCNHandle ccnHandle) throws NullPointerException{
        if(ccnHandle != null){
            this.ccnHandle = ccnHandle;
        }else{
            throw new NullPointerException("CCNHandle should not be null");
        }

    }
    @Override
    public CCNFileInputStream getCCNFile(String contentName) {
        try {
            ContentName cn = ContentName.fromURI(contentName);
            CCNFileInputStream cis = new CCNFileInputStream(cn, ccnHandle);
            return cis;
        } catch (MalformedContentNameStringException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CCNFileOutputStream putCCNFile(String contentname) {
        try {
            ContentName cn = ContentName.fromURI(contentname);
            CCNFileOutputStream cos = new CCNFileOutputStream(cn, ccnHandle);
            return cos;
        } catch (MalformedContentNameStringException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RepositoryFileOutputStream putRepoFile(String contentname) {
        try {
            ContentName cn = ContentName.fromURI(contentname);
            RepositoryFileOutputStream ros = new RepositoryFileOutputStream(cn, ccnHandle);
        } catch (MalformedContentNameStringException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
