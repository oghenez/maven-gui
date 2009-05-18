package com.mui.monitor;

import org.apache.maven.wagon.WagonConstants;
import org.apache.maven.wagon.events.TransferEvent;

import com.mui.MavenCommonContext;
import com.mui.logger.MavenLogger;

public class ProgressDownloadMonitor extends AbstractProgressDownloadMonitor {

	private long complete;
	private static MavenCommonContext context = MavenCommonContext.getInstance();

    public void transferInitiated( TransferEvent transferEvent )
    {
        String message = transferEvent.getRequestType() == TransferEvent.REQUEST_PUT ? "Uploading" : "Downloading";
        String url = transferEvent.getWagon().getRepository().getUrl();
        // TODO: can't use getLogger() because this isn't currently instantiated as a component
        //MavenLogger.info( message + ": " + url + "/" + transferEvent.getResource().getName() );
        complete = 0;
        
        
        /*if(context.mavenProgressMonitor != null){
        	context.mavenProgressMonitor.showMessage(message + ": " + url + "/" 
        			+ transferEvent.getResource().getName());
        }*/
        
    }

    public void transferStarted( TransferEvent transferEvent )
    {
        // This space left intentionally blank
    }

    public void transferProgress( TransferEvent transferEvent, byte[] buffer, int length )
    {
        long total = transferEvent.getResource().getContentLength();
        complete += length;
        /*// TODO [BP]: Sys.out may no longer be appropriate, but will \r work with getLogger()?
        if ( total >= 1024 )
        {
        	MavenLogger.info(
                ( complete / 1024 ) + "/" + ( total == WagonConstants.UNKNOWN_LENGTH ? "?" : ( total / 1024 ) + "K" ) +
                    "\r" );
        }
        else
        {
        	MavenLogger.info( complete + "/" + ( total == WagonConstants.UNKNOWN_LENGTH ? "?" : total + "b" ) + "\r" );
        }*/
        /*if(context.mavenProgressMonitor != null){
        	context.mavenProgressMonitor.showProgress(total, complete);
        }*/
        
    }

	public void transferCompleted(TransferEvent transferEvent) {
		long contentLength = transferEvent.getResource().getContentLength();
        if ( contentLength != WagonConstants.UNKNOWN_LENGTH )
        {
            String type = ( transferEvent.getRequestType() == TransferEvent.REQUEST_PUT ? "uploaded" : "downloaded" );
            String l = contentLength >= 1024 ? ( contentLength / 1024 ) + "K" : contentLength + "b";
            //MavenLogger.info( l + " " + type );
            /*if(context.mavenProgressMonitor != null){
            	context.mavenProgressMonitor.showMessage( l + " " + type);
            }*/
        }
	}
    
    /*public void transferCompleted(TransferEvent transferEvent) {
		long contentLength = transferEvent.getResource().getContentLength();
        if ( contentLength != WagonConstants.UNKNOWN_LENGTH )
        {
            String type = ( transferEvent.getRequestType() == TransferEvent.REQUEST_PUT ? "uploaded" : "downloaded" );
            String l = contentLength >= 1024 ? ( contentLength / 1024 ) + "K" : contentLength + "b";
            MavenLogger.info( l + " " + type );
        }
	}*/
	
}
