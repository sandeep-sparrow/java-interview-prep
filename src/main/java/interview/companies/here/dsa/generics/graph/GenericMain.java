package interview.companies.here.dsa.generics.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenericMain {
    public static void main(String[] args) {

        GenericGraph<Profile> myGenericGraph = new GenericGraph<>();
        List<Profile> profiles = profileGenerator(100);

        for(int i = 0; i < profiles.size(); i++){
            myGenericGraph.addVertex(profiles.get(i));
        }

        for(int i = 0; i < profiles.size(); i++){
            myGenericGraph.addEdge(profiles.get(i), profiles.get(++i));
            for(int j = 1; j == profiles.size(); j++){
                myGenericGraph.addEdge(profiles.get(j), profiles.get(j+1));
            }
        }

        myGenericGraph.pringGraph();

    }

    public static List<Profile> profileGenerator(int noOfProfiles){
        List<Profile> profiles = new ArrayList<>();

        for(int i = 0; i < noOfProfiles; i++){
            String userName = UUID.randomUUID().toString();
            String email = UUID.randomUUID().toString();
            profiles.add(new Profile(userName, email));
        }

        return profiles;
    }
    
}
