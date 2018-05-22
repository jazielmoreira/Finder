package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	
	private static String initialCommit;
//	private static boolean flag = true;
	
	private static int find(String url) throws Exception {
		String directory = System.getProperty("java.io.tmpdir") + File.separator + "Projeto" + File.separator;
		String commit = "HEAD";
		
		System.out.println("Projeto: "+url);
		Finder finder=new Finder(directory+url.substring(url.lastIndexOf("/")+1),url);
		int totalCommits=finder.totalCommits(commit);
		initialCommit = finder.getInitialCommit();
		System.out.println(initialCommit);
//		if(flag) { 
//			if(url.equals("https://github.com/selendroid/selendroid"))
//				flag = false;
//			return totalCommits;
//		}
		
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		return totalCommits;
	}
	
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("repositoryURLs.txt");
		FileWriter fw = new FileWriter(new File("log.txt"), true);
		Scanner in = new Scanner(fr);
		while(in.hasNext()) {
			String url = in.nextLine();
			int totalCommit = find(url);
			fw.write("Repository: " + url + "\r\n"); 
			
			fw.write("Initial commit: " + initialCommit + "\r\n");
			fw.write("Total commits: " + totalCommit + "\r\n\r\n");
			fw.flush();
		}
		fw.close();
	}
	
//	public static void main(String[] args) throws Exception {
//		
//		String[] urls = {
//				"https://github.com/square/okhttp/commit/1ca5c113e4938a4af8092da66daae601aa5e1847",
//				"https://github.com/zxing/zxing/commit/274159117ac631ef8d48913f22ec48b0bb8d7543",
//				"https://github.com/libgdx/libgdx/commit/6f709cbcd517bdd0595a3378fb28bfc44572aca7",
//				"https://github.com/netty/netty/commit/0b690a991fb86903188e769763225ce9f3099b4c",
//				"https://github.com/alibaba/fastjson/commit/9aae9e0dc91e1f0ccd43cea06b42338b04f436c5"};
//		
//		
//		int [] totalCommit = new int[urls.length];
//		for(int i = 0; i<urls.length; i++)
//			totalCommit[i] = find(urls[i]);
//		
//		for(int i = 0; i<urls.length; i++)
//			System.out.println(urls[i] + ": " + totalCommit[i]);
//		
//		
//	}
}
