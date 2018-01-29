package main;


	
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String url="https://github.com/jopt-simple/jopt-simple";
		String commit="bdcb06831908b4976afc88a67289839a25e7b826";
				
		System.out.println("Projeto: "+url);
		Finder finder=new Finder("C:\\tmp\\Projeto\\"+url.substring(url.lastIndexOf("/")+1),url); //Windows
		int totalCommits=finder.totalCommits(commit);
		System.out.println(finder.analiseMultipla(commit,totalCommits));
		System.out.println(totalCommits+"");
		
		
	}
}
