import java.util.ArrayList;

public class ProjectClass{

    private String name;
    private String description;
    private double initialCost;

    public ProjectClass(){}; // No arguments

    public ProjectClass(String nameGiven){ //Name argument
        this.name = nameGiven;
    }

    public ProjectClass(String nameGiven, String descriptionGiven){ //Name and Description Arguments
        this.name = nameGiven;
        this.description = descriptionGiven;
    }

    public String elevatorPitch(){
        return this.name + "(" + this.initialCost + "): " + this.description;
    }

    public Object setName(String newName){
        this.name = newName;
        return this;
    }

    public Object setDescription(String newDescription){
        this.description = newDescription;
        return this;
    }
    
    public Object setCost(double cost){
        this.initialCost = cost;
        return this;
    }

    public double getCost(){
        return this.initialCost;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
}

// public class Portfolio{
//     private ArrayList<ProjectClass> projects;

//     public Portfolio(){};

//     public void setProject(ArrayList<ProjectClass> project){
//         projects.add(project);
//         System.out.println("Added project.");
//     }

//     public ArrayList<ProjectClass> getProjects(){
//         return this.projects;
//     }

//     public double getPortfolioCost(){
//         double sum = 0;
//         for (int i=0; i<this.projects.size(); i++){
//             System.out.println(this.projects[i]);
//         }
//     }
// }