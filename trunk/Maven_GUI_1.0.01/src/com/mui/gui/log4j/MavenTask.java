/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mui.gui.log4j;

import java.util.List;
import javax.swing.SwingWorker;

import com.mui.MavenGUIContext;


/**
 *
 * @author sabuj.das
 */
public class MavenTask<Integer, String> extends SwingWorker<Integer, String>{
    private static MavenGUIContext context = MavenGUIContext.getInstance();
    private Integer taskId;
    private String taskName;
    private java.lang.String[] cmdLineArgs;

    public MavenTask(Integer taskId, String taskName) {
        if(taskId == null){
            throw new IllegalArgumentException("TaskID cannot be NULL");
        }
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public void setCmdLineArgs(java.lang.String[] cmdLineArgs) {
        this.cmdLineArgs = cmdLineArgs;
    }

    

    @Override
    protected Integer doInBackground() throws Exception {
        
        return taskId;
    }

    @Override
    protected void done() {
        MainLogger.logInfo("Finished");
    }

    @Override
    protected void process(List<String> chunks) {
        super.process(chunks);
    }




}
