package com.makk.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;


/**
 *
 */
public class NetADBUtil {
    public NetADBUtil() {
    }

    String stringout = "";

    public String NormalCmd(final String cmd, int fTimeOut) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Process process = null;
                DataInputStream is = null;
                try {
                    LogUtils.d("cmd:" + cmd
                    );
                    process = Runtime.getRuntime().exec(cmd);
                    is = new DataInputStream(process.getInputStream());
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    stringout = new String(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    StreamUtil.close(is);
                    if (process != null) {
                        process.destroy();
                    }

                }
            }
        });

        try {
            t.start();
            t.join(fTimeOut);
            t.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringout;
    }

    public String getRunCmd(final String cmd, int fTimeOut) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                Process process = null;
                DataOutputStream os = null;
                DataInputStream is = null;
                try {
                    process = Runtime.getRuntime().exec("su");
                    os = new DataOutputStream(process.getOutputStream());
                    os.writeBytes(cmd + "\n");
                    os.writeBytes("exit\n");
                    os.flush();
                    process.waitFor();
                    is = new DataInputStream(process.getInputStream());
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    stringout = new String(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    StreamUtil.close(os);
                    StreamUtil.close(is);
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        });

        try {
            t.start();
            t.join(fTimeOut);
            t.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringout;
    }

    private boolean result = false;

    public boolean RootCmd(final String cmd, int fTimeOut) {
        result = false;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Process process = null;
                DataOutputStream os = null;

                try {
                    process = Runtime.getRuntime().exec("su");
                    os = new DataOutputStream(process.getOutputStream());
                    os.writeBytes(cmd + "\n");
                    os.writeBytes("exit\n");
                    os.flush();
                    if (process.waitFor() != 0)
                        result = false;
                    else
                        result = true;
                } catch (InterruptedException e) {
                } catch (Exception e) {
                    LogUtils.d(e.getMessage());
                    e.printStackTrace();
                } finally {
                    StreamUtil.close(os);
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        });

        try {
            t.start();
            t.join(fTimeOut);
            t.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
