package com.mui.launch;

import org.codehaus.plexus.embed.Embedder;
import org.codehaus.plexus.util.Os;

public class MavenGui
{
	
	/** @deprecated use {@link Os#OS_NAME} */
    public static final String OS_NAME = Os.OS_NAME;

    /** @deprecated use {@link Os#OS_ARCH} */
    public static final String OS_ARCH = Os.OS_ARCH;

    /** @deprecated use {@link Os#OS_VERSION} */
    public static final String OS_VERSION = Os.OS_VERSION;

    private static Embedder embedder;
    
    
    
}
