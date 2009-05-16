package com.mui.monitor;

import org.apache.maven.wagon.WagonConstants;
import org.apache.maven.wagon.events.TransferEvent;
import org.apache.maven.wagon.events.TransferListener;
import org.codehaus.plexus.logging.AbstractLogEnabled;

import com.mui.logger.MavenLogger;

public abstract class AbstractProgressDownloadMonitor extends
		AbstractLogEnabled implements TransferListener {

	public void debug(String message) {
		// TODO Auto-generated method stub

	}

	public void transferCompleted(TransferEvent transferEvent) {
		long contentLength = transferEvent.getResource().getContentLength();
        if ( contentLength != WagonConstants.UNKNOWN_LENGTH )
        {
            String type = ( transferEvent.getRequestType() == TransferEvent.REQUEST_PUT ? "uploaded" : "downloaded" );
            String l = contentLength >= 1024 ? ( contentLength / 1024 ) + "K" : contentLength + "b";
            MavenLogger.info( l + " " + type );
        }
	}

	public void transferError(TransferEvent transferEvent) {
		MavenLogger.error("", transferEvent.getException());
	}

	public void transferInitiated(TransferEvent transferEvent) {
		String message = 
			(transferEvent.getRequestType() == TransferEvent.REQUEST_PUT)
			? "Uploading" : "Downloading";
        String url = transferEvent.getWagon().getRepository().getUrl();
        // TODO: can't use getLogger() because this isn't currently instantiated as a component
        MavenLogger.info( message + ": " + url + "/" + transferEvent.getResource().getName() );
	}

	public void transferProgress(TransferEvent transferEvent, byte[] buffer,
			int length) {
		// TODO Auto-generated method stub

	}

	public void transferStarted(TransferEvent transferEvent) {
		// TODO Auto-generated method stub

	}

}
