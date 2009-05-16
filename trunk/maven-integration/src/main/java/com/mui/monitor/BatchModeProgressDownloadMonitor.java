package com.mui.monitor;

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

}
