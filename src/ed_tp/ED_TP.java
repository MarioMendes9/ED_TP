/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_tp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import matriz_ad.Network;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mario
 */
public class ED_TP {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        String file = "socialgraph2.json";
        User[] users = new User[20];
        UserInformation info = new UserInformation(file, users);
        info.loadInfo();
        info.saveInfo();
        
        Network n=new Network();
        
        
    }
}
