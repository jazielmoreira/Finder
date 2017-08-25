package main;


	
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String url="https://github.com/square/retrofit";
		String commit="e6a7cd01657670807bed24f6f4ed56eb59c9c9ab";
				
		System.out.println("Projeto: "+url);
		Finder finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		int totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
		//Jasmine
		/*String url="https://github.com/searls/jasmine-maven-plugin";
		String commit="dc3ef56ed822535edcede404b740ee2e926feeac";
				
		System.out.println("Projeto: "+url);
		Finder finder=new Finder("/tmp/Projeto/"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		int totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		
		
		//java-apns
		url="https://github.com/notnoop/java-apns";
		commit="45dc3be3dbb8726dfd5c965b1a57b589848191b6";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("/tmp/Projeto/"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		
		
		//jopt-simple
		url="https://github.com/jopt-simple/jopt-simple";
		commit="bdcb06831908b4976afc88a67289839a25e7b826";
				
		System.out.println("Projeto: "+url);
		finder=new Finder("/tmp/Projeto/"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));*/
		
		
		//la4j
		//String url="https://github.com/vkostyukov/la4j";
		//String commit="44119bf0af9ab40c25f5010c7350659a29025dca";
				
		//System.out.println("Projeto: "+url);
		//Finder finder=new Finder("/tmp/Projeto/"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		//int totalCommits=finder.totalCommits(commit);
		//System.out.println(finder.analiseMultipla(commit,totalCommits));
		
		
		/*String url="https://github.com/vkostyukov/la4j";
		String commit="008718841fec8db44dd0716fad56d53ffacd18ac";
				
		System.out.println("Projeto: "+url);
		Finder finder=new Finder("/tmp/Projeto/"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		System.out.println(finder.analise(commit));*/
	}
}
