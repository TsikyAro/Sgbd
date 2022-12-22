package affiche;
import relation.*;
import java.io.*;
public class Vocabulaire{
    public String[] splite(String requete){
        String [] valiny = requete.split(" ",0);
        return valiny;    
    }

    public String select(String requete){
        Base relat = new Base();
        String[] splitee = splite(requete);
        String valinys = "";
        try{
            if(splitee[0].equalsIgnoreCase("select") && splitee[1].equalsIgnoreCase("*") ){
                Table valiny = relat.SelectAll(requete);
                Form form = new Form();
                valinys = form.affiche(valiny);
            }else{
                valinys = "Veuillez verifier votre requete";
            }
        }catch(IOException io){ 
            valinys = "il y a une exception dans votre requete";
        }
        return valinys;
    }
    public String manakambana(String requete){
        String[] splitee = splite(requete);
        Fonction f = new Fonction();
        Base relat = new Base();
        String valiny ="";
        try{
            Table tab1 = relat.SelectAll("Select * from " + splitee[1]);
            Table tab2 = relat.SelectAll("Select * from " + splitee[3]);
             Form form = new Form();
            if(splitee[0].equalsIgnoreCase("Manakambana")){
                f.UNION(tab1,tab2);
                valiny = form.affiche(tab1);
            }else{
                valiny = "Veuillez verifier votre requete";
            }
        }catch(IOException io){ 
            valiny = "il y a une exception dans votre requete";
        }
        return valiny;
    }
    public String MakaColonne(String requete){
        String[] splitee = splite(requete);
        Fonction f = new Fonction();
        String val ="";
        try{
            if(splitee[0].equalsIgnoreCase("select") && !splitee[1].equalsIgnoreCase("*") ){
                String[] colonne = f.PROJECTION(requete);
                val += "----"+splitee[1]+"----"+"\n";
                if(colonne.length ==0){
                    val = "table collone existant";
                }
                else{
                    for(int i =0; i<colonne.length ; i++){
                        val += "----"+colonne[i]+"------"+"\n";
                    }
                }
            }else{
                val = "Veuillez verifier votre requete";
            }
        }catch (IOException IO){
            val = "il y a une exception dans votre requete";
        }
        return val;
    }
    public String Fifandraisana(String requete){
        String[] splitee = splite(requete);
        Fonction f = new Fonction();
        Base relat = new Base();
        String valiny = "";
        try{
            Table tab1 = relat.SelectAll("Select * from " + splitee[0]);
            Table tab2 = relat.SelectAll("Select * from " + splitee[2]);
            if(splitee[1].equalsIgnoreCase("inter")){
               valiny = f.l_inter(tab1,tab2);
            }else{
                valiny = "veuillez voir le syntax de la sql >>> inter";
            }
        }catch (IOException IO){
            valiny = "il y a une exception dans votre requete";
        }
        return valiny;
    }
    public String TsyMitovy(String requete){
        String[] splitee = splite(requete);
        Fonction f = new Fonction();
        Base relat = new Base();
        String valinys ="";
        try{
            Table tab1 = relat.SelectAll("Select * from " + splitee[0]);
            Table tab2 = relat.SelectAll("Select * from " + splitee[2]);
            if(splitee[1].equalsIgnoreCase("difference")){
                Table valiny = f.DIFFERENCE(tab1,tab2); 
                Form form = new Form();
                valinys = form.affiche(valiny);  
            }else{
                valinys = "veuillez voir le syntax de la sql >>> difference";
            }
        }catch (IOException IO){
            valinys = "il y a une exception dans votre requete";
        }
        return valinys;
    }
    public String create_table(String requete){
        String[] split = splite(requete);
        try{
            Table tab = new Table();
            tab.SetName(split[2]);
            Base b = new Base();
            b.addTable(tab);
        }catch(Exception e){}
        return "Table created";
    } 
    public String vocab(String requete){
        String [] split = splite(requete);
        String valiny = "";
        if(split[0].equalsIgnoreCase("select") && split[1].equalsIgnoreCase("*")){
            valiny = select(requete);
        }
        else if(split[0].equalsIgnoreCase("Manakambana")){
            valiny = manakambana(requete);
        }
        else if(split[0].equalsIgnoreCase("select") && !split[1].equalsIgnoreCase("*")){
            valiny = MakaColonne(requete);
        }
        else if(split[1].equalsIgnoreCase("inter")){
            valiny = Fifandraisana(requete);
        }else if(split[1].equalsIgnoreCase("difference")){
            valiny = TsyMitovy(requete);
        }
        else if(split[0].equalsIgnoreCase("Create") && split[1].equalsIgnoreCase("table")){
            valiny = create_table(requete);
        }
        else{
            valiny = "Veuillez verifier votre requete";
        }
         return valiny;
    }
}