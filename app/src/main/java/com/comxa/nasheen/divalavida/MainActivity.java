package com.comxa.nasheen.divalavida;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;

public class  MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener, AsyncResponse, View.OnClickListener {

    TextView etuserName;
    View parlo;
    NavigationView navView;
    Button logout;

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        etuserName = (TextView) findViewById(R.id.username);
//        etuserName.setText("haha");

        navView = (NavigationView) findViewById(R.id.nav_view);
        parlo = navView.getHeaderView(0);
        etuserName = (TextView) parlo.findViewById(R.id.username);

        etuserName.setText(getIntent().getExtras().getString("Username"));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_generate) { //GENERATE
            // Handle the camera action
            GenerateFragment generateFragment = new GenerateFragment(); //create an object
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constlayout_forfragment, generateFragment, generateFragment.getTag()).commit(); // getTag()= when you want to call the fragment back from the fragment managerv

        } else if (id == R.id.nav_compare) { //COMPARE
            Toast.makeText(this, "galleryyy", Toast.LENGTH_SHORT).show();
            CompareFragment compareFragment = new CompareFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constlayout_forfragment, compareFragment, compareFragment.getTag()).commit();

        } else if (id == R.id.nav_bookmark) { //BOOKMARK
            Toast.makeText(this, "slideshowww", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.nav_home) { //MAIN
            HomeFragment homeFragment = HomeFragment.newInstance(5);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constlayout_forfragment, homeFragment, homeFragment.getTag()).commit();



        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_logout) {
                SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();
            //AppState.getSingleInstance().setLoggingOut(true);
            //Log.d("", "Now log out and start the activity login");
            Intent intent = new Intent(MainActivity.this,
                    LoginActivity.class);

            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void processFinish(String result) {
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {




//        HashMap postData = new HashMap();
//        postData.put("btnLogin", "Login");
//        postData.put("mobile", "android");
//        postData.put("txtUsername", etuserName.getText().toString());
//        postData.put("txtPassword", etPassword.getText().toString() );
//
//        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
//        task.execute("http://10.0.2.2/client/login.php");
    }
}
