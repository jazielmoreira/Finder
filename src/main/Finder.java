package main;

import java.io.File;
import java.util.List;

import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

import refdiff.core.RefDiff;
import refdiff.core.api.GitService;
import refdiff.core.rm2.model.refactoring.SDRefactoring;
import refdiff.core.util.GitServiceImpl;

public class Finder {
	
	private Repository repository;
	private String cloneURL;
	
	
	
	public Finder(String folder, String cloneURL) throws Exception {
		GitService gitService = new GitServiceImpl(); 
		this.cloneURL=cloneURL;
		this.repository = gitService.cloneIfNotExists(folder, cloneURL);
	}
	
	public int analise(String commitInicial){ 
		RefDiff refDiff = new RefDiff();
		try {
			List<SDRefactoring> refactorings = refDiff.detectAtCommit(repository, commitInicial);
			for (SDRefactoring refactoring : refactorings) {
				System.out.println(refactoring.getName());
			}
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public int totalCommits(String commitInicial) {
		int total=0;
		try {
			RevWalk revWalk = new RevWalk(repository);
			RevCommit commit;
			ObjectId id=repository.resolve(commitInicial);
			for(total=0;total<Integer.MAX_VALUE;total++){
				commit=revWalk.parseCommit(id);
				System.out.println(total+"# "+commit);
				id=commit.getParent(0);
			}
			
			System.out.println("FIM");
			revWalk.close();
			return total;
		} catch (ArrayIndexOutOfBoundsException e) {
			return total;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public int analiseMultipla(String commitInicial, int qtd){ 
		RefDiff refDiff = new RefDiff();
		try {
			String file=cloneURL.substring(cloneURL.lastIndexOf("/")+1);
			if(System.getProperty("os.name").contains("Linux"))
				file="/home/jaziel/Dropbox/UFCG/Projeto/Dados/CSVs/"+file+" - refatoramentos.csv";
			else
				file="C:\\Users\\Jaziel Moreira\\Dropbox\\UFCG\\Projeto\\Dados\\CSVs\\"+file+" - refatoramentos.csv";
			CSV csv = new CSV(file);
			RevWalk revWalk = new RevWalk(repository);
			RevCommit commit;
			ObjectId id=repository.resolve(commitInicial);
			int cont=0;
			for(int i=0;i<qtd;i++){
				commit=revWalk.parseCommit(id);
				List<SDRefactoring> refactorings = refDiff.detectAtCommit(repository, commit.getName());
				for (SDRefactoring refactoring : refactorings) {
					csv.addCsv(i,commit,refactoring);
				}
				System.out.println(i+"# "+commit);
				id=commit.getParent(0);
			}
			
			System.out.println("FIM");
			revWalk.close();
			csv.close();
			return cont;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
}
