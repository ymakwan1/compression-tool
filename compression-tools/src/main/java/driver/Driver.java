package driver;

import projectmanager.ProjectManager;

public class Driver {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage : javac Driver.java filename.text or file path.");
            System.exit(0);
        }

        ProjectManager projectManager = new ProjectManager(args[0]);
        projectManager.runProject();
    }
}