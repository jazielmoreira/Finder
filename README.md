# Projeto
# Finder

This project uses RefDiff to search for refactorings edits.

```
	-u, --url:         Repository's url *                      
	-l, --list:        File with list of repository's url *    
	-i, --init:        Initial commit                        (Default: "HEAD")
	-O, --output:      Output folder                         (Default: This directory)
	-d, --download:    Download folder                       (Default: Temp directory)
	-log:              Log errors                            (Default: False)
```

	* It is necessary a repository's urls or file with a list of repository's url
	If a a repository list is provided, then "HEAD" is used as the initial commit for all repositories;		