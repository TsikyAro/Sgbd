package affiche;
import java.io.*;
import relation.*;
public class Form{
    public String affiche(Table valiny) throws IOException{
        String reps = valiny.getAttribute().get(0)[0]+"----"+valiny.getAttribute().get(0)[1]+"----"+valiny.getAttribute().get(0)[2]+ "\n";
        // Fonction f =new Fonction();
        // f.UNION(valiny, valiny);
         for(int y = 0; y<valiny.getDonnes().size(); y++){
             reps +=  valiny.getDonnes().get(y)[0]+"----"+valiny.getDonnes().get(y)[1]+"----"+valiny.getDonnes().get(y)[2]+"\n";
            
         }
         return reps;
    }
     public void affiches(Table valiny) throws IOException{
        String val = valiny.getAttribute().get(0)[0];
        for(int i =1; i< valiny.getAttribute().get(0).length;i++){
            val +="----"+valiny.getAttribute().get(0)[i];
        }
       
        System.out.println(val);
        System.out.println(valiny.getDonnes().size());
        for(int y = 0; y<valiny.getDonnes().size(); y++){
             String valu = valiny.getDonnes().get(y)[0];
            for(int u =1; u<valiny.getDonnes().get(y).length; u++){
                valu += "------"+  valiny.getDonnes().get(y)[u];
            }
            System.out.println( valu+" //"+ y);
        }
    }
}