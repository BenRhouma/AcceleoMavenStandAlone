====================================================
this maven project is used only to run the code generator from outside eclipse as standalone application


- This application will not replace Acceleo Eclipse IDE. So you still need eclipse to work with templates
and generate binary  acceleo files.

- All eclipse dependencies are loaded from local repository.
SO YOU SHOULD DOWNLOAD ECLIPSE "KEPLER" jars and install them manually. (It's hard, but I specified the major,minor version in the POM), 
if you want to load these dependencies, just download the Netbeans acceleo project in my Github Repo and you will find these dep in the lib directory.


- Finally to run your custom code you have to 
	-Generate your EMF java model
	- Replace existing Model
	-Generate your template "emtl" file then put it in the resource directory.
	-ensure that you are loading the rigth XMI resource file or Ecore resource model.
	
	
- One other thing, ensure that the eclipse Acceleo project is working well before trying to run it on another IDE or as Standalone app.
	
	
	Have fun, and don't refuse to 
	
	-Thanks Acceleo team. you made my life easier. :)
	
	