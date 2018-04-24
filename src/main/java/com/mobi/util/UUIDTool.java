package com.mobi.util;

import java.util.UUID;  

public class UUIDTool {  
  
    public UUIDTool() {  
    }    
    public static String getUUID() {   
        return UUID.randomUUID().toString().replace("-", "");  
    }  
   
} 