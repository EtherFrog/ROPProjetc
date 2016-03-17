//Package à importer afin d'utiliser l'objet File
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class test {
    
    int n;
    int w;
    int v;
    int[][] objects;
    String[] objectsName;
    
    public test(String filename)
    {
        File f = new File(filename);    
        
        try
        {
            FileReader input = new FileReader(f);
            BufferedReader bufRead = new BufferedReader(input);
            String myLine = null;
            
            int c = input.read();
            String myText =""; 
            while (c != -1)
            {
                myText +=(char)c;
                c = input.read();
            }
            String[] array1 = myText.split("\n");
        
            for (int i = 0; i < array1.length; i++)
            {
                if (i == 0) 
                { 
                    n=Integer.parseInt(array1[i].substring(0,array1[i].length()-1)); 
                    objects = new int[n][3];
                    objectsName = new String[n]; 
                }
                else if (i == array1.length-2)
                {
                    w=Integer.parseInt(array1[i].substring(0,array1[i].length()-1));
                }
                else if (i == array1.length-1)
                {
                    v=Integer.parseInt(array1[i].substring(0,array1[i].length()));
                }
                else
                {
                    String[] array2 = array1[i].split(" ");
                    for (int j = 0; j < array2.length-1; j++)
                    {
                        objects[i-1][j]=Integer.parseInt(array2[j]);
                    }
                objectsName[i-1]=array2[array2.length-1];
                }
            }        
        }
        catch (Exception exception)
        {
            System.out.println ("Erreur lors de la lecture du fichier ");
        }
    }
    
    public void printData()
    {
        System.out.println ("| n : "+n+"| w : "+w+"| v : "+v);
        float avrgVal=0,avrgPoi=0,avrgVol=0;
        for (int i = 0; i < n; i++)
        {
            avrgVal+=objects[i][0];
            avrgPoi+=objects[i][1];
            avrgVol+=objects[i][2];
        }
        avrgVal/=n;
        avrgPoi/=n;
        avrgVol/=n;
        System.out.println ("| moy.valeur : "+avrgVal+"| moy.poid : "+avrgPoi+"| moy.volume : "+avrgVol);
        for (int i = 0; i < n; i++)
        {
            System.out.println ("| object "+i+" : "+objects[i][0]+" | : "+objects[i][1]+" | : "+objects[i][2]+" | "+objectsName[i]);
        }
    }
    
    public void solve() 
    {
        
    }
    
    public static void main(String[] args) 
    {
        test sac = new test("donneTest.txt");
        sac.printData();
        sac.solve();
    }
}
    
    