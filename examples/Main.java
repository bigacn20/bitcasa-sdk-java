import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.bitcasa.javalib.BitcasaClient;
import com.bitcasa.javalib.dao.BitcasaFile;
import com.bitcasa.javalib.dao.BitcasaFolder;
import com.bitcasa.javalib.dao.BitcasaItem;
import com.bitcasa.javalib.dao.BitcasaItem.Type;
import com.bitcasa.javalib.exception.BitcasaException;
import com.bitcasa.javalib.http.BitcasaHttpRequestor;
import com.bitcasa.javalib.http.Downloader;
import com.bitcasa.javalib.http.ProgressTracker;
import com.bitcasa.javalib.http.Uploader;


public class Main {
	
	public static final String CLIENT_ID 				= "YOUR_CLIENT_ID";
	public static final String CLIENT_SECRET			= "YOUR_CLIENT_SECRET";
	public static final String ACCESS_TOKEN 			= "YOUR_ACCESS_TOKEN";
	
	static BitcasaClient sClient;
	
	static List<BitcasaItem> sItems;
	
	public static void main(String[] args) {
		
		sClient = new BitcasaClient(CLIENT_ID, CLIENT_SECRET);
//		sClient = new BitcasaClient(ACCESS_TOKEN);
		try {
			String input = null;
			Scanner scanner = new Scanner(System.in);
			while(sClient.getAccessToken() == null) {
				try {
					System.out.println("Please go to " + sClient.getAuthenticateUrl() + " and get the authorization code or type \"exit\" to exit");
					System.out.println("authorization code: ");
					input = scanner.next();
					if (input.equals("exit"))
						System.exit(0);
					sClient.requestForAccessToken(input);
				} catch (Exception e) {}
			};

			System.out.println("Your access token is: " + sClient.getAccessToken() + "\n\n");
			
			List<BitcasaItem> files = getItemsInFolder(null);
			String itemType = "File";
			for (int i = 0; i < files.size(); i++) {
				BitcasaItem item = files.get(i);
				if (item.getType() == Type.FILE)
					itemType = "File";
				else
					itemType = "Folder";
				System.out.println("[" + i + "]\t" + itemType + " name: " + item.getName() + ", path: " + item.getPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<BitcasaItem> getItemsInFolder(BitcasaFolder folder) throws IOException, BitcasaException {
		return sClient.getItemsInFolder(null);
	}
	
	public static List<BitcasaItem> createFolder(BitcasaFolder folder, String fileName) throws IOException, BitcasaException {
		return sClient.createFolder(folder, fileName);
	}
	
	public static void downloadFile (BitcasaItem item, String destinationFolder) throws IOException, BitcasaException {
		Downloader downloader = new Downloader(((BitcasaFile)item), destinationFolder);
		downloader.setProgressTracker(new ProgressTracker() {
			@Override
			public void progressUpdate(int percentage) {
			}

			@Override
			public void progressComplete(BitcasaItem item) {
				System.out.println("Download complete");
			}
		});
		sClient.downloadFile(downloader);
	}
	
	public static void uploadFile(String filePath, BitcasaFolder destinationFolder) throws BitcasaException, IOException {
		Uploader uploader = new Uploader(destinationFolder, filePath);
		uploader.setProgressTracker(new ProgressTracker() {

			@Override
			public void progressUpdate(int percentage) {
			}

			@Override
			public void progressComplete(BitcasaItem item) {
				System.out.println("Upload complete");
			}
			
		});
		sClient.uploadFile(uploader);
	}
}
