package com.fitucab.ds1617b.fitucab.Helper;

/**
 * Created by Alejandro Fernandez on 26/5/2017.
 * Esta clase será d edonde se va sacar el ip a donde se va a conectar
 * Absoultamente TODOS debemos usar esta clase para al momento de ejecutar se tenga el mismo string
 *
 */

public class IpStringConnection {

    private String _ip = "http://192.168.1.101:8080/WebServicesFitUCAB_war_exploded/";

    public IpStringConnection() {

        this._ip = "http://192.168.1.101:8080/WebServicesFitUCAB_war_exploded/";


    }

    public String getIp() {

        return _ip;

    }

    public void set_ip(String url){
        this._ip = url;
    }

}

