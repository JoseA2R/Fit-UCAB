package com.fitucab.ds1617b.fitucab.UI.Fragments.M05;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fitucab.ds1617b.fitucab.Helper.OnFragmentSwap;
import com.fitucab.ds1617b.fitucab.Helper.Rest.VolleySingleton;
import com.fitucab.ds1617b.fitucab.Model.Activit;
import com.fitucab.ds1617b.fitucab.Model.AdapterItem;
import com.fitucab.ds1617b.fitucab.R;
import com.fitucab.ds1617b.fitucab.UI.Activities.M05AddExerciseActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by elberg on 27/05/17.
 */

public class M05PrincipalActivityFragment extends Fragment implements View.OnClickListener {

    public ArrayList<Activit> _activits;

    Toolbar toolbar;
    Gson gson = new Gson();

    ListView _listView;
    TextView imprime;
    ArrayAdapter<Activit> adaptador;
    // Atributo para la posicion de la seleccion
    int selection;

    private TextView _tvdisplaydate;
    private FloatingActionButton _fabChangeDate;

    // Para saber si hay elemntos seleccionados
    int pase = 0;
    int size;

    //Para las fechas
    private int _year;
    private int _month;
    private int _day;

    //Para la hora
    private int _hour;
    private int _min;

    View _view;
    private OnFragmentSwap _callBack;



    public M05PrincipalActivityFragment() {
    }

    /**
     * Una vez la activity llama a un fragment se ejecuta este metodo
     * @param activity recibe la activity que llamo o instancio al fragment
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {

            _callBack = (OnFragmentSwap) activity;

        }
        catch (ClassCastException e) {

            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.activity_m05_principal_activity, container, false);
        setupViewValues();
        return _view;

    }

    private void setupViewValues() {
        toolbar = (Toolbar) _view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        _listView = (ListView) _view.findViewById(R.id.lv_m05_listactivity);
        _fabChangeDate = (FloatingActionButton) _view.findViewById(R.id.fab_m05_datepickerserch);

        // Se pone en modo de escucha
        _fabChangeDate.setOnClickListener(this);
        _tvdisplaydate = (TextView) _view.findViewById(R.id.tv_m05_actualdate);

        // Diseño del toolbar
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhiteSmoke));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string._ttl_m05_activity);

        //Llena el ListView
        makeRequest();
        registerForContextMenu(_listView);
    }


    /**
     * Metodo para iniciar la seleccion de elemntos
     */
    public void selectedElement (){

        // Para la seleccion individual
        _listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        _listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtención del manejador de fragmentos
            //    FragmentManager fragmentManager = getFragmentManager();
              //  new M05ModifyFragment().show(fragmentManager, "M05ModifyFragment");
                return true;
            }
        });


        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), R.string._tst_m05_seletectitemonetouch,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }



    /**
     * Infla el menu
     *
     * @param menu
     * @return
     */


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        ((AppCompatActivity)getActivity()).getMenuInflater().inflate(R.menu.menu_m05_principal, menu);
    }



    /**
     * Acciones  que son consecuencia de opcionar algun item del action bar
     *
     * @param item Seleccion del item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.itm_m05_start_activity){
            Intent newActivity = new Intent(getContext(), M05AddExerciseActivity.class);
            startActivity(newActivity);
        }

        return super.onOptionsItemSelected(item);
    }




    /**
     * Se escucha el View que se este opciondo y segun sea el caso acciona dialogo apropiado,
     * Para este caso no es necesario la hora
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v == _fabChangeDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            _year = c.get(Calendar.YEAR);
            _month = c.get(Calendar.MONTH);
            _day = c.get(Calendar.DAY_OF_MONTH);
            final SimpleDateFormat format = new SimpleDateFormat("E MMM d yyyy");

            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            //_tvdisplaydate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(Calendar.YEAR,year);
                            calendar.set(Calendar.MONTH,monthOfYear);
                            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                            _tvdisplaydate.setText(format.format(calendar.getTime()));

                        }
                    }, _year, _month, _day);
            datePickerDialog.show();
        }
    }


    public void makeRequest()
    {
        String consult ="http://192.168.250.3:8080/untitled_war_exploded/M05_ServicesActivity/" +
                "getActivity?idPer=1&fechalejana=2017-05-20&fechacercana=2017-05-20";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        final StringRequest stringRequest = new StringRequest
                (Request.Method.GET, consult,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                ArrayList<Activit> at = new ArrayList<Activit>();
                                at = gson.fromJson(response, new TypeToken<List<Activit>>(){}.getType());
                                _activits = at;
                               // _listView.setAdapter(new AdapterItem(_view.getContext(), _activits);
                                Log.e("RESPONSE ",at.get(0).get_name());
/*                                ArrayList<Activit> activit = new ArrayList<Activit>();


                                for (int i = 0; i < at.size(); i++ ){
                                    activit.add(new Activit(at.get(i).get_date(),at.get(i).get_name()));
                                }

                                adaptador = new ArrayAdapter<Activit>(getContext(),
                                        android.R.layout.simple_list_item_1, activit);
                                adapter.addAll(activit);
*/

                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.i("no trajo nada","");

                    }
                });
// Access the RequestQueue through your singleton class.
        queue.add( stringRequest );
        //_listView.setOnClickListener(this);
    }

}
