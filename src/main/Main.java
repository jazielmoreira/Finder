package main;

import java.io.File;

public class Main {
	
	private static int find(String url) throws Exception {
		String directory = System.getProperty("java.io.tmpdir") + File.separator + "Projeto" + File.separator;
		
		String[] split = url.split("/commit/");
		url = split[0];
		String commit = split[1];
		
		System.out.println("Projeto: "+url);
		Finder finder=new Finder(directory+url.substring(url.lastIndexOf("/")+1),url);
		int totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		return totalCommits;
	}
	
	public static void main(String[] args) throws Exception {
		
		String[] urls = {
				"https://github.com/square/okhttp/commit/1ca5c113e4938a4af8092da66daae601aa5e1847",
				"https://github.com/zxing/zxing/commit/274159117ac631ef8d48913f22ec48b0bb8d7543",
				"https://github.com/libgdx/libgdx/commit/6f709cbcd517bdd0595a3378fb28bfc44572aca7",
				"https://github.com/netty/netty/commit/0b690a991fb86903188e769763225ce9f3099b4c",
				"https://github.com/alibaba/fastjson/commit/9aae9e0dc91e1f0ccd43cea06b42338b04f436c5"};
		
		
		int [] totalCommit = new int[urls.length];
		for(int i = 0; i<urls.length; i++)
			totalCommit[i] = find(urls[i]);
		
		for(int i = 0; i<urls.length; i++)
			System.out.println(urls[i] + ": " + totalCommit[i]);
		
		
	}
}
