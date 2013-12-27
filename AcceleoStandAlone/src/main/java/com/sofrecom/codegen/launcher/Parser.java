package com.sofrecom.codegen.launcher;

import java.io.File;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EPackage;


import com.sofrecom.codegen.resources.Template;

public class Parser {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// BGI
		//Main.main(new String[]{"C:\\Users\\BGI6\\Dropbox\\JPATest\\model\\mymodel.xmi","./Output-gen"});
		// Home
		
	
		registerPackages();
		Template.main(new String[]{new File("./").getAbsolutePath()+"\\model\\ViewModel.xmi","./Output-gen"});
//		ZkGenerator.main(new String[]{"C:\\Users\\zied.Rassil-PC\\Dropbox\\JPATest\\model\\ViewModel.xmi","./Output-gen"});
	}

	public static void registerPackages() {
//		EPackage.Registry.INSTANCE.put(CodegenPackage.eNS_URI, CodegenPackage.eINSTANCE);
//		EPackage.Registry.INSTANCE.put("http://wwww.sofrecom.codegen", CodegenPackage.eINSTANCE);
     }

}
