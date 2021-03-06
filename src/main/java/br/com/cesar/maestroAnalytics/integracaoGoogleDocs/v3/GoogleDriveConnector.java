package br.com.cesar.maestroAnalytics.integracaoGoogleDocs.v3;

import java.io.IOException;
import java.util.List;

import com.google.api.services.drive.Drive;

public interface GoogleDriveConnector {
	/**
	 * 
	 * @return
	 */
	public List<String> getScopes();

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public Drive getDriveService() throws IOException;


}
