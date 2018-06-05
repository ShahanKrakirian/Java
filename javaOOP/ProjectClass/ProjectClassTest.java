public class ProjectClassTest{
    public static void main(String[] args){
        ProjectClass emptyProject = new ProjectClass();
        ProjectClass namedProject = new ProjectClass("Duane");
        ProjectClass namedAndDescribedProject = new ProjectClass("Duane", "Awesome");
        System.out.println(emptyProject.elevatorPitch());
        System.out.println(namedProject.elevatorPitch());
        System.out.println(namedAndDescribedProject.elevatorPitch());

        // ProjectClass portfolio = new Portfolio();
        // portfolio.setProject(namedProject);
        // portfolio.setProject(namedAndDescribedProject);
        // System.out.println(portfolio.getProjects());
    }
}