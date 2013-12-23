package com.sofrecom.codegen.launcher;

import com.sofrecom.codegen.resources.Template;
import java.io.File;


public class Launcher {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Template.run(new String[]{new File("./").getAbsolutePath() + "\\model\\ViewModel.xmi", "./Output-gen"});
    }


  

}
