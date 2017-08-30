package main;


	
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String url="https://github.com/mcMMO-Dev/mcMMO";
		String commit="f1ac5739e4681fb3e14849baf3738a0df97a3a95";
				
		System.out.println("Projeto: "+url);
		Finder finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		int totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
		url="https://github.com/alibaba/fastjson";
		commit="1b3e30325f65a98f5ddb814ceb7e8a3880be5b36";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
		url="https://github.com/EnterpriseQualityCoding/FizzBuzzEnterpriseEdition";
		commit="cdfac751e51e18607b67d6ca3794a8d703863aa9";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
		url="https://github.com/alibaba/druid";
		commit="76c441949f5d133057c86c926330851497dc1254";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
		url="https://github.com/jankotek/mapdb";
		commit="59fd37c1d6887594e8bce0766251faa1ae07aca2";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
		url="https://github.com/clojure/clojure";
		commit="8a3f296dd3fa037852cfd4c201a5b2a6606260fc";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
	}
}
