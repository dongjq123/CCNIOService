package edu.bupt.service.io;

import org.ccnx.ccn.io.CCNFileInputStream;
import org.ccnx.ccn.io.CCNFileOutputStream;
import org.ccnx.ccn.io.RepositoryFileOutputStream;

import java.io.OutputStream;

/**
 * Created by fish on 16-4-22.
 */
public interface CCNIOManage {

    CCNFileInputStream getCCNFile(String contentName);
    CCNFileOutputStream putCCNFile(String contentname);
    RepositoryFileOutputStream putRepoFile(String contentname);
}
