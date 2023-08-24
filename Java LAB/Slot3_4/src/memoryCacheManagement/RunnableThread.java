/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryCacheManagement;

/**
 *
 * @author Nhật Huy
 */
public class RunnableThread implements Runnable {
    private String threadName;

    public RunnableThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            
        } 
        catch (Exception e) {
            System.out.println("Exception is caught!");
        }
        finally {
            System.out.println(this.threadName + " is stopped.");
        }
    }
}
