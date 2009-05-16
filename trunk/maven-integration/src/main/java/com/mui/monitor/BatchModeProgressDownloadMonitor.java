package com.mui.monitor;

import org.apache.maven.wagon.WagonConstants;
import org.apache.maven.wagon.events.TransferEvent;

import com.mui.logger.MavenLogger;

public class BatchModeProgressDownloadMonitor extends
		AbstractProgressDownloadMonitor {

	public void transferInitiated( TransferEvent transferEvent )
    {
        String message = transferEvent.getRequestType() == TransferEvent.REQUEST_PUT ? "Uploading" : "Downloading";

        String url = transferEvent.getWagon().getRepository().getUrl();

        // TODO: can't use getLogger() because this isn't currently instantiated as a component
        MavenLogger.info( message + ": " + url + "/" + transferEvent.getResource().getName() );
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
	
	

}
