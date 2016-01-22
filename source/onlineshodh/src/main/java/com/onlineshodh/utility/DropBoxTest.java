package com.onlineshodh.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v1.DbxClientV1;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles.FileMetadata;
import com.dropbox.core.v2.DbxFiles.Metadata;
import com.dropbox.core.v2.DbxUsers.FullAccount;
import com.dropbox.core.v2.DbxUsers.GetCurrentAccountException;

public class DropBoxTest {
	
	
	static final String ACCESS_TOKEN = "OQurutdpfeAAAAAAAAAAMkKKiex3Jr7eVPfUvQ5bIEcImn_1vyVgnVP6iVBOu101";

    public static void main(String args[]) throws GetCurrentAccountException, DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        DbxClientV1 dbxClient = new DbxClientV1(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users.getCurrentAccount();
        System.out.println(account.name.displayName);

        // Get files and folder metadata from Dropbox root directory
        ArrayList<Metadata> entries = client.files.listFolder("").entries;
        for (Metadata metadata : entries) {
            System.out.println(metadata.pathLower);
        }
        
        // Upload "test.txt" to Dropbox
        
        InputStream in = new FileInputStream("C:\\Users\\Chetan Lohar\\Documents\\test.txt");
		
        
        FileMetadata metadata = client.files.uploadBuilder("/test.txt").run(in);
        System.out.println("Hi:"+metadata.toStringMultiline());
        
        String sharedLink = dbxClient.createShareableUrl(metadata.pathLower);
        System.out.println("sharedLink: "+sharedLink);
        
        
        /*dbxClient.delete("/test.txt");*/
        
    }

}
