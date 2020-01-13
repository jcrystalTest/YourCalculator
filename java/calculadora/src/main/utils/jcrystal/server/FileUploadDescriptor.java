package jcrystal.server;
import java.io.IOException;
public class FileUploadDescriptor{
	private javax.servlet.http.Part $fileContentPart;
	public FileUploadDescriptor(javax.servlet.http.Part $fileContentPart){
		this.$fileContentPart = $fileContentPart;
	}
	public void put(java.io.File file) throws IOException{
		try(java.io.FileOutputStream fos = new java.io.FileOutputStream(file)){
			jcrystal.utils.ServletUtils.copy(8*1024, $fileContentPart.getInputStream(), fos);
		}
	}
	public void put(String path) throws IOException{
		this.put(StorageUtils.getDEFAULT_BUCKET(), path);
	}
	public void put(String bucketName, String path) throws IOException{
		com.google.appengine.tools.cloudstorage.GcsService gcsService = com.google.appengine.tools.cloudstorage.GcsServiceFactory.createGcsService();
		com.google.appengine.tools.cloudstorage.GcsFileOptions instance = new com.google.appengine.tools.cloudstorage.GcsFileOptions.Builder().mimeType($fileContentPart.getContentType()).build();
		com.google.appengine.tools.cloudstorage.GcsOutputChannel outputChannel = gcsService.createOrReplace(new com.google.appengine.tools.cloudstorage.GcsFilename(bucketName, path), instance);
		jcrystal.utils.ServletUtils.copy(8*1024, $fileContentPart.getInputStream(), java.nio.channels.Channels.newOutputStream(outputChannel));
	}
}
