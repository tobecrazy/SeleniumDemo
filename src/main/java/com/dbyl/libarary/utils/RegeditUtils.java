package com.dbyl.libarary.utils;

import java.util.prefs.Preferences;

/**
 * This Class is for regedit for windows 
 * @author young
 *
 */
public class RegeditUtils {
	 // store value to register 
    public void writeValue() {  
        // HKEY_LOCAL_MACHINE\Software\JavaSoft\prefs下写入注册表值.  
        Preferences pre = Preferences.systemRoot().node("/javaplayer");  
        for (int i = 0; i < 6; i++) {  
            
        }  
    }  
  
    /*** 
     * 根据key获取value 
     *  
     */  
    public String getValue(String key) {  
        Preferences pre = Preferences.systemRoot().node("/javaplayer");  
        return pre.get(key, "time");  
    }  
}
