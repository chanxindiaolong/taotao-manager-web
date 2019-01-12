package com.taotao.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class TestFastDFS {
	@Test
	public void uploadFile() throws Exception {
		ClientGlobal.init("C:/Users/DONGLI/eclipse-workspace/taotao-manager-web/src/main/resources/resource/client.conf");
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageServer storageServer= null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		String[] strings=storageClient.upload_appender_file("C:/Users/Public/Pictures/Sample Pictures/Tulips.jpg", "jpg", null);
		for (String s:strings) {
			System.out.println(s);
		}
	}
}
