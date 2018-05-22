package main;

import java.io.File;
import java.io.FileWriter;
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
	private String initialCommit;
	
	
	
	public Finder(String folder, String cloneURL) throws Exception {
		GitService gitService = new GitServiceImpl(); 
		this.cloneURL=cloneURL;
		this.repository = gitService.cloneIfNotExists(folder, cloneURL);
		initialCommit = null;
	}
	
	public int analise(String commitInicial){ 
		RefDiff refDiff = new RefDiff();
		try {
			List<SDRefactoring> refactorings = refDiff.detectAtCommit(repository, commitInicial);
			for (SDRefactoring refactoring : refactorings) {
				System.out.println("\n\n"+refactoring.getEntityBefore().fullName().replace(" ", ""));
				System.out.println(refactoring.getEntityAfter().fullName().replace(" ", ""));
				System.out.println(refactoring.getRefactoringType().toString());
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
			ObjectId id=repository.resolve(commitInicial);
			RevCommit commit=revWalk.parseCommit(id);
			initialCommit = commit.getName();
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
			String aux=cloneURL.substring(cloneURL.lastIndexOf("/")+1);
			File file = new File(System.getProperty("user.home") + File.separator + "Dropbox" + File.separator + "UFCG" +
					File.separator + "Projeto" + File.separator + "Dados" + File.separator + "Projetos Dataset" + File.separator + "Part 1");
			
			
			
			
			CSV csv = new CSV(new File(file,aux+".csv"));
			RevWalk revWalk = new RevWalk(repository);
			ObjectId id=repository.resolve(commitInicial);
			RevCommit commit=revWalk.parseCommit(id);
			initialCommit = commit.getName();
			
			FileWriter writer = new FileWriter(new File(file,aux+" - log.txt"));
			writer.write("URL Projeto: "+cloneURL);
			writer.write("\r\nTotal de commits: "+qtd);
			writer.write("\r\nCommit Inicial: "+initialCommit);
			writer.flush();
			
			int contError=0;
			for(int i=0;i<qtd;i++){
				commit=revWalk.parseCommit(id);
				try {
					List<SDRefactoring> refactorings = refDiff.detectAtCommit(repository, commit.getName());
					for (SDRefactoring refactoring : refactorings) {
						csv.addCSV(i,commit,refactoring);
					}
				}catch(Exception e) {
					e.printStackTrace();
					writer.write("\r\n\r\nErro ao detectar refatoramentos no commit #"+i+": "+commit.getName());
					writer.write("\r\nErro: "+e.toString());
					writer.flush();
					contError++;
				}
				System.out.println(i+"# "+commit);
				id=commit.getParent(0);
			}
			
			System.out.println("FIM");
			revWalk.close();
			csv.close();
			writer.write("\r\n\r\n Total de erros: "+contError);
			writer.flush();
			writer.close();
			return contError;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public String getInitialCommit() {
		return initialCommit;
	}
	
}
