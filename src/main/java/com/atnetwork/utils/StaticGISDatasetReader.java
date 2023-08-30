/**
 * 
 */
package com.atnetwork.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import io.micrometer.common.util.StringUtils;

/**
 * @author weiwei
 * @see Springframework tools
 * @see Apache common io tools
 */
public class StaticGISDatasetReader {
	private String url;
	private String localfilepath;

	public final static String default_local_path = ".";
	public final static String default_url = "https://gtfs.at.govt.nz/gtfs.zip";
	private String pattern = "yyyy-MM-dd-HH-mm-ss";
	// public final static String default_url =
	// "https://opendata.arcgis.com/api/v3/datasets/d5a4db7acb5a45a9a4f1bd08a3f0f0a6_2/downloads/data?format=geojson&spatialRefId=4326&where=1%3D1";
	

	public StaticGISDatasetReader() {
		this.url = default_url;
		this.localfilepath = default_local_path;
	}

	public StaticGISDatasetReader(String url, String local_path) {
		if (!StringUtils.isBlank(url)) {
			this.url = url;
		} else {
			this.url = default_url;
		}
		if (!StringUtils.isBlank(local_path)) {
			this.localfilepath = local_path;
		} else {
			this.localfilepath = default_local_path;
		}
	}

	/**
	 * Download the file and write into local file
	 * 
	 * @return
	 */
	public void readDataToLocalFile() {
		try {
			URL url = new URL(this.url);
			SimpleDateFormat df = new SimpleDateFormat(this.pattern);
			String datestr = df.format(new Date());
			// File myf = new File(url.toURI().getPath(), "gtfs-"+time+".zip");
			File myf = new File(localfilepath + File.separator, "gtfs-" + datestr + ".zip");
			if (!myf.exists())
				myf.mkdirs();
			FileUtils.copyURLToFile(url, myf);	
			unzipFile(myf, localfilepath+File.separator+"gtfs-" + datestr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return;
	}

	/**
	 * Unzip the file to the local directory
	 * @param f
	 * @param destpath
	 * @return
	 */
	public boolean unzipFile(final File f, final String destpath){
		String destDir = null;
		if (StringUtils.isBlank(destpath)){
			destDir = this.localfilepath;
		}else{
			destDir = destpath;
		}
		File dest = new File(destDir);
		if (!dest.exists())
			dest.mkdirs();
		FileInputStream fis;
		byte[] buffer = new byte[1024];
		try{
			fis = new FileInputStream(f.getAbsolutePath());
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String filename = ze.getName();
				File newFile = new File(dest+File.separator+filename);
				System.out.println("Unzipping to "+newFile.getAbsolutePath());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile, true);
				int len;
				while((len=zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		return false;
	} 

	/**
	 * Testing stub
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StaticGISDatasetReader t = new StaticGISDatasetReader();
		t.readDataToLocalFile();
	}
}
