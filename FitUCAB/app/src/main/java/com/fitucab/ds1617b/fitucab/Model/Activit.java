package com.fitucab.ds1617b.fitucab.Model;

import android.widget.ImageView;

import java.util.Date;

/**
 * Clase resferida a las actividades ejecutads por el usuario
 *
 */

public class Activit {
    private int    _id;
    private String _startime;
    private String _endtime;
    private String _date;
    private float  _km;
    private float  _calor;
    private String _starsite;
    private String _endsite;
    private String _name;



    //private ImageView imege;        // imagen para asignar en el list view, no esta en la BD

    public Activit() {
    }

    // Usado para llenar el ListView de la ventana principal del modulo 5

   /* public Activit(int uptime, String sportName, double metersActivity, double speedActivity,
                   String dateActivity) {
        this.uptime = uptime;
        this.sportName = sportName;
        this.metersActivity = metersActivity;
        this.speedActivity = speedActivity;
        this.dateActivity = dateActivity;

    }*/

    public Activit(String _date, float _km, String _name) {
        this._date = _date;
        this._km = _km;
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_startime() {
        return _startime;
    }

    public void set_startime(String _startime) {
        this._startime = _startime;
    }

    public String get_endtime() {
        return _endtime;
    }

    public void set_endtime(String _endtime) {
        this._endtime = _endtime;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public float get_km() {
        return _km;
    }

    public void set_km(float _km) {
        this._km = _km;
    }

    public float get_calor() {
        return _calor;
    }

    public void set_calor(float _calor) {
        this._calor = _calor;
    }

    public String get_starsite() {
        return _starsite;
    }

    public void set_starsite(String _starsite) {
        this._starsite = _starsite;
    }

    public String get_endsite() {
        return _endsite;
    }

    public void set_endsite(String _endsite) {
        this._endsite = _endsite;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

}
