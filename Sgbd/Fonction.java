package relation;
import java.io.*;
import java.util.ArrayList;
public class Fonction{
    /*---------UNION----------*/
    public  void UNION(Table tab1, Table tab2){
        ArrayList<String[]> v =new ArrayList<String[]>();
        for(int i=0; i< tab1.getDonnes().size(); i++){
            v.add(tab1.getDonnes().get(i));
            v.add(tab2.getDonnes().get(i));
        }

        tab1.SetDonnes(v);
    }

    /*---------PROJECTION-------*/
    public String[] PROJECTION(String sql) throws IOException{
       Table table=new Table();
       ArrayList<String[]> liste = new ArrayList<String[]> ();
        
       Base b = new Base();
        ArrayList<String> requete =b.split(sql);
        int colonne = 0;
        String nomTabl=b.get(requete.get(3));
        table.SetName(nomTabl);
        String[] attributes = b.getAttributes(table);
        for(int i = 0; i<attributes.length; i++){
            if(requete.get(1).equalsIgnoreCase(attributes[i])){
                liste = b.detailDonness(table);
                colonne = i;
            }
        }
       String [] valiny = new String [liste.size()];
            for(int o = 0; o<liste.size(); o++){
                    valiny[o] = new String();
                    valiny[o] = liste.get(o)[colonne];
                } 
        
        return valiny;
        
    }
    public ArrayList<String> compare(Table tab1, Table tab2){
        String reps = null;
        String val1 = new String();
        String val2 = new String();
        ArrayList<String> aray = new ArrayList<String > ();
        if(tab1.getAttribute().get(0).length==tab2.getAttribute().get(0).length){
            for(int i =0 ; i<tab1.getDonnes().size(); i++){
                for(int j = 0; j<tab1.getDonnes().get(0).length; j++){
                val1 += ","+ tab1.getDonnes().get(i)[j];
                val2 +=","+ tab2.getDonnes().get(i)[j];
                
                }
                if(val1.equalsIgnoreCase(val2)){
                    reps = val1;
                    aray.add(reps);
                }
                    val1 = " ";
                    val2 = " ";
            }
        }
        return aray;
    }
    /*----------INTERSECTION--------------*/
    public String l_inter(Table tab1, Table tab2){
        ArrayList<String> val = compare(tab1,tab2);
        String[] [] co = new String[val.size()][];
        String reps = "";
        if(val.size()!=0){
            for(int i =0 ; i< val.size(); i++){
                co[i] = val.get(i).split(",");
            }
            for(int j =0 ; j< co.length ; j ++){
                reps += co[j][1]+"--------"+co[j][2]+"----------"+co[j][3]+"\n";
                // System.out.println(co[j][1]+"--------"+co[j][2]+"----------"+co[j][3]);
            }
        }else{
            reps = "table inexistant";
        }
        return reps;
    }
    /*---------PRODUIT CARTESIEN----------*/
    public Table produitCartesien(Table tab1, Table tab2){
       /* Table valiny = new Table();
       valiny.SetName(tab1.getName()+"x"+tab2.getName());
        ArrayList<String[]> attrib1 = tab1.getAttribute();
        ArrayList<String[]> attrib2 = tab2.getAttribute();
        ArrayList<String[]> attr = new ArrayList<String[]>();
        ArrayList<String[]> donnes = new ArrayList<String[]>();
        String[] attribe = new String[attrib1.get(0).length+attrib2.get(0).length];
        /* Attributs */
        /*int o =0;
        for(int i =0; i< tab1.getAttribute().size(); i++){
            attribe[o] = attrib1.get(i)[i];
            attribe[o+1] = attrib1.get(i)[i];
            //  System.out.println(o+"tfsdg");
            o= o+2;
        }
        attr.add(attribe);
        //  System.out.println(attribe[5]);
        valiny.SetAttribute(attr);

        /*Donnes*/
        /*String[] done = new String[tab1.getDonnes().get(0).length+tab2.getDonnes().get(0).length];
        int u=0;
        int g =done.length;
        System.out.println(tab1.getDonnes().size());
        for(int i =0 ; i<tab1.getDonnes().size(); i++){
            u=0;
            for(int j =0; j<3; j++ ){
                if(u<g){
                    System.out.println(tab1.getDonnes().get(1)[2]+" ito");
                    // done[u] = tab1.getDonnes().get(i)[j];
                    done[u+1] = tab2.getDonnes().get(i)[j];
                    System.out.println(done[u+1]+"dfgh");
                    u = u+2;
                }
            
            }
            donnes.add(done);
        }
        valiny.SetDonnes(donnes);*/

        return null;
    }
    /*---------DIFFERENCE-----------------*/
    public Table DIFFERENCE(Table tab1, Table tab2){
        String reps = null;
        String val1 = new String();
        String val2 = new String();
        if(tab1.getAttribute().get(0).length==tab2.getAttribute().get(0).length){
            for(int i =0 ; i<tab1.getDonnes().size(); i++){
                for(int j = 0; j<tab1.getDonnes().get(0).length; j++){
                val1 += ","+ tab1.getDonnes().get(i)[j];
                val2 +=","+ tab2.getDonnes().get(i)[j];
                
                }
                if(val1.equalsIgnoreCase(val2)){
                    tab1.getDonnes().remove(i);
                    tab2.getDonnes().remove(i);
                }
                    val1 = " ";
                    val2 = " ";
            }
              UNION(tab1,tab2);  
        }
        return tab1;
    }
    /*------------DIVISION----------------*/
    /*public Table Division(Table t1, Table t2){
    Table t=new Table();
    Vector<Integer>hapotramitovy=new Vector<Integer>();

    t.setNom(t1.getNom()+"divider_par"+t2.getNom());

    Vector<Vector<String>>dt1=t1.getDonnees();
    Vector<Vector<String>>dt2=t2.getDonnees();
    // Vector<String>dt=new Vector<String>();
    // Vector<Vector<String>>donnees=new Vector<Vector<String>>();

    Vector<String>at1=t1.getAttributs();
    Vector<String>at2=t2.getAttributs();
    Vector<String>nomAttributTable=new Vector<String>();
    
    for(int i=0; i<at1.size(); i++){
        for(int j=0; j<at2.size(); j++){
            if(at1.get(i).equals(at2.get(j))){               
                hapotramitovy.add(j);
                at1.removeElementAt(i);
                
            }else{
                nomAttributTable.add(at1.get(i)); 
            }
        }
   }
   Vector<String>mitovy=new Vector<String>();

   for(int k=0; k<hapotramitovy.size(); k++){
        for(int i=0; i<dt1.size(); i++){
            for(int j=0; j<dt2.size(); j++){
                if(dt1.get(i).get(hapotramitovy.get(k)).equalsIgnoreCase(dt2.get(j).get(hapotramitovy.get(k)))){
                    mitovy.add(dt1.get(i).get(hapotramitovy.get(k)));
                }
            }
        }

    }
    for(int i=0; i<dt1.size(); i++){
        for(int j=0; j<dt1.get(i).size(); j++){
            for(int k=0; k<mitovy.size(); k++){
                if(dt1.get(i).get(j).equalsIgnoreCase(mitovy.get(k))){
                    dt1.get(i).removeElementAt(j);
                }
            }
        }
    }
    t.setAttributs(nomAttributTable);
    

    t.setDonnees(dt1);
    return t;
}*/
    
}