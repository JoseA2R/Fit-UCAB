package com.fitucab.ds1617b.fitucab.UI.Fragments.M05;

import com.fitucab.ds1617b.fitucab.Helper.IpStringConnection;
import com.fitucab.ds1617b.fitucab.Model.Global;

/**
 * Created by elberg on 26/05/17.
 */

public class M05UrlConsul {
    private static IpStringConnection IP= new IpStringConnection();

    // Deporte por id de deporte - consulta para traer id , nombre y met
    public static String _urlSportid = Global._url +"M05_ServicesSport/getSport?idSpo=1";

    // Elimina Actividad por id del mismo
    public static String _urlDeleteAct = Global._url+"M05_ServicesActivity/deleteActivity?idAct=";

    // Actualiza km
    public static String _urlUpdateKm(String id, String km) {
        String dir;
        dir =Global._url + "M05_ServicesActivity/updateKm?idAct="+id+"&km="+km;
        return dir;
     }

    //Actualiza Calorias
    public static String _urlUpdateCal(String id, String calorias) {
       String dir;
       dir = Global._url + "M05_ServicesActivity/updateCalor?idAct="+id+"&calorias="+calorias;
        return  dir;
    }

    //Esta consulta tre todas lasactividades de la persona
    public static String _urlActivitys =Global._url+"M05_ServicesActivity/getAllActivity?idPer=";

    /**
     * Crea el String para insertar actividad.
     */
    public static String _urlInsertAct(String horaIn, String horaFin,
                                       String lugIn, String lugFin,String fecha, String km,
                                       String calor, int idReg, int idSpo){
        return "insertActivity?horainicial="+horaIn+
                "&horafinal="+horaFin+"&fecha="+fecha+"&km="+km+"&calorias="+calor+
                "&lugarinicial="+lugIn+"&lugarfinal="+lugFin+
                "&idReg="+String.valueOf(idReg)+"&idSpo="+String.valueOf(idSpo);
    }

}