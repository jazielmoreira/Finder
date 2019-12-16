package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		String repositoryUrl = null;
		String repositoryList = null;
		String initialCommit = "HEAD";
		String outputFolder = null;
		String downloadFolder = null;
		boolean shouldLog = false;
		
		for(int i = 0; i<args.length; i++){
			switch(args[i]) {
			case "--url":
			case "-u":
				repositoryUrl = args[++i];
				break;
			case "--list":
			case "-l":
				repositoryList = args[++i];
				break;
			case "--init":
			case "-i":
				initialCommit = args[++i];
				break;
			case "--output":
			case "-o":
				outputFolder = args[++i];
				break;
			case "--download":
			case "-d":
				downloadFolder = args[++i];
				break;
			case "-log":
				shouldLog = Boolean.parseBoolean(args[++i]);
				break;
			case "-help":
				help();
				break;
			default:
			}
		}
		
		if(outputFolder!=null && !outputFolder.isEmpty()) {
			FileUtils.setOutputFolder(outputFolder);
		}
		
		if(downloadFolder!=null && !downloadFolder.isEmpty()) {
			FileUtils.setDownloadFolder(downloadFolder);
		}
		
		
		if(repositoryList != null) {
			List<String> urls = getUrls(repositoryList);
			for(String url: urls) {
				Finder finder = new Finder(url);
				finder.findRefactorings("HEAD", shouldLog);
			}
			
		}else if (repositoryUrl != null) {
			Finder finder = new Finder(repositoryUrl);
			finder.findRefactorings(initialCommit, shouldLog);
			
		}else
			throw new Exception("No url provided!");
	}
	
	private static void help() {
		System.out.println("-u, --url:         Repository's url *                      ");
		System.out.println("-l, --list:        File with list of repository's url *    ");
		System.out.println("-i, --init:        Initial commit                        (Default: \"HEAD\")");
		System.out.println("-O, --output:      Output folder                         (Default: This directory)");
		System.out.println("-d, --download:    Download folder                       (Default: Temp directory)");
		System.out.println("-log:              Log errors                            (Default: False)");
		System.out.println();
		System.out.println(" * It is necessary a repository's urls or file with a list of repository's url");
	}
	
	private static List<String> getUrls(String listFile) throws IOException{
		ArrayList<String> urls = new ArrayList<>();
		FileReader reader = new FileReader(listFile);
		BufferedReader buff = new BufferedReader(reader);
		
		String url = buff.readLine();
		while(url != null) {
			urls.add(url);
			url = buff.readLine();
		}
		buff.close();
		return urls;
	}
	
}
